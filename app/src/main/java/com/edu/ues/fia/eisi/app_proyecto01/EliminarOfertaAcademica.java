package com.edu.ues.fia.eisi.app_proyecto01;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class EliminarOfertaAcademica extends AppCompatActivity {
    ControlBDActividades helper;
    EditText idMateriaActiva;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eliminar_oferta_academica);
        helper=new ControlBDActividades(this);
        idMateriaActiva=findViewById(R.id.idMateriaActivaEliminarOfertaAcademica);
    }
    public void eliminarOfertaAcademica(View v){
        String regEliminadas;
        OfertaAcademica ofertaAcademica = new OfertaAcademica();
        ofertaAcademica.setIdMateriaActiva(idMateriaActiva.getText().toString());
        helper.abrir();
        regEliminadas = helper.eliminarOfertaAcademica(ofertaAcademica);
        helper.cerrar();
        Toast.makeText(this,regEliminadas,Toast.LENGTH_SHORT).show();
    }
}