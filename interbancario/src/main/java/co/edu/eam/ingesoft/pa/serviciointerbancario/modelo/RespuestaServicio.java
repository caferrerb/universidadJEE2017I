package co.edu.eam.ingesoft.pa.serviciointerbancario.modelo;

public class RespuestaServicio {

	private String codigo;
	private String mensaje;
	
	public RespuestaServicio() {
		// TODO Auto-generated constructor stub
	}
	
	
	public RespuestaServicio(String codigo, String mensaje) {
		super();
		this.codigo = codigo;
		this.mensaje = mensaje;
	}


	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getMensaje() {
		return mensaje;
	}
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	
	
}
