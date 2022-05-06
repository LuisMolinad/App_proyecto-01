package com.edu.ues.fia.eisi.app_proyecto01;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MenuEquipoDidactico extends AppCompatActivity implements View.OnClickListener{

    //Variables de CardView
    public CardView insertar, consultar, editar, eliminar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_equipo_didactico);

        //Insertar
        insertar = (CardView) findViewById(R.id.cardInsertarEquipo);
        insertar.setOnClickListener(this);

        //Consultar
        consultar = (CardView) findViewById(R.id.cardConsultarEquipo);
        consultar.setOnClickListener(this);

        //Editar
        editar = (CardView) findViewById(R.id.cardEditarEquipo);
        editar.setOnClickListener(this);

        //Eliminar
        eliminar = (CardView) findViewById(R.id.cardEliminarEquipo);
        eliminar.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        Intent i;

        switch (view.getId()){
            case R.id.cardInsertarEquipo:
                i = new Intent(this, InsertarEquipoDidactico.class);
                startActivity(i);
                break;
            case R.id.cardConsultarEquipo:
                i = new Intent(this, ConsultarEquipoDidactico.class);
                startActivity(i);
                break;
            case R.id.cardEditarEquipo:
                i = new Intent(this, EditarEquipoDidactico.class);
                startActivity(i);
                break;
            case R.id.cardEliminarEquipo:
                i = new Intent(this, EliminarEquipoDidactico.class);
                startActivity(i);
                break;
        }

    }
}