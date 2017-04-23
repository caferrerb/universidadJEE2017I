package co.edu.eam.ingesoft.pa.serviciointerbancario.modelo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="t_Conf")
public class ConfiguracionBanco implements Serializable {

	@Id
	@Column(name = "id")
	private String id;

	@OneToOne
	@JoinColumn(name = "id", insertable = false, updatable = false)
	private Banco banco;

	private String urlVerificar;

	private String numeroDocVerParam;

	private String tipoDocVerParam;

	private String numeroCuentaVerParam;

	private String urlEnviarDinero;

	private String numeroCuentaEnvParam;

	private String montoEnvParam;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Banco getBanco() {
		return banco;
	}

	public void setBanco(Banco banco) {
		this.banco = banco;
		id = banco.getCodigo();
	}

	public String getUrlVerificar() {
		return urlVerificar;
	}

	public void setUrlVerificar(String urlVerificar) {
		this.urlVerificar = urlVerificar;
	}

	public String getNumeroDocVerParam() {
		return numeroDocVerParam;
	}

	public void setNumeroDocVerParam(String numeroDocVerParam) {
		this.numeroDocVerParam = numeroDocVerParam;
	}

	public String getTipoDocVerParam() {
		return tipoDocVerParam;
	}

	public void setTipoDocVerParam(String tipoDocVerParam) {
		this.tipoDocVerParam = tipoDocVerParam;
	}

	public String getNumeroCuentaVerParam() {
		return numeroCuentaVerParam;
	}

	public void setNumeroCuentaVerParam(String numeroCuentaVerParam) {
		this.numeroCuentaVerParam = numeroCuentaVerParam;
	}

	public String getUrlEnviarDinero() {
		return urlEnviarDinero;
	}

	public void setUrlEnviarDinero(String urlEnviarDinero) {
		this.urlEnviarDinero = urlEnviarDinero;
	}

	public String getNumeroCuentaEnvParam() {
		return numeroCuentaEnvParam;
	}

	public void setNumeroCuentaEnvParam(String numeroCuentaEnvParam) {
		this.numeroCuentaEnvParam = numeroCuentaEnvParam;
	}

	public String getMontoEnvParam() {
		return montoEnvParam;
	}

	public void setMontoEnvParam(String montoEnvParam) {
		this.montoEnvParam = montoEnvParam;
	}

}
