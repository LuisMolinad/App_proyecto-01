package com.edu.ues.fia.eisi.app_proyecto01;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ConsultarEquipoDidactico extends AppCompatActivity {
    ControlBDActividades helper;
    EditText idEquipo;
    TextView idEquipoConsultar,nombreEquipoConsultar, descripcionEquipoConsultar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consultar_equipo_didactico);
        //Iniciamos la base de datos
        helper = new ControlBDActividades(this);

        //Cargamos los ids
        idEquipoConsultar = findViewById(R.id.idEquipoConsultar);
        nombreEquipoConsultar = findViewById(R.id.nombreEquipoConsultar);
        descripcionEquipoConsultar = findViewById(R.id.descripcionEquipoConsultar);
    }

    public void consultarEquipoDidactico(View v){
        String id_equipo = idEquipoConsultar.getText().toString();

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
                nombreEquipoConsultar.setText("Nombre del equipo: "+equipodidactico.getNOMBRE().toString());
                descripcionEquipoConsultar.setText("Descripción del equipo: "+equipodidactico.getDESCRIPCIONEQUIPO().toString());
            }
        }
    }



    public void CancelarConsultarEquipo (View v){
        idEquipoConsultar.setText("");
        nombreEquipoConsultar.setText("");
        descripcionEquipoConsultar.setText("");

    }
}