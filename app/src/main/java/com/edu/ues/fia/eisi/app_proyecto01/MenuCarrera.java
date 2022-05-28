package com.edu.ues.fia.eisi.app_proyecto01;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MenuCarrera extends AppCompatActivity implements View.OnClickListener{

    //Variables de CardView
    public CardView insertar, consultar, editar, eliminar;
    public CardView insertarExterno, consultarExterno, editarExterno, eliminarExterno;
    String tipoUsuario;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_carrera);

        //Insertar
        insertar =  findViewById(R.id.cardInsertarCarrera);
        consultar =  findViewById(R.id.cardConsultarCarrera);
        editar =  findViewById(R.id.cardEditarCarrera);
        eliminar = findViewById(R.id.cardEliminarCarrera);

        insertarExterno = findViewById(R.id.cardInsertarCarreraExterno);
        consultarExterno =  findViewById(R.id.cardConsultarCarreraExterno);
        editarExterno = findViewById(R.id.cardEditarCarreraExterno);
        eliminarExterno =  findViewById(R.id.cardEliminarCarreraExterno);

        Intent intent = getIntent();
        tipoUsuario = intent.getExtras().getString("OpcionCrud");
        if (tipoUsuario != null) {
            //   String opcioncRUD=tipoUsuario;
            switch (tipoUsuario) {
                case "0100":
                    /*Le pones el capturador de eventos*/
                    insertar.setOnClickListener(this);
                    consultar.setOnClickListener(this);
                    editar.setOnClickListener(this);
                    eliminar.setOnClickListener(this);
                    insertarExterno.setOnClickListener(this);
                    consultarExterno.setOnClickListener(this);
                    editarExterno.setOnClickListener(this);
                    eliminarExterno.setOnClickListener(this);
                    break;
                case "0200":
                case "0300":
                case "0500":
                case "0400":
                case "0600":
                    insertar.setVisibility(View.GONE);
                    consultar.setOnClickListener(this);
                    editar.setVisibility(View.GONE);
                    eliminar.setVisibility(View.GONE);
                    insertarExterno.setVisibility(View.GONE);
                    consultarExterno.setOnClickListener(this);
                    editarExterno.setVisibility(View.GONE);
                    eliminarExterno.setVisibility(View.GONE);
                    break;

            }


        }
    }

    @Override
    public void onClick(View view) {

        Intent i;

        switch (view.getId()){
            case R.id.cardInsertarCarrera:
                i = new Intent(this, InsertarCarrera.class);
                startActivity(i);
                break;
            case R.id.cardConsultarCarrera:
                i = new Intent(this, ConsultarCarrera.class);
                startActivity(i);
                break;
            case R.id.cardEditarCarrera:
                i = new Intent(this, EditarCarrera.class);
                startActivity(i);
                break;
            case R.id.cardEliminarCarrera:
                i = new Intent(this, EliminarCarrera.class);
                startActivity(i);
                break;
            case R.id.cardInsertarCarreraExterno:
                i = new Intent(this, InsertarCarreraExterno.class);
                startActivity(i);
                break;
            case R.id.cardConsultarCarreraExterno:
                i = new Intent(this, ConsultarCarreraExterno.class);
                startActivity(i);
                break;
            case R.id.cardEditarCarreraExterno:
                i = new Intent(this, EditarCarreraExterno.class);
                startActivity(i);
                break;
            case R.id.cardEliminarCarreraExterno:
                i = new Intent(this, EliminarCarreraExterno.class);
                startActivity(i);
                break;
        }

    }
}