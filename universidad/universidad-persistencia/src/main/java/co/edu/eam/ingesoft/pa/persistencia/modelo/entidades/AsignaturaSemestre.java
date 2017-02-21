package co.edu.eam.ingesoft.pa.persistencia.modelo.entidades;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Entidad intermedia entre semestre y asignatura.
 * @author caferrerb
 *
 */
@Entity
@IdClass(SemestreAsignaturaId.class)
@Table(name="asignatura_semestre")
public class AsignaturaSemestre implements Serializable {
	
	
	@Id
	@ManyToOne
	private Semestre semestre;
	
	@Id
	@ManyToOne
	private Asignatura asignatura;
	

	/**
	 * Constructuros.
	 */
	public AsignaturaSemestre() {
	}


	/**
	 * @return the semestre
	 */
	public Semestre getSemestre() {
		return semestre;
	}


	/**
	 * @param semestre the semestre to set
	 */
	public void setSemestre(Semestre semestre) {
		this.semestre = semestre;
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
	
	
	

}
