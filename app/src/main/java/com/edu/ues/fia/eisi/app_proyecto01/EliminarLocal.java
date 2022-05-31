package com.edu.ues.fia.eisi.app_proyecto01;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class EliminarLocal extends AppCompatActivity {

    ControlBDActividades helper;
    EditText idLocal;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eliminar_local);

        //Iniciamos la bd
        helper = new ControlBDActividades(this);

        idLocal = findViewById(R.id.idLocal);
    }
    public void eliminarLocal(View v){
        String regEliminados;

        Local local = new Local();
        local.setIDLOCAL(idLocal.getText().toString());

        helper.abrir();
        regEliminados = helper.eliminarLocal(local);
        helper.cerrar();

        Toast.makeText(this, regEliminados, Toast.LENGTH_SHORT).show();
    }

}