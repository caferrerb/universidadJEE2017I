package co.edu.eam.ingesoft.pa2.banco.persistencia.entidades.seguridad;

import java.io.Serializable;

public class AccesoRolPK implements Serializable {

	private Long acceso;
	
	private Long rol;

	
	public AccesoRolPK() {
	}
	/**
	 * constructor.
	 * @param acceso
	 * @param rol
	 */
	public AccesoRolPK(Long acceso, Long rol) {
		super();
		this.acceso = acceso;
		this.rol = rol;
	}
	/**
	 * @return the acceso
	 */
	public Long getAcceso() {
		return acceso;
	}
	/**
	 * @param acceso the acceso to set
	 */
	public void setAcceso(Long acceso) {
		this.acceso = acceso;
	}
	/**
	 * @return the rol
	 */
	public Long getRol() {
		return rol;
	}
	/**
	 * @param rol the rol to set
	 */
	public void setRol(Long rol) {
		this.rol = rol;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((acceso == null) ? 0 : acceso.hashCode());
		result = prime * result + ((rol == null) ? 0 : rol.hashCode());
		return result;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AccesoRolPK other = (AccesoRolPK) obj;
		if (acceso == null) {
			if (other.acceso != null)
				return false;
		} else if (!acceso.equals(other.acceso))
			return false;
		if (rol == null) {
			if (other.rol != null)
				return false;
		} else if (!rol.equals(other.rol))
			return false;
		return true;
	}
	
	
	
	
}
