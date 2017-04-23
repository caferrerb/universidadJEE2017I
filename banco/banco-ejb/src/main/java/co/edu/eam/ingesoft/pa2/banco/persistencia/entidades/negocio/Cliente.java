/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package co.edu.eam.ingesoft.pa2.banco.persistencia.entidades.negocio;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.xml.bind.annotation.XmlRootElement;

import co.edu.eam.ingesoft.pa2.banco.persistencia.entidades.seguridad.Usuario;

/**
 *
 * @author EAM
 */
@Entity
@XmlRootElement
public class Cliente implements Comparable<Cliente>,Serializable {

    private String nombre;
    private String password;
    private String telefono;
    private String direccion;
    @Id
    private String cedula;
    
    @ManyToOne
	@JoinColumn(name="usuario")
	private Usuario usuario;

   
    public Cliente() {
	}

   

    public Cliente(String nombre, String password, String telefono, String direccion, String cedula) {
        this.nombre = nombre;
        this.password = password;
        this.telefono = telefono;
        this.direccion = direccion;
        this.cedula = cedula;
        
    }

   

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public int compareTo(Cliente o) {
        throw new UnsupportedOperationException("Not supported yet.");
    }






}
