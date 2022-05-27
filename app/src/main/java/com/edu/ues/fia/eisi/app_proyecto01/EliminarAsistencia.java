package com.edu.ues.fia.eisi.app_proyecto01;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class EliminarAsistencia extends AppCompatActivity {

    ControlBDActividades helper;
    EditText idAsistencia;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eliminar_asistencia);

        helper = new ControlBDActividades(this);
        idAsistencia = findViewById(R.id.idAsistencia);
    }

    public void eliminarAsistencia(View v){
        String regEliminados;

        Asistencia asistencia = new Asistencia();
        asistencia.setIdAsistencia(idAsistencia.getText().toString());

        helper.abrir();
        regEliminados = helper.eliminarAsistencia(asistencia);
        helper.cerrar();

        Toast.makeText(this, regEliminados, Toast.LENGTH_SHORT).show();
    }
}