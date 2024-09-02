package com.millenium.etl.common.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public class GenericEtlRepository {

	@PersistenceContext
	EntityManager entityManager;
	
	/**
	 * Realiza un Delete de un entity dado
	 * @param <T>
	 * @param targetTable
	 * @return
	 */
	public <T> long deleteEntityTable(Class<T> targetTable) {
		return entityManager.createQuery( 
					String.format( "delete from %s model ", targetTable.getName() ) )
				.executeUpdate();
	}

	/**
	 * Guarda una lista de instancias
	 * @param <T>
	 * @param clazz
	 * @param data
	 * @return
	 */
	public <T> List<T> saveAll(Class<T> clazz, List<T> data) {
		SimpleJpaRepository<T, Object> simpleJpaRepository = new SimpleJpaRepository<>( clazz , entityManager );
		return simpleJpaRepository.saveAll( data );
	}
	
	
	public <T> long countEntity(Class<T> clazz) {
		SimpleJpaRepository<T, Object> simpleJpaRepository = new SimpleJpaRepository<>( clazz , entityManager );
		return simpleJpaRepository.count();
	}
	
	
	/**
	 * 
	 * Retorna el número de registros de guiones que existen en una lista
	 * @param guionTargetTable
	 * @param listId
	 * @return
	 */
	public long countGuionByMarcadorLista(String guionTargetTable, long listId) {
		return ((Number) entityManager.createNativeQuery( 
				String.format( "SELECT count(guion.id) FROM {h-schema}%s guion "
						+ "WHERE guion.marcadorLista_id = :listId "
				, guionTargetTable ) )
				.setParameter("listId", listId)
				.getSingleResult()).longValue();
	}

	
	/**
	 * Crea el marcador outbound usando la tabla del guión y la temporal <BR>
	 * 
	 * <B>Insert MarcadorOutbound (...) from targetGuionTable join temporalTable on id=id</B>
	 * 
	 * @param targetGuionTable
	 * @param temporalTable
	 * @param listId
	 * @param userId
	 * @return
	 */
	public int createMarcadorOutboundFromGuionAndLista(String targetGuionTable, long listId, long userId) {
		// Crea el marcador
		Query insertMarcadorOutbound = entityManager.createNativeQuery(
				String.format( "INSERT INTO {h-schema}MarcadorOutbound ("
						+ "telefono,"
						+ "tipificacionTelefono1_id,"
						+ "telefono2,"
						+ "tipificacionTelefono2_id,"
						+ "telefono3,"
						+ "tipificacionTelefono3_id,"
						+ "telefono4,"
						+ "tipificacionTelefono4_id,"
						+ "codigoTipificacion,"
						+ "idCrm,"
						+ "agente_id,"
						+ "fechaCreacion ,"
						+ "fechaActualizacion,"
						+ "prioridad,"
						+ "marcadorLista_id,"
						+ "registroValido,"
						+ "audio,"
						+ "adicional1,"
						+ "adicional2"
						+ ")"
						+ "SELECT "
						+ "guion.telefono1,"
						+ "-11,"
						+ "guion.telefono2,"
						+ "-11,"
						+ "guion.telefono3,"
						+ "-11,"
						+ "guion.telefono4,"
						+ "-11,"
						+ "-11,"
						+ "guion.id,"
						+ ":userId,"
						+ "current_timestamp ,"
						+ "current_timestamp,"
						+ "1,"
						+ "guion.marcadorLista_id,"
						+ "true,"
						+ "guion.informacionAdicional4,"
						+ "guion.informacionAdicional1,"
						+ "guion.informacionAdicional2 "
						+ "FROM {h-schema}%s guion "
						+ "WHERE "
						+ "guion.marcadorLista_id = :listId "
						, targetGuionTable
						)
				)
				.setParameter("userId", userId )
				.setParameter("listId", listId)
				;
		return insertMarcadorOutbound.executeUpdate();
	}


}