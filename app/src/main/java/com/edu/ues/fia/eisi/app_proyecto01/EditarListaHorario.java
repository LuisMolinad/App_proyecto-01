package com.edu.ues.fia.eisi.app_proyecto01;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class EditarListaHorario extends AppCompatActivity {

    ControlBDActividades helper;
    EditText idListaHorario,idDetalle,horario;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_lista_horario);
        helper = new ControlBDActividades(this);

        //Cargamos los ids
        idListaHorario = findViewById(R.id.idListraHorarioEditar);
        idDetalle = findViewById(R.id.idDetalle);
        horario = findViewById(R.id.horario);
    }

    public void consultarListaHorarioEditar(View v){
        String id_listaHorario = idListaHorario.getText().toString();

        if(id_listaHorario == null){
            Toast.makeText(this, "Error, ingrese un id del horario", Toast.LENGTH_SHORT).show();
        }
        else {
            helper.abrir();
            ListaHorario listaHorario = helper.consultarListaHorario(id_listaHorario);
            helper.cerrar();

            if(listaHorario == null){
                Toast.makeText(this, "Error no se ha encontrado la lista horario con el id "+id_listaHorario+", favor intente de nuevo", Toast.LENGTH_SHORT).show();
            }
            else{
                //idListaHorario.setText(listaHorario.getIDLISTAHORARIO());
                idDetalle.setText(listaHorario.getID_DETALLE());
                horario.setText(listaHorario.getIDHORARIO());
            }
        }
    }

    public void actualizarListaHorario(View v){

        String id_listaHorario = idListaHorario.getText().toString();
        String id_detalle = idDetalle.getText().toString();
        String id_horario = horario.getText().toString();


        if(id_listaHorario.isEmpty() ||  id_detalle.isEmpty() ||  id_horario.isEmpty()){
            Toast.makeText(this, "Todos los campos tiene que estar llenos", Toast.LENGTH_SHORT).show();
        }
        else {
            String regActualizados;

            ListaHorario listaHorario = new ListaHorario();
            listaHorario.setIDLISTAHORARIO(Integer.parseInt(id_listaHorario));
            listaHorario.setID_DETALLE(Integer.parseInt(id_detalle));
            listaHorario.setIDHORARIO(Integer.parseInt(id_horario));

            helper.abrir();
            regActualizados = helper.actualizarListaHorario(listaHorario);
            helper.cerrar();

            Toast.makeText(this, regActualizados, Toast.LENGTH_SHORT).show();
        }
    }
}