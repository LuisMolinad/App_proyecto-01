package com.edu.ues.fia.eisi.app_proyecto01;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MenuLocal extends AppCompatActivity implements View.OnClickListener{

    //Variables de CardView
    public CardView insertar, consultar, editar, eliminar;
    String tipoUsuario;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_local);

        //Insertar
        insertar = (CardView) findViewById(R.id.cardInsertarLocal);
        consultar = (CardView) findViewById(R.id.cardConsultarLocal);
        editar = (CardView) findViewById(R.id.cardEditarLocal);
        eliminar = (CardView) findViewById(R.id.cardEliminarLocal);

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
                    consultar.setOnClickListener(this);
                    insertar.setVisibility(View.GONE);
                    editar.setVisibility(View.GONE);
                    eliminar.setVisibility(View.GONE);
                    break;
                case "0400":
                    break;
                case "0500":
                    break;
                case "0600":
                    break;

            }
        }

    }

    @Override
    public void onClick(View view) {

        Intent i;

        switch (view.getId()){
            case R.id.cardInsertarLocal:
                i = new Intent(this, InsertarLocal.class);
                startActivity(i);
                break;
            case R.id.cardConsultarLocal:
                i = new Intent(this, ConsultarLocal.class);
                startActivity(i);
                break;
            case R.id.cardEditarLocal:
                i = new Intent(this, EditarLocal.class);
                startActivity(i);
                break;
            case R.id.cardEliminarLocal:
                i = new Intent(this, EliminarLocal.class);
                startActivity(i);
                break;
        }

    }
}