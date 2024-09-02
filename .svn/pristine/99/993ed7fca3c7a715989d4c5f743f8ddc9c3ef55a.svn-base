package com.millenium.etl.common.service;

import java.util.List;

import com.millenium.etl.common.dto.DataModelBuilder;

/**
 * ETL = Extract, Transform and Load
 * (LOAD)
 * Se encarga de persistir los datos 
 *
 * @param <T>
 * @param <P>
 */
public interface EntityToLoadService<T, R> {

    /**
     * Retorna la cantidad de datos
     * @return
     */

	
	default void validateProperties(R properties) {
		// valida las propiedades
	}

	default void preLoadData(R properties) {
		// proeso antes de cargar los datos
	}

	public List<T> validateData(R properties, DataModelBuilder<T> dataModel);

	public List<T> loadData(R properties, List<T> data);
	

	default void postLoadData(R properties , List<T> data) {
		// Ejecuta un procedimiento después de cargar datos
	}
	
}