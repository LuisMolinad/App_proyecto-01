package com.edu.ues.fia.eisi.app_proyecto01;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class EditarHorario extends AppCompatActivity {

    ControlBDActividades helper;
    EditText idHorario;
    TextView idDesdeHorario,hastaHorario,dia;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_horario);

        helper = new ControlBDActividades(this);
        //Cargamos los ids
        idHorario = findViewById(R.id.idHorario);
        idDesdeHorario = findViewById(R.id.idDesdeHorario);
        hastaHorario = findViewById(R.id.hastaHorario);
        dia = findViewById(R.id.dia);
    }

    public void consultarHorarioEditar(View v){
        String id_horario = idHorario.getText().toString();

        if(id_horario == null){
            Toast.makeText(this, "Error, ingrese un id del horario", Toast.LENGTH_SHORT).show();
        }
        else {
            helper.abrir();
            Horario horario = helper.consultarHorario(id_horario);
            helper.cerrar();

            if(horario == null){
                Toast.makeText(this, "Error no se ha encontrado el horario con el id "+id_horario+", favor intente de nuevo", Toast.LENGTH_SHORT).show();
            }
            else{
                idDesdeHorario.setText(horario.getIDHORARIO());
                hastaHorario.setText(horario.getHASTAHORARIO());
                dia.setText(horario.getDIA());
            }
        }
    }

    public void actualizarHorario(View v){

        String id_horario = idHorario.getText().toString();
        String id_DesdeHorario = idDesdeHorario.getText().toString();
        String id_hastaHorario = hastaHorario.getText().toString();
        String id_dia = dia.getText().toString();


        if(id_horario.isEmpty() ||  id_DesdeHorario.isEmpty() ||  id_hastaHorario.isEmpty()  ||  id_dia.isEmpty()){
            Toast.makeText(this, "Todos los campos tiene que estar llenos", Toast.LENGTH_SHORT).show();
        }
        else {
            String regActualizados;

            Horario horario = new Horario();

            horario.setIDHORARIO(id_horario);
            horario.setDESDEHORARIO(id_DesdeHorario);
            horario.setHASTAHORARIO(id_hastaHorario);
            horario.setDIA(id_dia);

            helper.abrir();
            regActualizados = helper.actualizarHorario(horario);
            helper.cerrar();

            Toast.makeText(this, regActualizados, Toast.LENGTH_SHORT).show();
        }
    }
}