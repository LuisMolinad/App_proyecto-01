package com.edu.ues.fia.eisi.app_proyecto01;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MenuMateria extends AppCompatActivity implements View.OnClickListener{

    //Variables de CardView
    public CardView insertar, consultar, editar, eliminar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_materia);

        //Insertar
        insertar = (CardView) findViewById(R.id.cardInsertarMateria);
        insertar.setOnClickListener(this);

        //Consultar
        consultar = (CardView) findViewById(R.id.cardConsultarMateria);
        consultar.setOnClickListener(this);

        //Editar
        editar = (CardView) findViewById(R.id.cardEditarMateria);
        editar.setOnClickListener(this);

        //Eliminar
        eliminar = (CardView) findViewById(R.id.cardEliminarMateria);
        eliminar.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        Intent i;

        switch (view.getId()){
            case R.id.cardInsertarMateria:
                i = new Intent(this, InsertarMateria.class);
                startActivity(i);
                break;
            case R.id.cardConsultarMateria:
                i = new Intent(this, ConsultarMateria.class);
                startActivity(i);
                break;
            case R.id.cardEditarMateria:
                i = new Intent(this, EditarMateria.class);
                startActivity(i);
                break;
            case R.id.cardEliminarMateria:
                i = new Intent(this, EliminarMateria.class);
                startActivity(i);
                break;
        }

    }
}