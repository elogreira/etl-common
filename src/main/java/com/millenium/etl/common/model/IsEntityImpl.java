package com.millenium.etl.common.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * Realiza implementación de IsEntity para que otras clases puedan heredar su implementación. <BR>
 * La clase que lo hereda debe agregar la anotación @SequenceGenerator para mantener referencia a su secuencia (ver ejemplos)
 *
 * @author Paulo Cifuentes
 *
 */
@MappedSuperclass
public abstract class IsEntityImpl implements IsEntity {

	protected Long id;

	public IsEntityImpl() {
		//
	}

	public IsEntityImpl(Long id) {
		this.id = id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Asigna la estrategia de la secuencia. Cada entidad puede implementar el generador definido y se requiere secuencia automática 
	 */
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "etl_seq_generator")
    @Override
	public Long getId() {
		return id;
	}
	
}
