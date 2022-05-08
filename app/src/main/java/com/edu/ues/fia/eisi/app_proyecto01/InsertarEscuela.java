package com.edu.ues.fia.eisi.app_proyecto01;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.ArrayList;

public class InsertarEscuela extends AppCompatActivity {
    ControlBDActividades helper;
    EditText idEscuela, NombreEscuela;
    Spinner spinneridCarrera;
    ArrayList<String> fkIdCarrera=new ArrayList<String>();
    ArrayAdapter<String> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insertar_escuela);
        //inicaimos la bd
        helper = new ControlBDActividades(this);
        idEscuela = findViewById(R.id.idEscuelaInsertar);
        spinneridCarrera = findViewById(R.id.spinneridCarreraInsertar);
        NombreEscuela = findViewById(R.id.nombreEscuelaInsertar);


        llenarSpinnerFKIdCarrera();

    }

    public void llenarSpinnerFKIdCarrera(){
        //declaramos un nuevo adaptador que sera llenado por la nd
        adapter=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,fkIdCarrera);
        //
        final ControlBDActividades db=new ControlBDActividades(this);
        //abrimos la bd
        db.abrir();
        //Cargar lso datos a spinner
        Cursor c=db.getAllValuesIdCARRERA();
        while(c.moveToNext())
        {
            String name=c.getString(0);
            //captura los id que luego llenan el adaptador
            fkIdCarrera.add(name);
        }
        //CLOSE
        db.cerrar();
        //SET IT TO SPINNER
        spinneridCarrera.setAdapter(adapter);
    }

}