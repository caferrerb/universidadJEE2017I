package co.edu.eam.ingesoft.pa.persistencia.modelo.entidades;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Entidad que representa el año lectivo y el semestre del año en el que nos
 * encontramos,
 * 
 */
@Entity
@Table(name="periodolectivo")

public class PeriodoLectivo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	private String id;

	/**
	 * año en el que nos encontramos.
	 */

	private int anho;

	/**
	 * Periodo: -I o II semedtre del año.
	 */

	private int periodo;

	public PeriodoLectivo() {

		super();
		id = "";
	}

	/**
	 * @return the anho
	 */
	public int getAnho() {
		return anho;
	}

	/**
	 * @param anho
	 *            the anho to set
	 */
	public void setAnho(int anho) {
		if (periodo != 0) {
			id = anho + "" + periodo;
		}
		this.anho = anho;
	}

	/**
	 * @return the periodo
	 */
	public int getPeriodo() {
		return periodo;
	}

	/**
	 * @param periodo
	 *            the periodo to set
	 */
	public void setPeriodo(int periodo) {

		if (anho != 0) {
			id = anho + "" + periodo;
		}
		this.periodo = periodo;
	}

	/**
	 * @return the id
	 */
	public String getId() {
		if(anho!=0 && periodo!=0){
			id=anho + "" + periodo;
		}
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

}
