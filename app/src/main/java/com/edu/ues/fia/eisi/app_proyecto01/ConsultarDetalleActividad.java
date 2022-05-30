package com.edu.ues.fia.eisi.app_proyecto01;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ConsultarDetalleActividad extends AppCompatActivity {
    ControlBDActividades helper;
    EditText idDetalle;
    TextView grupo,idActividad,idLocal,descripcionActividad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consultar_detalle_actividad);
        //Iniciamos la base de datos
        helper = new ControlBDActividades(this);

        //Cargamos los ids
        idDetalle = findViewById(R.id.idDetalleConsultar);
        grupo = findViewById(R.id.GrupoConsultar);
        idActividad = findViewById(R.id.idActividadConsultar);
        idLocal = findViewById(R.id.idLocalConsultar);
        descripcionActividad = findViewById(R.id.descripcionActividadConsultar);
    }

    public void consultarDetalleActividad(View v){
        String id_detalle = idDetalle.getText().toString();

        if(id_detalle == null){
            Toast.makeText(this, "Error, ingrese un id del detalle de actividad", Toast.LENGTH_SHORT).show();
        }
        else {
            helper.abrir();
            DetalleActividad detalle = helper.consultarDetalleActividad(id_detalle);
            helper.cerrar();

            if(detalle == null){
                Toast.makeText(this, "Error no se ha encontrado el detalle de actividad con el id "+id_detalle+", favor intente de nuevo", Toast.LENGTH_SHORT).show();
            }
            else{
             //   idDetalle.setText("Código de la actividad: "+ Integer.toString(detalle.getID_DETALLE()));
                grupo.setText("Grupo: "+ detalle.getGRUPO().toString());
                idActividad.setText("Actividad: "+detalle.getIDACTIVIDAD().toString());
                idLocal.setText("Local: "+detalle.getIDLOCAL().toString());
                descripcionActividad.setText("Descripción de actividad: "+detalle.getDESCRIPCIONACTIVIDAD().toString());
            }
        }
    }
    public void CancelarConsultarDetalleActividad (View v){
        idDetalle.setText("");

    }
}