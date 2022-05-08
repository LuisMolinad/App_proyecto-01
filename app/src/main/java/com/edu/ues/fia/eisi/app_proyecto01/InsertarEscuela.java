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
    public void InsertarESCUELA(View v){
        String IDESCUELA = idEscuela.getText().toString();
        String NOMBREESCUELA   = NombreEscuela.getText().toString();
        String fkidCarrera = spinneridCarrera.getSelectedItem().toString();
        //Validar que no esten vacios
        if (IDESCUELA.isEmpty())
        {
            Toast.makeText(this,"Error campo id carrera vacio",Toast.LENGTH_SHORT).show();
        }
        else if (NOMBREESCUELA.isEmpty()){
            Toast.makeText(this,"Error campo nombre carrera vacio",Toast.LENGTH_SHORT).show();
        }
        else {
            String regInsertados;

            Escuela escuela = new Escuela();
            escuela.setIDESCUELA(IDESCUELA);
            escuela.setNOMBRE_ESCUELA(NOMBREESCUELA);
            escuela.setIDCARRERA(fkidCarrera);
            helper.abrir();
            regInsertados=helper.insertarEscuela(escuela);
            helper.cerrar();
            Toast.makeText(this,regInsertados,Toast.LENGTH_SHORT).show();
        }
    }

    public void CancelarInsertarEscuela (View v){
        idEscuela.setText("");
        NombreEscuela.setText("");

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