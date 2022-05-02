package com.edu.ues.fia.eisi.app_proyecto01;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MenuMiembroUniversitario extends AppCompatActivity implements View.OnClickListener {

    //Variables de CardView
    public CardView insertar, consultar, editar, eliminar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_miembro_universitario);

        //Insertar
        insertar = (CardView) findViewById(R.id.cardInsertarMiembroUniversitario);
        insertar.setOnClickListener(this);

        //Consultar
        consultar = (CardView) findViewById(R.id.cardConsultarMiembroUniversitario);
        consultar.setOnClickListener(this);

        //Editar
        editar = (CardView) findViewById(R.id.cardEditarMiembroUniversitario);
        editar.setOnClickListener(this);

        //Eliminar
        eliminar = (CardView) findViewById(R.id.cardEliminarMiembroUniversitario);
        eliminar.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        Intent i;

        switch (view.getId()){
            case R.id.cardInsertarMiembroUniversitario:
                i = new Intent(this, InsertarMiembroUniversitario.class);
                startActivity(i);
                break;
            case R.id.cardConsultarMiembroUniversitario:
                i = new Intent(this, ConsultarMiembroUniversitario.class);
                startActivity(i);
                break;
            case R.id.cardEditarMiembroUniversitario:
                i = new Intent(this, EditarMiembroUniversitario.class);
                startActivity(i);
                break;
            case R.id.cardEliminarMiembroUniversitario:
                i = new Intent(this, EliminarMiembroUniversitario.class);
                startActivity(i);
                break;
        }

    }

}