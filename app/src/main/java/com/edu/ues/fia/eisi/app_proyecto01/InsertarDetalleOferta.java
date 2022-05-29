package com.edu.ues.fia.eisi.app_proyecto01;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


public class InsertarDetalleOferta extends AppCompatActivity {
    Spinner comboTipoGrupo;
    ControlBDActividades helper;
    EditText idGrupo,idMateriaActiva,numeroGrupo,cupoGrupo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insertar_detalle_oferta);

        comboTipoGrupo=(Spinner) findViewById(R.id.spinnerTipoGrupoDetelleOferta);
        ArrayAdapter<CharSequence> adapter=ArrayAdapter.createFromResource(this,R.array.opcionesTipoGrupo, android.R.layout.simple_spinner_item);
        comboTipoGrupo.setAdapter(adapter);
        helper =new ControlBDActividades(this);
        idGrupo=findViewById(R.id.edtIdGrupoDetelleOferta);
        idMateriaActiva=findViewById(R.id.edtIdMateriaActivaDetelleOferta);
        numeroGrupo=findViewById(R.id.edtNumeroGrupoDetelleOferta);
        cupoGrupo=findViewById(R.id.edtCupoGrupoDetelleOferta);
    }
    public void insertarDetalleOferta(View v){
        String id_grupo=idGrupo.getText().toString();
        String id_materia_activa=idMateriaActiva.getText().toString();
        String numero_grupo=numeroGrupo.getText().toString();
        String cupo_grupo=cupoGrupo.getText().toString();
        String tipo_grupo=comboTipoGrupo.getSelectedItem().toString();

        if(id_grupo.isEmpty()||id_materia_activa.isEmpty()||numero_grupo.isEmpty()||cupo_grupo.isEmpty()||tipo_grupo.isEmpty()||tipo_grupo.equals("Seleccione")){
            Toast.makeText(this,"Error no debe dejar campos vacios",Toast.LENGTH_SHORT).show();
        }
        else{
            String regInsertados;
            DetalleOferta detalleOferta = new DetalleOferta();
            detalleOferta.setIdGrupo(id_grupo);
            detalleOferta.setIdMateriaActiva(id_materia_activa);
            detalleOferta.setNumeroGrupo(Integer.parseInt(numero_grupo));
            detalleOferta.setTamanoGrupo(Integer.parseInt(cupo_grupo));
            detalleOferta.setTipoGrupo(tipo_grupo);


            helper.abrir();
            regInsertados=helper.insertarDetalleOferta(detalleOferta);
            helper.cerrar();
            Toast.makeText(this,regInsertados,Toast.LENGTH_SHORT).show();
        }
    }

}