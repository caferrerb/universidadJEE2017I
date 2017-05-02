package co.edu.eam.ingesoft.pa.appmovil;

/**
 * Created by caferrerb on 30/04/17.
 */

import java.util.List;

/**
 * REspuesta de los servicios REST
 */
public class RespuestaDTO<T> {


    private  String mensaje;
    private String codigo;
    private T obj;
    private List<T> lista;




    public RespuestaDTO(){



    }

    /**
     * mensaje del servicio
     */
    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    /**
     * codigo de respuesta
     */
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    /**
     * objeto de respuesta.
     */
    public T getObj() {
        return obj;
    }

    public void setObj(T obj) {
        this.obj = obj;
    }

    public void setLista(List<T> lista) {
        this.lista = lista;
    }

    public List<T> getLista() {
        return lista;
    }
}
