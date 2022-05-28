package com.edu.ues.fia.eisi.app_proyecto01;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


public class InsertarListaEquipo extends AppCompatActivity {
    ControlBDActividades helper;
    EditText idListaEquipo, idDetalle, idEquipo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insertar_lista_equipo);
        //Iniciar la base de datos
        helper = new ControlBDActividades(this);

        //Capturar los ide de cada EditText
        idListaEquipo = findViewById(R.id.idListaEquipoInsertar);
        idDetalle = findViewById(R.id.idDetalleInsertar);
        idEquipo = findViewById(R.id.idEquipoInsertar);
    }

    public void insertarListaEquipo(View v){

        if(idListaEquipo.getText().toString().isEmpty() || idDetalle.getText().toString().isEmpty() || idEquipo.getText().toString().isEmpty()){
            Toast.makeText(this, "Error, no debe dejar campos vacios", Toast.LENGTH_SHORT).show();
        }
        else{
            String regInsertados;

            ListaEquipo listaequipo = new ListaEquipo();

            listaequipo.setIDLISTAEQUIPO( Integer.parseInt(idListaEquipo.getText().toString()));
            listaequipo.setID_DETALLE(Integer.parseInt(idDetalle.getText().toString()));
            listaequipo.setIDEQUIPO(idEquipo.getText().toString());

            helper.abrir();
            regInsertados = helper.insertarListaEquipo(listaequipo);
            helper.cerrar();
            Toast.makeText(this, regInsertados, Toast.LENGTH_SHORT).show();
        }


    }
}