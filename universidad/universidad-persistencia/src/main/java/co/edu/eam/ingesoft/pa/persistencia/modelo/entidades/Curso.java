/**
 * 
 */
package co.edu.eam.ingesoft.pa.persistencia.modelo.entidades;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import co.edu.eam.ingesoft.pa.persistencia.modelo.enumeraciones.GrupoEnum;

/**
 * Comentarios 
 * @author Jessica Johanna Rodriguez Molina <jessi24cardona@gmail.com>
 * date 10/09/2014
 * Interaccion 
 * HU:012 Ver Registro 
 * Escuela de Administracion y Mercadotecnia Del Quindio-EAM
 * Curso Desarrollo en Equipo 
 */
/**
 * @author user
 *
 */


@Table(name="curso")

@Entity
public class Curso implements Serializable{
	
	
	/**
	 * Concatenacion del codigo de la asignatura, el grupo y el año lectivo.
	 */
	@Id
	@Column(name="id")
	private String id;
	
	@ManyToOne
	@JoinColumn(name="asignatura")
	private Asignatura asignatura;
	
	@ManyToOne
	@JoinColumn(name="semestre")
	private Semestre semestre;
	
	//A,B,C,etc
	@Column(name="grupo")
	@Enumerated(EnumType.STRING)
	private GrupoEnum grupo;
	
	
	@ManyToOne
	@JoinColumn(name="Docente")
	private Docente docente;

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the asignatura
	 */
	public Asignatura getAsignatura() {
		return asignatura;
	}

	/**
	 * @param asignatura the asignatura to set
	 */
	public void setAsignatura(Asignatura asignatura) {
		this.asignatura = asignatura;
	}

	

	/**
	 * @return the grupo
	 */
	public GrupoEnum getGrupo() {
		return grupo;
	}

	/**
	 * @param grupo the grupo to set
	 */
	public void setGrupo(GrupoEnum grupo) {
		this.grupo = grupo;
	}
	
	/**
	 * @return the docente
	 */
	public Docente getDocente() {
		return docente;
	}
	/**
	 * @param docente the docente to set
	 */
	public void setDocente(Docente docente) {
		this.docente = docente;
	}
}
