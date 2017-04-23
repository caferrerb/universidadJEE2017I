package co.edu.eam.ingesoft.pa.serviciointerbancario.logica;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import co.edu.eam.ingesoft.pa.serviciointerbancario.modelo.Banco;
import co.edu.eam.ingesoft.pa.serviciointerbancario.modelo.ConfiguracionBanco;
import co.edu.eam.ingesoft.pa.serviciointerbancario.modelo.Cuenta;
import co.edu.eam.ingesoft.pa.serviciointerbancario.modelo.Transferencia;

@Stateless
@LocalBean
public class Utilidades {

	@PersistenceContext
	private EntityManager em;

	public void crearBanco(String nombre, String codigo) {
		Banco b = new Banco(nombre, codigo);
		em.persist(b);
		ConfiguracionBanco conf = new ConfiguracionBanco();
		conf.setBanco(b);
		em.persist(conf);

	}

	public void configurarBanco(ConfiguracionBanco conf) {
		em.persist(conf);

	}

	public ConfiguracionBanco buscarConf(String id) {
		return em.find(ConfiguracionBanco.class, id);
	}

	public void editarConfiguracion(ConfiguracionBanco conf) {
		ConfiguracionBanco confbus = buscarConf(conf.getId());
		confbus.setMontoEnvParam(conf.getMontoEnvParam());
		confbus.setNumeroCuentaEnvParam(conf.getNumeroCuentaEnvParam());
		confbus.setNumeroCuentaVerParam(conf.getNumeroCuentaVerParam());
		confbus.setTipoDocVerParam(conf.getTipoDocVerParam());
		confbus.setNumeroDocVerParam(conf.getNumeroDocVerParam());
		confbus.setUrlEnviarDinero(conf.getUrlEnviarDinero());
		confbus.setUrlVerificar(conf.getUrlVerificar());

		em.merge(confbus);
	}

	public List<Transferencia> listarTx() {
		return em.createQuery("select t from Transferencia t  ORDER by t.fecha desc").getResultList();
	}
	
	public List<Cuenta> listarCuentas() {
		return em.createQuery("select t from Cuenta t ").getResultList();
	}
}
