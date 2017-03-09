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



@NamedQuery(name=Facultad.CONSULTA_LISTAR, query="SELECT a FROM Facultad a")

public class Facultad implements Serializable {

	public static final String CONSULTA_LISTAR="Facultad.listarTodos";

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


	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		return result;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Facultad other = (Facultad) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}

	


}
