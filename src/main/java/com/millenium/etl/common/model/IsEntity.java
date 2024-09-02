package com.millenium.etl.common.model;

import java.io.Serializable;

/**
 * Define una clase como isEntity
 *
 * @author Paulo Cifuentes
 *
 */
public interface IsEntity extends Serializable {

	public Long getId();
	public void setId(Long id);

}
