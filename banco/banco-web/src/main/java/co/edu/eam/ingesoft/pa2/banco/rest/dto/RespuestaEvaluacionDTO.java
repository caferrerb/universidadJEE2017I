package co.edu.eam.ingesoft.pa2.banco.rest.dto;

import java.util.List;

public class RespuestaEvaluacionDTO {

	private List<RespuestaPreguntaDTO> respuesta;
	private String idGrupo;
	private String comentario;
	private String codEstudiante;
	
	public RespuestaEvaluacionDTO() {
		// TODO Auto-generated constructor stub
	}

	
	
	public RespuestaEvaluacionDTO(List<RespuestaPreguntaDTO> respuesta, String idGrupo, String comentario,
			String codEstudiante) {
		super();
		this.respuesta = respuesta;
		this.idGrupo = idGrupo;
		this.comentario = comentario;
		this.codEstudiante = codEstudiante;
	}



	/**
	 * @return the respuesta
	 */
	public List<RespuestaPreguntaDTO> getRespuesta() {
		return respuesta;
	}

	/**
	 * @param respuesta the respuesta to set
	 */
	public void setRespuesta(List<RespuestaPreguntaDTO> respuesta) {
		this.respuesta = respuesta;
	}

	/**
	 * @return the idGrupo
	 */
	public String getIdGrupo() {
		return idGrupo;
	}

	/**
	 * @param idGrupo the idGrupo to set
	 */
	public void setIdGrupo(String idGrupo) {
		this.idGrupo = idGrupo;
	}

	/**
	 * @return the comentario
	 */
	public String getComentario() {
		return comentario;
	}

	/**
	 * @param comentario the comentario to set
	 */
	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	/**
	 * @return the codEstudiante
	 */
	public String getCodEstudiante() {
		return codEstudiante;
	}

	/**
	 * @param codEstudiante the codEstudiante to set
	 */
	public void setCodEstudiante(String codEstudiante) {
		this.codEstudiante = codEstudiante;
	}
	
	
	

}
