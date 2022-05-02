package com.edu.ues.fia.eisi.app_proyecto01;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MenuDetalleActividad extends AppCompatActivity implements View.OnClickListener{

    //Variables de CardView
    public CardView insertar, consultar, editar, eliminar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_detalle_actividad);

        //Insertar
        insertar = (CardView) findViewById(R.id.cardInsertarDetalleActividad);
        insertar.setOnClickListener(this);

        //Consultar
        consultar = (CardView) findViewById(R.id.cardConsultarDetalleActividad);
        consultar.setOnClickListener(this);

        //Editar
        editar = (CardView) findViewById(R.id.cardEditarDetalleActividad);
        editar.setOnClickListener(this);

        //Eliminar
        eliminar = (CardView) findViewById(R.id.cardEliminarDetalleActividad);
        eliminar.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent i;

        switch (view.getId()){
            case R.id.cardInsertarDetalleActividad:
                i = new Intent(this, InsertarDetalleActividad.class);
                startActivity(i);
                break;
            case R.id.cardConsultarDetalleActividad:
                i = new Intent(this, ConsultarDetalleActividad.class);
                startActivity(i);
                break;
            case R.id.cardEditarDetalleActividad:
                i = new Intent(this, EditarDetalleActividad.class);
                startActivity(i);
                break;
            case R.id.cardEliminarDetalleActividad:
                i = new Intent(this, EliminarDetalleActividad.class);
                startActivity(i);
                break;
        }

    }
}