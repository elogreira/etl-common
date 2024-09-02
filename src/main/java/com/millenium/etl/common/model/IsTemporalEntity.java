package com.millenium.etl.common.model;

import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;

import org.springframework.data.domain.Persistable;

/**
 * Útil para extender todos los Entities que deben ser tablas temporales
 * @author Paulo Cifuentes
 *
 */
@MappedSuperclass
public abstract class IsTemporalEntity implements Persistable<Long>, IsEntity{
	
	protected Long id;
	
	@Override
	public void setId(Long id) {
		this.id = id;
	}
	
	@Id
	@Override
	public Long getId() {
		return id;
	}
	
	/**
	 * Siempre es un nuevo registro, previene select antes del insert
	 */
	@Override
	@Transient
	public boolean isNew() {
		return true;
	}
	
}
