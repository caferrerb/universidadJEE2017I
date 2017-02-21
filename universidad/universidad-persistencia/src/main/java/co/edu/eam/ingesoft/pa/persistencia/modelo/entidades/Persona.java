/**
 * 
 */
package co.edu.eam.ingesoft.pa.persistencia.modelo.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * @author Jessica Johanna Rodriguez Molina <jessi24cardona@gmail.com>
 * @date 10/09/2014
 * Interaccion: 1
 * HU:012 Ver Registro 
 * Escuela de Administracion y Mercadotecnia Del Quindio-EAM
 * Curso Desarrollo en Equipo 
 */

@Entity
@Inheritance(strategy=InheritanceType.JOINED)
@Table(name="persona")
public class Persona implements Serializable {
	
	
	/**
	 * Consulta para buscar un usuario por nombre de usuario.
	 * ?1: nommbre de usuario.
	 */
	public static final String CONSULTAR_BY_LOGIN="Persona.buscarPorLogin";
	
	
	@Id
	private String documentoidentificacion;
	
	/**
	 * Nombre de la persona
	 */
	private String nombre;
	
	/**
	 * Apellido de la persona
	 */
	private String apellido;
	
	/**
	 * Direccion de correo electronico
	 */
	private String correoelectronico;
	
	/**
	 * Numero telefonico de la persona
	 */
	private String telefono;
	
	/**
	 * Direccion de vivienda de la persona
	 */
	private String direccion;
	
	
	
	
	/**
	 * COnstructor.
	 */
	public Persona() {}

	/**
	 * Constructor de la clase persona 
	 * @param documentoidentificacion
	 * @param nombre
	 * @param apellido
	 * @param correoelectronico
	 * @param telefono
	 * @param direccion
	 */
	

	public Persona(String documentoidentificacion, String nombre,
			String apellido, String correoelectronico, String telefono,
			String direccion) {
		super();
		this.documentoidentificacion = documentoidentificacion;
		this.nombre = nombre;
		this.apellido = apellido;
		this.correoelectronico = correoelectronico;
		this.telefono = telefono;
		this.direccion = direccion;		
		
	}
	/**
	 * 
	 * Metodo  accesor de documento de la persona 
	 * @Autor Jessica Johanna Rodriguez Molina <jessi24cardona@gmail.com>
	 * @date 10/09/2014
	 * HU: 012  Ver registro 
	 * Iteracion: 1
	 * @return String documentoidentificacion
	 */
	public String getDocumentoidentificacion() {
		return documentoidentificacion;
	}

	


	/**
	 * Metodo de modificacion para el documento de identificacion  de la persona 
	 * @Autor Jessica Johanna Rodriguez Molina <jessi24cardona@gmail.com>
	 * 10/09/2014
	 * HU: 012  Ver registro 
	 * Iteracion: 
	 * @param documentoidentificacion String
	 */
	public void setDocumentoidentificacion(String documentoidentificacion) {
		this.documentoidentificacion = documentoidentificacion;
	}

	/**
	 * Metodo  accesor del nombre de la persona 
	 * @Autor Jessica Johanna Rodriguez Molina <jessi24cardona@gmail.com>
	 * @date 10/09/2014
	 * HU: 012  Ver registro 
	 * Iteracion: 1 
	 * @return String nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * 
	 * Metodo modificador del nombre de la persona 
	 * @Autor Jessica Johanna Rodriguez Molina <jessi24cardona@gmail.com>
	 * 10/09/2014
	 * HU: 012  Ver registro 
	 * Iteracion: 1
	 * @param nombre String
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Metodo accesor del apellido de la persona 
	 * @Autor Jessica Johanna Rodriguez Molina <jessi24cardona@gmail.com>
	 * @date 10/09/2014
	 * HU: 012  Ver registro 
	 * Iteracion: 1
	 * @return String apellido
	 */
	public String getApellido() {
		return apellido;
	}

	/**
	 * Metodo modificador del apellido de la persona  
	 * @Autor Jessica Johanna Rodriguez Molina <jessi24cardona@gmail.com>
	 * 10/09/2014
	 * HU: 012  Ver registro 
	 * Iteracion: 1
	 * @param apellido
	 */
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	/**
	 * 
	 * Metodo accesor del correo electronico de la persona 
	 * @Autor Jessica Johanna Rodriguez Molina <jessi24cardona@gmail.com>
	 * @date 10/09/2014
	 * HU: 012  Ver registro 
	 * Iteracion: 1
	 * @return String correoelectronico
	 */
	public String getCorreoelectronico() {
		return correoelectronico;
	}

	/**
	 * Metodo modificador del correo electronico de la persona
	 * @Autor Jessica Johanna Rodriguez Molina <jessi24cardona@gmail.com>
	 * @date 10/09/2014
	 * HU: 012  Ver registro 
	 * Iteracion: 1
	 * @param correoelectronico String
	 */
	public void setCorreoelectronico(String correoelectronico) {
		this.correoelectronico = correoelectronico;
	}

	/**
	 * Metodo accedor del telefono de la persona  
	 * @Autor Jessica Johanna Rodriguez Molina <jessi24cardona@gmail.com>
	 * @date 10/09/2014
	 * HU: 012  Ver registro 
	 * Iteracion: 1
	 * @return String telefono
	 */
	public String getTelefono() {
		return telefono;
	}

	/**
	 * Metodo modificador del telefono de la persona 
	 * @Autor Jessica Johanna Rodriguez Molina <jessi24cardona@gmail.com>
	 * @date 10/09/2014
	 * HU: 012  Ver registro 
	 * Iteracion: 1
	 * @param telefono String
	 */
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	/**
	 * Metodo accesor de la  direccion de la persona 
	 * @Autor Jessica Johanna Rodriguez Molina <jessi24cardona@gmail.com>
	 * @date 10/09/2014
	 * HU: 012  Ver registro 
	 * Iteracion: 1
	 * @return String direccion
	 */
	public String getDireccion() {
		return direccion;
	}

	/**
	 * Metodo modificador de la direccion de la persona 
	 * @Autor Jessica Johanna Rodriguez Molina <jessi24cardona@gmail.com>
	 * @date 10/09/2014
	 * HU: 012  Ver registro 
	 * Iteracion: 1
	 * @param direccion String
	 */
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	

	
}
