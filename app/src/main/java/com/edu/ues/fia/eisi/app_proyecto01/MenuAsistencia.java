package com.edu.ues.fia.eisi.app_proyecto01;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MenuAsistencia extends AppCompatActivity implements View.OnClickListener {

    //Variables de CardView
    public CardView insertar, consultar, editar, eliminar;
    String tipoUsuario;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_asistencia);
        Intent intent = getIntent();
        tipoUsuario = intent.getExtras().getString("OpcionCrud");
        insertar = (CardView) findViewById(R.id.cardInsertarAsistencia);
        consultar = (CardView) findViewById(R.id.cardConsultarAsistencia);
        editar = (CardView) findViewById(R.id.cardEditarAsistencia);
        eliminar = (CardView) findViewById(R.id.cardEliminarAsistencia);

        if (tipoUsuario != null) {
            //   String opcioncRUD=tipoUsuario;
            switch (tipoUsuario) {
                case "0100":
                case "0400":
                case "0600":
                    insertar.setOnClickListener(this);
                    consultar.setOnClickListener(this);
                    editar.setOnClickListener(this);
                    eliminar.setOnClickListener(this);
                    break;
                case "0200":
                case "0300":
                case "0500":
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