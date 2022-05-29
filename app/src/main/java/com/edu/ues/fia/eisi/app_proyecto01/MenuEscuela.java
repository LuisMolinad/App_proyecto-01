package com.edu.ues.fia.eisi.app_proyecto01;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MenuEscuela extends AppCompatActivity implements View.OnClickListener{

    //Variables de CardView
    public CardView insertar, consultar, editar, eliminar;
    public CardView insertarExterno, consultarExterno, editarExterno, eliminarExterno;
    String tipoUsuario;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_escuela);

        //Insertar
        insertar = findViewById(R.id.cardInsertarEscuela);
        consultar = findViewById(R.id.cardConsultarEscuela);
        editar = findViewById(R.id.cardEditarEscuela);
        eliminar = findViewById(R.id.cardEliminarEscuela);
        insertarExterno = findViewById(R.id.cardInsertarEscuelaExterno);
        consultarExterno = findViewById(R.id.cardConsultarEscuelaExterno);
        editarExterno = findViewById(R.id.cardEditarEscuelaExterno);
        eliminarExterno = findViewById(R.id.cardEliminarEscuelaExterno);
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
                    consultarExterno.setOnClickListener(this);
                    insertarExterno.setOnClickListener(this);
                    editarExterno.setOnClickListener(this);
                    eliminarExterno.setOnClickListener(this);
                    break;
                case "0200":
                case "0300":
                case "0400":
                case "0500":
                case "0600":
                    consultar.setOnClickListener(this);
                    insertar.setVisibility(View.GONE);
                    editar.setVisibility(View.GONE);
                    eliminar.setVisibility(View.GONE);
                    consultarExterno.setOnClickListener(this);
                    insertarExterno.setVisibility(View.GONE);
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
            case R.id.cardInsertarEscuela:
                i = new Intent(this, InsertarEscuela.class);
                startActivity(i);
                break;
            case R.id.cardConsultarEscuela:
                i = new Intent(this, ConsultarEscuela.class);
                startActivity(i);
                break;
            case R.id.cardEditarEscuela:
                i = new Intent(this, EditarEscuela.class);
                startActivity(i);
                break;
            case R.id.cardEliminarEscuela:
                i = new Intent(this, EliminarEscuela.class);
                startActivity(i);
                break;
            case R.id.cardInsertarEscuelaExterno:
                i = new Intent(this, InsertarEscuelaExterno.class);
                startActivity(i);
                break;
            case R.id.cardConsultarEscuelaExterno:
                i = new Intent(this, ConsultarEscuelaExterno.class);
                startActivity(i);
                break;
            case R.id.cardEditarEscuelaExterno:
                i = new Intent(this, EditarEscuelaExterno.class);
                startActivity(i);
                break;
            case R.id.cardEliminarEscuelaExterno:
                i = new Intent(this, EliminarEscuelaExterno.class);
                startActivity(i);
                break;
        }

    }
}