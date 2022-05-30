package com.edu.ues.fia.eisi.app_proyecto01;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class InsertarLocal extends AppCompatActivity {


    ControlBDActividades helper;
    EditText idLocal, nombreLocal, cupo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insertar_local);

        //Iniciar la base de datos
        helper = new ControlBDActividades(this);

        //Capturar los ide de cada EditText
        idLocal = findViewById(R.id.idLocalIns);
        nombreLocal = findViewById(R.id.nombreLocal);
        cupo = findViewById(R.id.cupo);
    }

    public void insertarLocal(View v){

        if(idLocal.getText().toString().isEmpty() || nombreLocal.getText().toString().isEmpty() ||cupo.getText().toString().isEmpty()){
            Toast.makeText(this, "Error, no debe dejar campos vacios", Toast.LENGTH_SHORT).show();
        }
        else{
            String regInsertados;

            Local local = new Local();

            local.setIDLOCAL(idLocal.getText().toString());
            local.setNOMBRELOCAL(nombreLocal.getText().toString());
            local.setCUPO(Integer.valueOf(cupo.getText().toString()));

            helper.abrir();
            regInsertados = helper.insertarLocal(local);
            helper.cerrar();
            Toast.makeText(this, regInsertados, Toast.LENGTH_SHORT).show();
        }
    }
}