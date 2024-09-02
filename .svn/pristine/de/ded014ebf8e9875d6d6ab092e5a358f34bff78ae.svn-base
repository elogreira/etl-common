package com.millenium.etl.common.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class DataModelBuilder<T> {

	private List<T> dataList;

	/**
	 * Constructor de una lista de datos T
	 * @param dataList
	 */
	public DataModelBuilder(List<T> dataList) {
		this.dataList=dataList;
	}

	/**
	 * Opera la lista y retorna una lista del mismo tipo
	 * @param unaryOperator
	 * @return
	 */
	public DataModelBuilder<T> unaryMap(UnaryOperator<List<T>> unaryOperator) {
		this.dataList = unaryOperator.apply( dataList );
		return this;
	}
	
	/**
	 * Opera la lista y retorna una lista de otro tipo
	 * @param <R>
	 * @param function
	 * @return
	 */
	public <R> DataModelBuilder<R> map(Function<List<T>, List<R> > function ) {
		DataModelBuilder<R> dataModelProcessor = new DataModelBuilder<>( function.apply( dataList ) );
		dataList = new ArrayList<>(); // limpia los datos 
		return dataModelProcessor; // retorna el nuevo DataModelProcessor
	}
	
	/**
	 * Consume la lista
	 * @param consumer
	 * @return
	 */
	public DataModelBuilder<T> peek(Consumer<List<T>> consumer) {
		consumer.accept( dataList );
		return this;
	}
	
	
	/**
	 * Obtiene la lista
	 * @return
	 */
	public Supplier<List<T>> data() {
		return ()->dataList;
	}

}
