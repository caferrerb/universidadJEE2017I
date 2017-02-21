package co.edu.eam.ingesoft.pa.persistencia.modelo.entidades;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@IdClass(DetalleCursoEstudiantePK.class)
public class DetalleCursoEstudiante implements Serializable{
	
//	@Id
//	@GeneratedValue(strategy=GenerationType.IDENTITY)
//	private int id;
	@Id
	@ManyToOne
	private Curso curso;
	@Id
	@ManyToOne
	@JoinColumn(name="id_est")
	private Estudiante estudiante;
	
	public DetalleCursoEstudiante() {
	}

	/**
	 * @return the curso
	 */
	public Curso getCurso() {
		return curso;
	}

	/**
	 * @param curso the curso to set
	 */
	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	/**
	 * @return the estudiante
	 */
	public Estudiante getEstudiante() {
		return estudiante;
	}

	/**
	 * @param estudiante the estudiante to set
	 */
	public void setEstudiante(Estudiante estudiante) {
		this.estudiante = estudiante;
	}

	public DetalleCursoEstudiante(Curso curso, Estudiante estudiante) {
		super();
		this.curso = curso;
		this.estudiante = estudiante;
	}
	
	

}
