package co.edu.eam.ingesoft.pa2.banco.web.controladores;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;

import org.omnifaces.cdi.ViewScoped;
import org.omnifaces.util.Messages;
import org.primefaces.context.RequestContext;

import co.edu.eam.ingesoft.pa2.banco.negocio.ClienteEJB;
import co.edu.eam.ingesoft.pa2.banco.persistencia.entidades.negocio.Cliente;
import co.edu.eam.ingesoft.pa2.banco.web.interceptor.Secured;

/**
 * 
 * Controlador pantalla cliente. <br>
 * 
 * Camilo Andres Ferrer Bustos<br>
 * 
 * Fecha: 3/08/2016
 * @version 1.0
 */
@Named
@ViewScoped
public class ClienteBean implements Serializable {

	/**
	 * Instnacia del cliente a manejar en este controlador.
	 */
	private Cliente instancia;
	/**
	 * Lista de clientes.
	 */
	private java.util.List<Cliente> lista;

	/**
	 * ejb del clietne.
	 */
	@EJB
	private ClienteEJB clienteEJB;

	/**
	 * Método que inicializa el controlador. <br>
	 * 
	 * Camilo Andres Ferrer Bustos<br>
	 * 
	 * Fecha: 3/08/2016
	 * @version 1.0
	 *
	 */
	@PostConstruct
	public void init() {
		instancia = new Cliente();
		lista = clienteEJB.listar();
	}

	/**
	 * Método que crea un cliente.<br>
	 * 
	 * Camilo Andres Ferrer Bustos<br>
	 * 
	 * Fecha: 3/08/2016
	 * @version 1.0
	 *
	 */
	@Secured
	public void crear() {

		if (clienteEJB.buscar(instancia.getCedula()) == null) {

			clienteEJB.crear(instancia);
			Messages.addGlobalInfo("Cliente registrado con exito");
			init();
		} else {
			Messages.addGlobalError("Cliente con cedula {0} ya se encuentra registrado", instancia.getCedula());

		}
	}
	
	/**
	 * Método que edita un cliente.<br>
	 * 
	 * Camilo Andres Ferrer Bustos<br>
	 * 
	 * Fecha: 3/08/2016
	 * @version 1.0
	 *
	 */
	@Secured
	public void editar() {

		if (clienteEJB.buscar(instancia.getCedula()) != null) {

			clienteEJB.editar(instancia);
			Messages.addGlobalInfo("Cliente editado con exito");
			init();
		} else {
			Messages.addGlobalError("Cliente con cedula {0} NO se encuentra registrado", instancia.getCedula());

		}
	}

	/**
	 * 
	 * Método que busca un clietna. <br>
	 * 
	 * Camilo Andres Ferrer Bustos<br>
	 * 
	 * Fecha: 3/08/2016
	 * @version 1.0
	 *
	 */
	public void buscar() {
		instancia = clienteEJB.buscar(instancia.getCedula());
		if (instancia == null) {
			instancia = new Cliente();
			Messages.addGlobalWarn("Cliente con cedula {0} NO se encuentra registrado", instancia.getCedula());
		}
	}

	/**
	 * 
	 * Método que selecciona un cliente de la tabla <br>
	 * 
	 * Camilo Andres Ferrer Bustos<br>
	 * 
	 * Fecha: 3/08/2016
	 * @version 1.0
	 * @param cliente
	 *
	 */
	public void seleccionar(Cliente cliente) {
		System.out.println(cliente);
		instancia = clienteEJB.buscar(cliente.getCedula());
	}
	
	public void seleccionar2(Cliente cliente) {
		System.out.println(cliente);
		instancia = clienteEJB.buscar(cliente.getCedula());
		Map<String,Object> options = new HashMap<String, Object>();
        options.put("resizable", false);
        RequestContext.getCurrentInstance().openDialog("viewCars", options, null);
	}
	
	public void borrar(){
		clienteEJB.eliminar(instancia.getCedula());
		Messages.addGlobalWarn("Cliente borrado");
		init();
		
	}

	public Cliente getInstancia() {
		return instancia;
	}

	public void setInstancia(Cliente instancia) {
		this.instancia = instancia;
	}

	public java.util.List<Cliente> getLista() {
		return lista;
	}

	public void setLista(java.util.List<Cliente> lista) {
		this.lista = lista;
	}
	
	
}
