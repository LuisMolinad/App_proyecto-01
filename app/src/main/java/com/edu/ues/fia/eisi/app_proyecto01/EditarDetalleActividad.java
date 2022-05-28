package com.edu.ues.fia.eisi.app_proyecto01;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
public class EditarDetalleActividad extends AppCompatActivity {
    ControlBDActividades helper;
    EditText idDetalle;
    TextView grupo,idActividad,idLocal,descripcionActividad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_detalle_actividad);
        //Iniciamos la base de dato
        helper = new ControlBDActividades(this);

        //Cargamos los ids
        idDetalle = findViewById(R.id.idDetalleEditar);
       grupo = findViewById(R.id.GrupoEditar);
        idActividad = findViewById(R.id.idActividadEditar);
        idLocal = findViewById(R.id.idLocalEditar);
        descripcionActividad = findViewById(R.id.descripcionActividadEditar);
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
                // idDetalle.setText(Integer.toString(detalle.getID_DETALLE()));
                // grupo.setText(Integer.toString(detalle.getGRUPO()));
                idActividad.setText(detalle.getIDACTIVIDAD().toString());
              //  idLocal.setText(detalle.getIDLOCAL().toString());
                descripcionActividad.setText(detalle.getDESCRIPCIONACTIVIDAD().toString());
            }
        }
    }


    public void actualizarDetalleActividad(View v){

        String id_detalle = idDetalle.getText().toString();
       // String grupo1 = grupo.getText().toString();
        String id_Actividad = idActividad.getText().toString();
      //  String id_local = idLocal.getText().toString();
        String descripAct = descripcionActividad.getText().toString();

        //Validar que no este vacio
        //id_detalle.isEmpty() || grupo1.isEmpty() || id_Actividad.isEmpty() || id_local.isEmpty() || descripAct.isEmpty()
        if(id_detalle.isEmpty() ||  id_Actividad.isEmpty() ||  descripAct.isEmpty()){
            Toast.makeText(this, "Todos los campos tiene que estar llenos", Toast.LENGTH_SHORT).show();
        }
        else {
            String regActualizados;

            DetalleActividad detalleactividad = new DetalleActividad();

            detalleactividad.setID_DETALLE(Integer.parseInt(id_detalle));
           // detalleactividad.setGRUPO(Integer.parseInt(grupo1));
            detalleactividad.setIDACTIVIDAD(id_Actividad);
           // detalleactividad.setIDLOCAL(id_local);
            detalleactividad.setDESCRIPCIONACTIVIDAD(descripAct);


            helper.abrir();
            regActualizados = helper.actualizarDetalleActividad(detalleactividad);
            helper.cerrar();

            Toast.makeText(this, regActualizados, Toast.LENGTH_SHORT).show();
        }
    }

    public void CancelarActualizarDetalleActividad (View v){
        idDetalle.setText("");

    }

}