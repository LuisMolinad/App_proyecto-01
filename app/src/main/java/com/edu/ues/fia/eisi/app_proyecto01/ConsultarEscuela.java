package com.edu.ues.fia.eisi.app_proyecto01;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class ConsultarEscuela extends AppCompatActivity {
EditText idEscuelaconsultar, idCarreraCOnsultar, nombreescuelaConsultar;
ControlBDActividades helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consultar_escuela);
        helper = new ControlBDActividades(this);

        idEscuelaconsultar = findViewById(R.id.idEscuelaConsultar);
        idCarreraCOnsultar = findViewById(R.id.idCarreraConsultarFK);
        nombreescuelaConsultar = findViewById(R.id.nombreEscuelaConsultar);
    }

    public  void ConsultarEscuela(View v){
        helper.abrir();

        Escuela escuela = helper.consultarEscuela(idEscuelaconsultar.getText().toString());
        helper.cerrar();
        if(escuela == null){
            Toast.makeText(this,"Escuela no registrada",Toast.LENGTH_SHORT).show();
        }
        else{
            idCarreraCOnsultar.setText(String.valueOf(escuela.getIDCARRERA()));
            nombreescuelaConsultar.setText(String.valueOf(escuela.getNOMBRE_ESCUELA()));
        }
    }

    public void cancelarconsulta(View v){
        idEscuelaconsultar.setText("");
        idCarreraCOnsultar.setText("");
        nombreescuelaConsultar.setText("");
    }
}