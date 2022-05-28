package com.edu.ues.fia.eisi.app_proyecto01;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ConsultarListaEquipo extends AppCompatActivity {
        ControlBDActividades helper;
        EditText idListaEquipo;
        TextView idDetalle, idEquipo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consultar_lista_equipo);
        //Iniciamos la base de datos
        helper = new ControlBDActividades(this);

        //Cargamos los ids
        idListaEquipo = findViewById(R.id.idListaEquipoConsultar);
        idDetalle = findViewById(R.id.idDetalleConsultar);
        idEquipo = findViewById(R.id.idEquipoConsultar);

    }

    public void consultarListaEquipo(View v){
        String id_listaEquipo = idListaEquipo.getText().toString();

        if(id_listaEquipo == null){
            Toast.makeText(this, "Error, ingrese un id del lista de equipo", Toast.LENGTH_SHORT).show();
        }
        else {
            helper.abrir();
            ListaEquipo listaequipo = helper.consultarListaEquipo(id_listaEquipo);
            helper.cerrar();

            if(listaequipo == null){
                Toast.makeText(this, "Error no se ha encontrado una lista de equipo con el id "+id_listaEquipo+", favor intente de nuevo", Toast.LENGTH_SHORT).show();
            }
            else{
                idDetalle.setText("Código de la actividad: "+ Integer.toString(listaequipo.getID_DETALLE()));
                idEquipo.setText("Código del equipo didactico: "+listaequipo.getIDEQUIPO().toString());
            }
        }
    }
}
