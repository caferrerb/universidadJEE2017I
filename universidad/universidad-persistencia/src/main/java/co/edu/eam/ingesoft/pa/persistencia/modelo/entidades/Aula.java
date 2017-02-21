/**
 *
 */
package co.edu.eam.ingesoft.pa.persistencia.modelo.entidades;

import java.io.Serializable;

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

import co.edu.eam.ingesoft.pa.persistencia.modelo.enumeraciones.TipoAulaEnum;






/**
 * Comentarios
 * @author Jessica Johanna Rodriguez Molina <jessi24cardona@gmail.com>
 * date 10/09/2014
 * Interaccion
 * HU:012 Ver Registro
 * Escuela de Administracion y Mercadotecnia Del Quindio-EAM
 * Curso Desarrollo en Equipo
 */

@Entity
@Table(name="aula")
@NamedQueries(value={
		@NamedQuery(name=Aula.AULA_LISTAR_POR_BLOQUE,query="select a from Aula a where a.bloque=?1")
})
public class Aula  implements Serializable{

	/**
	 * Consulta para listar los salones por bloque
	 * @author Heider Stiven Llante V.
	 */
	public static final String AULA_LISTAR_POR_BLOQUE = "Aula.listarPorBloque";

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;

	@ManyToOne
	private Bloque bloque;

	private int numero;

	@Enumerated(EnumType.STRING)
	private TipoAulaEnum tipoAula;

	/**
	 * Constructor.
	 */
	public Aula() {
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
	 * @return the bloque
	 */
	public Bloque getBloque() {
		return bloque;
	}

	/**
	 * @param bloque the bloque to set
	 */
	public void setBloque(Bloque bloque) {
		this.bloque = bloque;
	}

	/**
	 * @return the numero
	 */
	public int getNumero() {
		return numero;
	}

	/**
	 * @param numero the numero to set
	 */
	public void setNumero(int numero) {
		this.numero = numero;
	}

	/**
	 * @return the tipoAula
	 */
	public TipoAulaEnum getTipoAula() {
		return tipoAula;
	}

	/**
	 * @param tipoAula the tipoAula to set
	 */
	public void setTipoAula(TipoAulaEnum tipoAula) {
		this.tipoAula = tipoAula;
	}






}
