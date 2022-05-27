package com.edu.ues.fia.eisi.app_proyecto01;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class EditarEscuela extends AppCompatActivity {
ControlBDActividades helper;
EditText idEscuela, idCarrera;
EditText NombreEscuelaEditar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_escuela);
        helper = new ControlBDActividades(this);

        idEscuela = findViewById(R.id.idEscuelaEditar);
        idCarrera = findViewById(R.id.idCarreraEditar);
        NombreEscuelaEditar = findViewById(R.id.nombreEscuelaEditar);


    }

    public void actualizarEscuela(View v) {

        Escuela escuela = new Escuela();
        escuela.setIDESCUELA(idEscuela.getText().toString());
        escuela.setIDCARRERA(idCarrera.getText().toString());
        escuela.setNOMBRE_ESCUELA(NombreEscuelaEditar.getText().toString());
        helper.abrir();
        String estado = helper.actualizarEscuela(escuela);
        helper.cerrar();
        Toast.makeText(this, estado, Toast.LENGTH_SHORT).show();
    }
    public void CancelarEscuela (View v){
        idEscuela.setText("");
        NombreEscuelaEditar.setText("");
        idCarrera.setText("");
    }



}