package co.edu.eam.ingesoft.pa.serviciointerbancario.modelo;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="t_Cuenta")
@IdClass(CuentaPK.class)
public class Cuenta implements Serializable {
	@ManyToOne
	private Ciudadano ciudadano;
	@Id
	@ManyToOne
	private Banco banco;
	@Id
	private String numero;
	private EstadoCuentaEnum estado;
	
	public Cuenta() {
		// TODO Auto-generated constructor stub
	}

	public Cuenta(Ciudadano ciudadano, Banco banco, String numero) {
		super();
		this.ciudadano = ciudadano;
		this.banco = banco;
		this.numero = numero;
		estado=EstadoCuentaEnum.PENDIENTE;
	}

	public Ciudadano getCiudadano() {
		return ciudadano;
	}

	public void setCiudadano(Ciudadano ciudadano) {
		this.ciudadano = ciudadano;
	}

	public Banco getBanco() {
		return banco;
	}

	public void setBanco(Banco banco) {
		this.banco = banco;
	}
	
	

	public EstadoCuentaEnum getEstado() {
		return estado;
	}

	public void setEstado(EstadoCuentaEnum estado) {
		this.estado = estado;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}
	
	
}
