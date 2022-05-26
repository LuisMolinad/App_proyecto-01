package com.edu.ues.fia.eisi.app_proyecto01;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MenuCarrera extends AppCompatActivity implements View.OnClickListener{

    //Variables de CardView
    public CardView insertar, consultar, editar, eliminar;
    String tipoUsuario;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_carrera);

        //Insertar
        insertar = (CardView) findViewById(R.id.cardInsertarCarrera);
        consultar = (CardView) findViewById(R.id.cardConsultarCarrera);
        editar = (CardView) findViewById(R.id.cardEditarCarrera);
        eliminar = (CardView) findViewById(R.id.cardEliminarCarrera);

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
        }

    }
}