package com.edu.ues.fia.eisi.app_proyecto01;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MenuDetalleActividad extends AppCompatActivity implements View.OnClickListener{

    //Variables de CardView
    public CardView insertar, consultar, editar, eliminar;
    String tipoUsuario;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_detalle_actividad);

        //Insertar
        insertar = (CardView) findViewById(R.id.cardInsertarDetalleActividad);
        editar = (CardView) findViewById(R.id.cardEditarDetalleActividad);
        consultar = (CardView) findViewById(R.id.cardConsultarDetalleActividad);
        eliminar = (CardView) findViewById(R.id.cardEliminarDetalleActividad);

        Intent intent = getIntent();
        tipoUsuario = intent.getExtras().getString("OpcionCrud");
        if (tipoUsuario != null) {
            //   String opcioncRUD=tipoUsuario;
            switch (tipoUsuario) {
                case "0100":
                    /*Le pones el capturador de eventos*/
                    insertar.setOnClickListener(this);
                    //Consultar
                    consultar.setOnClickListener(this);
                    //Editar
                    editar.setOnClickListener(this);
                    //Eliminar
                    eliminar.setOnClickListener(this);
                    break;
                case "0200":
                case "0300":
                case "0500":
                    insertar.setVisibility(View.GONE);
                    consultar.setOnClickListener(this);
                    editar.setVisibility(View.GONE);
                    eliminar.setVisibility(View.GONE);
                    break;
                case "0400":
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
            case R.id.cardInsertarDetalleActividad:
                i = new Intent(this, InsertarDetalleActividad.class);
                i.putExtra("OpcionCrud",tipoUsuario);
                startActivity(i);
                break;
            case R.id.cardConsultarDetalleActividad:
                i = new Intent(this, ConsultarDetalleActividad.class);
                i.putExtra("OpcionCrud",tipoUsuario);
                startActivity(i);
                break;
            case R.id.cardEditarDetalleActividad:
                i = new Intent(this, EditarDetalleActividad.class);
                i.putExtra("OpcionCrud",tipoUsuario);
                startActivity(i);
                break;
            case R.id.cardEliminarDetalleActividad:
                i = new Intent(this, EliminarDetalleActividad.class);
                i.putExtra("OpcionCrud",tipoUsuario);
                startActivity(i);
                break;
        }

    }
}