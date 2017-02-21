package co.edu.eam.ingesoft.pa.negocio.beans.remote;

import co.edu.eam.ingesoft.pa.persistencia.modelo.entidades.Docente;

/**
 * Interface remota para acceder a las operaciones del EJB.
 * @author caferrer
 *
 */
public interface IDocenteRemote {
	
	public void crearDocente(Docente doc);
	public Docente buscarDocente(String documentoidentificacion);
}
