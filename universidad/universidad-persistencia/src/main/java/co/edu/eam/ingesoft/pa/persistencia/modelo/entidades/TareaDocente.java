package co.edu.eam.ingesoft.pa.persistencia.modelo.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import co.edu.eam.ingesoft.pa.persistencia.modelo.enumeraciones.TipoTareaEnum;

@Entity
@Table(name="tareadocente")
@NamedQuery(name=TareaDocente.LISTAR_TAREA_POR_DOCENTE, query="select t from TareaDocente t where t.docente.documentoidentificacion=?1 and t.id=?2" )
public class TareaDocente implements Serializable {
public static final String LISTAR_TAREA_POR_DOCENTE="TareaDocente.listarTareasPorDocente";
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;

	@ManyToOne
	private Docente docente;

	@ManyToOne
	private TareaDocente tareaDocente;

	@Column
	private String descripcion;

	@Column
	private int horasDedicada;

	@Enumerated(EnumType.STRING)
	private TipoTareaEnum tipo;

	public TareaDocente() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param docente
	 * @param tareaDocente
	 * @param descripcion
	 * @param horasDedicada
	 */
	public TareaDocente(Docente docente, TareaDocente tareaDocente,
			String descripcion, int horasDedicada) {
		super();
		this.docente = docente;
		this.tareaDocente = tareaDocente;
		this.descripcion = descripcion;
		this.horasDedicada = horasDedicada;
	}

	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
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

	/**
	 * @return the tareaDocente
	 */
	public TareaDocente getTareaDocente() {
		return tareaDocente;
	}

	/**
	 * @param tareaDocente the tareaDocente to set
	 */
	public void setTareaDocente(TareaDocente tareaDocente) {
		this.tareaDocente = tareaDocente;
	}

	/**
	 * @return the descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * @param descripcion the descripcion to set
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	/**
	 * @return the horasDedicada
	 */
	public int getHorasDedicada() {
		return horasDedicada;
	}

	/**
	 * @param horasDedicada the horasDedicada to set
	 */
	public void setHorasDedicada(int horasDedicada) {
		this.horasDedicada = horasDedicada;
	}

	/**
	 * @return the tipo
	 */
	public TipoTareaEnum getTipo() {
		return tipo;
	}
	/**
	 * @param tipo the tipo to set
	 */
	public void setTipo(TipoTareaEnum tipo) {
		this.tipo = tipo;
	}




}
