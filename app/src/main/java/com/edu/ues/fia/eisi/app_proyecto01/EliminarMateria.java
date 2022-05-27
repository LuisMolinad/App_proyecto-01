package com.edu.ues.fia.eisi.app_proyecto01;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class EliminarMateria extends AppCompatActivity {
    ControlBDActividades helper ;
    Spinner spinneridAsignatuura;
    ArrayList<String> idAsignatura=new ArrayList<String>();
    ArrayAdapter<String> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eliminar_materia);
        helper = new ControlBDActividades(this);

        spinneridAsignatuura = findViewById(R.id.spinneridAsignaturaEliminar);
        llenarSpinnerIdAsignatura();

    }
    public void eliminarMateria(View v){
        String regEliminadas;
        String textSpinner = spinneridAsignatuura.getSelectedItem().toString();
        Materia materia=new Materia();
        materia.setIDASIGNATURA(textSpinner);
        helper.abrir();
        regEliminadas=helper.eliminarMateria(materia);
        helper.cerrar();
        Toast.makeText(this, regEliminadas, Toast.LENGTH_SHORT).show();
    }
    public void llenarSpinnerIdAsignatura(){
        //declaramos un nuevo adaptador que sera llenado por la nd
        adapter=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,idAsignatura);
        //
        final ControlBDActividades db=new ControlBDActividades(this);
        //abrimos la bd
        db.abrir();
        //Cargar lso datos a spinner
        Cursor c=db.getAllValuesIdAsignatura();
        while(c.moveToNext())
        {
            String name=c.getString(0);
            //captura los id que luego llenan el adaptador
            idAsignatura.add(name);
        }
        //CLOSE
        db.cerrar();
        //SET IT TO SPINNER
        spinneridAsignatuura.setAdapter(adapter);
    }

}