package co.edu.eam.ingesoft.pa2.banco.negocio;

import java.util.List;

import javax.ejb.Stateless;

import co.edu.eam.ingesoft.pa2.banco.persistencia.entidades.negocio.Cliente;
import co.edu.eam.ingesoft.pa2.banco.persistencia.entidades.seguridad.Acceso;
import co.edu.eam.ingesoft.pa2.banco.persistencia.entidades.seguridad.Rol;
import co.edu.eam.ingesoft.pa2.banco.persistencia.entidades.seguridad.Usuario;
import co.edu.eam.ingesoft.pa2.banco.persistencia.utilidades.ConstantesNamedQueries;

@Stateless
public class SeguridadEJB extends EJBGenerico<Usuario> {

	/**
	 * constructor.
	 */
	@Override
	public void init() {
		setClase(Usuario.class);
	}

	/**
	 * 
	 * Método que lista los roles de un usuario<br>
	 * 
	 * Camilo Andres Ferrer Bustos<br>
	 * 
	 * Fecha: 4/08/2016
	 * @version 1.0
	 * @param usuario
	 * @return
	 *
	 */
	public List<Rol> listarRolesUsuario(Usuario usuario) {
			return dao.ejecutarNamedQuery(ConstantesNamedQueries.CONSULTA_LISTARROLESUSUARIO, usuario);
	}

	/**
	 * 
	 * Método que lista los accesos validos para un rol <br>
	 * 
	 * @author Camilo Andres Ferrer Bustos<br>
	 * 
	 * Fecha: 4/08/2016
	 * @version 1.0
	 * @param rol
	 * @return
	 *
	 */
	public List<Acceso> listarAccesosRol(List<Rol> roles) {
		return dao.ejecutarNamedQuery(ConstantesNamedQueries.CONSULTA_LISTARACCESOSROL, roles);
	}
	
	

}
