package co.edu.eam.ingesoft.pa.universidad.servicios;

import javax.ejb.EJB;
import javax.enterprise.inject.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import co.edu.eam.ingesoft.pa.negocio.beans.FacultadEJB;
import co.edu.eam.ingesoft.pa.negocio.beans.ProgramaEJB;
import co.edu.eam.ingesoft.pa.persistencia.modelo.entidades.Facultad;

@Path("/facultad")
public class FacultadRest {

	@EJB
	private FacultadEJB ejb;

	@Path("/listar")
	@GET
	@javax.ws.rs.Produces(MediaType.APPLICATION_JSON)
	public RespuestaDTO listar() {
		return new RespuestaDTO("OK", 0, ejb.listar());
	}

	

}
