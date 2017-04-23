/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package co.edu.eam.ingesoft.pa2.banco.persistencia.entidades.negocio;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author EAM
 */
@Entity
public class Transaccion implements Serializable {

	@Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
	
	@Id
    private int id;
	
	@ManyToOne
    private TipoTransaccion tipo;
    private double monto;

    public Transaccion() {
	}
    
    public Transaccion(Date fecha, int id, TipoTransaccion tipo, double monto) {
        this.fecha = fecha;
        this.id = id;
        this.tipo = tipo;
        this.monto = monto;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public TipoTransaccion getTipo() {
        return tipo;
    }

    public void setTipo(TipoTransaccion tipo) {
        this.tipo = tipo;
    }

    

}
