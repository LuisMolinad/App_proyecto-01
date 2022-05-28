package com.edu.ues.fia.eisi.app_proyecto01;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MenuMiembroUniversitario extends AppCompatActivity implements View.OnClickListener {

    //Variables de CardView
    public CardView insertar, consultar, editar, eliminar;
    String tipoUsuario;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_miembro_universitario);

        //Insertar
        insertar = (CardView) findViewById(R.id.cardInsertarMiembroUniversitario);
        editar = (CardView) findViewById(R.id.cardEditarMiembroUniversitario);
        eliminar = (CardView) findViewById(R.id.cardEliminarMiembroUniversitario);
        consultar = (CardView) findViewById(R.id.cardConsultarMiembroUniversitario);
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
                case "0600":
                case "0400":
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
            case R.id.cardInsertarMiembroUniversitario:
                i = new Intent(this, InsertarMiembroUniversitario.class);
                startActivity(i);
                break;
            case R.id.cardConsultarMiembroUniversitario:
                i = new Intent(this, ConsultarMiembroUniversitario.class);
                startActivity(i);
                break;
            case R.id.cardEditarMiembroUniversitario:
                i = new Intent(this, EditarMiembroUniversitario.class);
                startActivity(i);
                break;
            case R.id.cardEliminarMiembroUniversitario:
                i = new Intent(this, EliminarMiembroUniversitario.class);
                startActivity(i);
                break;
        }

    }

}