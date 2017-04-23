package co.edu.eam.ingesoft.pa2.banco.rest;

import java.util.Date;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/cuenta")
public class CuentaRest {

	public CuentaRest() {
		// TODO Auto-generated constructor stub
	}
	
	@GET
	public String test(){
		return new Date().toString();
	}

}
