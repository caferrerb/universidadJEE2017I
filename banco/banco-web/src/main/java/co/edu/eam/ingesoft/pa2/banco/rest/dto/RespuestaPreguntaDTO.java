package co.edu.eam.ingesoft.pa2.banco.rest.dto;

public class RespuestaPreguntaDTO {

	private long idPregunta;
	private int calificacion;
	
	public RespuestaPreguntaDTO() {
		// TODO Auto-generated constructor stub
	}

	public RespuestaPreguntaDTO(long idPregunta, int calificacion) {
		super();
		this.idPregunta = idPregunta;
		this.calificacion = calificacion;
	}

	/**
	 * @return the idPregunta
	 */
	public long getIdPregunta() {
		return idPregunta;
	}

	/**
	 * @param idPregunta the idPregunta to set
	 */
	public void setIdPregunta(long idPregunta) {
		this.idPregunta = idPregunta;
	}

	/**
	 * @return the calificacion
	 */
	public int getCalificacion() {
		return calificacion;
	}

	/**
	 * @param calificacion the calificacion to set
	 */
	public void setCalificacion(int calificacion) {
		this.calificacion = calificacion;
	}
	
	

}
