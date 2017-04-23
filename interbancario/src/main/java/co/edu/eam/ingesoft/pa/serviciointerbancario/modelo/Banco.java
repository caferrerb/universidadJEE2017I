package co.edu.eam.ingesoft.pa.serviciointerbancario.modelo;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="t_banco")
public class Banco implements Serializable {

	private String nombre;
	@Id
	private String codigo;
	
	public Banco() {
		// TODO Auto-generated constructor stub
	}
	
	public Banco(String nombre, String codigo) {
		super();
		this.nombre = nombre;
		this.codigo = codigo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	
	
}
