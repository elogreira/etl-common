package com.millenium.etl.common.component;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;

import com.millenium.etl.common.dto.DataModelBuilder;
import com.millenium.etl.common.dto.EtlPropertiesDTO;
import com.millenium.etl.common.exception.EtlRuntimeException;
import com.millenium.etl.common.service.DataModelService;
import com.millenium.etl.common.service.EntityToLoadService;
import com.millenium.etl.common.service.EtlPropertiesFactoryService;

/**
 * Obtiene una lista de datos de un Excel y los persiste a una entidad T
 * La llave primaria de la entidad si o si debe ser el ID con secuencia y NO debe estar en la base de excel.
 * Este proceso es útil para Borrar registros y cargar información que requiere consultar por ejemplo un IVR 
 * 
 * @param <T>
 */
public class EtlProcess<T, R extends EtlPropertiesDTO>{
	
	private static final Logger LOG = Logger.getLogger( EtlProcess.class.getName() );
	
	@Autowired
	private EtlPropertiesFactoryService<R> etlPropertiesFactory;
	
	@Autowired
	private DataModelService dataModelService;

	@Autowired
	private EntityToLoadService<T,R> entityToLoadService;
	
	private Class<T> clazz;
    
    public EtlProcess(Class<T> clazz) {
		this.clazz=clazz;
	}
    
    public void run(String... args) {
    	if( args==null || args.length==0 ) {
    		throw new NullPointerException("Debe existir los argumentos para continuar");
    	}
    	
    	try { 
	    	LOG.info( "Iniciando ETL" );
	    	
	    	// obtiene las propiedades del commandLiseService
	    	R properties = etlPropertiesFactory.getFromArguments(args);
	    	
	    	// Valida el las propiedades
	    	LOG.info( "Validando propiedades" );
	    	entityToLoadService.validateProperties( properties );
	
	    	LOG.info( "Iniciando proceso" );
	    	entityToLoadService.preLoadData( properties );
	    	
			LOG.info( "Obteniendo datos del archivo" );
			DataModelBuilder<T> dataModel = dataModelService.getDataModelBuilderFromXlsxFile( properties.getFilePath() , clazz);
			
			LOG.info( "Transformando datos" );
			List<T> dataToLoad = entityToLoadService.validateData(properties,  dataModel );
			
			LOG.log(Level.INFO,  "Cargando datos, cantidad {0}" , dataToLoad.size() );
			List<T> dataLoaded = entityToLoadService.loadData(properties, dataToLoad );
			LOG.log(Level.INFO,  "Registros guardados: {0}" , dataLoaded.size() );
			
			LOG.info( "Finalizando el proceso" );
	    	entityToLoadService.postLoadData( properties, dataLoaded );
	    	
	    	LOG.info( "Fin de proceso" );
    	
    	}catch (EtlRuntimeException e) { // Captura excepciones en tiempo de ejecución controlados
    		e.setStackTrace( new StackTraceElement[]{ e.getStackTrace()[0] } ); // Reescribe la traza para mostrar solo la 1ra
    		LOG.log( Level.SEVERE, e.getMessage(), e );
		}
		
    }
    
}