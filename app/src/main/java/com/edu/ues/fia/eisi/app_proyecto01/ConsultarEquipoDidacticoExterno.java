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
@SuppressLint("NewApi")
public class ConsultarEquipoDidacticoExterno extends AppCompatActivity {

    EditText idEquipo;
    TextView idEquipoConsultar,nombreEquipoConsultar, descripcionEquipoConsultar;

    RequestQueue requestQueue;
    String url;

    private final String urlLocal = "http://192.168.0.8/Proyecto1.2/Equipo/ws_query_equipo.php";

    @SuppressLint("NewApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consultar_equipo_didactico_externo);
        //Cargamos los ids
        idEquipoConsultar = findViewById(R.id.idEquipoConsultar);
        nombreEquipoConsultar = findViewById(R.id.nombreEquipoConsultar);
        descripcionEquipoConsultar = findViewById(R.id.descripcionEquipoConsultar);
    }

    public void consultarEquipoDidactico(View v){

        String equipo = idEquipoConsultar.getText().toString();

        if(equipo == null){
            Toast.makeText(this, "El equipo didactico con el id "+idEquipoConsultar.getText().toString() + ", no ha sido encontrado", Toast.LENGTH_LONG).show();
        }
        else {

            url = urlLocal + "?IDEQUIPO="+equipo;

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
                        nombreEquipoConsultar.setText("Nombre del equipo: "+jsonObject.getString("NOMBRE"));
                        descripcionEquipoConsultar.setText("Descripción del equipo: "+jsonObject.getString("DESCRIPCIONEQUIPO"));

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


    public void CancelarConsultarEquipo (View v){
        idEquipoConsultar.setText("");
        nombreEquipoConsultar.setText("");
        descripcionEquipoConsultar.setText("");
    }

    }
