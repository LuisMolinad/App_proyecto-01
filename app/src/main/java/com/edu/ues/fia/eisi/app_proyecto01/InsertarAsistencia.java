package com.edu.ues.fia.eisi.app_proyecto01;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class InsertarAsistencia extends AppCompatActivity {

    ControlBDActividades helper;
    EditText idAsistencia, idDetalle, idMiembroUniversitario, calificacion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insertar_asistencia);

        //Iniciar la base de datos
        helper = new ControlBDActividades(this);

        //Capturar datos de cada Edit Text
        idAsistencia = findViewById(R.id.idAsistencia);
        idDetalle = findViewById(R.id.idDetalle);
        idMiembroUniversitario = findViewById(R.id.idMiembroUniversitario);
        calificacion = findViewById(R.id.calificacion);
    }

    public void insertarAsistencia(View v){

        String id_asistencia = idAsistencia.getText().toString();
        int variable = Integer.parseInt(idDetalle.getText().toString());
        int id_detalle = variable;
        String id_miembro = idMiembroUniversitario.getText().toString();
        variable = Integer.parseInt(calificacion.getText().toString());
        int _calificacion = variable;

        if(id_asistencia.isEmpty() || idDetalle.getText().toString().isEmpty() || id_miembro.isEmpty() || calificacion.getText().toString().isEmpty()){
            Toast.makeText(this, "Error, no debe dejar campos vacios", Toast.LENGTH_SHORT).show();
        }
        else {
            String regInsertados;
            Asistencia asistencia = new Asistencia();
            asistencia.setIdAsistencia(id_asistencia);
            asistencia.setIdDetalle(id_detalle);
            asistencia.setIdMiembroUniversitario(id_miembro);
            asistencia.setCalifacion(_calificacion);

            helper.abrir();
            regInsertados = helper.insertarAsistencia(asistencia);
            helper.cerrar();
            Toast.makeText(this, regInsertados, Toast.LENGTH_SHORT).show();
        }
    }
}