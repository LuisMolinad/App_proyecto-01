package com.edu.ues.fia.eisi.app_proyecto01;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class EliminarMiembroUniversitario extends AppCompatActivity {

    ControlBDActividades helper;
    EditText idMiembroUniversitario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eliminar_miembro_universitario);

        //inicaimos la bd
        helper = new ControlBDActividades(this);

        idMiembroUniversitario = findViewById(R.id.idMiembroUniversitario);
    }

    public void eliminarMiembroUniversitario(View v){
    String regEliminadas;

    MiembroUniversitario miembroUniversitario = new MiembroUniversitario();
    miembroUniversitario.setIdMiembroUniversitario(idMiembroUniversitario.getText().toString());
    helper.abrir();
    regEliminadas = helper.eliminarMiembroUniversitario(miembroUniversitario);
    helper.cerrar();
        Toast.makeText(this,regEliminadas, Toast.LENGTH_SHORT).show();
    }
}