package co.edu.eam.ingesoft.pa.persistencia.modelo.enumeraciones;

public enum TipoTareaEnum {

	DD("Docencia directa"),AE("Asesoria estudiantil"),PP("Preparacion de clase"),
	INV("Investigacion"),AP("APoyo al programa");
	
	private String descripcion;
	
	/**
	 * @param codigo
	 * @param descripcion
	 */
	private TipoTareaEnum(String descripcion) {
		this.descripcion = descripcion;
	}

	
	/**
	 * @return the descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * @param descripcion the descripcion to set
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return toString()+"-"+descripcion;
	}
	
}
