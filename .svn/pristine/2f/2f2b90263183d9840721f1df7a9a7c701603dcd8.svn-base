package com.millenium.etl.common.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;



@Entity
@SequenceGenerator(sequenceName = "seq_marcadorlista", allocationSize = 1, name = "etl_seq_generator")
public class MarcadorLista extends IsEntityImpl{

	private String nombre;
	private String descripcion;
	private Boolean activa;
	private Boolean visible;
	private String categoria;
	private Long marcadorconfiguracionId;
	
	
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public Boolean getActiva() {
		return activa;
	}
	public void setActiva(Boolean activa) {
		this.activa = activa;
	}
	
	public Boolean getVisible() {
		return visible;
	}
	public void setVisible(Boolean visible) {
		this.visible = visible;
	}
	
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	
	@Column(name = "marcadorconfiguracion_id")
	public Long getMarcadorconfiguracionId() {
		return marcadorconfiguracionId;
	}
	public void setMarcadorconfiguracionId(Long marcadorconfiguracionId) {
		this.marcadorconfiguracionId = marcadorconfiguracionId;
	}
	

}