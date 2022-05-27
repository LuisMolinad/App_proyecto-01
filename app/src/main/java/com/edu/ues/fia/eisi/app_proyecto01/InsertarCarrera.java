package com.edu.ues.fia.eisi.app_proyecto01;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class InsertarCarrera extends AppCompatActivity {
    ControlBDActividades helper;
    EditText idCarrera, NombreCarrera;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insertar_carrera);
        //inicaimos la bd
        helper = new ControlBDActividades(this);


        idCarrera = findViewById(R.id.idCarreraInsertar);
        NombreCarrera = findViewById(R.id.nombreCarreraInsertar);

    }

    public void insertarCarrera (View v){
        String idcarrera = idCarrera.getText().toString();
        String nombreCarreara   = NombreCarrera.getText().toString();

        //Validar que no esten vacios
        if (idcarrera.isEmpty())
        {
            Toast.makeText(this,"Error campo id carrera vacio",Toast.LENGTH_SHORT).show();
        }
        else if (nombreCarreara.isEmpty()){
            Toast.makeText(this,"Error campo nombre carrera vacio",Toast.LENGTH_SHORT).show();
        }
        else {
            String regInsertados;

            Carrera carrera = new Carrera();
            carrera.setIDCARRERA(idcarrera);
            carrera.setNOMBRECARRERA(nombreCarreara);

            helper.abrir();
            regInsertados=helper.insertar(carrera);
            helper.cerrar();
            Toast.makeText(this,regInsertados,Toast.LENGTH_SHORT).show();
        }


    }


    public void CancelarInsertado(View v){
        idCarrera.setText("");
        NombreCarrera.setText("");
    }
}