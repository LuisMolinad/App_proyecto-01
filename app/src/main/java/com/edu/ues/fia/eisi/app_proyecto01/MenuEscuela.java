package com.edu.ues.fia.eisi.app_proyecto01;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MenuEscuela extends AppCompatActivity implements View.OnClickListener{

    //Variables de CardView
    public CardView insertar, consultar, editar, eliminar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_escuela);

        //Insertar
        insertar = (CardView) findViewById(R.id.cardInsertarEscuela);
        insertar.setOnClickListener(this);

        //Consultar
        consultar = (CardView) findViewById(R.id.cardConsultarEscuela);
        consultar.setOnClickListener(this);

        //Editar
        editar = (CardView) findViewById(R.id.cardEditarEscuela);
        editar.setOnClickListener(this);

        //Eliminar
        eliminar = (CardView) findViewById(R.id.cardEliminarEscuela);
        eliminar.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        Intent i;

        switch (view.getId()){
            case R.id.cardInsertarEscuela:
                i = new Intent(this, InsertarEscuela.class);
                startActivity(i);
                break;
            case R.id.cardConsultarEscuela:
                i = new Intent(this, ConsultarEscuela.class);
                startActivity(i);
                break;
            case R.id.cardEditarEscuela:
                i = new Intent(this, EditarEscuela.class);
                startActivity(i);
                break;
            case R.id.cardEliminarEscuela:
                i = new Intent(this, EliminarEscuela.class);
                startActivity(i);
                break;
        }

    }
}