package co.edu.eam.ingesoft.pa.appmovil;

import android.content.Context;
import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.widget.Toast;

import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Created by caferrerb on 30/04/17.
 */

public class RestInvoker<T>  {


    public static  final String URLBASE="http://104.197.238.134:8080/universidad1/rest";

    /**
     * cliente rest.
     */
    private RestClient rest;
    /**
     * metodo http a usar en la invocacion.
     */
    private String metodo;
    /**
     * parametros del GET
     */
    private Map<String,String> parametros;
    /**
     * parametro del post
     */
    private Object obj;

    private String url;

    private Context ctx;

    private String token;

    /**
     * clase del objeto de respuesta
     */
    private Class<T> clase;

    private RespuestaDTO<T> dto;

    public RestInvoker(Class<T> clase,Context ctx) {
        rest=new RestClient(ctx);
        this.ctx=ctx;
        this.clase = clase;
    }

    /**
     * metodo para ejecutar un GET.
     * @param url, url del servicio
     * @param parametros, mapa de parametros
     * @return Respuesta DTO.
     */
    public RespuestaDTO<T> get(String url, Map<String,String> parametros){
        if(url.startsWith("/")){
            url=url.substring(1);
        }
        metodo="get";
        this.url=URLBASE+"/"+url;
        this.parametros=parametros;

        RespuestaDTO<T>resp = getRespuestaDTOFuture();

        return resp;


    }

    /**
     * metodo para ejecutar un POST.
     * @param url, url del servicio
     * @param obj, obj a enviar como json
     * @return Respuesta DTO.
     */
    public RespuestaDTO<T> post(String url, Object obj){
        if(url.startsWith("/")){
            url=url.substring(1);
        }
        metodo="post";
        this.url=URLBASE+"/"+url;
        this.obj=obj;

        RespuestaDTO<T>resp = getRespuestaDTOFuture();

        return resp;

    }

    /**
     * metod para invocar asincronicamente un metodo
     * @return
     */
    @NonNull
    private RespuestaDTO<T>getRespuestaDTOFuture() {
        ExecutorService pool= Executors.newFixedThreadPool(1);
        Future<RespuestaDTO<T>> resp=pool.submit(new Callable<RespuestaDTO<T>>() {

            @Override
            public RespuestaDTO<T> call() throws Exception {
                return doIt();
                /*final

                AsyncTask<Object, Long, RespuestaDTO<T>> async=new AsyncTask<Object, Long, RespuestaDTO<T>>() {
                    @Override
                    protected RespuestaDTO<T> doInBackground(Object... params) {

                    }

                    @Override
                    protected void onPostExecute(RespuestaDTO<T> tRespuestaDTO) {
                        dto=tRespuestaDTO;

                    }
                };
return                async.execute();

                while(async.getStatus()!= AsyncTask.Status.FINISHED);*/



            }
        });


        try {
            return resp.get();
        } catch(final Exception e) {
            AsyncTask task=new AsyncTask(){
                @Override
                protected Object doInBackground(Object[] params) {
                    return null;
                }

                @Override
                protected void onPostExecute(Object o) {
                    //super.onPostExecute(o);
                    Toast.makeText(ctx,e.getMessage(),Toast.LENGTH_LONG).show();

                }
            };
            task.execute();
            e.printStackTrace();
            RespuestaDTO respdto= new RespuestaDTO<>();
            respdto.setMensaje(e.getMessage());
            respdto.setCodigo("-500");
            return respdto;
        }finally {
            pool.shutdown();
        }
       // return null;
    }




    private RespuestaDTO<T> doIt(Object... params) throws Exception{

            String resp = "";
            if (metodo.equals("get")) {
                resp = rest.get(url, parametros);
            }
            if (metodo.equals("post")) {
                resp = rest.post(url, obj);
            }
            Gson gson = new Gson();
            JSONObject json = new JSONObject(resp);
            String msj=json.getString("mensaje");
            String codigo=json.getString("codigo");
            String response=json.getString("obj");

            RespuestaDTO<T> dto=new RespuestaDTO<T>();
            dto.setCodigo(codigo);
            dto.setMensaje(msj);

            if(json.get("obj")instanceof JSONArray){
                JSONArray array= (JSONArray) json.get("obj");
               List<T> list=new ArrayList<>();
                for (int i=0;i<array.length();i++){
                    String jsonstr=array.getString(i);
                    list.add(gson.fromJson(jsonstr,clase));

                }
                dto.setLista(list
                );

            }else{
                T obj=gson.fromJson(response,clase);
                dto.setObj(obj);
            }


            return dto;




    }

    public void setToken(String token) {
        this.token = token;
    }
}
