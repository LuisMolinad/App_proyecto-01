package com.edu.ues.fia.eisi.app_proyecto01;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ConsultarHorario extends AppCompatActivity {

    ControlBDActividades helper;
    EditText idHorario;
    TextView txtDesdeHorario, txtHastaHorario, txtDia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consultar_horario);

        //Iniciamos la base de datos
        helper = new ControlBDActividades(this);

        //Cargamos los ids
        idHorario = findViewById(R.id.idHorario);
        txtDesdeHorario = findViewById(R.id.txtDesdeHorario);
        txtHastaHorario = findViewById(R.id.txtHastaHorario);
        txtDia = findViewById(R.id.txtDia);
    }

    public void consultarHorario(View v) {
        String id_horario = idHorario.getText().toString();

        if (id_horario == null) {
            Toast.makeText(this, "Error, ingrese un id del particular", Toast.LENGTH_SHORT).show();
        } else {
            helper.abrir();
            Horario horario = helper.consultarHorario(id_horario);
            helper.cerrar();

            if (horario == null) {
                Toast.makeText(this, "Error no se ha encontrado un horario con el id " + id_horario + ", favor intente de nuevo", Toast.LENGTH_SHORT).show();
            } else {
                txtDesdeHorario.setText("Desde: " + horario.getDESDEHORARIO().toString());
                txtHastaHorario.setText("Hasta: " + horario.getHASTAHORARIO().toString());
                txtDia.setText("Dia: " + horario.getDIA().toString());
            }
        }
    }
}