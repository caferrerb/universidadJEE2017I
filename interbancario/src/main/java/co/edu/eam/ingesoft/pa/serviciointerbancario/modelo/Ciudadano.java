package co.edu.eam.ingesoft.pa.serviciointerbancario.modelo;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table(name="t_ciudadano")
@IdClass(CiudadanoPK.class)
public class Ciudadano implements Serializable {
	
	private String nombre;
	@Id
	private String numeroDoc;
	@Id
	private TipoDocumentoEnum tipoDoc;
	
	public Ciudadano() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	public Ciudadano(String nombre, String numeroDoc, TipoDocumentoEnum tipoDoc) {
		super();
		this.nombre = nombre;
		this.numeroDoc = numeroDoc;
		this.tipoDoc = tipoDoc;
	}



	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
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
	
	
	
}
