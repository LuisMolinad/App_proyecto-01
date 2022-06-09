package com.edu.ues.fia.eisi.app_proyecto01;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONObject;

@SuppressLint("NewApi")
public class EliminarActividadExterno extends AppCompatActivity {

    EditText idActividad;

    //private final String urlLocal = "http://192.168.1.8/Proyecto01Servicios/Actividad/ws_delete_actividad.php";

    @SuppressLint("NewApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eliminar_actividad_externo);

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        idActividad = findViewById(R.id.idActividad);
    }

    public void eliminarActividadExterno(View v){

        String id_actividad = idActividad.getText().toString();

        if (id_actividad.isEmpty()) {
            Toast.makeText(this, "No debe dejar campos vacios", Toast.LENGTH_SHORT).show();
        } else {
            String url = null;
            JSONObject datosActividad = new JSONObject();

            url = Rutas.delete("Actividad") + "?IDACTIVIDAD=" + id_actividad;
            ControladorServicio.insertar(url, this);
            Toast.makeText(this, "Se ejecuto correctamente", Toast.LENGTH_SHORT).show();
            }

        }
    }