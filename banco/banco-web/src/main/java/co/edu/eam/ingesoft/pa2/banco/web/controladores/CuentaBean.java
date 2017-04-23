package co.edu.eam.ingesoft.pa2.banco.web.controladores;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.validation.constraints.Pattern;

import org.omnifaces.cdi.ViewScoped;
import org.omnifaces.util.Messages;

import co.edu.eam.ingesoft.pa2.banco.negocio.CuentaEJB;
import co.edu.eam.ingesoft.pa2.banco.negocio.TipoCuentaEJB;
import co.edu.eam.ingesoft.pa2.banco.negocio.excepciones.ExcepcionFuncional;
import co.edu.eam.ingesoft.pa2.banco.persistencia.entidades.negocio.Cliente;
import co.edu.eam.ingesoft.pa2.banco.persistencia.entidades.negocio.Cuenta;
import co.edu.eam.ingesoft.pa2.banco.persistencia.entidades.negocio.TipoCuenta;
import co.edu.eam.ingesoft.pa2.banco.web.interceptor.ExceptionLogger;
import co.edu.eam.ingesoft.pa2.banco.web.interceptor.Secured;

@Named
@ViewScoped
@ExceptionLogger
public class CuentaBean implements Serializable {

	private TipoCuenta tipoCuentaSeleccionado;

	private String numero;

	private String cedulaCliente;

	private double saldoInicial;

	private List<TipoCuenta> listaTipos;

	@EJB
	private TipoCuentaEJB tipoCuentaEJB;
	@EJB
	private CuentaEJB cuentaEJB;

	@PostConstruct
	public void init() {
		listaTipos = tipoCuentaEJB.listar();
	}
	
	//@Secured(rol="superhipermegaadministrador")
	public void crear() {
		Cuenta cuenta = new Cuenta();
		cuenta.setCliente(new Cliente(null, null, null, null, cedulaCliente));
		cuenta.setSaldo(saldoInicial);
		cuenta.setTipo(tipoCuentaSeleccionado);
		cuenta.setCodigo(numero);

		cuentaEJB.crearCuenta(cuenta, cedulaCliente);
		Messages.addGlobalInfo("Cuenta creada con exito!!!");

	}

	/**
	 * @return the tipoCuentaSeleccionado
	 */
	public TipoCuenta getTipoCuentaSeleccionado() {
		return tipoCuentaSeleccionado;
	}

	/**
	 * @param tipoCuentaSeleccionado
	 *            the tipoCuentaSeleccionado to set
	 */
	public void setTipoCuentaSeleccionado(TipoCuenta tipoCuentaSeleccionado) {
		this.tipoCuentaSeleccionado = tipoCuentaSeleccionado;
	}

	/**
	 * @return the listaTipos
	 */
	public List<TipoCuenta> getListaTipos() {
		return listaTipos;
	}

	/**
	 * @param listaTipos
	 *            the listaTipos to set
	 */
	public void setListaTipos(List<TipoCuenta> listaTipos) {
		this.listaTipos = listaTipos;
	}

	/**
	 * @return the tipoCuentaEJB
	 */
	public TipoCuentaEJB getTipoCuentaEJB() {
		return tipoCuentaEJB;
	}

	/**
	 * @param tipoCuentaEJB
	 *            the tipoCuentaEJB to set
	 */
	public void setTipoCuentaEJB(TipoCuentaEJB tipoCuentaEJB) {
		this.tipoCuentaEJB = tipoCuentaEJB;
	}

	/**
	 * @return the numero
	 */
	public String getNumero() {
		return numero;
	}

	/**
	 * @param numero the numero to set
	 */
	public void setNumero(String numero) {
		this.numero = numero;
	}

	/**
	 * @return the cedulaCliente
	 */
	public String getCedulaCliente() {
		return cedulaCliente;
	}

	/**
	 * @param cedulaCliente the cedulaCliente to set
	 */
	public void setCedulaCliente(String cedulaCliente) {
		this.cedulaCliente = cedulaCliente;
	}

	/**
	 * @return the saldoInicial
	 */
	public double getSaldoInicial() {
		return saldoInicial;
	}

	/**
	 * @param saldoInicial the saldoInicial to set
	 */
	public void setSaldoInicial(double saldoInicial) {
		this.saldoInicial = saldoInicial;
	}
	
	

}
