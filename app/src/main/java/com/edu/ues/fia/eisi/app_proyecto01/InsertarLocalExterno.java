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
public class InsertarLocalExterno extends AppCompatActivity {

    EditText idLocal, nombreLocal, cupo;

    RequestQueue requestQueue;
    String url;

    //private final String urlLocal = "http://192.168.1.8/Proyecto01Servicios/Local/ws_insert_local.php";
    @SuppressLint("NewApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insertar_local_externo);

        //Capturar los ide de cada EditText
        idLocal = findViewById(R.id.idLocal);
        nombreLocal = findViewById(R.id.nombreLocal);
        cupo = findViewById(R.id.cupo);
    }


    public void insertarLocal(View v){

        String id_local = idLocal.getText().toString();
        String nombre_local = nombreLocal.getText().toString();
        String _cupo = cupo.getText().toString();

        if(idLocal.getText().toString().isEmpty() || nombreLocal.getText().toString().isEmpty() ||cupo.getText().toString().isEmpty()){
            Toast.makeText(this, "Error, no debe dejar campos vacios", Toast.LENGTH_SHORT).show();
        }
        else{
            url = Rutas.insert("Local") + "?IDLOCAL=" + id_local + "&NOMBRELOCAL=" + nombre_local + "&CUPO=" + _cupo;
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
                parametro.put("IDLOCAL", idLocal.getText().toString());
                parametro.put("NOMBRELOCAL", nombreLocal.getText().toString());
                parametro.put("CUPO", cupo.getText().toString());
                return parametro;
            }
        };

        requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }
}