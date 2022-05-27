package com.edu.ues.fia.eisi.app_proyecto01;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ConsultarAsistencia extends AppCompatActivity {

    ControlBDActividades helper;
    EditText idAsistencia;
    TextView idDetalle, idMiembro, calificacion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consultar_asistencia);

        helper = new ControlBDActividades(this);

        idAsistencia = findViewById(R.id.idAsistencia);
        idDetalle = findViewById(R.id.txtIdDetalle);
        idMiembro = findViewById(R.id.txtMiembroUniversitario);
        calificacion = findViewById(R.id.txtCalificacion);
    }

    public  void consultarAsistencia(View v){
        String id_asistencia = idAsistencia.getText().toString();

        if(id_asistencia == null){
            Toast.makeText(this, "Error, ingrese un id de la actividad", Toast.LENGTH_SHORT).show();
        }
        else{
            helper.abrir();
            Asistencia asistencia = helper.consultarAsistencia(id_asistencia);
            helper.cerrar();

            if(asistencia == null){
                Toast.makeText(this, "Error, no se encontro la asistencia con el id "+id_asistencia, Toast.LENGTH_SHORT).show();
            }
            else{
                idDetalle.setText("Id detalle: "+asistencia.getIdDetalle());
                idMiembro.setText("Id miembro: "+asistencia.getIdMiembroUniversitario());
                calificacion.setText("Calificacion: "+asistencia.getCalifacion());
            }
        }
    }
}