package com.edu.ues.fia.eisi.app_proyecto01;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MenuOfertaAcademica extends AppCompatActivity implements View.OnClickListener {

    //Variables de CardView
    public CardView insertar, consultar, editar, eliminar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_oferta_academica);

        //Insertar
        insertar = (CardView) findViewById(R.id.cardInsertarOfertaAcademica);
        insertar.setOnClickListener(this);

        //Consultar
        consultar = (CardView) findViewById(R.id.cardConsultarOfertaAcademica);
        consultar.setOnClickListener(this);

        //Editar
        editar = (CardView) findViewById(R.id.cardEditarOfertaAcademica);
        editar.setOnClickListener(this);

        //Eliminar
        eliminar = (CardView) findViewById(R.id.cardEliminarOfertaAcademica);
        eliminar.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        Intent i;

        switch (view.getId()){
            case R.id.cardInsertarOfertaAcademica:
                i = new Intent(this, InsertarOfertaAcademica.class);
                startActivity(i);
                break;
            case R.id.cardConsultarOfertaAcademica:
                i = new Intent(this, ConsultarOfertaAcademica.class);
                startActivity(i);
                break;
            case R.id.cardEditarOfertaAcademica:
                i = new Intent(this, EditarOfertaAcademica.class);
                startActivity(i);
                break;
            case R.id.cardEliminarOfertaAcademica:
                i = new Intent(this, EliminarOfertaAcademica.class);
                startActivity(i);
                break;
        }

    }
}