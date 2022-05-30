package com.edu.ues.fia.eisi.app_proyecto01;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class EditarOfertaAcademica extends AppCompatActivity {
    ControlBDActividades helper;
    EditText idMateriaActiva, idCiclo, idAsignatura, nombreMateriaActiva;
    TextView idRegistro;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_oferta_academica);
        helper = new ControlBDActividades(this);
        idMateriaActiva = findViewById(R.id.edtIdMateriaActivaOfertaAcademicaEditar);
        idCiclo = findViewById(R.id.edtIdCicloOfertaAcademicaEditar);
        idAsignatura = findViewById(R.id.edtIdAsignaturaOfertaAcademicaEditar);
        nombreMateriaActiva = findViewById(R.id.edtNombreMateriaActivaOfertaAcademicaEditar);
        idRegistro=findViewById(R.id.idMateriaActivaOfertaAcademicaEditar);

    }
    public void consultarOfertaAcademica(View v){
        helper.abrir();
        OfertaAcademica ofertaAcademica = helper.consultarOfertaAcademica(idMateriaActiva.getText().toString());
        helper.cerrar();
        if (ofertaAcademica == null) {
            Toast.makeText(this, "La oferta academica con el id " + idMateriaActiva.getText().toString() + " no ha sido encontrada.", Toast.LENGTH_LONG).show();
        } else {
            idRegistro.setText(ofertaAcademica.getIdMateriaActiva());
            idCiclo.setText(ofertaAcademica.getIdCiclo());
            idAsignatura.setText(ofertaAcademica.getIdAsignatura());
            nombreMateriaActiva.setText(ofertaAcademica.getNombreMateriaActiva());
        }
    }
    public void actualizarOfertaAcademica(View v){
        String id_materia_activa=idRegistro.getText().toString();
        String id_ciclo=idCiclo.getText().toString();
        String id_asignatura=idAsignatura.getText().toString();
        String nombre_materia_activa=nombreMateriaActiva.getText().toString();
        if(id_ciclo.isEmpty()||id_materia_activa.isEmpty()||id_asignatura.isEmpty()||nombre_materia_activa.isEmpty()){
            Toast.makeText(this,"Error no debe dejar campos vacios",Toast.LENGTH_SHORT).show();
        }
        else{
            String regInsertados;
            OfertaAcademica ofertaAcademica=new OfertaAcademica();
            ofertaAcademica.setIdMateriaActiva(id_materia_activa);
            ofertaAcademica.setIdCiclo(id_ciclo);
            ofertaAcademica.setIdAsignatura(id_asignatura);
            ofertaAcademica.setNombreMateriaActiva(nombre_materia_activa);

            helper.abrir();
            regInsertados=helper.actualizarOfertaAcademica(ofertaAcademica);
            helper.cerrar();
            Toast.makeText(this,regInsertados,Toast.LENGTH_SHORT).show();
        }
    }
}