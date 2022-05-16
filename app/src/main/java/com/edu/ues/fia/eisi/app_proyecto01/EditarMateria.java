package com.edu.ues.fia.eisi.app_proyecto01;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class EditarMateria extends AppCompatActivity {
    ControlBDActividades helper;
    EditText idAsignatura, idescuela, unidadVal, NombreAsignatura;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_materia);
        helper = new ControlBDActividades(this);

        idAsignatura = findViewById(R.id.idAsignaturaActualizar);
        idescuela = findViewById(R.id.idEscuelaActualizar);
        unidadVal = findViewById(R.id.unidadesValorativasEditar);
        NombreAsignatura = findViewById(R.id.nombreAsignaturaEditar);

    }


    public void actualizarMateria(View v) {
        Materia materia = new Materia();
      //  Integer unidades = Integer.valueOf(unidadVal.getText().toString());
        materia.setIDASIGNATURA(idAsignatura.getText().toString());
        materia.setIDESCUELA(idescuela.getText().toString());
        materia.setUNIDADESVALORATIVAS(Integer.valueOf(unidadVal.getText().toString()));
        materia.setNOMBREASIGNATURA(NombreAsignatura.getText().toString());
        helper.abrir();
        String estado = helper.actualizarMateria(materia);
        helper.cerrar();
        Toast.makeText(this, estado, Toast.LENGTH_SHORT).show();
    }



    public void Cancelar(View v) {
      idAsignatura.setText("");
      idescuela.setText("");
      unidadVal.setText("");
      NombreAsignatura.setText("");


    }
}