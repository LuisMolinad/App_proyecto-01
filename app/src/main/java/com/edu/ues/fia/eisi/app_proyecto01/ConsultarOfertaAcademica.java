package com.edu.ues.fia.eisi.app_proyecto01;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ConsultarOfertaAcademica extends AppCompatActivity {
    ControlBDActividades helper;
    EditText idMateriaActiva;
    TextView idCiclo, idAsignatura,nombreMateriaActiva;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consultar_oferta_academica);
        helper = new ControlBDActividades(this);
        idMateriaActiva=findViewById(R.id.edtIdMateriaActivaConsultarOferta);
        idCiclo=findViewById(R.id.txtIdCicloConsultarOfertaAcademica);
        idAsignatura=findViewById(R.id.txtIdCicloConsultarOfertaAcademica);
        nombreMateriaActiva=findViewById(R.id.txtNombreMateriaActivaOfertaAcademica);
    }
    public void consultarOfertaAcademica(View v){
        helper.abrir();
        OfertaAcademica ofertaAcademica = helper.consultarOfertaAcademica(idMateriaActiva.getText().toString());
        helper.cerrar();
        if(ofertaAcademica==null){
            Toast.makeText(this, "La oferta académica con el id "+idMateriaActiva.getText().toString()+" no ha sido encontrada.",Toast.LENGTH_LONG).show();
        }
        else{
            idCiclo.setText(idCiclo.getText().toString()+": "+ofertaAcademica.getIdCiclo());
            idAsignatura.setText(idAsignatura.getText().toString()+": "+ofertaAcademica.getIdAsignatura());
            nombreMateriaActiva.setText(nombreMateriaActiva.getText().toString()+": "+ofertaAcademica.getNombreMateriaActiva());
        }
    }
}