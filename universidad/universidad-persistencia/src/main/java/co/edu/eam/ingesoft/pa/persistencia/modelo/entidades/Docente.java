/**
 *
 */
package co.edu.eam.ingesoft.pa.persistencia.modelo.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import co.edu.eam.ingesoft.pa.persistencia.modelo.enumeraciones.EscalafonDocenteEnum;
import co.edu.eam.ingesoft.pa.persistencia.modelo.enumeraciones.TipoContratacionEnum;

/**
 * Comentario...
 * @author Monica Stephany Quintero Toro <moniqt94@gmail.com>
 * @date 10/09/2014
 * Iteracion:
 * HU:
 * Escuela de Administracion y Mercadotecnia del Quindio - EAM
 * Curso de Desarrollo en Equipo
 */



/**
 * se crea la consulta JPQL para buscar el docente por el nombre
 * @author Anderson Mauricio Hoyos Diaz
 *
 */
@Entity
@Table(name="docente")
@NamedQuery(name=Docente.DOCENTE_BUSCAR_POR_NOMBRE, query="select d from Docente d where d.nombre=?1" )

/**
 * se crea la consulta para buscar docente por programa
 * @author DIEGO FERNANDO ARIAS MONTOYA
 *
 */
@NamedQueries({
    @NamedQuery(name=Docente.DOCENTE_BUSCAR_POR_PROGRAMA, 
    		     query="SELECT d FROM Docente d  WHERE d.programa=?1"),
    
        @NamedQuery(name=Docente.LISTAR, 
        		     query="SELECT d FROM Docente d  ")
})

public class Docente extends Persona implements Serializable {

	public static final String DOCENTE_BUSCAR_POR_NOMBRE = "Docente.buscarPorNombre";
	public static final String DOCENTE_BUSCAR_POR_PROGRAMA = "Docente.listarPorPrograma";
	public static final String LISTAR = "Docente.listar";


	@Column(unique=true)
	private String codigodocente;

	@Enumerated(EnumType.STRING)
	private TipoContratacionEnum tipoContratacion;

	@Enumerated(EnumType.STRING)
	private EscalafonDocenteEnum escalafon;

	@Column
	private String seudonimo;

	@Column
	private String color;

	@ManyToOne
	private Programa programa;
	

	/**
	 * copnstructor
	 */
	public Docente() {
	}
	
	/**
	 * constructor
	 * @param documentoidentificacion
	 * @param nombre
	 * @param apellido
	 * @param correoelectronico
	 * @param telefono
	 * @param direccion
	 * @param programa
	 */
	public Docente(String documentoidentificacion, String nombre, String apellido, String correoelectronico,
			String telefono,Programa programa) {
		super(documentoidentificacion, nombre, apellido, correoelectronico, telefono,null);
		this.programa=programa;
		// TODO Auto-generated constructor stub
	}
	/**
	 * Retorna el valor del atributo.
	 * @return the codigodocente
	 */
	public String getCodigodocente() {
		return codigodocente;
	}
	/**
	/**
	 * Metodo para establecer el valor del atributo.
	 * @param codigodocente the codigodocente to set
	 */
	public void setCodigodocente(String codigodocente) {
		this.codigodocente = codigodocente;
	}
	/**
	 * Retorna el valor del atributo.
	 * @return the tipoContratacion
	 */
	public TipoContratacionEnum getTipoContratacion() {
		return tipoContratacion;
	}
	/**
	/**
	 * Metodo para establecer el valor del atributo.
	 * @param tipoContratacion the tipoContratacion to set
	 */
	public void setTipoContratacion(TipoContratacionEnum tipoContratacion) {
		this.tipoContratacion = tipoContratacion;
	}
	/**
	 * Retorna el valor del atributo.
	 * @return the programa
	 */
	public Programa getPrograma() {
		return programa;
	}
	/**
	/**
	 * Metodo para establecer el valor del atributo.
	 * @param programa the programa to set
	 */
	public void setPrograma(Programa programa) {
		this.programa = programa;
	}



}
