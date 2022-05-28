package com.edu.ues.fia.eisi.app_proyecto01;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class EliminarListaEquipo extends AppCompatActivity {
    ControlBDActividades helper;
    EditText idListaEquipo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eliminar_lista_equipo);
        //Iniciamos la bd
        helper = new ControlBDActividades(this);

        idListaEquipo = findViewById(R.id.idListaEquipoEliminar);
    }


    public void eliminarListaEquipo(View v){
        String regEliminados;

        ListaEquipo listaequipo = new ListaEquipo();
        listaequipo.setIDLISTAEQUIPO(Integer.parseInt(idListaEquipo.getText().toString()));

        helper.abrir();
        regEliminados = helper.eliminarListaEquipo(listaequipo);
        helper.cerrar();

        Toast.makeText(this, regEliminados, Toast.LENGTH_SHORT).show();
    }
}