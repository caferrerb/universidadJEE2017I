/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package co.edu.eam.ingesoft.pa2.banco.persistencia.entidades.negocio;

import java.io.Serializable;
import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 *
 * @author EAM
 */
@Entity
public class Cuenta implements Serializable{

	@Id
    private String codigo;
    private double saldo;
    @ManyToOne
    private TipoCuenta tipo;
    private String clave;
    private boolean cancelada;

    @ManyToOne
    private Cliente cliente;

   

    public Cuenta() {
		// TODO Auto-generated constructor stub
	}

    public Cuenta(String codigo, double saldo, TipoCuenta tipo, String clave, boolean cancelada) {
        this.codigo = codigo;
        this.saldo = saldo;
        this.tipo = tipo;
        this.clave = clave;
        this.cancelada = cancelada;
    }



    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public TipoCuenta getTipo() {
        return tipo;
    }

    public void setTipo(TipoCuenta tipo) {
        this.tipo = tipo;
    }

    

    public boolean isCancelada() {
        return cancelada;
    }

    public void setCancelada(boolean cancelada) {
        this.cancelada = cancelada;
    }

	/**
	 * @return the cliente
	 */
	public Cliente getCliente() {
		return cliente;
	}

	/**
	 * @param cliente the cliente to set
	 */
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}





}
