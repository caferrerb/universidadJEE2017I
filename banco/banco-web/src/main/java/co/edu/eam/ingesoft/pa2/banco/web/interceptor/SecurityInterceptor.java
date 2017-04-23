package co.edu.eam.ingesoft.pa2.banco.web.interceptor;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

import org.apache.log4j.Logger;

import co.edu.eam.ingesoft.pa2.banco.negocio.excepciones.ExcepcionFuncional;
import co.edu.eam.ingesoft.pa2.banco.persistencia.entidades.seguridad.Rol;
import co.edu.eam.ingesoft.pa2.banco.web.seguridad.SesionBean;

@Interceptor
@Secured
public class SecurityInterceptor implements Serializable {

	private static Logger log = Logger.getLogger(SecurityInterceptor.class);

	@Inject
	private SesionBean sesion;

	@AroundInvoke
	public Object intercpetar(InvocationContext ctx) throws Exception {

		// verificar que el metodo que se invoca este anotado.
		if (ctx.getMethod().isAnnotationPresent(Secured.class)) {

			if (sesion.isLogged()) {
				Secured sec = ctx.getMethod().getAnnotation(Secured.class);
				String rol = sec.rol();

				List<Rol> roles = sesion.getRoles();
				boolean invocar = false;
				for (Rol r : roles) {
					if (r.getDescripcion().equals(rol)) {
						invocar = true;
					}
				}
				if (invocar) {
					Object res = ctx.proceed();
					return res;
				} else {
					throw new ExcepcionFuncional("No autorizado!!!");
				}
			} else {
				throw new ExcepcionFuncional("No autorizado!!!");
			}
		} else {
			Object res = ctx.proceed();
			return res;
		}

	}
}
