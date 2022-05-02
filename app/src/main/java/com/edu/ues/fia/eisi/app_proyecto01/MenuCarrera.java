package com.edu.ues.fia.eisi.app_proyecto01;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MenuCarrera extends AppCompatActivity implements View.OnClickListener{

    //Variables de CardView
    public CardView insertar, consultar, editar, eliminar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_carrera);

        //Insertar
        insertar = (CardView) findViewById(R.id.cardInsertarCarrera);
        insertar.setOnClickListener(this);

        //Consultar
        consultar = (CardView) findViewById(R.id.cardConsultarCarrera);
        consultar.setOnClickListener(this);

        //Editar
        editar = (CardView) findViewById(R.id.cardEditarCarrera);
        editar.setOnClickListener(this);

        //Eliminar
        eliminar = (CardView) findViewById(R.id.cardEliminarCarrera);
        eliminar.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        Intent i;

        switch (view.getId()){
            case R.id.cardInsertarCarrera:
                i = new Intent(this, InsertarCarrera.class);
                startActivity(i);
                break;
            case R.id.cardConsultarCarrera:
                i = new Intent(this, ConsultarCarrera.class);
                startActivity(i);
                break;
            case R.id.cardEditarCarrera:
                i = new Intent(this, EditarCarrera.class);
                startActivity(i);
                break;
            case R.id.cardEliminarCarrera:
                i = new Intent(this, EliminarCarrera.class);
                startActivity(i);
                break;
        }

    }
}