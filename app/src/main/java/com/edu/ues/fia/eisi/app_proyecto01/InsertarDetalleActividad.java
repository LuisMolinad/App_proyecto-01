package com.edu.ues.fia.eisi.app_proyecto01;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class InsertarDetalleActividad extends AppCompatActivity {
    ControlBDActividades helper;
    EditText idDetalle, grupo, idActividad, idLocal, descripcionActividad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insertar_detalle_actividad);
        //Iniciar la base de datos
        helper = new ControlBDActividades(this);

        //Capturar los ide de cada EditText
        idDetalle = findViewById(R.id.idDetalleInsertar);
        grupo = findViewById(R.id.GrupoInsertar);
        idActividad = findViewById(R.id.idActividadInsertar);
        idLocal = findViewById(R.id.idLocalInsertar);
        descripcionActividad = findViewById(R.id.descripcionActividadInsertar);
    }

    public void insertarDetalleActividad(View v){
//idDetalle.getText().toString().isEmpty() || grupo.getText().toString().isEmpty() || idActividad.getText().toString().isEmpty() || idLocal.getText().toString().isEmpty() || descripcionActividad.getText().toString().isEmpty()
        if(idDetalle.getText().toString().isEmpty() || grupo.getText().toString().isEmpty() || idActividad.getText().toString().isEmpty() || idLocal.getText().toString().isEmpty() || descripcionActividad.getText().toString().isEmpty()){
            Toast.makeText(this, "Error, no debe dejar campos vacios", Toast.LENGTH_SHORT).show();
        }
        else{
            String regInsertados;

            DetalleActividad detalleactividad = new DetalleActividad();

            detalleactividad.setID_DETALLE( Integer.parseInt(idDetalle.getText().toString()));
            detalleactividad.setGRUPO(Integer.parseInt(grupo.getText().toString()));
            detalleactividad.setIDACTIVIDAD(idActividad.getText().toString());
            detalleactividad.setIDLOCAL(idLocal.getText().toString());
            detalleactividad.setDESCRIPCIONACTIVIDAD(descripcionActividad.getText().toString());

            helper.abrir();
            regInsertados = helper.insertarDetalleActividad(detalleactividad);
            helper.cerrar();
            Toast.makeText(this, regInsertados, Toast.LENGTH_SHORT).show();
        }


    }
    public void CancelarInsertarDetalleActividad (View v){
        idDetalle.setText("");
        grupo.setText("");
        idActividad.setText("");
        idLocal.setText("");
        descripcionActividad.setText("");
    }

}