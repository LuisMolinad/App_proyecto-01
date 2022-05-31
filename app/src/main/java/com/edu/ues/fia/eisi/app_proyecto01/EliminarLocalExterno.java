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
public class EliminarLocalExterno extends AppCompatActivity {

    EditText idLocal;

    RequestQueue requestQueue;
    String url;

    private final String urlLocal = "http://192.168.1.8/Proyecto01Servicios/Local/ws_delete_local.php";

    @SuppressLint("NewApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eliminar_local_externo);

        idLocal = findViewById(R.id.idLocal);
    }

    public void eliminarLocal(View v){
        String id_local = idLocal.getText().toString();
        if(id_local == null){
            Toast.makeText(this, "Error, ingrese un id del local", Toast.LENGTH_SHORT).show();
        }
        else {
            url = urlLocal + "?IDLOCAL=" + id_local;
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
                return parametro;
            }
        };

        requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }
}