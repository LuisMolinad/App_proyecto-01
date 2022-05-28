package com.edu.ues.fia.eisi.app_proyecto01;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class EliminarDetalleActividad extends AppCompatActivity {
    ControlBDActividades helper;
    EditText idDetalle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eliminar_detalle_actividad);

        //Iniciamos la bd
        helper = new ControlBDActividades(this);

        idDetalle = findViewById(R.id.idDetalleEliminar);
    }

    public void eliminarDetalleActividad(View v){
        String regEliminados;

        DetalleActividad detalleactividad = new DetalleActividad();
        detalleactividad.setID_DETALLE(Integer.parseInt(idDetalle.getText().toString()));

        helper.abrir();
        regEliminados = helper.eliminarDetalleActividad(detalleactividad);
        helper.cerrar();

        Toast.makeText(this, regEliminados, Toast.LENGTH_SHORT).show();
    }
}