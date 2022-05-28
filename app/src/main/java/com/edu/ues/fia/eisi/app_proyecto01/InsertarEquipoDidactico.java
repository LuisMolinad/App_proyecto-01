package com.edu.ues.fia.eisi.app_proyecto01;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class InsertarEquipoDidactico extends AppCompatActivity {
    ControlBDActividades helper;
    EditText idEquipo, nombre, descripcionEquipo;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insertar_equipo_didactico);
        //Iniciar la base de datos
        helper = new ControlBDActividades(this);

        //Capturar los ide de cada EditText
        idEquipo = findViewById(R.id.idEquipoInsertar);
        nombre = findViewById(R.id.nombreEquipoInsertar);
        descripcionEquipo = findViewById(R.id.descripcionEquipoInsertar);
    }

    public void insertarEquipoDidactico(View v){

        if(idEquipo.getText().toString().isEmpty() || nombre.getText().toString().isEmpty() || descripcionEquipo.getText().toString().isEmpty()){
            Toast.makeText(this, "Error, no debe dejar campos vacios", Toast.LENGTH_SHORT).show();
        }
        else{
            String regInsertados;

            EquipoDidactico equipodidactico = new EquipoDidactico();

            equipodidactico.setIDEQUIPO(idEquipo.getText().toString());
            equipodidactico.setNOMBRE(nombre.getText().toString());
            equipodidactico.setDESCRIPCIONEQUIPO(descripcionEquipo.getText().toString());

            helper.abrir();
            regInsertados = helper.insertarEquipoDidactico(equipodidactico);
            helper.cerrar();
            Toast.makeText(this, regInsertados, Toast.LENGTH_SHORT).show();
        }
    }
    public void CancelarInsertarEquipo (View v){
        idEquipo.setText("");
        nombre.setText("");
        descripcionEquipo.setText("");
    }
}