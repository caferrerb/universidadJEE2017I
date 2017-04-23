package co.edu.eam.ingesoft.pa.serviciointerbancario.logica;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.xml.ws.Endpoint;

import co.edu.eam.ingesoft.pa.serviciointerbancario.modelo.Banco;
import co.edu.eam.ingesoft.pa.serviciointerbancario.modelo.Ciudadano;
import co.edu.eam.ingesoft.pa.serviciointerbancario.modelo.CiudadanoPK;
import co.edu.eam.ingesoft.pa.serviciointerbancario.modelo.ConfiguracionBanco;
import co.edu.eam.ingesoft.pa.serviciointerbancario.modelo.Cuenta;
import co.edu.eam.ingesoft.pa.serviciointerbancario.modelo.CuentaPK;
import co.edu.eam.ingesoft.pa.serviciointerbancario.modelo.EstadoCuentaEnum;
import co.edu.eam.ingesoft.pa.serviciointerbancario.modelo.RespuestaServicio;
import co.edu.eam.ingesoft.pa.serviciointerbancario.modelo.TipoDocumentoEnum;
import co.edu.eam.ingesoft.pa.serviciointerbancario.modelo.Transferencia;

@WebService(name = "InterbancarioWS", serviceName = "InterbancarioWS", targetNamespace = "http://www.eam.edu.co/interbancario")
@Stateless
@LocalBean
public class Logica {

	@PersistenceContext
	private EntityManager em;

	private static HashMap<String, Cuenta> cuentas = new HashMap<>();
	private static List<Banco> listaBancos = new ArrayList<>();
	private static Set<String> novalido = new HashSet<>();
	static {
		listaBancos.add(new Banco("AVVillas", "1"));
		listaBancos.add(new Banco("Bancolombia", "2"));
		listaBancos.add(new Banco("BBVA", "3"));
		listaBancos.add(new Banco("Davivienda", "4"));
		listaBancos.add(new Banco("Caja social", "5"));
		listaBancos.add(new Banco("Banco de Bogota", "6"));
		listaBancos.add(new Banco("Banco popular", "7"));
		listaBancos.add(new Banco("Colpatria", "8"));
		listaBancos.add(new Banco("Banco de la mujer", "9"));
		listaBancos.add(new Banco("Banco pichinca", "10"));
		listaBancos.add(new Banco("Citibank", "11"));
		listaBancos.add(new Banco("Banco Santander", "12"));

	}

	@WebMethod(operationName = "listarBancos")
	@WebResult(name = "ListaBancos")
	public List<Banco> listarBanco() {

		return em.createQuery("select b From Banco b").getResultList();
		// return listaBancos;
	}

	@WebMethod(operationName = "registrarCuentaAsociada")
	@WebResult(name = "respuestaServicio")
	public RespuestaServicio registrarCuentaAsociada(@WebParam(name = "idbanco") String idBanco,
			@WebParam(name = "tipodoc") TipoDocumentoEnum tipoDoc, @WebParam(name = "numerodoc") String numeroDoc,
			@WebParam(name = "nombre") String nombre, @WebParam(name = "numerocuenta") String numeroCuenta) {

		Cuenta acc = em.find(Cuenta.class, new CuentaPK(idBanco, numeroCuenta));
		try {
			if (acc != null) {

				if (acc.getEstado() == EstadoCuentaEnum.ASOCIADA) {
					return new RespuestaServicio("0000", "Asociada");
				} else {
					if (Math.random() > 0.5) {
						acc.setEstado(EstadoCuentaEnum.ASOCIADA);
						em.merge(acc);
						return new RespuestaServicio("0000", EstadoCuentaEnum.ASOCIADA.name());

					} else {
						return new RespuestaServicio("0001", EstadoCuentaEnum.PENDIENTE.name());
					}
				}

			} else {
				Banco banco = em.find(Banco.class, idBanco);

				if (banco != null) {
					// llamar el servicio del banco de destino
					ClienteREstInterbancario rest = new ClienteREstInterbancario();
					ConfiguracionBanco conf = em.find(ConfiguracionBanco.class, banco.getCodigo());
					String resp = rest.verficarCuenta(numeroCuenta, numeroDoc, tipoDoc, conf);
					
					if (resp.equals("OK")) {
						
						Ciudadano persona = em.find(Ciudadano.class, new CiudadanoPK(tipoDoc,numeroDoc));
						if(persona==null){
							persona=new Ciudadano(nombre, numeroDoc, tipoDoc);
							em.persist(persona);
						}
						
						
						
						Cuenta cuenta = new Cuenta(persona, banco, numeroCuenta);
						em.persist(cuenta);
						return new RespuestaServicio("0001", EstadoCuentaEnum.PENDIENTE.name());
					} else {
						return new RespuestaServicio("-500", resp);
					}
				} else {
					return new RespuestaServicio("0010", "Banco no existe");
				}
			}

		} catch (Exception exc) {
			return new RespuestaServicio("-500", exc.getMessage());
		}

	}

	@WebMethod(operationName = "transferirMonto")
	@WebResult(name = "respuestaServicio")
	public RespuestaServicio transferir(@WebParam(name = "idbanco") String idBanco,
			@WebParam(name = "numerocuenta") String numeroCuenta, @WebParam(name = "monto") double monto) {

		Cuenta acc = em.find(Cuenta.class, new CuentaPK(idBanco, numeroCuenta));
		if (acc != null) {

			if (acc.getEstado() == EstadoCuentaEnum.ASOCIADA) {
				ClienteREstInterbancario rest = new ClienteREstInterbancario();
				ConfiguracionBanco conf = em.find(ConfiguracionBanco.class, acc.getBanco().getCodigo());
				String resp = rest.enviarDinero(numeroCuenta, monto, conf);
				if (resp.equals("OK")) {
					Transferencia tx = new Transferencia(acc, monto);
					em.persist(tx);
					return new RespuestaServicio("0000", "Transferencia exitosa");
				} else {
					Transferencia tx = new Transferencia(acc, monto);
					tx.setEstado(resp);
					em.persist(tx);
					return new RespuestaServicio("-500", resp);

				}
			} else {
				Transferencia tx = new Transferencia(acc, monto);
				tx.setEstado("Cuenta no asociada aun");
				em.persist(tx);
				return new RespuestaServicio("0002", "Cuenta no asociada aun");
			}

		} else {
			Transferencia tx = new Transferencia(acc, monto);
			tx.setEstado("Cuenta no existe en el banco de destino");
			em.persist(tx);
			return new RespuestaServicio("004", "Cuenta no existe en el banco de destino");

		}

	}

	public static void main(String[] args) {
		Endpoint.publish("http://0.0.0.0:9191/interbancario", new Logica());
	}

}
