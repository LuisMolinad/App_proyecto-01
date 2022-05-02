package com.edu.ues.fia.eisi.app_proyecto01;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MenuCicloActivity extends AppCompatActivity implements View.OnClickListener {

    //Variables de CardView
    public CardView insertar, consultar, editar, eliminar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_ciclo);

        //Insertar
        insertar = (CardView) findViewById(R.id.cardInsertarCiclo);
        insertar.setOnClickListener(this);

        //Consultar
        consultar = (CardView) findViewById(R.id.cardConsultarCiclo);
        consultar.setOnClickListener(this);

        //Editar
        editar = (CardView) findViewById(R.id.cardEditarCiclo);
        editar.setOnClickListener(this);

        //Eliminar
        eliminar = (CardView) findViewById(R.id.cardEliminarCiclo);
        eliminar.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        Intent i;

        switch (view.getId()){
            case R.id.cardInsertarCiclo:
                i = new Intent(this, InsertarCiclo.class);
                startActivity(i);
                break;
            case R.id.cardConsultarCiclo:
                i = new Intent(this, ConsultarCiclo.class);
                startActivity(i);
                break;
            case R.id.cardEditarCiclo:
                i = new Intent(this, EditarCiclo.class);
                startActivity(i);
                break;
            case R.id.cardEliminarCiclo:
                i = new Intent(this, EliminarCiclo.class);
                startActivity(i);
                break;
        }

    }
}