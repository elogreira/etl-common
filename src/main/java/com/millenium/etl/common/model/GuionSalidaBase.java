package com.millenium.etl.common.model;

import java.util.Date;

import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;

import org.springframework.data.domain.Persistable;

import com.google.gson.annotations.SerializedName;

@MappedSuperclass
public abstract class GuionSalidaBase implements Persistable<Long>{
	
	private Long   id							 ;
	
	@SerializedName("documento")
	private String documento					 ;                              
	
	@SerializedName("tipo de documento")
	private String tipoDocumento                 ;                            	
	
	@SerializedName("primer nombre")
	private String primerNombre                  ;                            	
	
	@SerializedName("segundo nombre")
	private String segundoNombre                 ;                            	
	
	@SerializedName("primer apellido")
	private String primerApellido                ;                            	
	
	@SerializedName("segundo apellido")
	private String segundoApellido               ;                            	
	
	@SerializedName("email")
	private String email                         ;                            	
	
	@SerializedName("telefono1")
	private String telefono1                     ;                            	
	
	@SerializedName("telefono2")
	private String telefono2                     ;                            	
	
	@SerializedName("telefono3")
	private String telefono3                     ;                            	
	
	@SerializedName("telefono4")
	private String telefono4                     ;                            	
	
	@SerializedName("adicional 1")
	private String informacionAdicional1         ;                            	
	
	@SerializedName("adicional2")
	private String informacionAdicional2         ;                            	
	
	@SerializedName("adicional3")
	private String informacionAdicional3         ;                            	
	
	@SerializedName("adicional4 - audio")
	private String informacionAdicional4         ;                            	
	
	@SerializedName("categoria de formulario")
	private String categoriaFormulario           ;                            	
	
	@SerializedName("dirección")
	private String direccion                     ;                            	
	
	@SerializedName("municipio")
	private String municipio                     ;                            	
	
	@SerializedName("departamento")
	private String departamento                  ;                            	
	
	@SerializedName("fecha evento")
	private String fechaEvento                   ;                            	
	
	@SerializedName("hora evento")
	private String horaEvento                    ;                            	
	
	@SerializedName("lugar evento")
	private String lugarEvento                   ;                            	
	
	@SerializedName("motivo")
	private String motivo                        ;                            	
	
	@SerializedName("descripcion")
	private String motivoDescripcion             ;
	
	@SerializedName("fecha inicio gestion")
	private Date  fechaInicioGestion             ;

	@Id
	@Override
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id=id;
	}

	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public String getTipoDocumento() {
		return tipoDocumento;
	}

	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	public String getPrimerNombre() {
		return primerNombre;
	}

	public void setPrimerNombre(String primerNombre) {
		this.primerNombre = primerNombre;
	}

	public String getSegundoNombre() {
		return segundoNombre;
	}

	public void setSegundoNombre(String segundoNombre) {
		this.segundoNombre = segundoNombre;
	}

	public String getPrimerApellido() {
		return primerApellido;
	}

	public void setPrimerApellido(String primerApellido) {
		this.primerApellido = primerApellido;
	}

	public String getSegundoApellido() {
		return segundoApellido;
	}

	public void setSegundoApellido(String segundoApellido) {
		this.segundoApellido = segundoApellido;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefono1() {
		return telefono1;
	}

	public void setTelefono1(String telefono1) {
		this.telefono1 = telefono1;
	}

	public String getTelefono2() {
		return telefono2;
	}

	public void setTelefono2(String telefono2) {
		this.telefono2 = telefono2;
	}

	public String getTelefono3() {
		return telefono3;
	}

	public void setTelefono3(String telefono3) {
		this.telefono3 = telefono3;
	}

	public String getTelefono4() {
		return telefono4;
	}

	public void setTelefono4(String telefono4) {
		this.telefono4 = telefono4;
	}

	public String getInformacionAdicional1() {
		return informacionAdicional1;
	}

	public void setInformacionAdicional1(String informacionAdicional1) {
		this.informacionAdicional1 = informacionAdicional1;
	}

	public String getInformacionAdicional2() {
		return informacionAdicional2;
	}

	public void setInformacionAdicional2(String informacionAdicional2) {
		this.informacionAdicional2 = informacionAdicional2;
	}

	public String getInformacionAdicional3() {
		return informacionAdicional3;
	}

	public void setInformacionAdicional3(String informacionAdicional3) {
		this.informacionAdicional3 = informacionAdicional3;
	}

	public String getInformacionAdicional4() {
		return informacionAdicional4;
	}

	public void setInformacionAdicional4(String informacionAdicional4) {
		this.informacionAdicional4 = informacionAdicional4;
	}

	public String getCategoriaFormulario() {
		return categoriaFormulario;
	}

	public void setCategoriaFormulario(String categoriaFormulario) {
		this.categoriaFormulario = categoriaFormulario;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getMunicipio() {
		return municipio;
	}

	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}

	public String getDepartamento() {
		return departamento;
	}

	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}

	public String getFechaEvento() {
		return fechaEvento;
	}

	public void setFechaEvento(String fechaEvento) {
		this.fechaEvento = fechaEvento;
	}

	public String getHoraEvento() {
		return horaEvento;
	}

	public void setHoraEvento(String horaEvento) {
		this.horaEvento = horaEvento;
	}

	public String getLugarEvento() {
		return lugarEvento;
	}

	public void setLugarEvento(String lugarEvento) {
		this.lugarEvento = lugarEvento;
	}

	public String getMotivo() {
		return motivo;
	}

	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}

	public String getMotivoDescripcion() {
		return motivoDescripcion;
	}

	public void setMotivoDescripcion(String motivoDescripcion) {
		this.motivoDescripcion = motivoDescripcion;
	}

	public Date getFechaInicioGestion() {
		return fechaInicioGestion;
	}

	public void setFechaInicioGestion(Date fechaInicioGestion) {
		this.fechaInicioGestion = fechaInicioGestion;
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
