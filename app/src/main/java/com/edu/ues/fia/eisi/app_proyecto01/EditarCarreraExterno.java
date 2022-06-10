package com.edu.ues.fia.eisi.app_proyecto01;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

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
public class EditarCarreraExterno extends AppCompatActivity {
    EditText idCarrera, nombreCarrera;
    RequestQueue requestQueue;
    String url;
    //Duque

    //private final String urlLocal = "http://192.168.0.3/Proyecto1.2/ws_CARRERA_update.php";

    @SuppressLint("NewApi")

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_carrera_externo);

        idCarrera = findViewById(R.id.idCarreraEditarExterno);
        nombreCarrera = findViewById(R.id.nombreCarreraEditarExterno);

    }

    public void EDITARCarreraEXTERNO(View v){
        String IDCARRERA = idCarrera.getText().toString();
        String NOMBRECARREARA = nombreCarrera.getText().toString();
        //Validar que no este vacio

        if(IDCARRERA.isEmpty() || NOMBRECARREARA.isEmpty() ){
            Toast.makeText(this, "Error, no debe dejar campos vacios", Toast.LENGTH_SHORT).show();
        }
        else {
            url = Rutas.update("Carrera")+ "?IDCARRERA=" + IDCARRERA + "&NOMBRECARRERA=" + NOMBRECARREARA ;
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


    /*
    public void EDITARCarreraEXTERNO(View v) {
        String IDCARRERA = idCarrera.getText().toString();
        String NOMBRECARREARA = nombreCarrera.getText().toString();
        String url = null;
        JSONObject datosNota = new JSONObject();
        JSONObject nota = new JSONObject();
        switch (v.getId()) {
            case R.id.botonEditarCarrera:
                url = Rutas.update("Carrera")+ "?IDCARRERA=" + IDCARRERA + "&NOMBRECARRERA=" + NOMBRECARREARA ;
                ControladorServicio.ActualizarCarreraExterno(url, this);
                break;
        }
    }*/
}