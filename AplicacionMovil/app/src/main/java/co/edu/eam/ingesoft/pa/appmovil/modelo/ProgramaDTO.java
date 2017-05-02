package co.edu.eam.ingesoft.pa.appmovil.modelo;

/**
 * Created by caferrerb on 2/05/17.
 */

public class ProgramaDTO {

    private  String nombre;
    private String codigo;
    private FAcultadDTO facultad;

    public ProgramaDTO() {
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

    @Override
    public String toString() {
        return nombre;
    }

    public FAcultadDTO getFacultad() {
        return facultad;
    }

    public void setFacultad(FAcultadDTO facultad) {
        this.facultad = facultad;
    }
}
