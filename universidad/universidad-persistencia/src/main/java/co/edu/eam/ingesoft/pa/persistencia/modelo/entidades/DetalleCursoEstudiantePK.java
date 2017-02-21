package co.edu.eam.ingesoft.pa.persistencia.modelo.entidades;

import java.io.Serializable;

public class DetalleCursoEstudiantePK implements Serializable{

	
	
	private String curso;
	
	private String estudiante;
	
	public DetalleCursoEstudiantePK() {
	}

	/**
	 * @return the estudiante
	 */
	public String getEstudiante() {
		return estudiante;
	}

	/**
	 * @param estudiante the estudiante to set
	 */
	public void setEstudiante(String estudiante) {
		this.estudiante = estudiante;
	}

	/**
	 * @return the curso
	 */
	public String getCurso() {
		return curso;
	}

	/**
	 * @param curso the curso to set
	 */
	public void setCurso(String curso) {
		this.curso = curso;
	}

	public DetalleCursoEstudiantePK(String estudiante, String curso) {
		super();
		this.estudiante = estudiante;
		this.curso = curso;
	}
	 
}
