package com.edu.ues.fia.eisi.app_proyecto01;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ConsultarCiclo extends AppCompatActivity {
    ControlBDActividades helper;
    EditText idCiclo;
    TextView numeroCiclo,inicioCiclo,finCiclo,anio;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consultar_ciclo);
        helper = new ControlBDActividades(this);
        idCiclo=findViewById(R.id.edtIdCicloConsultar);
        numeroCiclo = findViewById(R.id.txtNumeroCicloConsultar);
        inicioCiclo = findViewById(R.id.txtInicioCicloConsultar);
        finCiclo = findViewById(R.id.txtFinCicloConsultar);
        anio=findViewById(R.id.txtAnioCicloConsultar);
    }
    public void consultarCiclo(View v){
        helper.abrir();
        Ciclo ciclo = helper.consultarCiclo(idCiclo.getText().toString());
        helper.cerrar();
        if(ciclo==null){
            Toast.makeText(this, "El ciclo con el id "+idCiclo.getText().toString()+" no ha sido encontrado.",Toast.LENGTH_LONG).show();
        }
        else{
            numeroCiclo.setText(numeroCiclo.getText().toString()+": "+String.valueOf(ciclo.getNumeroCiclo()));
            inicioCiclo.setText(inicioCiclo.getText().toString()+": "+ciclo.getFechaInicio());
            finCiclo.setText(finCiclo.getText().toString()+": "+ciclo.getFechaFin());
            anio.setText(anio.getText().toString()+": "+ciclo.getAnio());

        }
    }
}