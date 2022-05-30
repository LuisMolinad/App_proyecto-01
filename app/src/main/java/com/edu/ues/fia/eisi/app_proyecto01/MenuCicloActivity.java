package com.edu.ues.fia.eisi.app_proyecto01;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MenuCicloActivity extends AppCompatActivity implements View.OnClickListener {

    //Variables de CardView
    public CardView insertar, consultar, editar, eliminar;
    public CardView insertarOnline, consultarOnline, editarOnline, eliminarOnline;

    String tipoUsuario;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_ciclo);

        //Insertar
        insertar = (CardView) findViewById(R.id.cardInsertarCiclo);
        editar = (CardView) findViewById(R.id.cardEditarCiclo);
        consultar = (CardView) findViewById(R.id.cardConsultarCiclo);
        eliminar = (CardView) findViewById(R.id.cardEliminarCiclo);
        insertarOnline = (CardView) findViewById(R.id.cardInsertarCicloOnline);
        editarOnline = (CardView) findViewById(R.id.cardEditarCicloOnline);
        consultarOnline = (CardView) findViewById(R.id.cardConsultarCicloOnline);
        eliminarOnline = (CardView) findViewById(R.id.cardEliminarCicloOnline);
        Intent intent = getIntent();
        tipoUsuario = intent.getExtras().getString("OpcionCrud");
        if (tipoUsuario != null) {
            //   String opcioncRUD=tipoUsuario;
            switch (tipoUsuario) {
                case "0100":
                    /*Le pones el capturador de eventos*/
                    consultar.setOnClickListener(this);
                    insertar.setOnClickListener(this);
                    editar.setOnClickListener(this);
                    eliminar.setOnClickListener(this);
                    consultarOnline.setOnClickListener(this);
                    insertarOnline.setOnClickListener(this);
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
            case R.id.cardInsertarCiclo:
                i = new Intent(this, InsertarCiclo.class);
                startActivity(i);
                break;
            case R.id.cardConsultarCiclo:
                i = new Intent(this, ConsultarCiclo.class);
                startActivity(i);
                break;
            case R.id.cardEditarCiclo:
                i = new Intent(this, EditarCiclo.class);
                startActivity(i);
                break;
            case R.id.cardEliminarCiclo:
                i = new Intent(this, EliminarCiclo.class);
                startActivity(i);
                break;
            case R.id.cardInsertarCicloOnline:
                i= new Intent(this,InsertarCicloExterno.class);
                startActivity(i);
                break;
        }

    }
}