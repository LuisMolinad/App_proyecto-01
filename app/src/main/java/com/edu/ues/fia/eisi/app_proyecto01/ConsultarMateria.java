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

public class ConsultarMateria extends AppCompatActivity {
    ControlBDActividades helper;
    Spinner idAsignatura;
    EditText unidadVal, nombreAsignatura, idEscuela;

    ArrayList<String> idAsiG=new ArrayList<String>();
    ArrayAdapter<String> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consultar_materia);
        helper = new ControlBDActividades(this);

        idAsignatura=findViewById(R.id.spinneridAsignaturaConsultar);
        idEscuela = findViewById(R.id.idEscuelaConsultar);
        unidadVal = findViewById(R.id.unidadesValorativasConsulta);
        nombreAsignatura = findViewById(R.id.nombreAsignaturaConsulta);
        llenarSpinneridAsignatura();
    }

    public  void ConsultarMateria(View v){
        String textSpinner = idAsignatura.getSelectedItem().toString();
        helper.abrir();

        Materia materia = helper.consultarMateria(textSpinner);
        helper.cerrar();
        if(materia == null){
            Toast.makeText(this,"Escuela no registrada",Toast.LENGTH_SHORT).show();
        }
        else{
            idEscuela.setText(String.valueOf(materia.getIDESCUELA()));
            unidadVal.setText(String.valueOf(materia.getUNIDADESVALORATIVAS()));
            nombreAsignatura.setText(String.valueOf(materia.getNOMBREMATERIA()));
        }
    }

    public void Cencelar(View v){
        idEscuela.setText("");
        unidadVal.setText("");
        nombreAsignatura.setText("");
    }





    public void llenarSpinneridAsignatura(){
        //declaramos un nuevo adaptador que sera llenado por la nd
        adapter=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,idAsiG);
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
            idAsiG.add(name);
        }
        //CLOSE
        db.cerrar();
        //SET IT TO SPINNER
        idAsignatura.setAdapter(adapter);
    }
}