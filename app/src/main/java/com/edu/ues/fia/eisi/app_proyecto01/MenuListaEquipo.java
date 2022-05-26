package com.edu.ues.fia.eisi.app_proyecto01;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MenuListaEquipo extends AppCompatActivity implements View.OnClickListener{

    //Variables de CardView
    public CardView insertar, consultar, editar, eliminar;
    String tipoUsuario;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_lista_equipo);

        //Insertar
        insertar = (CardView) findViewById(R.id.cardInsertarListaEquipo);
        editar = (CardView) findViewById(R.id.cardEditarListaEquipo);
        consultar = (CardView) findViewById(R.id.cardConsultarListaEquipo);
        eliminar = (CardView) findViewById(R.id.cardEliminarListaEquipo);
        //Consultar
        Intent intent = getIntent();
        tipoUsuario = intent.getExtras().getString("OpcionCrud");
        if (tipoUsuario != null) {
            //   String opcioncRUD=tipoUsuario;
            switch (tipoUsuario) {
                case "0100":
                case "0400":
                case "0600":
                    consultar.setOnClickListener(this);
                    insertar.setOnClickListener(this);
                    editar.setOnClickListener(this);
                    eliminar.setOnClickListener(this);
                    break;
                case "0200":
                case "0300":
                    consultar.setOnClickListener(this);
                    insertar.setVisibility(View.GONE);
                    editar.setVisibility(View.GONE);
                    eliminar.setVisibility(View.GONE);
                    break;
                case "0500":
                    consultar.setOnClickListener(this);
                    insertar.setVisibility(View.GONE);
                    editar.setOnClickListener(this);
                    eliminar.setVisibility(View.GONE);
                    break;

            }


        }
    }

    @Override
    public void onClick(View view) {

        Intent i;

        switch (view.getId()){
            case R.id.cardInsertarListaEquipo:
                i = new Intent(this, InsertarListaEquipo.class);
                startActivity(i);
                break;
            case R.id.cardConsultarListaEquipo:
                i = new Intent(this, ConsultarListaEquipo.class);
                startActivity(i);
                break;
            case R.id.cardEditarListaEquipo:
                i = new Intent(this, EditarListaEquipo.class);
                startActivity(i);
                break;
            case R.id.cardEliminarListaEquipo:
                i = new Intent(this, EliminarListaEquipo.class);
                startActivity(i);
                break;
        }

    }
}