/**
 * 
 */
package co.edu.eam.ingesoft.pa.persistencia.modelo.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import co.edu.eam.ingesoft.pa.persistencia.modelo.enumeraciones.TipoAsignatura;

/**
 * Comentario...
 * 
 * @author Monica Stephany Quintero Toro <moniqt94@gmail.com>
 * @date 10/09/2014 Iteracion: HU: Escuela de Administracion y Mercadotecnia del
 *       Quindio - EAM Curso de Desarrollo en Equipo
 */
@NamedQueries({
		@NamedQuery(name= "Asignatura.listarAsignaturaPorPrograma",
				    query= "SELECT a FROM Asignatura a WHERE a.programa=?1"),
		@NamedQuery(name= "Asignatura.listarAsignaturaPorNombre",
	    query= "SELECT a FROM Asignatura a WHERE a.nombre=?1"),
		@NamedQuery(name= "Asignatura.listarAsignaturaPorCodigo",
	    query= "SELECT a FROM Asignatura a WHERE a.codigo=?1"),
	
	
})
@Entity
@Table(name = "asignatura")
public class Asignatura implements Serializable {

	/**
	 * Consulta para listar las asignaturas por Programa<br>
	 
	 * @author Carlos Andres Torres Terreros<br>
	 
	 * ?1: entidad Programa
	 */
	public static final String CONSULTA_LISTAR_POR_PROGRAMA = "Asignatura.listarAsignaturaPorPrograma";
	/**
	 * Consulta para listar las asignaturas por Nombre<br>
	 
	 * @author Carlos Andres Torres Terreros<br>
	 
	 * ?1: entidad Programa
	 */
	public static final String CONSULTA_LISTAR_POR_NOMBRE= "Asignatura.listarAsignaturaPorNombre";
	/**
	 * Consulta para listar las asignaturas por Codigo<br>
	 
	 * @author Carlos Andres Torres Terreros<br>
	 
	 * ?1: entidad Programa
	 */
	public static final String CONSULTA_LISTAR_POR_CODIGO= "Asignatura.listarAsignaturaPorCodigo";

	@Id
	private String codigo;

	@Column
	private int semestre;
	@Column
	private String nombre;
	@Column
	private int intensidadHoraria;
	
	@Column
	private String color;

	@Column
	@Enumerated(EnumType.STRING)
	private TipoAsignatura tipo;
	
	@ManyToOne
	@JoinColumn(name="id_programa")
	private Programa programa;
	
	
	
	
	/**
	 * COnstructor.
	 * @param codigo
	 * @param semestre
	 * @param nombre
	 * @param intensidadHoraria
	 * @param color
	 * @param tipo
	 * @param programa
	 */
	public Asignatura(String codigo, int semestre, String nombre,
			int intensidadHoraria, String color, TipoAsignatura tipo,
			Programa programa) {
		super();
		this.codigo = codigo;
		this.semestre = semestre;
		this.nombre = nombre;
		this.intensidadHoraria = intensidadHoraria;
		this.color = color;
		this.tipo = tipo;
		this.programa = programa;
	}

	public Asignatura() {
		super();
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
	 * @return the semestre
	 */
	public int getSemestre() {
		return semestre;
	}

	/**
	 * @param semestre the semestre to set
	 */
	public void setSemestre(int semestre) {
		this.semestre = semestre;
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
	 * @return the intensidadHoraria
	 */
	public int getIntensidadHoraria() {
		return intensidadHoraria;
	}

	/**
	 * @param intensidadHoraria the intensidadHoraria to set
	 */
	public void setIntensidadHoraria(int intensidadHoraria) {
		this.intensidadHoraria = intensidadHoraria;
	}

	/**
	 * @return the color
	 */
	public String getColor() {
		return color;
	}

	/**
	 * @param color the color to set
	 */
	public void setColor(String color) {
		this.color = color;
	}

	/**
	 * @return the tipo
	 */
	public TipoAsignatura getTipo() {
		return tipo;
	}

	/**
	 * @param tipo the tipo to set
	 */
	public void setTipo(TipoAsignatura tipo) {
		this.tipo = tipo;
	}

	/**
	 * @return the programa
	 */
	public Programa getPrograma() {
		return programa;
	}

	/**
	 * @param programa the programa to set
	 */
	public void setPrograma(Programa programa) {
		this.programa = programa;
	}
	
	
	
	
	


	

	
}
