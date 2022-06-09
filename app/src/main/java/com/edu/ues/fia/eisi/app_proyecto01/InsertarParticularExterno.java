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

import java.util.HashMap;
import java.util.Map;

@SuppressLint("NewApi")
public class InsertarParticularExterno extends AppCompatActivity {

    EditText idParticular, idUsuario, nombreParticular, apellidoParticular;
    RequestQueue requestQueue;
    String url;

    //private final String urlLocal = "http://192.168.1.8/Proyecto01Servicios/Particular/ws_insert_particular.php";

    @SuppressLint("NewApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insertar_particular_externo);

        //Capturar los ide de cada EditText
        idParticular = findViewById(R.id.idParticular);
        idUsuario = findViewById(R.id.idUsuario);
        nombreParticular = findViewById(R.id.nombreParticular);
        apellidoParticular = findViewById(R.id.apellidoParticular);
    }


    public void insertarParticular(View v){

        if(idParticular.getText().toString().isEmpty() || idUsuario.getText().toString().isEmpty() || nombreParticular.getText().toString().isEmpty() || apellidoParticular.getText().toString().isEmpty()){
            Toast.makeText(this, "Error, no debe dejar campos vacios", Toast.LENGTH_SHORT).show();
        }
        else{
            url = Rutas.insert("Particular") + "?IDPARTICULAR=" + idParticular.getText().toString() +"&IDUSUARIO=" + idUsuario.getText().toString() + "&NOMBREPARTICULAR=" + nombreParticular.getText().toString() + "&APELLIDOPARTICULAR=" + apellidoParticular.getText().toString();
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
                parametro.put("IDPARTICULAR", idParticular.getText().toString());
                parametro.put("IDUSUARIO", idUsuario.getText().toString());
                parametro.put("NOMBREPARTICULAR", nombreParticular.getText().toString());
                parametro.put("APELLIDOPARTICULAR", apellidoParticular.getText().toString());
                return parametro;
            }
        };

        requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }
}