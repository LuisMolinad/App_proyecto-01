package com.edu.ues.fia.eisi.app_proyecto01;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
public class InsertarOfertaAcademica extends AppCompatActivity {
    ControlBDActividades helper;
    EditText idMateriaActiva, idCiclo,idAsignatura,nombreMateriaActiva;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insertar_oferta_academica);
        helper =new ControlBDActividades(this);
        idMateriaActiva=findViewById(R.id.edtIdMateriaActivaOfertaAcademica);
        idCiclo=findViewById(R.id.edtidCicloOfertaAcademica);
        idAsignatura=findViewById(R.id.edtIdAsignaturaOfertaAcademica);
        nombreMateriaActiva=findViewById(R.id.edtNombreMateriaActivaOfertaAcademica);
    }
    public void insertarOfertaAcademica(View v){
        String id_materia_activa=idMateriaActiva.getText().toString();
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
            regInsertados=helper.insertarOfertaAcademica(ofertaAcademica);
            helper.cerrar();
            Toast.makeText(this,regInsertados,Toast.LENGTH_SHORT).show();
        }
    }
}