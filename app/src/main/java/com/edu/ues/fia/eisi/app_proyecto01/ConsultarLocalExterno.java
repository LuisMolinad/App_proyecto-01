package com.edu.ues.fia.eisi.app_proyecto01;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ConsultarLocalExterno extends AppCompatActivity {

    EditText idLocal;
    TextView txtNombreLocal, txtCupo;

    RequestQueue requestQueue;
    String url;

    //private final String urlLocal = "http://192.168.1.8/Proyecto01Servicios/Local/ws_query_local.php";

    @SuppressLint("NewApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consultar_local_externo);

        //Cargamos los ids
        idLocal = findViewById(R.id.idLocal);
        txtNombreLocal = findViewById(R.id.txtNombreLocal);
        txtCupo = findViewById(R.id.txtCupo);
    }



    public void consultarLocal(View v) {
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
                        txtNombreLocal.setText("Nombre local: "+jsonObject.getString("NOMBRELOCAL"));
                        txtCupo.setText("Cupo: "+jsonObject.getString("CUPO"));
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