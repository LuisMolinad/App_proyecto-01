package com.edu.ues.fia.eisi.app_proyecto01;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class EditarEquipoDidactico extends AppCompatActivity {
    ControlBDActividades helper;

    EditText idEquipoE, nombreE, descripcionE;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_equipo_didactico);

       //Iniciar base de datos
        helper = new ControlBDActividades(this);

        idEquipoE = findViewById(R.id.idEquipoEditar);
        nombreE = findViewById(R.id.nombreEquipoEditar);
        descripcionE = findViewById(R.id.descripcionEquipoEditar);

    }


    public void consultarEquipoDidactico(View v){
        String id_equipo = idEquipoE.getText().toString();

        if(id_equipo == null){
            Toast.makeText(this, "Error, ingrese un id del equipo didactico", Toast.LENGTH_SHORT).show();
        }
        else {
            helper.abrir();
            EquipoDidactico equipodidactico = helper.consultarEquipoDidactico(id_equipo);
            helper.cerrar();

            if(equipodidactico == null){
                Toast.makeText(this, "Error no se ha encontrado el equipo didactico  con el id "+id_equipo+", favor intente de nuevo", Toast.LENGTH_SHORT).show();
            }
            else{
                nombreE.setText(equipodidactico.getNOMBRE().toString());
                descripcionE.setText(equipodidactico.getDESCRIPCIONEQUIPO().toString());
            }
        }
    }

    public void actualizarEquipoDidactico(View v){
        String id_equipo = idEquipoE.getText().toString();
        String nombre_equipo = nombreE.getText().toString();
        String descripcion_equipo = descripcionE.getText().toString();

        //Validar que no este vacio
        if(id_equipo.isEmpty() || nombre_equipo.isEmpty() || descripcion_equipo.isEmpty()){
            Toast.makeText(this, "Todos los campos tiene que estar llenos", Toast.LENGTH_SHORT).show();
        }
        else {
            String regActualizados;

            EquipoDidactico equipodidactico = new EquipoDidactico();

            equipodidactico.setIDEQUIPO(id_equipo);
            equipodidactico.setNOMBRE(nombre_equipo);
            equipodidactico.setDESCRIPCIONEQUIPO(descripcion_equipo);


            helper.abrir();
            regActualizados = helper.actualizarEquipoDidactico(equipodidactico);
            helper.cerrar();

            Toast.makeText(this, regActualizados, Toast.LENGTH_SHORT).show();
        }
    }

}