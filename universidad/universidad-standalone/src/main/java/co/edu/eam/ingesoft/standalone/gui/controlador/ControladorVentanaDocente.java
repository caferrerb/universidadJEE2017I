package co.edu.eam.ingesoft.standalone.gui.controlador;

import javax.naming.NamingException;

import co.edu.eam.ingesoft.pa.negocio.beans.remote.IDocenteRemote;
import co.edu.eam.ingesoft.pa.persistencia.modelo.entidades.Docente;
import co.edu.eam.ingesoft.standalone.util.ServiceLocator;

/**
 * Controlador de la ventana de crear docente.
 * @author caferrer
 *
 */
public class ControladorVentanaDocente {

	/**
	 * interface remota del EJB
	 */
	private IDocenteRemote docenteRemoto;
	
	/**
	 * constructor
	 * @throws NamingException
	 */
	public ControladorVentanaDocente() throws NamingException {
		docenteRemoto=(IDocenteRemote) ServiceLocator.buscarEJB("DocenteEJB",
				IDocenteRemote.class.getCanonicalName());
	}
	
	/**
	 * metodo para buscar docente.
	 * @param identificacion
	 * @return el docente.
	 */
	public Docente buscarDocente(String identificacion){
		return docenteRemoto.buscarDocente(identificacion);
	}
	
	/**
	 * metodo para crear docente.
	 * @param doc, docente
	 */
	public void crearDocente(Docente doc){
		docenteRemoto.crearDocente(doc);
	}
}
