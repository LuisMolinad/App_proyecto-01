package com.edu.ues.fia.eisi.app_proyecto01;

import android.annotation.SuppressLint;
import android.database.Cursor;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@SuppressLint("NewApi")
public class InsertarEscuelaExterno extends AppCompatActivity {
    ControlBDActividades helper;
    EditText idescuela, nombreescuela;
    Spinner spinneridCarrera;
    ArrayList<String> fkIdCarrera=new ArrayList<String>();
    ArrayAdapter<String> adapter;
    RequestQueue requestQueue;
    String url;

    //private final String urlLocal = "http://192.168.0.3/Proyecto1.2/ws_escuela_insert.php";
    @SuppressLint("NewApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insertar_escuela_externo);

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        helper = new ControlBDActividades(this);
        spinneridCarrera = findViewById(R.id.spinneridCarreraInsertarExterno);
        idescuela= findViewById(R.id.idEscuelaInsertarExterno);
        nombreescuela = findViewById(R.id.nombreEscuelaInsertarExterna);

        llenarSpinnerFKIdCarrera();

    }

    public void insertarEscuelaEXTERNO(View v){

        String IDESCUELA = idescuela.getText().toString();
        String fkidCarrera = spinneridCarrera.getSelectedItem().toString();
        String NOMBRE_ESCUELA = nombreescuela.getText().toString();

        url = Rutas.insert("Escuela")+ "?IDESCUELA=" + IDESCUELA +"&IDCARRERA="+fkidCarrera+ "&NOMBRE_ESCUELA=" + NOMBRE_ESCUELA ;
        ejecutar(url);
    }

    public void ejecutar(String URL){
        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Toast.makeText(getApplicationContext(), "Operacion exitosa", Toast.LENGTH_SHORT).show();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(), error.toString(), Toast.LENGTH_SHORT).show();
            }
        }
        ){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> parametro = new HashMap<String, String>();
                //parametro.put("IDACTIVIDAD", idActividad.getText().toString());
                parametro.put("IDESCUELA", idescuela.getText().toString());
                parametro.put("IDCARRERA", spinneridCarrera.getSelectedItem().toString());
                parametro.put("NOMBRE_ESCUELA", nombreescuela.getText().toString());
                return parametro;
            }
        };

        requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }

    /*
    public void insertarEscuelaEXTERNO(View v) {
        String IDESCUELA = idescuela.getText().toString();
        String fkidCarrera = spinneridCarrera.getSelectedItem().toString();
        String NOMBRE_ESCUELA = nombreescuela.getText().toString();
        if (IDESCUELA.isEmpty()&& NOMBRE_ESCUELA.isEmpty())
        {
            Toast.makeText(this,"Campos vacios",Toast.LENGTH_SHORT).show();
        }
        else {
            String url = null;
            JSONObject datosNota = new JSONObject();
            JSONObject nota = new JSONObject();
            switch (v.getId()) {
                case R.id.botonguardarEscuelaExterno:
                    url = Rutas.insert("Escuela")+ "?IDESCUELA=" + IDESCUELA +"&IDCARRERA="+fkidCarrera+ "&NOMBRE_ESCUELA=" + NOMBRE_ESCUELA ;
                    ControladorServicio.insertar(url, this);
                    break;

            }
        }

    }*/

    public void llenarSpinnerFKIdCarrera(){
        //declaramos un nuevo adaptador que sera llenado por la nd
        adapter=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,fkIdCarrera);
        //
        final ControlBDActividades db=new ControlBDActividades(this);
        //abrimos la bd
        db.abrir();
        //Cargar lso datos a spinner
        Cursor c=db.getAllValuesIdCARRERA();
        while(c.moveToNext())
        {
            String name=c.getString(0);
            //captura los id que luego llenan el adaptador
            fkIdCarrera.add(name);
        }
        //CLOSE
        db.cerrar();
        //SET IT TO SPINNER
        spinneridCarrera.setAdapter(adapter);
    }
}