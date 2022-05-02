package com.edu.ues.fia.eisi.app_proyecto01;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MenuLocal extends AppCompatActivity implements View.OnClickListener{

    //Variables de CardView
    public CardView insertar, consultar, editar, eliminar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_local);

        //Insertar
        insertar = (CardView) findViewById(R.id.cardInsertarLocal);
        insertar.setOnClickListener(this);

        //Consultar
        consultar = (CardView) findViewById(R.id.cardConsultarLocal);
        consultar.setOnClickListener(this);

        //Editar
        editar = (CardView) findViewById(R.id.cardEditarLocal);
        editar.setOnClickListener(this);

        //Eliminar
        eliminar = (CardView) findViewById(R.id.cardEliminarLocal);
        eliminar.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        Intent i;

        switch (view.getId()){
            case R.id.cardInsertarLocal:
                i = new Intent(this, InsertarLocal.class);
                startActivity(i);
                break;
            case R.id.cardConsultarLocal:
                i = new Intent(this, ConsultarLocal.class);
                startActivity(i);
                break;
            case R.id.cardEditarLocal:
                i = new Intent(this, EditarLocal.class);
                startActivity(i);
                break;
            case R.id.cardEliminarLocal:
                i = new Intent(this, EliminarLocal.class);
                startActivity(i);
                break;
        }

    }
}