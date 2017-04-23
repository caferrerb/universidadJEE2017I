package co.edu.eam.ingesoft.pa2.banco.web.seguridad;

import java.io.Serializable;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.logging.Logger;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import org.omnifaces.util.Faces;
import org.omnifaces.util.Messages;

import co.edu.eam.ingesoft.pa2.banco.negocio.EmpleadoEJB;
import co.edu.eam.ingesoft.pa2.banco.negocio.SeguridadEJB;
import co.edu.eam.ingesoft.pa2.banco.persistencia.entidades.negocio.Empleado;
import co.edu.eam.ingesoft.pa2.banco.persistencia.entidades.seguridad.Acceso;
import co.edu.eam.ingesoft.pa2.banco.persistencia.entidades.seguridad.AccesoRol;
import co.edu.eam.ingesoft.pa2.banco.persistencia.entidades.seguridad.Rol;
import co.edu.eam.ingesoft.pa2.banco.persistencia.entidades.seguridad.Usuario;

@Named
@SessionScoped
public class SesionBean implements Serializable {

	private org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(SesionBean.class);

	private Usuario usuario;

	private String nombreUsuario;

	private String pass;

	@EJB
	private SeguridadEJB seguridadEJB;
	@EJB
	private EmpleadoEJB empleadoEJB;

	private List<Acceso> accesos;

	private List<Rol> roles;

	/**
	 * Método que <br>
	 * 
	 * @author Camilo Andres Ferrer Bustos<br>
	 * 
	 *         Fecha: 8/08/2016
	 * @version 1.0
	 * @return
	 *
	 */
	public String login() {

		Empleado emp = empleadoEJB.buscarClientePorNombreUsuario(nombreUsuario);

		pass = MD5Util.code(pass);

		if (emp != null && pass.equals(emp.getUsuario().getPassword())) {
			usuario = emp.getUsuario();
			
			Faces.getSession().setAttribute("usuario", usuario);
			
			
			roles = seguridadEJB.listarRolesUsuario(usuario);
			accesos = seguridadEJB.listarAccesosRol(roles);
			Messages.addFlashGlobalInfo("Inicio de sesion exitoso!!!!");
			return "/paginas/inicio.jsf?faces-redirect=true";

		} else {
			usuario = null;
			roles = null;
			accesos = null;
			Messages.addFlashGlobalError("Usuario o password incorrecto!!!!");
			return null;
		}

	}

	/**
	 * 
	 * Método que valida si hay sesion<br>
	 * 
	 * @author Camilo Andres Ferrer Bustos<br>
	 * 
	 * @date 12/08/2016
	 * @version 1.0
	 * @return
	 *
	 */
	public boolean isLogged() {
		
		return usuario != null;
	}

	public String logOut() {
		//
		// FacesContext.getCurrentInstance().getExternalContext().getSession().invalidate()
		Faces.getSession().invalidate();
		return "/index.jsf?faces-redirect=true";
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
	 * @return the pass
	 */
	public String getPass() {
		return pass;
	}

	/**
	 * @param pass
	 *            the pass to set
	 */
	public void setPass(String pass) {
		this.pass = pass;
	}

	/**
	 * @return the usuario
	 */
	public Usuario getUsuario() {
		return usuario;
	}

	/**
	 * @return the accesos
	 */
	public List<Acceso> getAccesos() {
		return accesos;
	}

	/**
	 * @return the roles
	 */
	public List<Rol> getRoles() {
		return roles;
	}

}
