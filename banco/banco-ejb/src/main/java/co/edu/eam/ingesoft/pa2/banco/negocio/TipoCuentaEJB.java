package co.edu.eam.ingesoft.pa2.banco.negocio;

import javax.ejb.Stateless;

import co.edu.eam.ingesoft.pa2.banco.persistencia.entidades.negocio.TipoCuenta;

@Stateless
public class TipoCuentaEJB extends EJBGenerico<TipoCuenta> {

	@Override
	public void init() {
		setClase(TipoCuenta.class);
		
	}

}
