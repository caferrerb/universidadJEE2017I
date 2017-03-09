package co.edu.eam.ingesoft.pa.universidad.web.convertidores;

import javax.ejb.EJB;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Named;

import co.edu.eam.ingesoft.pa.negocio.beans.ProgramaEJB;
import co.edu.eam.ingesoft.pa.persistencia.modelo.entidades.Programa;

@FacesConverter(value="progConverter",forClass=Programa.class)
@Named("progConverter")
public class ProgramaConverter implements Converter {

	@EJB
	private ProgramaEJB progEjb;
	
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String string) {
		if (string == null || string.trim().length() == 0 || string.equals("Seleccione...")) {
			return null;
		}
		return progEjb.buscar(string);
	}

	public String getAsString(FacesContext arg0, UIComponent arg1, Object obj) {

		if (obj instanceof Programa) {
			Programa prog = (Programa) obj;
			return prog.getCodigo();
		}
		
		return null;
	}

}
