package co.edu.eam.ingesoft.pa.serviciointerbancario.modelo;

import java.io.Serializable;

public class CiudadanoPK implements Serializable {
	private String numeroDoc;
	private TipoDocumentoEnum tipoDoc;

	public CiudadanoPK(TipoDocumentoEnum tipoDoc2, String numeroDoc2) {
		this.tipoDoc = tipoDoc2;
		this.numeroDoc = numeroDoc2;
	}

	public CiudadanoPK() {
		// TODO Auto-generated constructor stub
	}
	public String getNumeroDoc() {
		return numeroDoc;
	}

	public void setNumeroDoc(String numeroDoc) {
		this.numeroDoc = numeroDoc;
	}

	public TipoDocumentoEnum getTipoDoc() {
		return tipoDoc;
	}

	public void setTipoDoc(TipoDocumentoEnum tipoDoc) {
		this.tipoDoc = tipoDoc;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((numeroDoc == null) ? 0 : numeroDoc.hashCode());
		result = prime * result + ((tipoDoc == null) ? 0 : tipoDoc.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CiudadanoPK other = (CiudadanoPK) obj;
		if (numeroDoc == null) {
			if (other.numeroDoc != null)
				return false;
		} else if (!numeroDoc.equals(other.numeroDoc))
			return false;
		if (tipoDoc != other.tipoDoc)
			return false;
		return true;
	}

}
