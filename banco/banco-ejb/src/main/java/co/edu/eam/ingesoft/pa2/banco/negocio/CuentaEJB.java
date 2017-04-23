package co.edu.eam.ingesoft.pa2.banco.negocio;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.xml.ws.BindingProvider;

import co.edu.eam.ingesoft.pa2.banco.negocio.excepciones.ExcepcionFuncional;
import co.edu.eam.ingesoft.pa2.banco.persistencia.entidades.negocio.Cliente;
import co.edu.eam.ingesoft.pa2.banco.persistencia.entidades.negocio.Cuenta;
import co.edu.eam.pa.clientews.Notificaciones;
import co.edu.eam.pa.clientews.NotificacionesService;
import co.edu.eam.pa.clientews.Sms;

@Stateless
public class CuentaEJB extends EJBGenerico<Cuenta> {

	@EJB
	private ClienteEJB clienteEJB;

	@Override
	public void init() {
		setClase(Cuenta.class);

	}

	public void crearCuenta(Cuenta cuenta, String cedulaCLiente) {
		Cliente cliente = clienteEJB.buscar(cedulaCLiente);
		if (cliente != null) {
			cuenta.setCliente(cliente);
			super.crear(cuenta);
		} else {
			throw new ExcepcionFuncional("Cliente no registrado");
		}
	}

	public void consignar(String cuenta, double monto) {
		Cuenta acc = buscar(cuenta);
		if (acc != null) {
			acc.setSaldo(acc.getSaldo() + monto);
			editar(acc);
			Cliente cust = dao.encontrarPorId(Cliente.class, acc.getCliente().getCedula());
			String tel = cust.getTelefono();
			NotificacionesService cliente = new NotificacionesService();
			Notificaciones servicio = cliente.getNotificacionesPort();

			String endpointURL = "http://104.197.238.134:8080/notificaciones/notificacionesService";
			BindingProvider bp = (BindingProvider) servicio;
			bp.getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, endpointURL);
			Sms sms = new Sms();
			sms.setTexto("Cuenta# "+acc.getCodigo()+"Consignacion por:" + monto + ". nuevo saldo:" + acc.getSaldo());
			sms.setTo(tel);
			servicio.enviarSMS(sms);
		}else{
			throw new ExcepcionFuncional("Cuenta no existe!!!");
		}
	}

	public List<Object[]> reporteCuentas() {
		return dao.ejecutarNamedQuery("cuenta.reporteCuentas");
	}
}
