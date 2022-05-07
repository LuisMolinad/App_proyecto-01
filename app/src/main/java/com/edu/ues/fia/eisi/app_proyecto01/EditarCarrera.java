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

public class EditarCarrera extends AppCompatActivity {
    ControlBDActividades helper;
    Spinner spinnerCarreraId;
    EditText nombrecarrera;
    //declaramos el array que va a ser llenar
    ArrayList<String> names=new ArrayList<String>();
    ArrayAdapter<String> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_carrera);
        helper = new ControlBDActividades(this);


        spinnerCarreraId= findViewById(R.id.spinneridCarrera);
        nombrecarrera = findViewById(R.id.nombreCarreraEditar);
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

    public void actualizarCarrera(View v) {
        Carrera carrera = new Carrera();

        String textSpinner = spinnerCarreraId.getSelectedItem().toString();

        carrera.setIDCARRERA(textSpinner);
        carrera.setNOMBRECARRERA(nombrecarrera.getText().toString());

        helper.abrir();
        String estado = helper.actualizarCarrera(carrera);
        helper.cerrar();
        Toast.makeText(this, estado, Toast.LENGTH_SHORT).show();
    }
    public void CancelarEdicion(View v){
        nombrecarrera.setText("");
    }

}