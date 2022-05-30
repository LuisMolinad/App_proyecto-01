package com.edu.ues.fia.eisi.app_proyecto01;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MenuEquipoDidactico extends AppCompatActivity implements View.OnClickListener{

    //Variables de CardView
    public CardView insertar, consultar, editar, eliminar;
    public CardView insertarOnline, consultarOnline, editarOnline, eliminarOnline;
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

        insertarOnline = (CardView) findViewById(R.id.cardInsertarEquipoOnline);
        consultarOnline = (CardView) findViewById(R.id.cardConsultarEquipoOnline);
        editarOnline = (CardView) findViewById(R.id.cardEditarEquipoOnline);
        eliminarOnline = (CardView) findViewById(R.id.cardEliminarEquipoOnline);
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
                    insertarOnline.setOnClickListener(this);
                    consultarOnline.setOnClickListener(this);
                    editarOnline.setOnClickListener(this);
                    eliminarOnline.setOnClickListener(this);
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
            case R.id.cardInsertarEquipoOnline:
                i = new Intent(this, InsertarEquipoDidacticoExterno.class);
                startActivity(i);
                break;
            case R.id.cardEliminarEquipoOnline:
                i = new Intent(this, EliminarEquipoDidacticoExterno.class);
                startActivity(i);
                break;
            case R.id.cardConsultarEquipoOnline:
                i = new Intent(this, ConsultarEquipoDidacticoExterno.class);
                startActivity(i);
                break;
            case R.id.cardEditarEquipoOnline:
                i = new Intent(this, EditarEquipoDidacticoExterno.class);
                startActivity(i);
                break;
        }

    }
}