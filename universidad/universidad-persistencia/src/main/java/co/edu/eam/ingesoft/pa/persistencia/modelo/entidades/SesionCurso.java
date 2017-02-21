/**
 *
 */
package co.edu.eam.ingesoft.pa.persistencia.modelo.entidades;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import co.edu.eam.ingesoft.pa.persistencia.modelo.enumeraciones.DiaSemanaEnum;

@Entity
@Table(name = "sesioncurso")
@NamedQueries({
		@NamedQuery(name = SesionCurso.CONSULTA_SESIONES_CURSO_SEMESTRE,
				query = "SELECT s FROM SesionCurso s where s.curso.asignatura.programa.codigo = ?1 "
						+ "and s.curso.semestre.numero = ?2"),
		@NamedQuery(name = SesionCurso.SESION_CURSO_LISTAR_SESIONES_POR_SALON,query="select s from SesionCurso s where s.aula=?1"),
		@NamedQuery(name=SesionCurso.CANTIDAD_HORAS_ASIGNATURA_REGISTRADAS,
				query="SELECT SUM(s.horaFinal-s.horaInicio) FROM SesionCurso s WHERE s.curso = ?1")
})
public class SesionCurso implements Serializable {

	/**
	 * Consulta para listar las sesiones que se ven en un aula
	 * @author Heider Stiven Llantén V.
	 */
	public static final String SESION_CURSO_LISTAR_SESIONES_POR_SALON = "SesionCurso.listarSesionesPorSalon";

	/**
	 * @author Cristian Camilo Zapata Torres
	 * Consulta para generar un resultado de sesiones de un semestre y programa en congruente
	 */
	public static final String CONSULTA_SESIONES_CURSO_SEMESTRE="SesionCurso.listarSesionesCursoSemestre";

	/**
	 * @author Cristian Camilo Zapata Torres
	 * Consulta para traer las horas asignadas a una asignatura
	 */
	public static final String CANTIDAD_HORAS_ASIGNATURA_REGISTRADAS="SesionCurso.CantidadHorasRegistradas";

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@ManyToOne
	private Curso curso;

	@Enumerated(EnumType.STRING)
	private DiaSemanaEnum dia;

	@Temporal(TemporalType.TIME)
	@Column(name = "horainicio")
	private Date horaInicio;

	@Temporal(TemporalType.TIME)
	@Column(name = "horafinal")
	private Date horaFinal;

	@ManyToOne
	private Aula aula;

	/**
	 * Constructor.
	 */
	public SesionCurso() {
	}

	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * @return the curso
	 */
	public Curso getCurso() {
		return curso;
	}

	/**
	 * @param curso
	 *            the curso to set
	 */
	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	/**
	 * @return the dia
	 */
	public DiaSemanaEnum getDia() {
		return dia;
	}

	/**
	 * @param dia
	 *            the dia to set
	 */
	public void setDia(DiaSemanaEnum dia) {
		this.dia = dia;
	}

	/**
	 * @return the horaInicio
	 */
	public Date getHoraInicio() {
		return horaInicio;
	}

	/**
	 * @param horaInicio
	 *            the horaInicio to set
	 */
	public void setHoraInicio(Date horaInicio) {
		// formato al Date
		this.horaInicio = horaInicio;
	}

	/**
	 * @return the horaFinal
	 */
	public Date getHoraFinal() {
		return horaFinal;
	}

	/**
	 * @param horaFinal
	 *            the horaFinal to set
	 */
	public void setHoraFinal(Date horaFinal) {
		this.horaFinal = horaFinal;
	}

}
