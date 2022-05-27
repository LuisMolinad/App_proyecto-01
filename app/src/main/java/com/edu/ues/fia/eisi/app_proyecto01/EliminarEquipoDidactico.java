package com.edu.ues.fia.eisi.app_proyecto01;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class EliminarEquipoDidactico extends AppCompatActivity {
    ControlBDActividades helper;
    EditText idEquipoE;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eliminar_equipo_didactico);
        //Iniciamos la bd
        helper = new ControlBDActividades(this);

        idEquipoE = findViewById(R.id.idEquipo);
    }

    public void eliminarEquipoDidactico(View v){
        String regEliminados;

        EquipoDidactico equipodidactico = new EquipoDidactico();
        equipodidactico.setIDEQUIPO(idEquipoE.getText().toString());

        helper.abrir();
        regEliminados = helper.eliminarEquipoDidactico(equipodidactico);
        helper.cerrar();

        Toast.makeText(this, regEliminados, Toast.LENGTH_SHORT).show();
    }
}