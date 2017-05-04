package appmovil.pa.ingesoft.eam.edu.co.aplicacionmovil;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import co.edu.eam.ingesoft.pa.appmovil.RespuestaDTO;
import co.edu.eam.ingesoft.pa.appmovil.RestClient;
import co.edu.eam.ingesoft.pa.appmovil.RestInvoker;
import co.edu.eam.ingesoft.pa.appmovil.modelo.DocenteDTO;
import co.edu.eam.ingesoft.pa.appmovil.modelo.EditarNombreDTO;
import co.edu.eam.ingesoft.pa.appmovil.modelo.FAcultadDTO;
import co.edu.eam.ingesoft.pa.appmovil.modelo.ProgramaDTO;

public class MainActivity extends AppCompatActivity {

    private List<FAcultadDTO> facultades;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnBuscar=(Button)findViewById(R.id.btnBuscar);
        btnBuscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buscar();
            }
        });


        Button btnEditar=(Button)findViewById(R.id.btnEditar);
        btnEditar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editar();
            }
        });
        llenarFacultad();

        Spinner cbFAcultad=(Spinner)findViewById(R.id.cbFAcultad);

        cbFAcultad.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                FAcultadDTO fac=facultades.get(position);
                llenarPrograma(fac.getCodigo());

            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // your code here
            }

        });



    }

    public void llenarPrograma(String id){
        Spinner cbPrograma=(Spinner)findViewById(R.id.cbPrograma);
        RestInvoker<ProgramaDTO> cliente=new RestInvoker<ProgramaDTO>(ProgramaDTO.class,this);

        Map<String,String> params=new HashMap<>();
        params.put("id",id);
        RespuestaDTO<ProgramaDTO> resp=cliente.get("programa/listarfacultad",params);
        if(resp.getCodigo().equals("0")) {
            ArrayAdapter<ProgramaDTO> spinnerArrayAdapter = new ArrayAdapter<ProgramaDTO>(this,
                    android.R.layout.simple_spinner_item,
                    resp.getLista());
            cbPrograma.setAdapter(spinnerArrayAdapter);
        }

    }

    public void llenarFacultad(){
        Spinner cbFAcultad=(Spinner)findViewById(R.id.cbFAcultad);
        RestInvoker<FAcultadDTO> cliente=new RestInvoker<FAcultadDTO>(FAcultadDTO.class,this);
        RespuestaDTO<FAcultadDTO> resp=cliente.get("facultad/listar",null);
        if(resp.getCodigo().equals("0")) {
            ArrayAdapter<FAcultadDTO> spinnerArrayAdapter = new ArrayAdapter<FAcultadDTO>(this,
                    android.R.layout.simple_spinner_item,
                    resp.getLista());
            cbFAcultad.setAdapter(spinnerArrayAdapter);
            facultades = resp.getLista();
        }
    }

    /**
     * MEtodo para buscar
     */
    public void buscar(){

        EditText edCedula=(EditText) findViewById(R.id.edCedula);
        String cedula=edCedula.getText().toString();

        RestInvoker<DocenteDTO> cliente=new RestInvoker<DocenteDTO>(DocenteDTO.class,this);

        Map<String,String> params=new HashMap<>();
        params.put("documento",cedula);

        RespuestaDTO<DocenteDTO> resp=cliente.get("/docente/buscar",params);

        if(resp.getObj()!=null){
            EditText edNombre=(EditText) findViewById(R.id.edNombre);
            EditText edCorreo=(EditText) findViewById(R.id.edCorreo);
            EditText edApellido=(EditText) findViewById(R.id.edApellido);

            edNombre.setText(resp.getObj().getNombre());
            edApellido.setText(resp.getObj().getApellido());
            edCorreo.setText(resp.getObj().getCorreoelectronico());


        }else{
            Toast.makeText(this,resp.getMensaje(),Toast.LENGTH_LONG);
        }



    }

    /**
     * Editar docente
     */
    public void editar(){
        EditText edCedula=(EditText) findViewById(R.id.edCedula);
        EditText edNombre=(EditText) findViewById(R.id.edNombre);

        EditarNombreDTO dto=new EditarNombreDTO();
        dto.setCedula(edCedula.getText().toString());
        dto.setNombre(edNombre.getText().toString());

        RestInvoker<String> cliente=new RestInvoker(String.class,this);

        RespuestaDTO<String> resp=cliente.post("docente/editarnombredto",dto);
        if(resp.getCodigo().equals("0")){
            Toast.makeText(this,"EXITO!!!!!!",Toast.LENGTH_LONG);

        }else{
            Toast.makeText(this,resp.getMensaje(),Toast.LENGTH_LONG);

        }



    }
}
