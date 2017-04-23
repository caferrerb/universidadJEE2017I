package co.edu.eam.ingesoft.pa2.banco.negocio;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import co.edu.eam.ingesoft.pa2.banco.persistencia.entidades.negocio.Cliente;
import co.edu.eam.ingesoft.pa2.banco.persistencia.utilidades.ConstantesNamedQueries;

/**
 * Clase responsable de la logica de negocio del cliente. <br>
 * 
 * Camilo Andres Ferrer Bustos<br>
 * 
 * Fecha: 3/08/2016
 * @version 1.0
 */
@Stateless
@LocalBean
public class ClienteEJB extends EJBGenerico<Cliente> {

	@Override
	public void init() {
		setClase(Cliente.class);

	}

	/**
	 * 
	 * Método que busca un cliente por nombre de usuario <br>
	 * 
	 * @author Camilo Andres Ferrer Bustos<br>
	 * 
	 * Fecha: 4/08/2016
	 * @version 1.0
	 * @param rol
	 * @return
	 *
	 */
	public Cliente buscarClientePorNombreUsuario(String nombreUsuario) {
		List<Cliente> lista = dao.ejecutarNamedQuery(ConstantesNamedQueries.CONSULTA_BUSCARCLIENTE_POR_USUARIO,
				nombreUsuario);
		
		if(lista.isEmpty()){
			return null;
		}else{
			return lista.get(0);
		}
	}

}
