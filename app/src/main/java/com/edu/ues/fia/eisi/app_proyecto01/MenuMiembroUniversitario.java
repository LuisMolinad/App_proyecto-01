package com.edu.ues.fia.eisi.app_proyecto01;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MenuMiembroUniversitario extends AppCompatActivity implements View.OnClickListener {

    //Variables de CardView
    public CardView insertar, consultar, editar, eliminar;
    public CardView insertarOnline, consultarOnline, editarOnline, eliminarOnline;
    String tipoUsuario;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_miembro_universitario);

        //Insertar
        insertar = (CardView) findViewById(R.id.cardInsertar);
        editar = (CardView) findViewById(R.id.cardEditar);
        eliminar = (CardView) findViewById(R.id.cardEliminar);
        consultar = (CardView) findViewById(R.id.cardConsultar);
        insertarOnline = (CardView) findViewById(R.id.cardInsertarOnline);
        editarOnline = (CardView) findViewById(R.id.cardEditarOnline);
        eliminarOnline = (CardView) findViewById(R.id.cardEliminarOnline);
        consultarOnline = (CardView) findViewById(R.id.cardConsultarOnline);

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
                    consultarOnline.setOnClickListener(this);
                    insertarOnline.setOnClickListener(this);
                    editarOnline.setOnClickListener(this);
                    eliminarOnline.setOnClickListener(this);
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
                    consultarOnline.setOnClickListener(this);
                    insertarOnline.setVisibility(View.GONE);
                    editarOnline.setVisibility(View.GONE);
                    eliminarOnline.setVisibility(View.GONE);
                    break;
            }
        }
    }

    @Override
    public void onClick(View view) {

        Intent i;

        switch (view.getId()){
            case R.id.cardInsertar:
                i = new Intent(this, InsertarMiembroUniversitario.class);
                startActivity(i);
                break;
            case R.id.cardConsultar:
                i = new Intent(this, ConsultarMiembroUniversitario.class);
                startActivity(i);
                break;
            case R.id.cardEditar:
                i = new Intent(this, EditarMiembroUniversitario.class);
                startActivity(i);
                break;
            case R.id.cardEliminar:
                i = new Intent(this, EliminarMiembroUniversitario.class);
                startActivity(i);
                break;
            case R.id.cardInsertarOnline:
                i = new Intent(this, InsertarMiembroUniversitarioExterno.class);
                startActivity(i);
                break;
            case R.id.cardEliminarOnline:
                i = new Intent(this, EliminarMiembroUniversitarioExterno.class);
                startActivity(i);
                break;
            case R.id.cardConsultarOnline:
                i = new Intent(this, ConsultarMiembroUniversitarioExterno.class);
                startActivity(i);
                break;
            case R.id.cardEditarOnline:
                i = new Intent(this, EditarMiembroUniversitarioExterno.class);
                startActivity(i);
                break;
        }

    }

}