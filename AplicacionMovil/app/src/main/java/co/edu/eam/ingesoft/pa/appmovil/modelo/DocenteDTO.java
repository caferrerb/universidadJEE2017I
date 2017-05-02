package co.edu.eam.ingesoft.pa.appmovil.modelo;

/**
 * Created by caferrerb on 2/05/17.
 */

public class DocenteDTO {

    private String nombre;
    private String documentoidentificacion;
    private String apellido;
    private String correoelectronico;

    public DocenteDTO() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDocumentoidentificacion() {
        return documentoidentificacion;
    }

    public void setDocumentoidentificacion(String documentoidentificacion) {
        this.documentoidentificacion = documentoidentificacion;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCorreoelectronico() {
        return correoelectronico;
    }

    public void setCorreoelectronico(String correoelectronico) {
        this.correoelectronico = correoelectronico;
    }
}
