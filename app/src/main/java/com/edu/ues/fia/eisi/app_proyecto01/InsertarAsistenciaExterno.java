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
public class InsertarAsistenciaExterno extends AppCompatActivity {

    EditText idAsistencia, idDetalle, idMiembroUniversitario, calificacion;
    RequestQueue requestQueue;
    String url;

    //private final String urlLocal = "http://192.168.1.8/Proyecto01Servicios/Asistencia/ws_insert_asistencia.php";

    @SuppressLint("NewApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insertar_asistencia_externo);

        //Capturar datos de cada Edit Text
        idAsistencia = findViewById(R.id.idAsistencia);
        idDetalle = findViewById(R.id.idDetalle);
        idMiembroUniversitario = findViewById(R.id.idMiembroUniversitario);
        calificacion = findViewById(R.id.calificacion);
    }

    public void insertarAsistencia(View v){

        String id_asistencia = idAsistencia.getText().toString();
        int variable = Integer.parseInt(idDetalle.getText().toString());
        int id_detalle = variable;
        String id_miembro = idMiembroUniversitario.getText().toString();
        variable = Integer.parseInt(calificacion.getText().toString());
        int _calificacion = variable;

        if(id_asistencia.isEmpty() || idDetalle.getText().toString().isEmpty() || id_miembro.isEmpty() || calificacion.getText().toString().isEmpty()){
            Toast.makeText(this, "Error, no debe dejar campos vacios", Toast.LENGTH_SHORT).show();
        }
        else {
            url = Rutas.insert("Asistencia") + "?IDASISTENCIA=" + id_asistencia + "&ID_DETALLE=" + id_detalle + "&IDMIEMBROUNIVERSITARIO=" + id_miembro + "&CALIFICACION=" + _calificacion ;

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
                parametro.put("IDASISTENCIA", idAsistencia.getText().toString());
                parametro.put("ID_DETALLE", idDetalle.getText().toString());
                parametro.put("IDMIEMBROUNIVERSITARIO", idMiembroUniversitario.getText().toString());
                parametro.put("CALIFICACION", calificacion.getText().toString());
                return parametro;
            }
        };

        requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }
}