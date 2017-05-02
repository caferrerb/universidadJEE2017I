package co.edu.eam.ingesoft.pa.appmovil;

import android.content.Context;
import android.widget.Toast;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

/**
 * Created by caferrerb on 30/04/17.
 */

/**
 * clase para realizar una peticion REST.
 */
public class RestClient {

    private Context ctx;

    public RestClient(Context ctx) {
        this.ctx = ctx;
    }

    /**
     * MEtodo para realizar una peticion GET
     * @param url, url de la peticion
     * @param parametros, parametros de la peticion.
     * @return el string resultante.
     */
    public String get(String url, Map<String,String> parametros){
        BufferedReader reader=null;
        HttpURLConnection conn=null;
        String res="";
        try {

            if(parametros!=null){
                url=url+"?";
               for(Map.Entry<String,String> entry:parametros.entrySet()){
                   url+=entry.getKey()+"="+entry.getValue()+"&";
               }
            }
            URL urlServ = new URL(url);
             conn=(HttpURLConnection)urlServ.openConnection();

            reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            StringBuilder sb = new StringBuilder();
            String line = null;

            // Read Server Response
            while((line = reader.readLine()) != null)
            {
                // Append server response in string
                sb.append(line + "");
            }

            // Append Server Response To Content String
            res = sb.toString();

            return res;
        }catch (Exception e){
            Toast.makeText(ctx,e.getMessage(),Toast.LENGTH_LONG);

            e.printStackTrace();
        }finally {
            try {
                if(reader!=null){
                    reader.close();
                }
                if(conn!=null) {
                    conn.connect();
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return "";
    }

    /**
     * MEtodo para realizar una peticion POST JSON.
     * @param url, url del servicio
     * @param obj, objeto json a enviar
     * @return, el resultado de la peticion
     */
    public String post(String url, Object obj){
        BufferedReader reader=null;
        HttpURLConnection conn=null;
        String res="";
        try {


            URL urlServ = new URL(url);
            conn=(HttpURLConnection)urlServ.openConnection();
            conn.setDoOutput(true);
            conn.setRequestMethod("POST");
            conn.addRequestProperty("Accept", "application/json");
            conn.addRequestProperty("Content-Type", "application/json");

            OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());
            //theJSONYouWantToSend should be the JSONObject as String
            wr.write(new Gson().toJson(obj));  //<--- sending data.

            wr.flush();

            reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            StringBuilder sb = new StringBuilder();
            String line = null;

            // Read Server Response
            while((line = reader.readLine()) != null)
            {
                // Append server response in string
                sb.append(line + "");
            }

            // Append Server Response To Content String
            res = sb.toString();

            return res;
        }catch (Exception e){
            e.printStackTrace();
            Toast.makeText(ctx,e.getMessage(),Toast.LENGTH_LONG);

        }finally {
            try {
                if(reader!=null){
                    reader.close();
                }
                if(conn!=null) {
                    conn.connect();
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return "";
    }



}
