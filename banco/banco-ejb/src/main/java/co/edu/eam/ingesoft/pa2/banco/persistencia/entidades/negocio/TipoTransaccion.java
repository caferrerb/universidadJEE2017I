/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package co.edu.eam.ingesoft.pa2.banco.persistencia.entidades.negocio;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author EAM
 */
@Entity
public class TipoTransaccion implements Serializable{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    private double impuesto;
    private String nombre;

    public TipoTransaccion() {
	}
    
    public TipoTransaccion(int id, double impuesto, String nombre) {
        this.id = id;
        this.impuesto = impuesto;
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getImpuesto() {
        return impuesto;
    }

    public void setImpuesto(double impuesto) {
        this.impuesto = impuesto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    
}
