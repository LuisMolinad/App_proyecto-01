package com.edu.ues.fia.eisi.app_proyecto01;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class EliminarCiclo extends AppCompatActivity {
    ControlBDActividades helper;
    EditText idCiclo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eliminar_ciclo);
        helper = new ControlBDActividades(this);
        idCiclo = findViewById(R.id.idCicloEliminarCiclo);
    }
    public void eliminarCiclo(View v){
        String regEliminadas;
        Ciclo ciclo = new Ciclo();
        ciclo.setIdCiclo(idCiclo.getText().toString());
        helper.abrir();
        regEliminadas = helper.eliminarCiclo(ciclo);
        helper.cerrar();
        Toast.makeText(this,regEliminadas,Toast.LENGTH_SHORT).show();
    }
}