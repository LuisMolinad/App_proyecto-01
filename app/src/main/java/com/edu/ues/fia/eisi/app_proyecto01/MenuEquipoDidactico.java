package com.edu.ues.fia.eisi.app_proyecto01;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MenuEquipoDidactico extends AppCompatActivity implements View.OnClickListener{

    //Variables de CardView
    public CardView insertar, consultar, editar, eliminar;
    String tipoUsuario;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_equipo_didactico);

        //Insertar
        insertar = (CardView) findViewById(R.id.cardInsertarEquipo);
        consultar = (CardView) findViewById(R.id.cardConsultarEquipo);
        editar = (CardView) findViewById(R.id.cardEditarEquipo);
        eliminar = (CardView) findViewById(R.id.cardEliminarEquipo);
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
            case R.id.cardInsertarEquipo:
                i = new Intent(this, InsertarEquipoDidactico.class);
                startActivity(i);
                break;
            case R.id.cardConsultarEquipo:
                i = new Intent(this, ConsultarEquipoDidactico.class);
                startActivity(i);
                break;
            case R.id.cardEditarEquipo:
                i = new Intent(this, EditarEquipoDidactico.class);
                startActivity(i);
                break;
            case R.id.cardEliminarEquipo:
                i = new Intent(this, EliminarEquipoDidactico.class);
                startActivity(i);
                break;
        }

    }
}