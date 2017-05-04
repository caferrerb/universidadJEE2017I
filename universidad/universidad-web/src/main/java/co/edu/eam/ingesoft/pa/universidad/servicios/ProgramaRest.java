package co.edu.eam.ingesoft.pa.universidad.servicios;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import co.edu.eam.ingesoft.pa.negocio.beans.ProgramaEJB;
import co.edu.eam.ingesoft.pa.persistencia.modelo.entidades.Facultad;
import co.edu.eam.ingesoft.pa.universidad.servicios.seguridad.Secured;

@Secured
@Path("/programa")
public class ProgramaRest {

	@EJB
	private ProgramaEJB progEJB;

	@Path("/listar")
	@GET
	@javax.ws.rs.Produces(MediaType.APPLICATION_JSON)
	public RespuestaDTO listar() {
		return new RespuestaDTO("OK", 0, progEJB.listar());
	}

	@Path("/listarfacultad")
	@GET
	@javax.ws.rs.Produces(MediaType.APPLICATION_JSON)
	public RespuestaDTO listar(@QueryParam("id") String fac) {
		return new RespuestaDTO("OK", 0, progEJB.listarPorFacultad(new Facultad(fac, null)));
	}

}
