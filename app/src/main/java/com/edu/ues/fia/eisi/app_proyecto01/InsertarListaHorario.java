package com.edu.ues.fia.eisi.app_proyecto01;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class InsertarListaHorario extends AppCompatActivity {

    ControlBDActividades helper;
    EditText idListaHorario, idDetalle, idHorario;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insertar_lista_horario);

        //Iniciar la base de datos
        helper = new ControlBDActividades(this);

        //Capturar los ide de cada EditText
        idListaHorario = findViewById(R.id.idListaHorario);
        idDetalle = findViewById(R.id.idDetalle);
        idHorario = findViewById(R.id.idHorario);
    }
    public void insertarListaHorario(View v){

        if(idListaHorario.getText().toString().isEmpty() || idDetalle.getText().toString().isEmpty() ||idHorario.getText().toString().isEmpty()){
            Toast.makeText(this, "Error, no debe dejar campos vacios", Toast.LENGTH_SHORT).show();
        }
        else{
            String regInsertados;

            ListaHorario listaHorario = new ListaHorario();

            //detalleactividad.setID_DETALLE( Integer.parseInt(idDetalle.getText().toString()));
            listaHorario.setIDLISTAHORARIO(Integer.parseInt(idListaHorario.getText().toString()));
            listaHorario.setID_DETALLE(Integer.parseInt(idDetalle.getText().toString()));
            listaHorario.setIDHORARIO(Integer.parseInt(idHorario.getText().toString()));

            helper.abrir();
            regInsertados = helper.insertarListaHorario(listaHorario);
            helper.cerrar();
            Toast.makeText(this, regInsertados, Toast.LENGTH_SHORT).show();
        }
    }
}