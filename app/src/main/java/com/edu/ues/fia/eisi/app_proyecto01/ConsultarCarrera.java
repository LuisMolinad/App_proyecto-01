package com.edu.ues.fia.eisi.app_proyecto01;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class ConsultarCarrera extends AppCompatActivity {
 ControlBDActividades helper;
 EditText IdCarrera, nombreCarrera;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consultar_carrera);

        //iniciamos a bd
        helper = new ControlBDActividades(this);

        IdCarrera = findViewById(R.id.idCarreraConsulta);
        nombreCarrera = findViewById(R.id.nombreCarreraConsulta);
    }

    public void consultarCarrera(View v) {
        helper.abrir();
        Carrera carrera = helper.consultarCarrera(IdCarrera.getText().toString());
        helper.cerrar();
        if(carrera == null)
            Toast.makeText(this, "Alumno con carnet " + IdCarrera.getText().toString() + " no encontrado", Toast.LENGTH_LONG).show();
        else{
            nombreCarrera.setText(carrera.getNOMBRECARRERA());
        }
    }

    public void CancelarConsulta(View v){
        IdCarrera.setText("");
        nombreCarrera.setText("");
    }

}