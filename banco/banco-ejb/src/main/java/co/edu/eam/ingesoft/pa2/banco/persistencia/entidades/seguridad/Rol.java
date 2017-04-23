package co.edu.eam.ingesoft.pa2.banco.persistencia.entidades.seguridad;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

/**
 * 
 * Clase responsable de modelar la entidad rol <br>
 * 
 * Camilo Andres Ferrer Bustos<br>
 * 
 * Fecha: 4/08/2016
 * @version 1.0
 */
@Entity
public class Rol implements Serializable {

	@Id
	@SequenceGenerator(name = "rol_seq", sequenceName = "rol_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator="rol_seq")	
	private Long idRol;

	private String descripcion;

	/**
	 * Constructor.
	 */
	public Rol() {
	}

	/**
	 * @return the idRol
	 */
	public Long getIdRol() {
		return idRol;
	}

	/**
	 * @param idRol the idRol to set
	 */
	public void setIdRol(Long idRol) {
		this.idRol = idRol;
	}

	/**
	 * @return the descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * @param descripcion the descripcion to set
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	
	
	

}
