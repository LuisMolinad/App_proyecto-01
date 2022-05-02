package com.edu.ues.fia.eisi.app_proyecto01;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MenuListaEquipo extends AppCompatActivity implements View.OnClickListener{

    //Variables de CardView
    public CardView insertar, consultar, editar, eliminar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_lista_equipo);

        //Insertar
        insertar = (CardView) findViewById(R.id.cardInsertarListaEquipo);
        insertar.setOnClickListener(this);

        //Consultar
        consultar = (CardView) findViewById(R.id.cardConsultarListaEquipo);
        consultar.setOnClickListener(this);

        //Editar
        editar = (CardView) findViewById(R.id.cardEditarListaEquipo);
        editar.setOnClickListener(this);

        //Eliminar
        eliminar = (CardView) findViewById(R.id.cardEliminarListaEquipo);
        eliminar.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        Intent i;

        switch (view.getId()){
            case R.id.cardInsertarListaEquipo:
                i = new Intent(this, InsertarListaEquipo.class);
                startActivity(i);
                break;
            case R.id.cardConsultarListaEquipo:
                i = new Intent(this, ConsultarListaEquipo.class);
                startActivity(i);
                break;
            case R.id.cardEditarListaEquipo:
                i = new Intent(this, EditarListaEquipo.class);
                startActivity(i);
                break;
            case R.id.cardEliminarListaEquipo:
                i = new Intent(this, EliminarListaEquipo.class);
                startActivity(i);
                break;
        }

    }
}