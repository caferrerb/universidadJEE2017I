package co.edu.eam.ingesoft.pa.persistencia.modelo.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "semestre")
@NamedQueries(value={
		@NamedQuery(name=Semestre.LISTAR_SEMESTRES_PROGRAMA,
				query="SELECT s FROM Semestre s WHERE s.programa.codigo=?1")
})
public class Semestre implements Serializable {

	public static final String LISTAR_SEMESTRES_PROGRAMA="Semestre.listarSemestresPrograma";
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	/**
	 * numero del semestre.
	 */
	@Column
	private int numero;

	/**
	 * jornada del semestre.
	 */
	@ManyToOne
	private Jornada jornada;

	@ManyToOne
	private PeriodoLectivo periodo;

	/**
	 * Programa del semestre
	 */
	@ManyToOne
	private Programa programa;

	public Semestre(int numero, Jornada jornada, PeriodoLectivo periodo, Programa programa) {
		super();
		this.numero = numero;
		this.jornada = jornada;
		this.periodo = periodo;
		this.programa = programa;
	}

	public Semestre() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the numero
	 */
	public int getNumero() {
		return numero;
	}

	/**
	 * @param numero
	 *            the numero to set
	 */
	public void setNumero(int numero) {
		this.numero = numero;
	}

	/**
	 * @return the jornada
	 */
	public Jornada getJornada() {
		return jornada;
	}

	/**
	 * @param jornada
	 *            the jornada to set
	 */
	public void setJornada(Jornada jornada) {
		this.jornada = jornada;
	}

	/**
	 * @return the periodo
	 */
	public PeriodoLectivo getPeriodo() {
		return periodo;
	}

	/**
	 * @param periodo
	 *            the periodo to set
	 */
	public void setPeriodo(PeriodoLectivo periodo) {
		this.periodo = periodo;
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
	 * @return the programa
	 */
	public Programa getPrograma() {
		return programa;
	}

	/**
	 * @param programa
	 *            the programa to set
	 */
	public void setPrograma(Programa programa) {
		this.programa = programa;
	}

}
