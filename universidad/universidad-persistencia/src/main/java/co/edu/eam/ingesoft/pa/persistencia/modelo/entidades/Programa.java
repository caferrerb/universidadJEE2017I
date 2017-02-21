/**
 *
 */
package co.edu.eam.ingesoft.pa.persistencia.modelo.entidades;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


@NamedQueries({
	@NamedQuery(name=Programa.CONSULTA_PROGRAMA_POR_CODIGO, query="SELECT a FROM Programa a WHERE a.codigo=?1"),
	@NamedQuery(name=Programa.CONSULTA_LISTAR, query="SELECT a FROM Programa a"),
	@NamedQuery(name=Programa.CONSULTAR_PROGRAMAS_POR_FACULTAD, query="SELECT a FROM Programa a WHERE a.facultad.codigo=?1")


})
/**
 * Comentario...
 * @author Monica Stephany Quintero Toro <moniqt94@gmail.com>
 * @date 10/09/2014
 * Iteracion:
 * HU:
 * Escuela de Administracion y Mercadotecnia del Quindio - EAM
 * Curso de Desarrollo en Equipo
 */
@Entity
@Table(name="programa")

public class Programa implements Serializable {

	public static final String CONSULTA_PROGRAMA_POR_CODIGO="Programa.listarPrograma";
	public static final String CONSULTA_LISTAR="Programa.listarTodos";
	public static final String CONSULTAR_PROGRAMAS_POR_FACULTAD="Programa.listarProgramaFacultad";

	@Id
	private String codigo;

	private String nombre;

	@ManyToOne
	private Facultad facultad;


	/**
	 * Constructor.
	 */
	public Programa() {
	}


	public Programa(String codigo, String nombre, Facultad facultad) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.facultad = facultad;
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

	/**
	 * @return the facultad
	 */
	public Facultad getFacultad() {
		return facultad;
	}

	/**
	 * @param facultad the facultad to set
	 */
	public void setFacultad(Facultad facultad) {
		this.facultad = facultad;
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
		Programa other = (Programa) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}




}
