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

public class InsertarMateria extends AppCompatActivity {
    ControlBDActividades helper;
    Spinner idEscuelaFk;
    EditText unidadVal, nombreAsignatura, idAsignatura;

    ArrayList<String> fkIdEscuela=new ArrayList<String>();
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insertar_materia);
        helper = new ControlBDActividades(this);

        idAsignatura= findViewById(R.id.idAsignaturaInsertar);
        idEscuelaFk = findViewById(R.id.spinneridEscuelaInsertar);
        unidadVal = findViewById(R.id.unidadesValorativasInsertar);
        nombreAsignatura = findViewById(R.id.nombreAsignaturainsertar);
        llenarSpinnerFKIdEscuela();

    }

    public  void insertarMateria(View v){
        String idasignatura = idAsignatura.getText().toString();
        String textSpinner = idEscuelaFk.getSelectedItem().toString();

        //Validar que no esten vacios
        if (idasignatura.isEmpty())
        {
            Toast.makeText(this,"Error campo id carrera vacio",Toast.LENGTH_SHORT).show();
        }
        else {
            String regInsertados;
            Materia materia = new Materia();
            materia.setIDASIGNATURA(idasignatura);
            materia.setIDESCUELA(textSpinner);
            materia.setUNIDADESVALORATIVAS(Integer.valueOf(unidadVal.getText().toString()));
            materia.setNOMBREASIGNATURA(nombreAsignatura.getText().toString());
            helper.abrir();
            regInsertados=helper.insertarAsignatura(materia);
            helper.cerrar();
            Toast.makeText(this,regInsertados,Toast.LENGTH_SHORT).show();
        }

    }
    public void CancelarInsertarMateria(View v ){
        idAsignatura.setText("");
        unidadVal.setText("" );
        nombreAsignatura.setText("");

    }

    public void llenarSpinnerFKIdEscuela(){
        //declaramos un nuevo adaptador que sera llenado por la nd
        adapter=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,fkIdEscuela);
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
            fkIdEscuela.add(name);
        }
        //CLOSE
        db.cerrar();
        //SET IT TO SPINNER
        idEscuelaFk.setAdapter(adapter);
    }




}
