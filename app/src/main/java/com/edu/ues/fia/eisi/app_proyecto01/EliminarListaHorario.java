package com.edu.ues.fia.eisi.app_proyecto01;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class EliminarListaHorario extends AppCompatActivity {

    ControlBDActividades helper;
    EditText idListaHorario;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eliminar_lista_horario);

        //Iniciamos la bd
        helper = new ControlBDActividades(this);

        idListaHorario = findViewById(R.id.idListaHorarioEliminar);
    }

    public void eliminarListaHorario(View v){
        String regEliminados;

        ListaHorario listaHorario = new ListaHorario();
        listaHorario.setIDLISTAHORARIO(Integer.valueOf(idListaHorario.getText().toString()));

        helper.abrir();
        regEliminados = helper.eliminarListaHorario(listaHorario);
        helper.cerrar();

        Toast.makeText(this, regEliminados, Toast.LENGTH_SHORT).show();
    }
}