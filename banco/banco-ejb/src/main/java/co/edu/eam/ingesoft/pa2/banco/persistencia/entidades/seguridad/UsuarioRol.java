package co.edu.eam.ingesoft.pa2.banco.persistencia.entidades.seguridad;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.ManyToOne;

@Entity
@IdClass(value= UsuarioRolPK.class)
public class UsuarioRol implements Serializable {

	
	@Id
	@ManyToOne
	private Usuario usuario;
	
	@Id
	@ManyToOne
	private Rol rol;

	/**
	 * constructor.
	 */
	public UsuarioRol() {
	}
	
	/**
	 * constructor.
	 * @param usuario
	 * @param rol
	 */
	public UsuarioRol(Usuario usuario, Rol rol) {
		super();
		this.usuario = usuario;
		this.rol = rol;
	}

	/**
	 * @return the usuario
	 */
	public Usuario getUsuario() {
		return usuario;
	}

	/**
	 * @param usuario the usuario to set
	 */
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	/**
	 * @return the rol
	 */
	public Rol getRol() {
		return rol;
	}

	/**
	 * @param rol the rol to set
	 */
	public void setRol(Rol rol) {
		this.rol = rol;
	}
	
	
	
	
	
}
