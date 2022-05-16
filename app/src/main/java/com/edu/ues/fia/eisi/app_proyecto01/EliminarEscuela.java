package com.edu.ues.fia.eisi.app_proyecto01;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class EliminarEscuela extends AppCompatActivity {
    ControlBDActividades helper ;
    Spinner spinneridEscuela;
    ArrayList<String> idEscuela=new ArrayList<String>();
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eliminar_escuela);
        helper = new ControlBDActividades(this);
        spinneridEscuela = findViewById(R.id.spinneridEscuelaEliminar);
        llenarSpinneridEscuela();


    }

    public void eliminarEscuela(View v){
        String regEliminadas;
        String textSpinner = spinneridEscuela.getSelectedItem().toString();
        Escuela escuela=new Escuela();
        escuela.setIDESCUELA(textSpinner);
        helper.abrir();
        regEliminadas=helper.eliminarEscuela(escuela);
        helper.cerrar();
        Toast.makeText(this, regEliminadas, Toast.LENGTH_SHORT).show();
    }




    public void llenarSpinneridEscuela(){
        //declaramos un nuevo adaptador que sera llenado por la nd
        adapter=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,idEscuela);
        //
        final ControlBDActividades db=new ControlBDActividades(this);
        //abrimos la bd
        db.abrir();
        //Cargar lso datos a spinner
        Cursor c=db.getAllValuesIdEscuela();
        while(c.moveToNext())
        {
            String name=c.getString(0);
            //captura los id que luego llenan el adaptador
            idEscuela.add(name);
        }
        //CLOSE
        db.cerrar();
        //SET IT TO SPINNER
        spinneridEscuela.setAdapter(adapter);
    }

}