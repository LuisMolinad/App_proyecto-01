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
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

@SuppressLint("NewApi")

public class EditarEquipoDidacticoExterno extends AppCompatActivity {

    EditText idEquipoE, nombreE, descripcionE;
    RequestQueue requestQueue;
    String url;

    //private final String urlLocal = "http://192.168.0.8/Proyecto1.2/Equipo/ws_update_equipo.php";
    //private final String urlQuery = "http://192.168.0.8/Proyecto1.2/Equipo/ws_query_equipo.php";

    @SuppressLint("NewApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_equipo_didactico_externo);

        idEquipoE = findViewById(R.id.idEquipoEditar);
        nombreE = findViewById(R.id.nombreEquipoEditar);
        descripcionE = findViewById(R.id.descripcionEquipoEditar);

    }

    //Editar

    public void actualizarEquipoDidacticoExterno(View v){
        String idEquipoA = idEquipoE.getText().toString();
        String nombre_A = nombreE.getText().toString();
        String desc_A = descripcionE.getText().toString();


        //Validar que no este vacio

        if(idEquipoA.isEmpty() || nombre_A.isEmpty() || desc_A.isEmpty() ){
            Toast.makeText(this, "Error, no debe dejar campos vacios", Toast.LENGTH_SHORT).show();
        }
        else {

            url = Rutas.update("Equipo") + "?IDEQUIPO=" + idEquipoA + "&NOMBRE=" + nombre_A + "&DESCRIPCIONEQUIPO=" + desc_A;

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
                parametro.put("IDEQUIPO", idEquipoE.getText().toString());
                parametro.put("NOMBRE", nombreE.getText().toString());
                parametro.put("DESCRIPCIONEQUIPO", descripcionE.getText().toString());

                return parametro;
            }
        };

        requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }

    public void consultarEquipoDidacticoExterno(View v){

        String equipo = idEquipoE.getText().toString();

        if(equipo == null){
            Toast.makeText(this, "El equipo didactico con el id "+idEquipoE.getText().toString() + ", no ha sido encontrado", Toast.LENGTH_LONG).show();
        }
        else {

            url = Rutas.query("Equipo") + "?IDEQUIPO="+equipo;

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
                        nombreE.setText(jsonObject.getString("NOMBRE"));
                        descripcionE.setText(jsonObject.getString("DESCRIPCIONEQUIPO"));

                    } catch (JSONException e) {
                        Toast.makeText(getApplicationContext(), e.getMessage().toString(), Toast.LENGTH_SHORT).show();
                    }
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
        requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(jsonArrayRequest);
    }








}