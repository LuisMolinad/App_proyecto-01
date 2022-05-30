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

@SuppressLint("NewApi")
public class ConsultarAsistenciaExterno extends AppCompatActivity {

    EditText idAsistencia;
    TextView idDetalle, idMiembro, calificacion;

    RequestQueue requestQueue;
    String url;

    private final String urlLocal = "http://192.168.1.8/Proyecto01Servicios/Asistencia/ws_query_asistencia.php";

    @SuppressLint("NewApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consultar_asistencia_externo);

        idAsistencia = findViewById(R.id.idAsistencia);
        idDetalle = findViewById(R.id.txtIdDetalle);
        idMiembro = findViewById(R.id.txtMiembroUniversitario);
        calificacion = findViewById(R.id.txtCalificacion);
    }

    public  void consultarAsistencia(View v){
        String id_asistencia = idAsistencia.getText().toString();

        if(id_asistencia == null){
            Toast.makeText(this, "Error, ingrese un id de la actividad", Toast.LENGTH_SHORT).show();
        }
        else{
            url = urlLocal + "?IDASISTENCIA=" + id_asistencia;

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
                        idDetalle.setText("Id Detalle: "+jsonObject.getString("ID_DETALLE"));
                        idMiembro.setText("Id Miembro: "+jsonObject.getString("IDMIEMBROUNIVERSITARIO"));
                        calificacion.setText("Calificacion: "+jsonObject.getString("CALIFICACION"));
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