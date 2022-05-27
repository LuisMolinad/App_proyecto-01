package com.edu.ues.fia.eisi.app_proyecto01;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MenuActividadd extends AppCompatActivity implements View.OnClickListener {

    //Variables de CardView
    public CardView insertar, consultar, editar, eliminar;
    String tipoUsuario;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_actividadd);

        //Insertar
        insertar = findViewById(R.id.cardInsertarActividad);
        consultar = findViewById(R.id.cardConsultarActividad);
        editar = findViewById(R.id.cardEditarActividad);
        eliminar = findViewById(R.id.cardEliminarActividad);
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
                    break;
                case "0200":
                case "0300":
                case "0500":
                case "0600":
                    insertar.setVisibility(View.GONE);
                    consultar.setOnClickListener(this);
                    editar.setVisibility(View.GONE);
                    eliminar.setVisibility(View.GONE);
                    break;
                case "0400":
                    insertar.setVisibility(View.GONE);
                    consultar.setOnClickListener(this);
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
            case R.id.cardInsertarActividad:
                i = new Intent(this, InsertarActividad.class);
                startActivity(i);
                break;
            case R.id.cardConsultarActividad:
                i = new Intent(this, ConsultarActividad.class);
                startActivity(i);
                break;
            case R.id.cardEditarActividad:
                i = new Intent(this, EditarActividad.class);
                startActivity(i);
                break;
            case R.id.cardEliminarActividad:
                i = new Intent(this, EliminarActividad.class);
                startActivity(i);
                break;
        }
    }
}