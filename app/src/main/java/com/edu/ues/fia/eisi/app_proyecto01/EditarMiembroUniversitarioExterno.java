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
public class EditarMiembroUniversitarioExterno extends AppCompatActivity {

    EditText idMiembroUniversitario, idAsignatura, idUsuario, nombreMiembrioUniversitario, tipoMiembro;

    RequestQueue requestQueue;
    String url;

    private final String urlLocal = "http://192.168.1.8/Proyecto01Servicios/MiembroUniversitario/ws_update_miembro.php";
    private final String urlQuery = "http://192.168.1.8/Proyecto01Servicios/MiembroUniversitario/ws_query_miembro.php";

    @SuppressLint("NewApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_miembro_universitario_externo);

        idMiembroUniversitario = findViewById(R.id.idMiembroUniversitario);
        idAsignatura = findViewById(R.id.idAsignatura);
        idUsuario = findViewById(R.id.idUsuario);
        nombreMiembrioUniversitario = findViewById(R.id.nombreMiembroUniversitario);
        tipoMiembro = findViewById(R.id.tipoMiembroUniversitario);
    }


    //Editar

    public void actualizarMiembroUniversitarioExterno(View v){
        String id_miembro_universitario = idMiembroUniversitario.getText().toString();
        String id_asignatura = idAsignatura.getText().toString();
        String id_usuario = idUsuario.getText().toString();
        String nombre_miembro_universitario = nombreMiembrioUniversitario.getText().toString();
        String tipo_miembro = tipoMiembro.getText().toString();

        //Validar que no este vacio

        if(id_miembro_universitario.isEmpty() || id_asignatura.isEmpty() || id_usuario.isEmpty() || nombre_miembro_universitario.isEmpty() || tipo_miembro.isEmpty() ){
            Toast.makeText(this, "Error, no debe dejar campos vacios", Toast.LENGTH_SHORT).show();
        }
        else {

            url = urlLocal + "?IDMIEMBROUNIVERSITARIO=" + id_miembro_universitario + "&IDASIGNATURA=" + id_asignatura + "&IDUSUARIO=" + id_usuario +"&NOMBREMIEMBROUNIVERSITARIO=" + nombre_miembro_universitario + "&TIPOMIEMBRO=" + tipo_miembro;

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
                parametro.put("IDMIEMBROUNIVERSITARIO", idMiembroUniversitario.getText().toString());
                parametro.put("IDASIGNATURA", idAsignatura.getText().toString());
                parametro.put("IDUSUARIO", idUsuario.getText().toString());
                parametro.put("NOMBREMIEMBROUNIVERSITARIO", nombreMiembrioUniversitario.getText().toString());
                parametro.put("TIPOMIEMBRO", tipoMiembro.getText().toString());
                return parametro;
            }
        };

        requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }



    //Consultar

    public void consultarMiembroUniversitarioExterno(View v){

        String miembro = idMiembroUniversitario.getText().toString();

        if(miembro == null){
            Toast.makeText(this, "El miembro universitario con el id "+idMiembroUniversitario.getText().toString() + ", no ha sido encontrado", Toast.LENGTH_LONG).show();
        }
        else {

            url = urlQuery + "?IDMIEMBROUNIVERSITARIO="+miembro;

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
                        idAsignatura.setText(jsonObject.getString("IDASIGNATURA"));
                        idUsuario.setText(jsonObject.getString("IDUSUARIO"));
                        nombreMiembrioUniversitario.setText(jsonObject.getString("NOMBREMIEMBROUNIVERSITARIO"));
                        tipoMiembro.setText(jsonObject.getString("TIPOMIEMBRO"));
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