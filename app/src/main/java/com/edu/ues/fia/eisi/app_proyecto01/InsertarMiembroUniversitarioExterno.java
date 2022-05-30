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
public class InsertarMiembroUniversitarioExterno extends AppCompatActivity {

    EditText idMiembroUniversitario, idAsignatura, idUsuario, nombreMiembrioUniversitario, tipoMiembro;
    RequestQueue requestQueue;
    String url;

    private final String urlLocal = "http://192.168.1.8/Proyecto01Servicios/MiembroUniversitario/ws_insert_miembro.php";

    @SuppressLint("NewApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insertar_miembro_universitario_externo);

        idMiembroUniversitario = findViewById(R.id.idMiembroUniversitario);
        idAsignatura = findViewById(R.id.idAsignatura);
        idUsuario = findViewById(R.id.idUsuario);
        nombreMiembrioUniversitario = findViewById(R.id.nombreMiembroUniversitario);
        tipoMiembro = findViewById(R.id.tipoMiembroUniversitario);
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

    public void insertarMiembroUniversitarioExterno(View v){
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
}