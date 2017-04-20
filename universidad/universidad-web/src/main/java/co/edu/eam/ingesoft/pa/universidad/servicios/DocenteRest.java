package co.edu.eam.ingesoft.pa.universidad.servicios;

import java.util.Date;
import java.util.List;

import javax.annotation.Generated;
import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import co.edu.eam.ingesoft.pa.negocio.beans.DocenteEJB;
import co.edu.eam.ingesoft.pa.persistencia.modelo.entidades.Docente;
import co.edu.eam.ingesoft.pa.universidad.servicios.dtos.EditarNombreDTO;

//para invocar un servicio se necesita:
/*
 * 1. la url del servicio: http://ip:puerto/<root>/<raizRest>/<pathclase>/<pathmetodo>
 */
//<pathclase>=docente
@Path("/docente")
public class DocenteRest {
	
	@EJB
	private DocenteEJB docEJB;
	//pathmetodo=darhora
	@GET
	@Path("/darHora")
	public String darFecha(){
		return new Date().toString();
	}
	
	@GET
	@Path("/buscar")
	@Produces(MediaType.APPLICATION_JSON)
	public RespuestaDTO buscarDocente(@QueryParam("documento")String codigo){
		Docente doc=docEJB.buscarDocente(codigo);
		return new RespuestaDTO("se encontro", 0, doc)
				;
	}
	@PUT
	@Path("/crear")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public RespuestaDTO crear(Docente doc){
		
		docEJB.crearDocente(doc);
		return new RespuestaDTO("se creo exitosamente", 0, true);
		
	}
	
	
	@POST
	@Path("/editar")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public RespuestaDTO editar(Docente doc){
		
		docEJB.editarDocente(doc);
		return new RespuestaDTO("se edito exitosamente", 0, true);
		
	}
	
	@POST
	@Path("/editarnombre")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	public RespuestaDTO editar(@FormParam("cedula")String codigo,@FormParam("nombre")String nombre){
		Docente doc=docEJB.buscarDocente(codigo);
		doc.setNombre(nombre);
		docEJB.editarDocente(doc);
		return new RespuestaDTO("se edito exitosamente", 0, true);
	}
	@GET
	@Path("/listar")
	@Produces(MediaType.APPLICATION_JSON)
	public RespuestaDTO listar(){
		List<Docente> lista= docEJB.listar();
		if(lista.isEmpty()){
			return new RespuestaDTO("No hay registros", 1, null);
		}else{
			return new RespuestaDTO("Se encontraron registros",0,lista);
		}
	}
	
	
	@POST
	@Path("/editarnombredto")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public RespuestaDTO editar(EditarNombreDTO dto){
		Docente doc=docEJB.buscarDocente(dto.getCedula());
		doc.setNombre(dto.getNombre());
		docEJB.editarDocente(doc);
		return new RespuestaDTO("se edito exitosamente", 0, true);
	}
	
	
	
	
	
	

}
