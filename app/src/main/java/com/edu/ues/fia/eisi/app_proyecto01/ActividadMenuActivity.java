package com.edu.ues.fia.eisi.app_proyecto01;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ActividadMenuActivity extends AppCompatActivity implements View.OnClickListener {

    /*Varibles*/
    public CardView DetalleActividad, ListaHorario, ListaEquipoDidactico, Asistencia, Actividad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad_menu);

        /*Tomamos el datos*/
        DetalleActividad = (CardView) findViewById(R.id.cardDetalleActividad);
        ListaHorario = (CardView) findViewById(R.id.cardListaHorario);
        ListaEquipoDidactico = (CardView) findViewById(R.id.cardListaEquipoDidactico);
        Asistencia = (CardView) findViewById(R.id.cardAsistencia);
        Actividad = (CardView) findViewById(R.id.cardActividad);

        /*Le pones el capturador de eventos*/
        DetalleActividad.setOnClickListener(this);
        ListaHorario.setOnClickListener(this);
        ListaEquipoDidactico.setOnClickListener(this);
        Asistencia.setOnClickListener(this);
        Actividad.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent i ;
        switch (view.getId()) {
            case R.id.cardDetalleActividad:
                i = new Intent(this, MenuDetalleActividad.class);
                startActivity(i);
                break;
            case R.id.cardListaHorario:
                i =  new Intent(this, MenuListaHorario.class);
                startActivity(i);
                break;
            case R.id.cardListaEquipoDidactico:
                i = new Intent( this, MenuListaEquipo.class);
                startActivity(i);
                break;
            case R.id.cardAsistencia:
                i = new Intent(this, MenuAsistencia.class);
                startActivity(i);
                break;
            case R.id.cardActividad:
                i = new Intent(this, MenuActividadd.class);
                startActivity(i);
                break;
        }
    }


}