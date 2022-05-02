package com.edu.ues.fia.eisi.app_proyecto01;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MenuAsistencia extends AppCompatActivity implements View.OnClickListener {

    //Variables de CardView
    public CardView insertar, consultar, editar, eliminar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_asistencia);

        //Insertar
        insertar = (CardView) findViewById(R.id.cardInsertarAsistencia);
        insertar.setOnClickListener(this);

        //Consultar
        consultar = (CardView) findViewById(R.id.cardConsultarAsistencia);
        consultar.setOnClickListener(this);

        //Editar
        editar = (CardView) findViewById(R.id.cardEditarAsistencia);
        editar.setOnClickListener(this);

        //Eliminar
        eliminar = (CardView) findViewById(R.id.cardEliminarAsistencia);
        eliminar.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        Intent i;

        switch (view.getId()){
            case R.id.cardInsertarAsistencia:
                i = new Intent(this, InsertarAsistencia.class);
                startActivity(i);
                break;
            case R.id.cardConsultarAsistencia:
                i = new Intent(this, ConsultarAsistencia.class);
                startActivity(i);
                break;
            case R.id.cardEditarAsistencia:
                i = new Intent(this, EditarAsistencia.class);
                startActivity(i);
                break;
            case R.id.cardEliminarAsistencia:
                i = new Intent(this, EliminarAsistencia.class);
                startActivity(i);
                break;
        }

    }
}