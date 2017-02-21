package co.edu.eam.ingesoft.pa.persistencia.modelo.entidades;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

@Entity
public class Estudiante extends Persona implements Serializable {
	
	private String codigo;
	
	/**
	 * @return the cedula
	 */
	public String getCodigo() {
		return codigo;
	}

	/**
	 * @param cedula the cedula to set
	 */
	public void setCodigo(String cedula) {
		this.codigo = cedula;
	}

	public Estudiante(String cedula, Programa programa, int semestre, List<DetalleCursoEstudiante> cursos) {
		super();
		this.codigo = cedula;
		this.programa = programa;
		this.semestre = semestre;
//		this.cursos = cursos;
	}

	@ManyToOne
	private Programa programa;
	
	private int semestre;
	
	@OneToMany(cascade=CascadeType.ALL,mappedBy="estudiante")
	private List<DetalleCursoEstudiante> cursos;
	
	public Estudiante() {
		// TODO Auto-generated constructor stub
	}

	public Estudiante(Programa programa, int semestre, List<DetalleCursoEstudiante> cursos) {
		super();
		this.programa = programa;
		this.semestre = semestre;
		this.cursos = cursos;
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
	 * @return the cursos
	 */
	public List<DetalleCursoEstudiante> getCursos() {
		return cursos;
	}

	/**
	 * @param cursos the cursos to set
	 */
	public void setCursos(List<DetalleCursoEstudiante> cursos) {
		this.cursos = cursos;
	}
	
	

}
