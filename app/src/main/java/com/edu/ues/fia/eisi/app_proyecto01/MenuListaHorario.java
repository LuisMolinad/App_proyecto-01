package com.edu.ues.fia.eisi.app_proyecto01;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MenuListaHorario extends AppCompatActivity implements View.OnClickListener{

    //Variables de CardView
    public CardView insertar, consultar, editar, eliminar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_lista_horario);

        //Insertar
        insertar = (CardView) findViewById(R.id.cardInsertarListaHorario);
        insertar.setOnClickListener(this);

        //Consultar
        consultar = (CardView) findViewById(R.id.cardConsultarListaHorario);
        consultar.setOnClickListener(this);

        //Editar
        editar = (CardView) findViewById(R.id.cardEditarListaHorario);
        editar.setOnClickListener(this);

        //Eliminar
        eliminar = (CardView) findViewById(R.id.cardEliminarListaHorario);
        eliminar.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        Intent i;

        switch (view.getId()){
            case R.id.cardInsertarListaHorario:
                i = new Intent(this, InsertarListaHorario.class);
                startActivity(i);
                break;
            case R.id.cardConsultarListaHorario:
                i = new Intent(this, ConsultarListaHorario.class);
                startActivity(i);
                break;
            case R.id.cardEditarListaHorario:
                i = new Intent(this, EditarListaHorario.class);
                startActivity(i);
                break;
            case R.id.cardEliminarListaHorario:
                i = new Intent(this, EliminarListaHorario.class);
                startActivity(i);
                break;
        }

    }
}