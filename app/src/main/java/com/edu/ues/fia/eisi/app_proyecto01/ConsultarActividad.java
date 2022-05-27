package com.edu.ues.fia.eisi.app_proyecto01;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ConsultarActividad extends AppCompatActivity {

    ControlBDActividades helper;
    EditText idActividad;
    TextView txtIdMiembroUniversitario, txtNombreActividad, txtFechaReserva, txtDesdeActividad, txtHastaActividad, txtAprobado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consultar_actividad);

        //Iniciamos la base de datos
        helper = new ControlBDActividades(this);

        //Cargamos los ids
        idActividad = findViewById(R.id.idActividad);
        txtIdMiembroUniversitario = findViewById(R.id.txtMiembroUniversitario);
        txtNombreActividad = findViewById(R.id.txtNombreActividad);
        txtFechaReserva = findViewById(R.id.txtFecha);
        txtDesdeActividad = findViewById(R.id.txtDesdeActividad);
        txtHastaActividad = findViewById(R.id.txtHastaActividad);
        txtAprobado = findViewById(R.id.txtAprobado);
    }

    public void consultarActividad(View v){
        String id_actividad = idActividad.getText().toString();

        if(id_actividad == null){
            Toast.makeText(this, "Error, ingrese un id de la actividad", Toast.LENGTH_SHORT).show();
        }
        else {
            helper.abrir();
            Actividad actividad = helper.consultarActividad(id_actividad);
            helper.cerrar();

            if(actividad == null){
                Toast.makeText(this, "Error, no se encontro la actividad", Toast.LENGTH_SHORT).show();
            }
            else {
                txtIdMiembroUniversitario.setText("Id miembro universitario: "+ actividad.getIdMiembroUniversitario());
                txtNombreActividad.setText("Nombre de la actividad: "+actividad.getNombreActividad());
                txtFechaReserva.setText("Fecha de reserva: "+actividad.getFechaReserva());
                txtDesdeActividad.setText("Fecha de inicio de la actividad: "+actividad.getDesdeActividad());
                txtHastaActividad.setText("Fecha de finalizacion de la actividad: "+actividad.getHastaActividad());
                txtAprobado.setText("Aprobado: "+actividad.getAprobado());
            }
        }
    }
}