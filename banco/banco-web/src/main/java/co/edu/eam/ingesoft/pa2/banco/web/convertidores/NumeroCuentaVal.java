package co.edu.eam.ingesoft.pa2.banco.web.convertidores;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import javax.inject.Named;

@FacesValidator(value="numeroval")
public class NumeroCuentaVal implements Validator {

	@Override
	public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
		
			if (value instanceof String) {
				String numero = (String) value;
				if(!numero.matches("[0-9]{3}-[0-9]{5}")){
					throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR,"El numero de la cuenta debe ser de la forma ###-#####",null));
				}
				
			}else{
				throw new ValidatorException(new FacesMessage("Tipo invalido, se espera String"));
			}
		
	}

}
