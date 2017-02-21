package co.edu.eam.ingesoft.pa.persistencia.modelo.entidades;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Llave compuesta semestre-asignatura.
 * @author caferrerb
 *
 */
@XmlRootElement
public class SemestreAsignaturaId implements Serializable {

	/**
	 * id del semestre.
	 */
	private long semestre;
	
	/**
	 * id de la asignatura.
	 */
	private String asignatura;
	
	public SemestreAsignaturaId() {
	}

	/**
	 * COnstructor.
	 * @param semestre
	 * @param asignatura
	 */
	public SemestreAsignaturaId(long semestre, String asignatura) {
		super();
		this.semestre = semestre;
		this.asignatura = asignatura;
	}

	/**
	 * @return the semestre
	 */
	public long getSemestre() {
		return semestre;
	}

	/**
	 * @param semestre the semestre to set
	 */
	public void setSemestre(long semestre) {
		this.semestre = semestre;
	}

	/**
	 * @return the asignatura
	 */
	public String getAsignatura() {
		return asignatura;
	}

	/**
	 * @param asignatura the asignatura to set
	 */
	public void setAsignatura(String asignatura) {
		this.asignatura = asignatura;
	}
	
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}
	
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
	}
	
	
	
	
	
}
