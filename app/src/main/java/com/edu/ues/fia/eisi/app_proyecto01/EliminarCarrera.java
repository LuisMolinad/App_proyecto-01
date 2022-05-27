package com.edu.ues.fia.eisi.app_proyecto01;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class EliminarCarrera extends AppCompatActivity {
    //ControlBDActividades helper;
    Spinner spinnerCarreraId;
    EditText nombrecarrera;
    ControlBDActividades controlhelper;

    //declaramos el array que va a ser llenar
    ArrayList<String> names=new ArrayList<String>();
    ArrayAdapter<String> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eliminar_carrera);
        controlhelper = new ControlBDActividades(this);
        spinnerCarreraId= findViewById(R.id.spinneridCarreraEliminar);
        llenarSpinnerId();



    }
    public void eliminarCarrera(View v){
        String regEliminadas;
        String textSpinner = spinnerCarreraId.getSelectedItem().toString();
        Carrera carrera=new Carrera();
        carrera.setIDCARRERA(textSpinner);
        controlhelper.abrir();
        regEliminadas=controlhelper.eliminar(carrera);
        controlhelper.cerrar();
        Toast.makeText(this, regEliminadas, Toast.LENGTH_SHORT).show();
    }


    public void llenarSpinnerId(){
        //declaramos un nuevo adaptador que sera llenado por la nd
        adapter=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,names);
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
            names.add(name);
        }
        //CLOSE
        db.cerrar();
        //SET IT TO SPINNER
        spinnerCarreraId.setAdapter(adapter);
    }




    public void CancelarEdicion(View v){
        nombrecarrera.setText("");
    }
}