package co.edu.eam.ingesoft.pa.universidad.web.convertidores;

import javax.ejb.EJB;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Named;

import co.edu.eam.ingesoft.pa.negocio.beans.FacultadEJB;
import co.edu.eam.ingesoft.pa.persistencia.modelo.entidades.Facultad;
import co.edu.eam.ingesoft.pa.persistencia.modelo.entidades.Programa;

@FacesConverter(value="facConverter",forClass=Facultad.class)
@Named("facConverter")
public class FacultadConverter implements Converter {

	@EJB
	private FacultadEJB facEjb;
	
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String string) {
		if (string == null || string.trim().length() == 0 || string.equals("Seleccione...")) {
			return null;
		}
		return facEjb.buscar(string);
	}

	public String getAsString(FacesContext arg0, UIComponent arg1, Object obj) {

		if (obj instanceof Facultad) {
			Facultad fac = (Facultad) obj;
			return fac.getCodigo();
		}
		
		return null;
	}

}
