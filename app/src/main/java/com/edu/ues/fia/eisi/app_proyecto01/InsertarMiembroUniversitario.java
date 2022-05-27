package com.edu.ues.fia.eisi.app_proyecto01;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class InsertarMiembroUniversitario extends AppCompatActivity {
    ControlBDActividades helper;
    EditText idMiembroUniversitario, idAsignatura, idUsuario, nombreMiembrioUniversitario, tipoMiembro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insertar_miembro_universitario);

        //inicaimos la bd
        helper = new ControlBDActividades(this);

        idMiembroUniversitario = findViewById(R.id.idMiembroUniversitario);
        idAsignatura = findViewById(R.id.idAsignatura);
        idUsuario = findViewById(R.id.idUsuario);
        nombreMiembrioUniversitario = findViewById(R.id.nombreMiembroUniversitario);
        tipoMiembro = findViewById(R.id.tipoMiembroUniversitario);
    }

    public void insertarMiembroUniversitaria(View v){
        String id_miembro_universitario = idMiembroUniversitario.getText().toString();
        String id_asignatura = idAsignatura.getText().toString();
        String id_usuario = idUsuario.getText().toString();
        String nombre_miembro_universitario = nombreMiembrioUniversitario.getText().toString();
        String tipo_miembro = tipoMiembro.getText().toString();

        //Validar que no este vacio

        if(id_miembro_universitario.isEmpty() || id_asignatura.isEmpty() || id_usuario.isEmpty() || nombre_miembro_universitario.isEmpty() || tipo_miembro.isEmpty() ){
            Toast.makeText(this, "Error, no debe dejar campos vacios", Toast.LENGTH_SHORT).show();
        }
        else {
            String regInsertados;

            MiembroUniversitario miembroUniversitario = new MiembroUniversitario();
            miembroUniversitario.setIdMiembroUniversitario(id_miembro_universitario);
            miembroUniversitario.setIdAsignatura(id_asignatura);
            miembroUniversitario.setIdUsuario(id_usuario);
            miembroUniversitario.setNombreMiembroUniversitario(nombre_miembro_universitario);
            miembroUniversitario.setTipoMiembro(tipo_miembro);

            helper.abrir();
            regInsertados = helper.insertarMiembroUniversitario(miembroUniversitario);
            helper.cerrar();
            Toast.makeText(this, regInsertados, Toast.LENGTH_SHORT).show();
        }
    }
}