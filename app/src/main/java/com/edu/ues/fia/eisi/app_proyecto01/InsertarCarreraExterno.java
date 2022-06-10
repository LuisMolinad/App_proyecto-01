package com.edu.ues.fia.eisi.app_proyecto01;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
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

import java.util.HashMap;
import java.util.Map;

@SuppressLint("NewApi")
public class InsertarCarreraExterno extends AppCompatActivity {
    EditText idCarrera, nombreCarrera;
    RequestQueue requestQueue;
    String url;
    //Duque
    //private final String urlLocal = "http://192.168.0.3/Proyecto1.2/ws_nota_insertCarrera.php";
//aca pueden poner sus propias ur si quieren o solo cambian la mia
@SuppressLint("NewApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insertar_carrera_externo);
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()
                .permitAll().build();
        StrictMode.setThreadPolicy(policy);
        idCarrera = findViewById(R.id.idCarreraInsertarExterno);
        nombreCarrera = findViewById(R.id.nombreCarreraExterno);



    }
    /*
    public void insertarCarreraEXTERNO(View v) {
        String IDCARRERA = idCarrera.getText().toString();
        String NOMBRECARREARA = nombreCarrera.getText().toString();
        String url = null;
        JSONObject datosNota = new JSONObject();
        JSONObject nota = new JSONObject();
        switch (v.getId()) {
            case R.id.botonguardarCarreraExterno:
                url = Rutas.insert("Carreras")+ "?IDCARRERA=" + IDCARRERA + "&NOMBRECARRERA=" + NOMBRECARREARA ;
                //ControladorServicio.insertar(url, this);
                ejecutar(url);
                break;
        }
    }*/

    public void insertarCarreraExterno(View v){
        String IDCARRERA = idCarrera.getText().toString();
        String NOMBRECARREARA = nombreCarrera.getText().toString();
        //Validar que no este vacio

        if(IDCARRERA.isEmpty() || NOMBRECARREARA.isEmpty() ){
            Toast.makeText(this, "Error, no debe dejar campos vacios", Toast.LENGTH_SHORT).show();
        }
        else {
            url = Rutas.insert("Carrera")+ "?IDCARRERA=" + IDCARRERA + "&NOMBRECARRERA=" + NOMBRECARREARA ;
            ejecutar(url);
        }

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
                parametro.put("IDCARRERA", idCarrera.getText().toString());
                parametro.put("NOMBRECARRERA", nombreCarrera.getText().toString());
                return parametro;
            }
        };

        requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }
}


