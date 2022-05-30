package com.edu.ues.fia.eisi.app_proyecto01;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
public class EditarDetalleOferta extends AppCompatActivity {
    ControlBDActividades helper;
    EditText idGrupo, idMateriaActiva, numeroGrupo, tamanoGrupo;
    TextView idRegistro;
    Spinner comboTipoGrupo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_detalle_oferta);
        comboTipoGrupo=(Spinner) findViewById(R.id.spinnerTipoGrupoDetalleOfertaEditar);
        ArrayAdapter<CharSequence> adapter=ArrayAdapter.createFromResource(this,R.array.opcionesTipoGrupo, android.R.layout.simple_spinner_item);
        comboTipoGrupo.setAdapter(adapter);
        helper = new ControlBDActividades(this);
        idGrupo=findViewById(R.id.edtIdGrupoDetalleOfertaEditar);
        idMateriaActiva=findViewById(R.id.edtIdMateriaActivaDetalleOfertaEditar);
        numeroGrupo=findViewById(R.id.edtNumeroGrupoDetalleOfertaEditar);
        tamanoGrupo=findViewById(R.id.edtTamanoGrupoDetalleOfertaEditar);
        idRegistro=findViewById(R.id.idDetalleOfertaConsultar);
    }
    public void consultarDetalleOferta(View v){
        helper.abrir();
        DetalleOferta detalleOferta = helper.consultarDetellaOferta(idGrupo.getText().toString());
        helper.cerrar();
        if (detalleOferta == null) {
            Toast.makeText(this, "El detalle oferta con el id " + idGrupo.getText().toString() + " no ha sido encontrado.", Toast.LENGTH_LONG).show();
        } else {
            String tipo=detalleOferta.getTipoGrupo();
            /*if(tipo=="Teórico"){
                comboTipoGrupo.setSelection(1);
            }
            else{
                comboNumeroCiclo.setSelection(2);
            }*/
            switch (tipo){
                case "Teórico":
                    comboTipoGrupo.setSelection(1);
                    break;
                case "Discusión":
                    comboTipoGrupo.setSelection(2);
                    break;
                case "Laboratorio":
                    comboTipoGrupo.setSelection(3);
                    break;
                case "Exámen parcial":
                    comboTipoGrupo.setSelection(4);
                    break;
                case "Exámen laboratorio":
                    comboTipoGrupo.setSelection(5);
                    break;
                case "Ponencia":
                    comboTipoGrupo.setSelection(6);
                    break;
            }
            idRegistro.setText(detalleOferta.getIdGrupo());
            idMateriaActiva.setText(detalleOferta.getIdMateriaActiva());
            numeroGrupo.setText(String.valueOf(detalleOferta.getNumeroGrupo()));
            tamanoGrupo.setText(String.valueOf(detalleOferta.getTamanoGrupo()));
        }
    }
    public void actualizarDetalleOferta(View v) {
        String id_grupo=idRegistro.getText().toString();
        String id_materia_activa=idMateriaActiva.getText().toString();
        String numero_grupo=numeroGrupo.getText().toString();
        String cupo_grupo=tamanoGrupo.getText().toString();
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
            regInsertados=helper.actualizarDetalleOferta(detalleOferta);
            helper.cerrar();
            Toast.makeText(this,regInsertados,Toast.LENGTH_SHORT).show();
        }
    }
}