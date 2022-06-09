package com.edu.ues.fia.eisi.app_proyecto01;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class EditarLocalExterno extends AppCompatActivity {

    EditText idLocal,cupo, nombreLocal;

    RequestQueue requestQueue;
    String url;

    //private final String urlquery = "http://192.168.1.8/Proyecto01Servicios/Local/ws_query_local.php";
    //private final String urlLocal = "http://192.168.1.8/Proyecto01Servicios/Local/ws_update_local.php";

    @SuppressLint("NewApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_local_externo);

        //Cargamos los ids
        idLocal = findViewById(R.id.idLocal);
        nombreLocal = findViewById(R.id.idNombreLocal);
        cupo = findViewById(R.id.cupo);
    }




    public void actualizarLocal(View v){

        String id_local = idLocal.getText().toString();
        String nombre_local = nombreLocal.getText().toString();
        String _cupo = cupo.getText().toString();

        if(idLocal.getText().toString().isEmpty() || nombreLocal.getText().toString().isEmpty() ||cupo.getText().toString().isEmpty()){
            Toast.makeText(this, "Error, no debe dejar campos vacios", Toast.LENGTH_SHORT).show();
        }
        else{
            url = Rutas.update("Local") + "?IDLOCAL=" + id_local + "&NOMBRELOCAL=" + nombre_local + "&CUPO=" + _cupo;
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





    //Consultar
    public void consultarLocalEditar(View v) {
        String id_local = idLocal.getText().toString();

        if (id_local == null) {
            Toast.makeText(this, "Error, ingrese un id del local", Toast.LENGTH_SHORT).show();
        } else {

            url = Rutas.query("Local") + "?IDLOCAL=" + id_local;

            ejecutarJSON(url);
        }
    }

    public void ejecutarJSON(String url){

        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(url, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                JSONObject jsonObject = null;
                for (int i = 0; i < response.length(); i++) {
                    try {
                        jsonObject = response.getJSONObject(i);
                        //idLocal.setText("Id Detalle: "+jsonObject.getString("ID_DETALLE"));
                        nombreLocal.setText(jsonObject.getString("NOMBRELOCAL"));
                        cupo.setText(jsonObject.getString("CUPO"));
                    } catch (JSONException e) {
                        Toast.makeText(getApplicationContext(), e.getMessage().toString(), Toast.LENGTH_SHORT).show();
                    }
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(), error.getMessage().toString(), Toast.LENGTH_SHORT).show();
            }
        });
        requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(jsonArrayRequest);
    }
}