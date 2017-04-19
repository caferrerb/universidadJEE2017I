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
	public Docente buscarDocente(@QueryParam("documento")String codigo){
		Docente doc=docEJB.buscarDocente(codigo);
		return doc;
	}
	@PUT
	@Path("/crear")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public boolean crear(Docente doc){
		try{
		docEJB.crearDocente(doc);
		return true;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}
	
	
	@POST
	@Path("/editar")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public boolean editar(Docente doc){
		try{
		docEJB.editarDocente(doc);
		return true;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}
	
	@POST
	@Path("/editarnombre")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	public boolean editar(@FormParam("cedula")String codigo,@FormParam("nombre")String nombre){
		Docente doc=docEJB.buscarDocente(codigo);
		doc.setNombre(nombre);
		docEJB.editarDocente(doc);
		return true;
	}
	
	@GET
	@Path("/listar")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Docente> listar(){
		return docEJB.listar();
	}
	
	
	
	
	
	

}
