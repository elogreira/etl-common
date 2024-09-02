package com.millenium.etl.common.service;

import static java.util.Optional.ofNullable;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Spliterators;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Value;

import com.github.pjfanning.xlsx.StreamingReader;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.millenium.etl.common.dto.DataModelBuilder;

public class DataModelService {
	
	private static final Logger LOG = Logger.getLogger( DataModelService.class.getName() );
	
    @Value("${etl.file_row_cache_size:100}")
    private int fileRowCacheSize;
    
    /**
     * 
     * @param <T>
     * @param argumentsDTO
     * @param clazz
     * @return
     */
	public <T> DataModelBuilder<T> getDataModelBuilderFromXlsxFile(String filePath, Class<T> clazz ) {
		List<T> base = new ArrayList<>();
		// Carga un archivo XLSX
		try (InputStream is = new FileInputStream( getFile( filePath ) );
			// carga el archivo por Stream
			Workbook workbook = StreamingReader.builder().rowCacheSize( fileRowCacheSize ).bufferSize(4096).open(is)) {
            
            // Carga la primera hoja
            Sheet datatypeSheet = workbook.getSheetAt(0);
            
            // Imprime cuantas filas tiene el archivo
            LOG.log( Level.INFO,  "Cantidad de filas de la base: {0}" ,  datatypeSheet.getLastRowNum() );
            
            // Mapa para referenciar número de columna y nombre de columna
            final Map<Integer, String> columnsPositionNames;

            // Itera cada fila
            Iterator<Row> iterator = datatypeSheet.iterator();
           
            // Se lee el encabezado
            if( iterator.hasNext() ) {
            	columnsPositionNames = extractHeaderFromFirstRow( iterator.next() );
            }else {
            	throw new UnsupportedOperationException("No se puede leer el encabezado de la base (primera fila)");
            }
            
            // itera las filas 
            iterator.forEachRemaining( currentRow->{
            	T rowModelFromExcel = getdataFromRow(columnsPositionNames, currentRow, clazz);
            	if( rowModelFromExcel==null ) {
            		return;
            	}
				base.add( rowModelFromExcel );
            });
            
            
        } catch (Exception e) {
            LOG.log(Level.SEVERE, e.getMessage(), e );
        }

		LOG.log( Level.INFO,  "Cantidad de filas en memoria: {0}", base.size() );
		return new DataModelBuilder<>(base);
	}
	
	protected File getFile(String filePath) {
    	return new File( filePath );
    }

	protected Map<Integer, String> extractHeaderFromFirstRow(Row currentRow) {
		final Map<Integer, String> columnsPositionNames = new HashMap<>();
		// Guarda en un mapa <index,Columna> para referenciar las siguientes filas
		StreamSupport
			.stream( Spliterators.spliteratorUnknownSize( currentRow.cellIterator() , 0) , false)
			.filter( c->c.getStringCellValue()!=null && !c.getStringCellValue().trim().isEmpty() )
			.collect( Collectors.toMap( Cell::getColumnIndex , Cell::getStringCellValue, (a,b)->a, ()->columnsPositionNames ) );
		
		//Imprime las columnas en consola|log
		printHeaders( currentRow );
		
		// Retorna las columnas
		return columnsPositionNames;
		
	}
	
	
	protected void printHeaders( Row currentRow ) {
		// Obtiene en un String todas las columnas de la fila separado por |
		String collect = StreamSupport
				.stream( Spliterators.spliteratorUnknownSize( currentRow.cellIterator() , 0) , false)
				.filter( c->c.getStringCellValue()!=null && !c.getStringCellValue().trim().isEmpty() )
				.map( Cell::getStringCellValue ).collect( Collectors.joining("|") );
		
		//Se debe cruzar el encabezado con la estructura que debe recibir
		String headerStr = collect.chars().mapToObj( c->"#" ).collect( Collectors.joining("","#","#") );
		LOG.log(Level.INFO, headerStr );
		LOG.log(Level.INFO, "|{0}|" , collect );
		LOG.log(Level.INFO, headerStr );		
	}

	protected <T> T getdataFromRow(final Map<Integer, String> columnsPositionNames, final Row currentRow, Class<T> clazz) {
		// Obtiene un mapa de headers vs valores de la fila
		Map<String, String> rowMap = StreamSupport
				.stream(Spliterators.spliteratorUnknownSize(currentRow.cellIterator(), 0), false)
				.collect(Collectors.toMap(c -> ofNullable(columnsPositionNames.get(c.getColumnIndex())).orElse("-n-a-"),
						Cell::getStringCellValue));

		if (rowMap.isEmpty()) {
			return null;
		}

		// Obtiene el modelo de datos del mapa
		Gson gson = new Gson();
		JsonElement jsonTree = gson.toJsonTree(rowMap);
		return gson.fromJson(jsonTree, clazz);
	}


}