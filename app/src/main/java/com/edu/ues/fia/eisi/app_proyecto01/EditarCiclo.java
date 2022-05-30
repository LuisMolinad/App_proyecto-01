package com.edu.ues.fia.eisi.app_proyecto01;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class EditarCiclo extends AppCompatActivity {
    ControlBDActividades helper;
    EditText idCiclo, inicioCiclo, finCiclo, anioCiclo;
    Spinner comboNumeroCiclo;
    TextView idRegistro;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_ciclo);
        comboNumeroCiclo = (Spinner) findViewById(R.id.spinnerNumeroCicloEditarCiclo);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.opcionesNumeroCiclo, android.R.layout.simple_spinner_item);
        comboNumeroCiclo.setAdapter(adapter);
        helper = new ControlBDActividades(this);
        idCiclo = findViewById(R.id.edtIdCicloEditarCiclo);
        inicioCiclo = findViewById(R.id.edtFechaInicioCicloEditarCiclo);
        finCiclo = findViewById(R.id.edtFechaFinCicloEditarCiclo);
        anioCiclo = findViewById(R.id.edtAnioCicloEditarCiclo);
        idRegistro=findViewById(R.id.idCicloEditarCiclo);
    }

    public void consultarCiclo(View v) {
        helper.abrir();
        Ciclo ciclo = helper.consultarCiclo(idCiclo.getText().toString());
        helper.cerrar();
        if (ciclo == null) {
            Toast.makeText(this, "El ciclo con el id " + idCiclo.getText().toString() + " no ha sido encontrado.", Toast.LENGTH_LONG).show();
        } else {
            int valor=Integer.valueOf(ciclo.getNumeroCiclo());
            if(valor==1){
                comboNumeroCiclo.setSelection(1);
            }
            else{
                comboNumeroCiclo.setSelection(2);
            }
            idRegistro.setText(ciclo.getIdCiclo());
            inicioCiclo.setText(ciclo.getFechaInicio());
            finCiclo.setText(ciclo.getFechaFin());
            anioCiclo.setText(ciclo.getAnio());
        }
    }

    public void actualizarCiclo(View v) {
        String id_ciclo = idRegistro.getText().toString();
        String numero_ciclo = comboNumeroCiclo.getSelectedItem().toString();
        String fecha_inicio = inicioCiclo.getText().toString();
        String fecha_fin = finCiclo.getText().toString();
        String anio_ciclo = anioCiclo.getText().toString();

        if (id_ciclo.isEmpty() || numero_ciclo.isEmpty() || numero_ciclo.equals("Seleccione") || fecha_inicio.isEmpty() || fecha_fin.isEmpty() || anio_ciclo.isEmpty()) {
            Toast.makeText(this, "Error no debe dejar campos vacios", Toast.LENGTH_SHORT).show();
        } else {
            String regInsertados;
            Ciclo ciclo = new Ciclo();
            ciclo.setIdCiclo(id_ciclo);
            ciclo.setNumeroCiclo(Integer.parseInt(numero_ciclo));
            ciclo.setFechaInicio(fecha_inicio);
            ciclo.setFechaFin(fecha_fin);
            ciclo.setAnio(anio_ciclo);

            helper.abrir();
            regInsertados = helper.actualizarCiclo(ciclo);
            helper.cerrar();
            Toast.makeText(this, regInsertados, Toast.LENGTH_SHORT).show();
        }
    }
}