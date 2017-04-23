package co.edu.eam.ingesoft.pa2.banco.rest.dto;

public class ReporteCuentaDTO  {

	private String numeroCuenta;
	private double saldo;
	private String nombreCliente;
	private String tipoCuenta;
	
	public ReporteCuentaDTO() {
		// TODO Auto-generated constructor stub
	}

	
	
	public ReporteCuentaDTO(String numeroCuenta, double saldo, String nombreCliente, String tipoCuenta) {
		super();
		this.numeroCuenta = numeroCuenta;
		this.saldo = saldo;
		this.nombreCliente = nombreCliente;
		this.tipoCuenta = tipoCuenta;
	}



	/**
	 * @return the numeroCuenta
	 */
	public String getNumeroCuenta() {
		return numeroCuenta;
	}

	/**
	 * @param numeroCuenta the numeroCuenta to set
	 */
	public void setNumeroCuenta(String numeroCuenta) {
		this.numeroCuenta = numeroCuenta;
	}

	/**
	 * @return the saldo
	 */
	public double getSaldo() {
		return saldo;
	}

	/**
	 * @param saldo the saldo to set
	 */
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	/**
	 * @return the nombreCliente
	 */
	public String getNombreCliente() {
		return nombreCliente;
	}

	/**
	 * @param nombreCliente the nombreCliente to set
	 */
	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}

	/**
	 * @return the tipoCuenta
	 */
	public String getTipoCuenta() {
		return tipoCuenta;
	}

	/**
	 * @param tipoCuenta the tipoCuenta to set
	 */
	public void setTipoCuenta(String tipoCuenta) {
		this.tipoCuenta = tipoCuenta;
	}
	
	
	

}
