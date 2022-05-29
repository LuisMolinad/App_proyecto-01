package com.edu.ues.fia.eisi.app_proyecto01;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class EliminarDetalleOferta extends AppCompatActivity {
    ControlBDActividades helper;
    EditText idGrupo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eliminar_detalle_oferta);
        helper = new ControlBDActividades(this);
        idGrupo = findViewById(R.id.idGrupoEliminarDetalleOferta);
    }
    public void eliminarDetalleOferta(View v){
        String regEliminadas;
        DetalleOferta detalleOferta = new DetalleOferta();
        detalleOferta.setIdGrupo(idGrupo.getText().toString());
        helper.abrir();
        regEliminadas=helper.eliminarDetalleOferta(detalleOferta);
        helper.cerrar();
        Toast.makeText(this,regEliminadas,Toast.LENGTH_SHORT).show();
    }
}