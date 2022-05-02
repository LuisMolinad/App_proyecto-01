package com.edu.ues.fia.eisi.app_proyecto01;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class CatalogoAcademicoActivity extends AppCompatActivity implements View.OnClickListener{

    public CardView OfertaAcademica, Carrera, Escuela, Materia, DetalleOfertaAcademica;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_catalogo_academico);

        OfertaAcademica = (CardView) findViewById(R.id.cardOfertaAcademica);
        OfertaAcademica.setOnClickListener(this);

        Carrera = (CardView) findViewById(R.id.cardCarrera);
        Carrera.setOnClickListener(this);

        Escuela = (CardView) findViewById(R.id.cardEscuela);
        Escuela.setOnClickListener(this);

        Materia = (CardView) findViewById(R.id.cardMateria);
        Materia.setOnClickListener(this);

        DetalleOfertaAcademica = (CardView) findViewById(R.id.cardDetalleOferta);
        DetalleOfertaAcademica.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        Intent i ;

        switch (view.getId()){
            case R.id.cardOfertaAcademica:
                i = new Intent(this, MenuOfertaAcademica.class);
                startActivity(i);
                break;
            case R.id.cardCarrera:
                i = new Intent(this, MenuCarrera.class);
                startActivity(i);
                break;
            case R.id.cardEscuela:
                i = new Intent(this, MenuEscuela.class);
                startActivity(i);
                break;
            case R.id.cardMateria:
                i = new Intent(this, MenuMateria.class);
                startActivity(i);
                break;
            case R.id.cardDetalleOferta:
                i = new Intent(this, MenuDetalleOferta.class);
                startActivity(i);
                break;
        }
    }
}