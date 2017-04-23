package co.edu.eam.ingesoft.pa.serviciointerbancario.logica;

import javax.persistence.criteria.Order;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Form;
import javax.ws.rs.core.Response;

import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;

import co.edu.eam.ingesoft.pa.serviciointerbancario.modelo.ConfiguracionBanco;
import co.edu.eam.ingesoft.pa.serviciointerbancario.modelo.TipoDocumentoEnum;

public class ClienteREstInterbancario {

	public String verficarCuenta(String numeroCuenta, String numeroCliente, TipoDocumentoEnum tipoDoc,
			ConfiguracionBanco conf) {
		ResteasyClient client = new ResteasyClientBuilder().build();
		try {
			
			WebTarget target = client.target(conf.getUrlVerificar());
			Form form = new Form().param(conf.getNumeroCuentaVerParam(), numeroCuenta)
					.param(conf.getNumeroDocVerParam(), numeroCliente);

			switch (tipoDoc) {
			case CC:
				form.param(conf.getTipoDocVerParam(), "1");
				break;
			case TI:
				form.param(conf.getTipoDocVerParam(), "2");
				break;
			case PAS:
				form.param(conf.getTipoDocVerParam(), "3");
				break;
			case CE:
				form.param(conf.getTipoDocVerParam(), "4");
				break;
			default:
				break;
			}

			Response response = target.request().post(Entity.form(form));
			String resp = response.readEntity(String.class);
			if (resp.equalsIgnoreCase("exito")) {

				return "OK";
			} else {
				return resp;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return e.getMessage();
		}finally {
			client.close();
		}
	}

	public String enviarDinero(String numeroCuenta, double monto, ConfiguracionBanco conf) {
		ResteasyClient client = new ResteasyClientBuilder().build();
		try {
			
			WebTarget target = client.target(conf.getUrlEnviarDinero());
			Form form = new Form().param(conf.getNumeroCuentaEnvParam(), numeroCuenta).param(conf.getMontoEnvParam(),
					monto + "");

			Response response = target.request().post(Entity.form(form));
			String resp = response.readEntity(String.class);
			if (resp.equalsIgnoreCase("exito")) {

				return "OK";
			} else {
				return resp;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return e.getMessage();
		}finally {
			client.close();
		}
	}
}
