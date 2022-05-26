package com.edu.ues.fia.eisi.app_proyecto01;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MenuMateria extends AppCompatActivity implements View.OnClickListener{

    //Variables de CardView
    public CardView insertar, consultar, editar, eliminar;
    String tipoUsuario;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_materia);

        //Insertar
        insertar = (CardView) findViewById(R.id.cardInsertarMateria);
        consultar = (CardView) findViewById(R.id.cardConsultarMateria);
        editar = (CardView) findViewById(R.id.cardEditarMateria);
        eliminar = (CardView) findViewById(R.id.cardEliminarMateria);
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
                    break;

            }
        }
    }

    @Override
    public void onClick(View view) {

        Intent i;

        switch (view.getId()){
            case R.id.cardInsertarMateria:
                i = new Intent(this, InsertarMateria.class);
                startActivity(i);
                break;
            case R.id.cardConsultarMateria:
                i = new Intent(this, ConsultarMateria.class);
                startActivity(i);
                break;
            case R.id.cardEditarMateria:
                i = new Intent(this, EditarMateria.class);
                startActivity(i);
                break;
            case R.id.cardEliminarMateria:
                i = new Intent(this, EliminarMateria.class);
                startActivity(i);
                break;
        }

    }
}