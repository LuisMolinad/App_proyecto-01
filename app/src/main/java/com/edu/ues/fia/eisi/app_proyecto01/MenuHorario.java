package com.edu.ues.fia.eisi.app_proyecto01;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MenuHorario extends AppCompatActivity implements View.OnClickListener{

    //Variables de CardView
    public CardView insertar, consultar, editar, eliminar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_horario);

        //Insertar
        insertar = (CardView) findViewById(R.id.cardInsertarHorario);
        insertar.setOnClickListener(this);

        //Consultar
        consultar = (CardView) findViewById(R.id.cardConsultarHorario);
        consultar.setOnClickListener(this);

        //Editar
        editar = (CardView) findViewById(R.id.cardEditarHorario);
        editar.setOnClickListener(this);

        //Eliminar
        eliminar = (CardView) findViewById(R.id.cardEliminarHorario);
        eliminar.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        Intent i;

        switch (view.getId()){
            case R.id.cardInsertarHorario:
                i = new Intent(this, InsertarHorario.class);
                startActivity(i);
                break;
            case R.id.cardConsultarHorario:
                i = new Intent(this, ConsultarHorario.class);
                startActivity(i);
                break;
            case R.id.cardEditarHorario:
                i = new Intent(this, EditarHorario.class);
                startActivity(i);
                break;
            case R.id.cardEliminarHorario:
                i = new Intent(this, EliminarHorario.class);
                startActivity(i);
                break;
        }

    }
}