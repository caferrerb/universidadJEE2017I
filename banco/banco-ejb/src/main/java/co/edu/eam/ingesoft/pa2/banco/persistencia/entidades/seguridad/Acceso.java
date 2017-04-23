package co.edu.eam.ingesoft.pa2.banco.persistencia.entidades.seguridad;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

/**
 * Entidad que define los elementos que se van a autorizar.. <br>
 * 
 * Camilo Andres Ferrer Bustos<br>
 * 
 * Fecha: 4/08/2016
 * @version 1.0
 */
@Entity
public class Acceso implements Serializable {

	@Id
	@SequenceGenerator(name = "accesos_seq", sequenceName = "accesos_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "accesos_seq")
	private Long id;
	private String url;

	private String nombre;

	/**
	 * constructor.
	 */
	public Acceso() {
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * @param url
	 *            the url to set
	 */
	public void setUrl(String url) {
		this.url = url;
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre
	 *            the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}
