package com.edu.ues.fia.eisi.app_proyecto01;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.Spinner;

public class InsertarMateria extends AppCompatActivity {
    ControlBDActividades helper;
    Spinner idEscuelaFk;
    EditText unidadVal, nombreAsignatura, idAsignatura;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insertar_materia);
        helper = new ControlBDActividades(this);

        idAsignatura= findViewById(R.id.idAsignaturaInsertar);
        idEscuelaFk = findViewById(R.id.spinneridEscuelaInsertar);
        unidadVal = findViewById(R.id.unidadesValorativasInsertar);
        nombreAsignatura = findViewById(R.id.nombreAsignaturainsertar);


    }


}