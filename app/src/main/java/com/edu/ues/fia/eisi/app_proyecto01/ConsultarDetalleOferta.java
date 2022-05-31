package com.edu.ues.fia.eisi.app_proyecto01;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ConsultarDetalleOferta extends AppCompatActivity {
    ControlBDActividades helper;
    EditText idGrupo;
    TextView idMateriaActiva, tipoGrupo, numeroGrupo,tamanoGrupo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consultar_detalle_oferta);
        helper = new ControlBDActividades(this);
        idGrupo = findViewById(R.id.edtIdGrupoDetelleOfertaConsultar);
        idMateriaActiva = findViewById(R.id.txtIdMateriaActivaDetalleOfertaConsultar);
        tipoGrupo = findViewById(R.id.txtTipoGrupoDetalleOfertaConsultar);
        numeroGrupo = findViewById(R.id.txtNumeroGrupoDetalleOfertaConsultar);
        tamanoGrupo = findViewById(R.id.txtTamanoGrupoDetalleOfertaConsultar);
    }
    public void consultarDetalleOferta(View v){
        idMateriaActiva.setText(R.string.idMateriaActiva);
        tipoGrupo.setText(R.string.tipoGrupo);
        numeroGrupo.setText(R.string.numeroGrupo);
        tamanoGrupo.setText(R.string.tamanoGrupo);
        helper.abrir();
        DetalleOferta detalleOferta = helper.consultarDetellaOferta(idGrupo.getText().toString());
        helper.cerrar();
        if(detalleOferta==null){
            Toast.makeText(this, "El detalle oferta con el id "+idGrupo.getText().toString()+" no ha sido encontrado.",Toast.LENGTH_LONG).show();
        }
        else{
            idMateriaActiva.setText(idMateriaActiva.getText().toString()+": "+detalleOferta.getIdMateriaActiva());
            tipoGrupo.setText(tipoGrupo.getText().toString()+": "+detalleOferta.getTipoGrupo());
            numeroGrupo.setText(numeroGrupo.getText().toString()+": "+String.valueOf(detalleOferta.getNumeroGrupo()));
            tamanoGrupo.setText(tamanoGrupo.getText().toString()+": "+String.valueOf(detalleOferta.getTamanoGrupo()));
        }
    }
}