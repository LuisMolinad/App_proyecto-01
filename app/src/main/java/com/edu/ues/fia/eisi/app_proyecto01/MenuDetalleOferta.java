package com.edu.ues.fia.eisi.app_proyecto01;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MenuDetalleOferta extends AppCompatActivity implements View.OnClickListener {

    //Variables de CardView
    public CardView insertar, consultar, editar, eliminar;
    String tipoUsuario;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_detalle_oferta);

        //Insertar
        insertar = (CardView) findViewById(R.id.cardInsertarDetalleOferta);
        consultar = (CardView) findViewById(R.id.cardConsultarDetalleOferta);
        editar = (CardView) findViewById(R.id.cardEditarDetalleOferta);
        eliminar = (CardView) findViewById(R.id.cardEliminarDetalleOferta);

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
            case R.id.cardInsertarDetalleOferta:
                i = new Intent(this, InsertarDetalleOferta.class);
                startActivity(i);
                break;
            case R.id.cardConsultarDetalleOferta:
                i = new Intent(this, ConsultarDetalleOferta.class);
                startActivity(i);
                break;
            case R.id.cardEditarDetalleOferta:a:
                i = new Intent(this, EditarDetalleOferta.class);
                startActivity(i);
                break;
            case R.id.cardEliminarDetalleOferta:
                i = new Intent(this, EliminarDetalleOferta.class);
                startActivity(i);
                break;
        }

    }
}