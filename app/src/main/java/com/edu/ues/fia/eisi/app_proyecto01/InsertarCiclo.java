package com.edu.ues.fia.eisi.app_proyecto01;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class InsertarCiclo extends AppCompatActivity {
    Spinner comboNumeroCiclo;
    ControlBDActividades helper;
    EditText  idCiclo,fechaInicio,fechaFin,anio;
    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insertar_ciclo);
        comboNumeroCiclo=(Spinner) findViewById(R.id.spinnerNumeroCiclo);
        ArrayAdapter<CharSequence> adapter=ArrayAdapter.createFromResource(this,R.array.opcionesNumeroCiclo, android.R.layout.simple_spinner_item);
        comboNumeroCiclo.setAdapter(adapter);
        helper =new ControlBDActividades(this);
        idCiclo=findViewById(R.id.idCiclo);
        fechaInicio=findViewById(R.id.edtFechaInicio);
        fechaFin=findViewById(R.id.edtFechaFin);
        anio=findViewById(R.id.edtAnio);
    }
    public void insertarCiclo(View v){
        String id_ciclo=idCiclo.getText().toString();
        String numero_ciclo=comboNumeroCiclo.getSelectedItem().toString();
        String fecha_inicio=fechaInicio.getText().toString();
        String fecha_fin=fechaFin.getText().toString();
        String anio_ciclo=anio.getText().toString();

        if(id_ciclo.isEmpty()||numero_ciclo.isEmpty()||numero_ciclo.equals("Seleccione")||fecha_inicio.isEmpty()||fecha_fin.isEmpty()||anio_ciclo.isEmpty()){
            Toast.makeText(this,"Error no debe dejar campos vacios",Toast.LENGTH_SHORT).show();
        }
        else{
            String regInsertados;
            Ciclo ciclo=new Ciclo();
            ciclo.setIdCiclo(id_ciclo);
            ciclo.setNumeroCiclo(Integer.parseInt(numero_ciclo));
            ciclo.setFechaInicio(fecha_inicio);
            ciclo.setFechaFin(fecha_fin);
            ciclo.setAnio(anio_ciclo);

            helper.abrir();
            regInsertados=helper.insertarCiclo(ciclo);
            helper.cerrar();
            Toast.makeText(this,regInsertados,Toast.LENGTH_SHORT).show();
        }
    }
}