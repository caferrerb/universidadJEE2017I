package co.edu.eam.ingesoft.pa2.banco.persistencia.entidades.seguridad;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Clase responsable de.... <br>
 * 
 * Camilo Andres Ferrer Bustos<br>
 * 
 * Fecha: 4/08/2016
 * @version 1.0
 */
@Entity
public class Usuario implements Serializable {

	/**
	 * nombre de usuario.
	 */
	@Id
	private String nombreUsuario;

	/**
	 * constraseña del usuario.
	 */
	private String password;

	/**
	 * constructor
	 */
	public Usuario() {
	}

	/**
	 * @return the nombreUsuario
	 */
	public String getNombreUsuario() {
		return nombreUsuario;
	}

	/**
	 * @param nombreUsuario
	 *            the nombreUsuario to set
	 */
	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password
	 *            the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

}
