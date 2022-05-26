package com.edu.ues.fia.eisi.app_proyecto01;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MenuOfertaAcademica extends AppCompatActivity implements View.OnClickListener {

    //Variables de CardView
    public CardView insertar, consultar, editar, eliminar;
    String tipoUsuario;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_oferta_academica);

        //Insertar
        insertar = (CardView) findViewById(R.id.cardInsertarOfertaAcademica);
        consultar = (CardView) findViewById(R.id.cardConsultarOfertaAcademica);
        editar = (CardView) findViewById(R.id.cardEditarOfertaAcademica);
        eliminar = (CardView) findViewById(R.id.cardEliminarOfertaAcademica);
        Intent intent = getIntent();
        tipoUsuario = intent.getExtras().getString("OpcionCrud");
        if (tipoUsuario != null) {
            //   String opcioncRUD=tipoUsuario;
            switch (tipoUsuario) {
                case "0100":
                    /*Le pones el capturador de eventos*/
                    consultar.setOnClickListener(this);
                    insertar.setOnClickListener(this);
                    editar.setOnClickListener(this);
                    eliminar.setOnClickListener(this);
                    break;
                case "0200":
                case "0300":
                case "0500":
                case "0600":
                case "0400":
                    consultar.setOnClickListener(this);
                    insertar.setVisibility(View.GONE);
                    editar.setVisibility(View.GONE);
                    eliminar.setVisibility(View.GONE);
                    break;

            }
        }

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