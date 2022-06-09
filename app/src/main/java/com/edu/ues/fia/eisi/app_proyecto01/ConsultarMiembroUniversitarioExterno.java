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
public class ConsultarMiembroUniversitarioExterno extends AppCompatActivity {

    EditText idMiembroUniversitario;
    TextView txtIdAsignatura, txtIdUsuario, txtNombre, txtTipoMiembro;

    RequestQueue requestQueue;
    String url;

    //private final String urlLocal = "http://192.168.1.8/Proyecto01Servicios/MiembroUniversitario/ws_query_miembro.php";

    @SuppressLint("NewApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consultar_miembro_universitario_externo);

        idMiembroUniversitario = findViewById(R.id.idMiembroUniversitario);

        txtIdAsignatura = findViewById(R.id.txtIdAsignatura);
        txtIdUsuario = findViewById(R.id.txtIdUsuario);
        txtNombre = findViewById(R.id.txtNombre);
        txtTipoMiembro = findViewById(R.id.txtTipoMiembro);
    }

    public void consultarMiembroUniversitario(View v){

        String miembro = idMiembroUniversitario.getText().toString();

        if(miembro == null){
            Toast.makeText(this, "El miembro universitario con el id "+idMiembroUniversitario.getText().toString() + ", no ha sido encontrado", Toast.LENGTH_LONG).show();
        }
        else {

            url = Rutas.query("MiembroUniversitario") + "?IDMIEMBROUNIVERSITARIO="+miembro;

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
                        txtIdAsignatura.setText("Id asignatura: "+jsonObject.getString("IDASIGNATURA"));
                        txtIdUsuario.setText("Id usuario: "+jsonObject.getString("IDUSUARIO"));
                        txtNombre.setText("Nombre: "+jsonObject.getString("NOMBREMIEMBROUNIVERSITARIO"));
                        txtTipoMiembro.setText("Tipo miembro: "+jsonObject.getString("TIPOMIEMBRO"));
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