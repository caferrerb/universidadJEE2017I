package co.edu.eam.ingesoft.pa.serviciointerbancario.web;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Inject;
import javax.inject.Named;

import org.omnifaces.util.Faces;
import org.omnifaces.util.Messages;

import co.edu.eam.ingesoft.pa.serviciointerbancario.logica.ClienteREstInterbancario;
import co.edu.eam.ingesoft.pa.serviciointerbancario.logica.Logica;
import co.edu.eam.ingesoft.pa.serviciointerbancario.logica.Utilidades;
import co.edu.eam.ingesoft.pa.serviciointerbancario.modelo.Banco;
import co.edu.eam.ingesoft.pa.serviciointerbancario.modelo.ConfiguracionBanco;
import co.edu.eam.ingesoft.pa.serviciointerbancario.modelo.Cuenta;
import co.edu.eam.ingesoft.pa.serviciointerbancario.modelo.TipoDocumentoEnum;
import co.edu.eam.ingesoft.pa.serviciointerbancario.modelo.Transferencia;

@Named
@org.omnifaces.cdi.ViewScoped
public class Controlador implements Serializable {

	private List<Banco> bancos;

	private ConfiguracionBanco conf;

	private String codigoBanco;
	private String nombreBanco;

	private String numeroCuenta;
	private double monto;
	private TipoDocumentoEnum tipoDoc;
	private String numeroDoc;

	@Inject
	private Logica log;

	@Inject
	private Utilidades util;

	private List<Transferencia> txs;
	
	private List<Cuenta> cuentas;

	@PostConstruct
	public void init() {
		bancos = log.listarBanco();
		txs = util.listarTx();
		cuentas=util.listarCuentas();
		String idbanco = Faces.getSessionAttribute("banco");
		codigoBanco = idbanco;
		if (idbanco == null) {
			conf = new ConfiguracionBanco();
		} else {
			conf = util.buscarConf(idbanco);
		}
	}

	public void crearBanco() {
		util.crearBanco(nombreBanco, codigoBanco);
		Messages.addFlashGlobalInfo("Banco creado!!!");
		bancos = log.listarBanco();

	}

	public String irConfBanco(String banco) {
		Faces.setSessionAttribute("banco", banco);
		return "/configurarbanco.xhtml?faces-redirect=true";
	}

	public String irProbarBanco(String banco) {
		Faces.setSessionAttribute("banco", banco);
		return "/probarbanco.xhtml?faces-redirect=true";

	}

	public void editarConfiguracion() {
		util.editarConfiguracion(conf);
		Messages.addFlashGlobalInfo("Configuracion editada con exito!!!");
	}

	public TipoDocumentoEnum[] getTipos() {
		return TipoDocumentoEnum.values();
	}

	public void probarEnviarDinero() {
		// RespuestaServicio resp = log.registrarCuentaAsociada(codigoBanco,
		// tipoDoc, numeroDoc, "Test", numeroCuenta);
		ClienteREstInterbancario client = new ClienteREstInterbancario();
		String resp = client.enviarDinero(numeroCuenta, monto, conf);
		Messages.addFlashGlobalInfo("Respuesta:" + resp);

	}

	public void probarVerificarCuenta() {
		// RespuestaServicio resp = log.registrarCuentaAsociada(codigoBanco,
		// tipoDoc, numeroDoc, "Test", numeroCuenta);
		ClienteREstInterbancario client = new ClienteREstInterbancario();
		String resp = client.verficarCuenta(numeroCuenta, numeroDoc, tipoDoc, conf);
		Messages.addFlashGlobalInfo("Respuesta:" + resp);

	}

	public List<Banco> getBancos() {
		return bancos;
	}

	public void setBancos(List<Banco> bancos) {
		this.bancos = bancos;
	}

	public ConfiguracionBanco getConf() {
		return conf;
	}

	public void setConf(ConfiguracionBanco conf) {
		this.conf = conf;
	}

	public String getCodigoBanco() {
		return codigoBanco;
	}

	public void setCodigoBanco(String codigoBanco) {
		this.codigoBanco = codigoBanco;
	}

	public String getNombreBanco() {
		return nombreBanco;
	}

	public void setNombreBanco(String nombreBanco) {
		this.nombreBanco = nombreBanco;
	}

	public String getNumeroCuenta() {
		return numeroCuenta;
	}

	public void setNumeroCuenta(String numeroCuenta) {
		this.numeroCuenta = numeroCuenta;
	}

	public double getMonto() {
		return monto;
	}

	public void setMonto(double monto) {
		this.monto = monto;
	}

	public TipoDocumentoEnum getTipoDoc() {
		return tipoDoc;
	}

	public void setTipoDoc(TipoDocumentoEnum tipoDoc) {
		this.tipoDoc = tipoDoc;
	}

	public String getNumeroDoc() {
		return numeroDoc;
	}

	public void setNumeroDoc(String numeroDoc) {
		this.numeroDoc = numeroDoc;
	}

	public List<Transferencia> getTxs() {
		return txs;
	}
	
	public List<Cuenta> getCuentas() {
		return cuentas;
	}

}
