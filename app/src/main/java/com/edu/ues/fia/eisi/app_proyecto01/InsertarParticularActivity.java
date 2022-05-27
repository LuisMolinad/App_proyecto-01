package com.edu.ues.fia.eisi.app_proyecto01;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class InsertarParticularActivity extends AppCompatActivity {

    ControlBDActividades helper;
    EditText idParticular, idUsuario, nombreParticular, apellidoParticular;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insertar_particular);

        //Iniciar la base de datos
        helper = new ControlBDActividades(this);

        //Capturar los ide de cada EditText
        idParticular = findViewById(R.id.idParticular);
        idUsuario = findViewById(R.id.idUsuario);
        nombreParticular = findViewById(R.id.nombreParticular);
        apellidoParticular = findViewById(R.id.apellidoParticular);
    }

    public void insertarParticular(View v){

        if(idParticular.getText().toString().isEmpty() || idUsuario.getText().toString().isEmpty() || nombreParticular.getText().toString().isEmpty() || apellidoParticular.getText().toString().isEmpty()){
            Toast.makeText(this, "Error, no debe dejar campos vacios", Toast.LENGTH_SHORT).show();
        }
        else{
            String regInsertados;

            Particular particular = new Particular();

            particular.setIDPARTICULAR(idParticular.getText().toString());
            particular.setIDPUSUARIO(idUsuario.getText().toString());
            particular.setNOMBREPARTICULAR(nombreParticular.getText().toString());
            particular.setAPELLIDOPARTICULAR(apellidoParticular.getText().toString());

            helper.abrir();
            regInsertados = helper.insertarParticular(particular);
            helper.cerrar();
            Toast.makeText(this, regInsertados, Toast.LENGTH_SHORT).show();
        }
    }
}