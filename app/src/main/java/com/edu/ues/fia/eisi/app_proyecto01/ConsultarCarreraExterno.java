package com.edu.ues.fia.eisi.app_proyecto01;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
@SuppressLint("NewApi")

public class ConsultarCarreraExterno extends AppCompatActivity {
    //private final String urlLocal = "http://192.168.0.3/Proyecto1.2/ws_db_Carrera_Consultar.php";

    EditText id,nombre;
    RequestQueue requestQueue;
    String url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consultar_carrera_externo);

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()
                .permitAll().build();
        StrictMode.setThreadPolicy(policy);
        id = findViewById(R.id.idCarreraConsultarExterna);
        nombre = findViewById( R.id.NOMBRECARRERAConsultarExterna);

    }
    /*
    public void consultarCARRERALocal(View v) {
        String IDCARRERA1 = IDCARRERA.getText().toString();
       // String url = urlLocal + "?IDCARRERA=" + IDCARRERA1;
        String notaPromedioJSON = ControladorServicio.obtenerRespuestaPeticion(Rutas.query("Carrera")+"?IDCARRERA=" + IDCARRERA1, this);
        NombreCarrera.setText(ControladorServicio.obtenerCarreraJSON(notaPromedioJSON,this));
    }*/
    public void consultarCARRERALocal(View v){

        String IDCARRERA = id.getText().toString();
        String NOMBRECARREARA = nombre.getText().toString();


            url = Rutas.query("Carrera") + "?IDCARRERA=" + IDCARRERA;

            ejecutarJSON(url);
    }

    public void ejecutarJSON(String url){

        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(url, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                JSONObject jsonObject = null;
                for (int i = 0; i < response.length(); i++) {
                    try {
                        jsonObject = response.getJSONObject(i);
                        nombre.setText(jsonObject.getString("NOMBRECARRERA"));
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


