package com.edu.ues.fia.eisi.app_proyecto01;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class EliminarHorario extends AppCompatActivity {

    ControlBDActividades helper;
    EditText idHorario;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eliminar_horario);

        //Iniciamos la bd
        helper = new ControlBDActividades(this);

        idHorario = findViewById(R.id.idHorario);
    }

    public void eliminarHorario(View v){
        String regEliminados;

        Horario horario = new Horario();
        horario.setIDHORARIO(idHorario.getText().toString());

        helper.abrir();
        regEliminados = helper.eliminarHorario(horario);
        helper.cerrar();

        Toast.makeText(this, regEliminados, Toast.LENGTH_SHORT).show();
    }
}