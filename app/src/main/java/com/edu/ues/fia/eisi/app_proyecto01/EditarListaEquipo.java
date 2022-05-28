package com.edu.ues.fia.eisi.app_proyecto01;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class EditarListaEquipo extends AppCompatActivity {
    ControlBDActividades helper;

    EditText idListaEquipo, idDetalle, idEquipo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_lista_equipo);

        //Iniciar base de datos
        helper = new ControlBDActividades(this);

        idListaEquipo = findViewById(R.id.idListaEquipoEditar);
        idDetalle = findViewById(R.id.idDetalleEditar);
        idEquipo = findViewById(R.id.idEquipoEditar);

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
                idDetalle.setText(Integer.toString(listaequipo.getID_DETALLE()));
                idEquipo.setText(listaequipo.getIDEQUIPO().toString());
            }
        }
    }



    public void actualizarListaEquipo(View v){

        String id_ListaEquipo = idListaEquipo.getText().toString();
        String detalle_equipo = idDetalle.getText().toString();
        String id_Equipo = idEquipo.getText().toString();

        //Validar que no este vacio
        if(id_ListaEquipo.isEmpty() || detalle_equipo.isEmpty() || id_Equipo.isEmpty()){
            Toast.makeText(this, "Todos los campos tiene que estar llenos", Toast.LENGTH_SHORT).show();
        }
        else {
            String regActualizados;

            ListaEquipo listaequipo = new ListaEquipo();

            listaequipo.setIDLISTAEQUIPO(Integer.parseInt(id_ListaEquipo));
            listaequipo.setID_DETALLE(Integer.parseInt(detalle_equipo));
            listaequipo.setIDEQUIPO(id_Equipo);


            helper.abrir();
            regActualizados = helper.actualizarListaEquipo(listaequipo);
            helper.cerrar();

            Toast.makeText(this, regActualizados, Toast.LENGTH_SHORT).show();
        }
    }
}