package co.edu.eam.ingesoft.pa2.banco.rest;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import co.edu.eam.ingesoft.pa2.banco.negocio.ClienteEJB;
import co.edu.eam.ingesoft.pa2.banco.negocio.CuentaEJB;
import co.edu.eam.ingesoft.pa2.banco.persistencia.entidades.negocio.Cliente;
import co.edu.eam.ingesoft.pa2.banco.rest.dto.ReporteCuentaDTO;
import co.edu.eam.ingesoft.pa2.banco.rest.dto.RespuestaDTO;
import co.edu.eam.ingesoft.pa2.banco.rest.dto.RespuestaEvaluacionDTO;
import co.edu.eam.ingesoft.pa2.banco.rest.dto.RespuestaPreguntaDTO;

@Path("/cliente")
public class ClienteREST {

	@EJB
	private ClienteEJB clienteEJB;

	@EJB
	private CuentaEJB accEJB;

	public ClienteREST() {
	}

	@GET
	@Path("/buscarcliente")
	@Produces(MediaType.APPLICATION_XML)
	public RespuestaDTO buscarCliente(@QueryParam(value = "ced") String cedula) {
		System.out.println("buscando a:" + cedula);
		Cliente c = clienteEJB.buscar(cedula);
		return new RespuestaDTO(c);
	}

	@Path("/crear")
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public RespuestaDTO crear(Cliente cliente) {

		if (clienteEJB.buscar(cliente.getCedula()) == null) {
			clienteEJB.crear(cliente);
			return new RespuestaDTO(true);
		} else {
			return new RespuestaDTO(false, "El cliente ya existe", "-1");
		}

	}

	@Path("/listar")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public RespuestaDTO listarCLientes() {
		List<Cliente> lista = clienteEJB.listar();
		System.err.println("METODO LISTAR!!!!!");
		if (Math.random() > 0.5) {
			throw new RuntimeException("Excepcion!!!!!!");
		}
		return new RespuestaDTO(lista);
	}

	@GET
	@Path("/reportecuentas")
	@Produces(MediaType.APPLICATION_JSON)
	public RespuestaDTO reporteCuentas() {
		List<ReporteCuentaDTO> dtos = new ArrayList<ReporteCuentaDTO>();
		List<Object[]> lista = accEJB.reporteCuentas();
		// acc.numero,acc.tipo,cli.nombre,acc.saldo
		for (Object[] objects : lista) {
			dtos.add(new ReporteCuentaDTO(objects[0].toString(), (double) objects[3], objects[2].toString(),
					objects[1].toString()));
		}

		return new RespuestaDTO(dtos);

	}

	@POST
	@Path("/responderEval")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public RespuestaDTO calificarEvaluacion(RespuestaEvaluacionDTO resp) {
		
		System.out.println(resp.getCodEstudiante());
		System.out.println(resp.getComentario());
		System.out.println(resp.getIdGrupo());
		
		for (RespuestaPreguntaDTO res : resp.getRespuesta()) {
			System.out.println(res.getIdPregunta()+"-"+res.getCalificacion());
		}
		
		
		return new RespuestaDTO("OK");
	}

	// @Path("/a")
	// @Produces(MediaType.APPLICATION_XML)
	// @GET
	// public B b(){
	// return new A();
	// }

}
