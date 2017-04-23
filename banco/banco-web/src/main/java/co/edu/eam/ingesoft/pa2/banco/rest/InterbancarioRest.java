package co.edu.eam.ingesoft.pa2.banco.rest;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import co.edu.eam.ingesoft.pa2.banco.negocio.CuentaEJB;
import co.edu.eam.ingesoft.pa2.banco.persistencia.entidades.negocio.Cliente;
import co.edu.eam.ingesoft.pa2.banco.persistencia.entidades.negocio.Cuenta;

@Path("/interbancario")
public class InterbancarioRest {

	@EJB
	private CuentaEJB cuentaEJB;

	@POST
	@Path("/verificarcuenta")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.TEXT_PLAIN)
	public String verificarCuenta(@FormParam("numerodoc") String cedula, @FormParam("tipodoc") String tipo,
			@FormParam("numerocuenta") String numero) {

		try {

			Cuenta acc = cuentaEJB.buscar(numero);
			if (acc != null) {
				Cliente c = acc.getCliente();
				if (c.getCedula().equals(cedula)) {
					return "EXITO";
				}
			}

			return "ERROR";
		} catch (Exception e) {
			e.printStackTrace();
			return "ERROR";
		}

	}

	@POST
	@Path("/recibirdinero")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.TEXT_PLAIN)

	public String recibirDinero(@FormParam("monto") double monto, @FormParam("numerocuenta") String numero) {
		try {
			cuentaEJB.consignar(numero, monto);
			return "EXITO";
		} catch (Exception e) {
			e.printStackTrace();
			return "ERROR";
		}
	}

}
