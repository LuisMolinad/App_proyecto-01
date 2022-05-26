package com.edu.ues.fia.eisi.app_proyecto01;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class EliminarParticularActivity extends AppCompatActivity {

    ControlBDActividades helper;
    EditText idParticular;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eliminar_particular);

        //Iniciamos la bd
        helper = new ControlBDActividades(this);

        idParticular = findViewById(R.id.idParticular);
    }

    public void eliminarParticular(View v){
        String regEliminados;

        Particular particular = new Particular();
        particular.setIDPARTICULAR(idParticular.getText().toString());

        helper.abrir();
        regEliminados = helper.eliminarParticular(particular);
        helper.cerrar();

        Toast.makeText(this, regEliminados, Toast.LENGTH_SHORT).show();
    }
}