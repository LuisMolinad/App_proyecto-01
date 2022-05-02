package com.edu.ues.fia.eisi.app_proyecto01;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MenuDetalleOferta extends AppCompatActivity implements View.OnClickListener {

    //Variables de CardView
    public CardView insertar, consultar, editar, eliminar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_detalle_oferta);

        //Insertar
        insertar = (CardView) findViewById(R.id.cardInsertarDetalleOferta);
        insertar.setOnClickListener(this);

        //Consultar
        consultar = (CardView) findViewById(R.id.cardConsultarDetalleOferta);
        consultar.setOnClickListener(this);

        //Editar
        editar = (CardView) findViewById(R.id.cardEditarDetalleOferta);
        editar.setOnClickListener(this);

        //Eliminar
        eliminar = (CardView) findViewById(R.id.cardEliminarDetalleOferta);
        eliminar.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        Intent i;

        switch (view.getId()){
            case R.id.cardInsertarDetalleOferta:
                i = new Intent(this, InsertarDetalleOferta.class);
                startActivity(i);
                break;
            case R.id.cardConsultarDetalleOferta:
                i = new Intent(this, ConsultarDetalleOferta.class);
                startActivity(i);
                break;
            case R.id.cardEditarDetalleOferta:a:
                i = new Intent(this, EditarDetalleOferta.class);
                startActivity(i);
                break;
            case R.id.cardEliminarDetalleOferta:
                i = new Intent(this, EliminarDetalleOferta.class);
                startActivity(i);
                break;
        }

    }
}