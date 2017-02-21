package co.edu.eam.ingesoft.pa.persistencia.modelo.entidades;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * Entidad que representa una entidad.
 * @author Camilo Andres Ferrer bustos <caferrerb@gmail.com>
 *
 */
@Entity
@Table(name="facultad")




public class Facultad implements Serializable {


	@Id
	private String codigo;

	private String nombre;


	/**
	 * Constructor
	 */
	public Facultad() {
	}


	public Facultad(String codigo, String nombre) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
	}


	/**
	 * @return the codigo
	 */
	public String getCodigo() {
		return codigo;
	}


	/**
	 * @param codigo the codigo to set
	 */
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}


	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}


	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



}
