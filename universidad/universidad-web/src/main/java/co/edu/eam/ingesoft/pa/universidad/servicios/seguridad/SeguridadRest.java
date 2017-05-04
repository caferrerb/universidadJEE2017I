package co.edu.eam.ingesoft.pa.universidad.servicios.seguridad;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import co.edu.eam.ingesoft.pa.negocio.beans.SeguridadEJB;
import co.edu.eam.ingesoft.pa.persistencia.modelo.entidades.Usuario;
import co.edu.eam.ingesoft.pa.universidad.servicios.RespuestaDTO;
import co.edu.eam.ingesoft.pa.universidad.servicios.dtos.LoginDTO;
import co.edu.eam.ingesoft.pa.universidad.servicios.dtos.LoginRespuestaDTO;

@Path("/seguridad")
public class SeguridadRest {

	public static Map<String, Usuario> usuarios = new HashMap<String, Usuario>();;

	@EJB
	private SeguridadEJB ejb;

	@Path("/login")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public RespuestaDTO login(LoginDTO dto) {

		Usuario user = ejb.buscarUsuario(dto.getUser());
		if (user != null && user.getPassword().equals(dto.getPassword())) {
			String token = UUID.randomUUID().toString();
			usuarios.put(token, user);
			return new RespuestaDTO("EXITO", 0,
					new LoginRespuestaDTO(token, user.getPersona().getDocumentoidentificacion()));
		} else {
			return new RespuestaDTO("Credenciales erroneas", -403, null);
		}

	}
}
