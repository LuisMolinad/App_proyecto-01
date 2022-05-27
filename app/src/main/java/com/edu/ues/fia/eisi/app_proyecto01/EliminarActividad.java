package com.edu.ues.fia.eisi.app_proyecto01;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class EliminarActividad extends AppCompatActivity {

    ControlBDActividades helper;
    EditText idActividad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eliminar_actividad);

        helper = new ControlBDActividades(this);
        idActividad = findViewById(R.id.idActividad);
    }

    public void eliminarActividad(View v){
        String regEliminados;

        Actividad actividad = new Actividad();
        actividad.setIdActividad(idActividad.getText().toString());

        helper.abrir();
        regEliminados = helper.eliminarActividad(actividad);
        helper.cerrar();

        Toast.makeText(this, regEliminados, Toast.LENGTH_SHORT).show();
    }
}