package com.edu.ues.fia.eisi.app_proyecto01;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ConsultarListaHorario extends AppCompatActivity {

    ControlBDActividades helper;
    EditText edtIdListaHorario;
    TextView txtIdDetalle, txtIdHorario;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consultar_lista_horario);

        //Iniciamos la base de datos
        helper = new ControlBDActividades(this);

        //Cargamos los ids
        edtIdListaHorario = findViewById(R.id.idListaHorario);
        txtIdDetalle = findViewById(R.id.txtIdDetalle);
        txtIdHorario = findViewById(R.id.txtIdHorario);
    }

    public void consultarListaHorario(View v){
        String id_listaHorario = edtIdListaHorario.getText().toString();

        if(id_listaHorario == null){
            Toast.makeText(this, "Error, ingrese un id de lista horario", Toast.LENGTH_SHORT).show();
        }
        else {
            helper.abrir();
            ListaHorario listaHorario = helper.consultarListaHorario(id_listaHorario);
            helper.cerrar();

            if(listaHorario == null){
                Toast.makeText(this, "Error no se ha encontrado una lista horario con el id "+id_listaHorario+", favor intente de nuevo", Toast.LENGTH_SHORT).show();
            }
            else{
                txtIdDetalle.setText("Código de la actividad: "+ Integer.toString(listaHorario.getID_DETALLE()));
                txtIdHorario.setText("Id horario: "+listaHorario.getIDHORARIO());
            }
        }
    }
}