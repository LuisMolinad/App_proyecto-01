package com.edu.ues.fia.eisi.app_proyecto01;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MenuLocal extends AppCompatActivity implements View.OnClickListener{

    //Variables de CardView
    public CardView insertar, consultar, editar, eliminar;
    public CardView insertarExterno, consultarExterno, editarExterno, eliminarExterno;

    String tipoUsuario;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_local);

        //Insertar
        insertar = findViewById(R.id.cardInsertar);
        consultar = findViewById(R.id.cardConsultar);
        editar = findViewById(R.id.cardEditar);
        eliminar = findViewById(R.id.cardEliminar);

        insertarExterno = findViewById(R.id.cardInsertarOnline);
        consultarExterno =  findViewById(R.id.cardConsultarOnline);
        editarExterno = findViewById(R.id.cardEditarOnline);
        eliminarExterno =  findViewById(R.id.cardEliminarOnline);

        Intent intent = getIntent();
        tipoUsuario = intent.getExtras().getString("OpcionCrud");
        if (tipoUsuario != null) {
            //   String opcioncRUD=tipoUsuario;
            switch (tipoUsuario) {
                case "0100":
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
                case "0500":
                case "0400":
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
            case R.id.cardInsertar:
                i = new Intent(this, InsertarLocal.class);
                startActivity(i);
                break;
            case R.id.cardConsultar:
                i = new Intent(this, ConsultarLocal.class);
                startActivity(i);
                break;
            case R.id.cardEditar:
                i = new Intent(this, EditarLocal.class);
                startActivity(i);
                break;
            case R.id.cardEliminar:
                i = new Intent(this, EliminarLocal.class);
                startActivity(i);
                break;
            case R.id.cardInsertarOnline:
                i = new Intent(this, InsertarLocal.class);
                startActivity(i);
                break;
            case R.id.cardConsultarOnline:
                i = new Intent(this, ConsultarLocal.class);
                startActivity(i);
                break;
            case R.id.cardEditarOnline:
                i = new Intent(this, EditarLocal.class);
                startActivity(i);
                break;
            case R.id.cardEliminarOnline:
                i = new Intent(this, EliminarLocal.class);
                startActivity(i);
                break;
        }

    }
}