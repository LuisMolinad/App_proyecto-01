package com.edu.ues.fia.eisi.app_proyecto01;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class InsertarHorario extends AppCompatActivity {

    ControlBDActividades helper;
    EditText idHorario, desdeHorario, hastaHorario, dia;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insertar_horario);

        //Iniciar la base de datos
        helper = new ControlBDActividades(this);

        //Capturar los ide de cada EditText
        idHorario = findViewById(R.id.idHorarioInsertar);
        desdeHorario = findViewById(R.id.desdeHorario);
        hastaHorario = findViewById(R.id.hastaHorario);
        dia = findViewById(R.id.dia);
    }

    public void insertarHorario(View v){

        if(idHorario.getText().toString().isEmpty() || desdeHorario.getText().toString().isEmpty() || hastaHorario.getText().toString().isEmpty() || dia.getText().toString().isEmpty()){
            Toast.makeText(this, "Error, no debe dejar campos vacios", Toast.LENGTH_SHORT).show();
        }
        else{
            String regInsertados;

            Horario horario = new Horario();

            horario.setIDHORARIO(idHorario.getText().toString());
            horario.setDESDEHORARIO(desdeHorario.getText().toString());
            horario.setHASTAHORARIO(hastaHorario.getText().toString());
            horario.setDIA(dia.getText().toString());



            helper.abrir();
            regInsertados = helper.insertarHorario(horario);
            helper.cerrar();
            Toast.makeText(this, regInsertados, Toast.LENGTH_SHORT).show();
        }
    }
}