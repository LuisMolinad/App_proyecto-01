package com.edu.ues.fia.eisi.app_proyecto01;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class EditarAsistencia extends AppCompatActivity {

    ControlBDActividades helper;
    EditText idAsistencia, idDetalle, idMiembro, calificacion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_asistencia);

        //Iniciar la base de datos
        helper = new ControlBDActividades(this);

        //Capturar datos de cada Edit Text
        idAsistencia = findViewById(R.id.idAsistencias);
        idDetalle = findViewById(R.id.idDetalles);
        idMiembro = findViewById(R.id.idMiembros);
        calificacion = findViewById(R.id.calificacions);
    }

    public  void consultarAsistencias(View v){
        String id_asistencia = idAsistencia.getText().toString();

        if(id_asistencia == null){
            Toast.makeText(this, "Error, ingrese un id de la asistencia", Toast.LENGTH_SHORT).show();
        }
        else{
            helper.abrir();
            Asistencia asistencia = helper.consultarAsistencia(id_asistencia);
            helper.cerrar();

            if(asistencia == null){
                Toast.makeText(this, "Error, no se encontro la asistencia con el id "+id_asistencia, Toast.LENGTH_SHORT).show();
            }
            else{
                idDetalle.setText(Integer.toString(asistencia.getIdDetalle()));
                idMiembro.setText(asistencia.getIdMiembroUniversitario());
                calificacion.setText(Integer.toString(asistencia.getCalifacion()));
            }
        }
    }

    public void actualizarAsistencia(View v){
        String id_asistencia = idAsistencia.getText().toString();
        int variable = Integer.parseInt(idDetalle.getText().toString());
        int id_detalle = variable;
        String id_miembro = idMiembro.getText().toString();
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
            regInsertados = helper.actualizarAsistencia(asistencia);
            helper.cerrar();
            Toast.makeText(this, regInsertados, Toast.LENGTH_SHORT).show();
        }
    }
}