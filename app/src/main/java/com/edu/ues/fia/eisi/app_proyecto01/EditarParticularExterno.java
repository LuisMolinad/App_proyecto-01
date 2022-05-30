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

public class EditarParticularExterno extends AppCompatActivity {

    EditText idParticular, idUsuario, nombreParticular, apellidoParticular;
    RequestQueue requestQueue;
    String url;

    private final String urlQuery = "http://192.168.1.8/Proyecto01Servicios/Particular/ws_query_particular.php";
    private final String urlLocal = "http://192.168.1.8/Proyecto01Servicios/Particular/ws_update_particular.php";

    @SuppressLint("NewApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_particular_externo);

        idParticular = findViewById(R.id.idParticular);
        idUsuario = findViewById(R.id.idUsuario);
        nombreParticular = findViewById(R.id.nombreParticular);
        apellidoParticular = findViewById(R.id.apellidoParticular);
    }

    //Editar
    public void actualizarParticular(View v){
        String id_particular = idParticular.getText().toString();
        String id_usuario = idUsuario.getText().toString();
        String nombre_particular = nombreParticular.getText().toString();
        String apellido_particular = apellidoParticular.getText().toString();

        //Validar que no este vacio
        if(id_particular.isEmpty() || id_usuario.isEmpty() || nombre_particular.isEmpty() || apellido_particular.isEmpty()){
            Toast.makeText(this, "Todos los campos tiene que estar llenos", Toast.LENGTH_SHORT).show();
        }
        else {
            url = urlLocal + "?IDPARTICULAR=" + idParticular.getText().toString() +"&IDUSUARIO=" + idUsuario.getText().toString() + "&NOMBREPARTICULAR=" + nombreParticular.getText().toString() + "&APELLIDOPARTICULAR=" + apellidoParticular.getText().toString();
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
                parametro.put("IDPARTICULAR", idParticular.getText().toString());
                parametro.put("IDUSUARIO", idUsuario.getText().toString());
                parametro.put("NOMBREPARTICULAR", nombreParticular.getText().toString());
                parametro.put("APELLIDOPARTICULAR", apellidoParticular.getText().toString());
                return parametro;
            }
        };

        requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }

    //Consultar
    public void consultarParticular(View v){
        String id_particular = idParticular.getText().toString();

        if(id_particular == null){
            Toast.makeText(this, "Error, ingrese un id del particular", Toast.LENGTH_SHORT).show();
        }
        else {
            url = urlQuery + "?IDPARTICULAR=" + id_particular;

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
                        idUsuario.setText(jsonObject.getString("IDUSUARIO"));
                        nombreParticular.setText(jsonObject.getString("NOMBREPARTICULAR"));
                        apellidoParticular.setText(jsonObject.getString("APELLIDOPARTICULAR"));
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