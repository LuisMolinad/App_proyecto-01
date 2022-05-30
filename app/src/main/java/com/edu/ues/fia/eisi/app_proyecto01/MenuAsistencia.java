package com.edu.ues.fia.eisi.app_proyecto01;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MenuAsistencia extends AppCompatActivity implements View.OnClickListener {

    //Variables de CardView
    public CardView insertar, consultar, editar, eliminar;
    public CardView insertarExterno, consultarExterno, editarExterno, eliminarExterno;
    String tipoUsuario;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_asistencia);
        Intent intent = getIntent();
        tipoUsuario = intent.getExtras().getString("OpcionCrud");
        insertar = (CardView) findViewById(R.id.cardInsertar);
        consultar = (CardView) findViewById(R.id.cardConsultar);
        editar = (CardView) findViewById(R.id.cardEditar);
        eliminar = (CardView) findViewById(R.id.cardEliminar);

        insertarExterno = findViewById(R.id.cardInsertarOnline);
        consultarExterno =  findViewById(R.id.cardConsultarOnline);
        editarExterno = findViewById(R.id.cardEditarOnline);
        eliminarExterno =  findViewById(R.id.cardEliminarOnline);

        if (tipoUsuario != null) {
            //   String opcioncRUD=tipoUsuario;
            switch (tipoUsuario) {
                case "0100":
                case "0400":
                case "0600":
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
                    insertar.setVisibility(View.GONE);
                    consultar.setOnClickListener(this);
                    editar.setOnClickListener(this);
                    eliminar.setVisibility(View.GONE);

                    insertarExterno.setVisibility(View.GONE);
                    consultarExterno.setOnClickListener(this);
                    editarExterno.setOnClickListener(this);
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
                i = new Intent(this, InsertarAsistencia.class);
                startActivity(i);
                break;
            case R.id.cardConsultar:
                i = new Intent(this, ConsultarAsistencia.class);
                startActivity(i);
                break;
            case R.id.cardEditar:
                i = new Intent(this, EditarAsistencia.class);
                startActivity(i);
                break;
            case R.id.cardEliminar:
                i = new Intent(this, EliminarAsistencia.class);
                startActivity(i);
                break;
            case R.id.cardInsertarOnline:
                i = new Intent(this, InsertarAsistenciaExterno.class);
                startActivity(i);
                break;
            case R.id.cardEliminarOnline:
                i = new Intent(this, EliminarAsistenciaExterno.class);
                startActivity(i);
                break;
            case R.id.cardConsultarOnline:
                i = new Intent(this, ConsultarAsistenciaExterno.class);
                startActivity(i);
                break;
            case R.id.cardEditarOnline:
                i = new Intent(this, EditarAsistenciaExterno.class);
                startActivity(i);
                break;
        }

    }
}