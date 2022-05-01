package com.edu.ues.fia.eisi.app_proyecto01;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MenuActividadd extends AppCompatActivity implements View.OnClickListener {

    //Variables de CardView
    public CardView insertar, consultar, editar, eliminar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_actividadd);

        //Insertar
        insertar = (CardView) findViewById(R.id.cardInsertarActividad);
        insertar.setOnClickListener(this);

        //Consultar
        consultar = (CardView) findViewById(R.id.cardConsultarActividad);
        consultar.setOnClickListener(this);

        //Editar
        editar = (CardView) findViewById(R.id.cardEditarActividad);
        editar.setOnClickListener(this);

        //Eliminar
        eliminar = (CardView) findViewById(R.id.cardEliminarActividad);
        eliminar.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent i;

        switch (view.getId()){
            case R.id.cardInsertarActividad:
                i = new Intent(this, InsertarActividad.class);
                startActivity(i);
                break;
            case R.id.cardConsultarActividad:
                i = new Intent(this, ConsultarActividad.class);
                startActivity(i);
                break;
            case R.id.cardEditarActividad:
                i = new Intent(this, EditarActividad.class);
                startActivity(i);
                break;
            case R.id.cardEliminarActividad:
                i = new Intent(this, EliminarActividad.class);
                startActivity(i);
                break;
        }
    }
}