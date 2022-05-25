package com.edu.ues.fia.eisi.app_proyecto01;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class CatalogoAcademicoActivity extends AppCompatActivity implements View.OnClickListener{

    public CardView OfertaAcademica, Carrera, Escuela, Materia, DetalleOfertaAcademica;
    String tipoUsuario;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_catalogo_academico);

        OfertaAcademica = (CardView) findViewById(R.id.cardOfertaAcademica);
        Carrera = (CardView) findViewById(R.id.cardCarrera);
        Escuela = (CardView) findViewById(R.id.cardEscuela);
        Materia = (CardView) findViewById(R.id.cardMateria);
        DetalleOfertaAcademica = (CardView) findViewById(R.id.cardDetalleOferta);
        Intent intent = getIntent();
        tipoUsuario = intent.getExtras().getString("OpcionCrud");
        if (tipoUsuario != null) {
            //   String opcioncRUD=tipoUsuario;
            switch (tipoUsuario) {
                case "0100":
                    /*Le pones el capturador de eventos*/
                    OfertaAcademica.setOnClickListener(this);
                    Carrera.setOnClickListener(this);
                    Escuela.setOnClickListener(this);
                    Materia.setOnClickListener(this);
                    DetalleOfertaAcademica.setOnClickListener(this);
                    break;
                case "0200":
                    OfertaAcademica.setVisibility(View.GONE);
                    Carrera.setOnClickListener(this);
                    Escuela.setVisibility(View.GONE);
                    Materia.setVisibility(View.GONE);
                    DetalleOfertaAcademica.setOnClickListener(this);
                    break;
                case "0300":
                    break;
                case "0400":
                    break;
                case "0500":
                    break;
                case "0600":
                    break;

            }


        }
    }

    @Override
    public void onClick(View view) {

        Intent i ;

        switch (view.getId()){
            case R.id.cardOfertaAcademica:
                i = new Intent(this, MenuOfertaAcademica.class);
                i.putExtra("OpcionCrud",tipoUsuario);
                startActivity(i);
                break;
            case R.id.cardCarrera:
                i = new Intent(this, MenuCarrera.class);
                i.putExtra("OpcionCrud",tipoUsuario);
                startActivity(i);
                break;
            case R.id.cardEscuela:
                i = new Intent(this, MenuEscuela.class);
                i.putExtra("OpcionCrud",tipoUsuario);
                startActivity(i);
                break;
            case R.id.cardMateria:
                i = new Intent(this, MenuMateria.class);
                i.putExtra("OpcionCrud",tipoUsuario);
                startActivity(i);
                break;
            case R.id.cardDetalleOferta:
                i = new Intent(this, MenuDetalleOferta.class);
                i.putExtra("OpcionCrud",tipoUsuario);
                startActivity(i);
                break;
        }
    }
}