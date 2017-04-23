package co.edu.eam.ingesoft.pa2.banco.web.convertidores;

import javax.ejb.EJB;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Named;

import co.edu.eam.ingesoft.pa2.banco.negocio.TipoCuentaEJB;
import co.edu.eam.ingesoft.pa2.banco.persistencia.entidades.negocio.TipoCuenta;

@Named
@FacesConverter(value = "tipocuenta", forClass = TipoCuenta.class)
public class TipoCuentaConverter implements Converter {
	@EJB
	private TipoCuentaEJB ejb;

	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String string) {

			if (string == null || string.trim().length() == 0 || string.equals("Seleccione...")) {
				return null;
			}

		Integer idtipo = Integer.valueOf(string);
		TipoCuenta tipo = ejb.buscar(idtipo);
		return tipo;


	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {

		if (arg2 instanceof TipoCuenta) {
			TipoCuenta tipo = (TipoCuenta) arg2;
			return String.valueOf(tipo.getId());
		}
		return null;
	}

}
