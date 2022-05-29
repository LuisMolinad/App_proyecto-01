package com.edu.ues.fia.eisi.app_proyecto01;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MenuActividadd extends AppCompatActivity implements View.OnClickListener {

    //Variables de CardView
    public CardView insertar, consultar, editar, eliminar;
    public CardView insertarExterno, consultarExterno, editarExterno, eliminarExterno;

    String tipoUsuario;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_actividadd);

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
                case "0600":
                    insertar.setVisibility(View.GONE);
                    consultar.setOnClickListener(this);
                    editar.setVisibility(View.GONE);
                    eliminar.setVisibility(View.GONE);

                    insertarExterno.setOnClickListener(this);
                    consultarExterno.setOnClickListener(this);
                    editarExterno.setOnClickListener(this);
                    eliminarExterno.setOnClickListener(this);
                    break;
                case "0400":
                    insertar.setVisibility(View.GONE);
                    consultar.setOnClickListener(this);
                    editar.setOnClickListener(this);
                    eliminar.setVisibility(View.GONE);

                    insertarExterno.setOnClickListener(this);
                    consultarExterno.setOnClickListener(this);
                    editarExterno.setOnClickListener(this);
                    eliminarExterno.setOnClickListener(this);
                    break;

            }


        }
    }

    @Override
    public void onClick(View view) {
        Intent i;

        switch (view.getId()){
            case R.id.cardInsertar:
                i = new Intent(this, InsertarActividad.class);
                startActivity(i);
                break;
            case R.id.cardConsultar:
                i = new Intent(this, ConsultarActividad.class);
                startActivity(i);
                break;
            case R.id.cardEditar:
                i = new Intent(this, EditarActividad.class);
                startActivity(i);
                break;
            case R.id.cardEliminar:
                i = new Intent(this, EliminarActividad.class);
                startActivity(i);
                break;
            case R.id.cardInsertarOnline:
                i = new Intent(this, InsertarActividadExterno.class);
                startActivity(i);
                break;
            case R.id.cardEliminarOnline:
                i = new Intent(this, EliminarActividadExterno.class);
                startActivity(i);
                break;
        }
    }
}