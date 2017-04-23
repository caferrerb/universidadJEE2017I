package co.edu.eam.ingesoft.pa2.banco.persistencia.utilidades;

/**
 * Clase para las contantes de los nombres de las namedqueris. <br>
 * 
 * @author Camilo Andres Ferrer Bustos<br>
 * 
 * Fecha: 4/08/2016
 * @version 1.0
 */
public class ConstantesNamedQueries {

	/**
	 * Consulta que retorna la lista de accesos de un rol.<br>
	 * ?1: rol.
	 */
	public static final String CONSULTA_LISTARACCESOSROL = "acceso.listarAccesosPorRol";

	/**
	 * Consulta que retorna la lista de roles de un usuario.<br>
	 * ?1: usuario.
	 */
	public static final String CONSULTA_LISTARROLESUSUARIO = "rol.listarRolesPorUsuario";

	
	/**
	 * Consulta que retorna el cliente asociado a un usuario<br>
	 * ?1: nombre usuario.
	 */
	public static final String CONSULTA_BUSCARCLIENTE_POR_USUARIO = "cliente.buscarPorUsuario";

	
	/**
	 * Consulta que retorna el empleado asociado a un usuario<br>
	 * ?1: nombre usuario.
	 */
	public static final String CONSULTA_BUSCAREMP_POR_USUARIO = "empleado.buscarPorUsuario";
	
	private ConstantesNamedQueries() {
	}
	
}
