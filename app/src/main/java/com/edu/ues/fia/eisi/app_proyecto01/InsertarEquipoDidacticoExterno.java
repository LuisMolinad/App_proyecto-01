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
public class InsertarEquipoDidacticoExterno extends AppCompatActivity {

    EditText idEquipo, nombre, descripcionEquipo;

    RequestQueue requestQueue;
    String url;

    //private final String urlLocal = "http://192.168.0.8/Proyecto1.2/Equipo/ws_insert_equipo.php";

    @SuppressLint("NewApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insertar_equipo_didactico_externo);


        idEquipo = findViewById(R.id.idEquipoInsertar);
        nombre = findViewById(R.id.nombreEquipoInsertar);
        descripcionEquipo = findViewById(R.id.descripcionEquipoInsertar);

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
                parametro.put("IDEQUIPO", idEquipo.getText().toString());
                parametro.put("NOMBRE", nombre.getText().toString());
                parametro.put("DESCRIPCIONEQUIPO", descripcionEquipo.getText().toString());
                return parametro;
            }
        };

        requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }

    public void insertarEquipoExterno(View v){
        String id_equipo = idEquipo.getText().toString();
        String nombreE = nombre.getText().toString();
        String desEquipo = descripcionEquipo.getText().toString();


        //Validar que no este vacio

        if(id_equipo.isEmpty() || nombreE.isEmpty() || desEquipo.isEmpty() ){
            Toast.makeText(this, "Error, no debe dejar campos vacios", Toast.LENGTH_SHORT).show();
        }
        else {

            url = Rutas.insert("Equipo") + "?IDEQUIPO=" + id_equipo + "&NOMBRE=" + nombreE + "&DESCRIPCIONEQUIPO=" + desEquipo;

            ejecutar(url);

        }
    }
    public void CancelarInsertarEquipo (View v){
        idEquipo.setText("");
        nombre.setText("");
        descripcionEquipo.setText("");
    }


}