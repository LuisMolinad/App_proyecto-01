package com.edu.ues.fia.eisi.app_proyecto01;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ActividadMenuActivity extends AppCompatActivity implements View.OnClickListener {

    /*Varibles*/
    public CardView DetalleActividad, ListaHorario, ListaEquipoDidactico, Asistencia, Actividad;
    String tipoUsuario;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad_menu);

        DetalleActividad = (CardView) findViewById(R.id.cardDetalleActividad);
        ListaHorario = (CardView) findViewById(R.id.cardListaHorario);
        ListaEquipoDidactico = (CardView) findViewById(R.id.cardListaEquipoDidactico);
        Asistencia = (CardView) findViewById(R.id.cardAsistencia);
        Actividad = (CardView) findViewById(R.id.cardActividad);


        Intent intent = getIntent();
        tipoUsuario = intent.getExtras().getString("OpcionCrud");
        if (tipoUsuario != null) {
            //   String opcioncRUD=tipoUsuario;
            switch (tipoUsuario) {
                case "0100":
                    /*Le pones el capturador de eventos*/
                    DetalleActividad.setOnClickListener(this);
                    ListaHorario.setOnClickListener(this);
                    ListaEquipoDidactico.setOnClickListener(this);
                    Asistencia.setOnClickListener(this);
                    Actividad.setOnClickListener(this);
                    break;
                case "0200":
                    DetalleActividad.setOnClickListener(this);
                    ListaHorario.setVisibility(View.GONE);
                    ListaEquipoDidactico.setVisibility(View.GONE);
                    Asistencia.setOnClickListener(this);
                    Actividad.setOnClickListener(this);
                    break;
                case "0300":
                    break;
                case "0400":
                    break;
                case "0500":
                    break;
                case "0600":
                    break;

            }


        }
    }

    @Override
    public void onClick(View view) {
        Intent i;
        switch (view.getId()) {
            case R.id.cardDetalleActividad:
                i = new Intent(this, MenuDetalleActividad.class);
                i.putExtra("OpcionCrud",tipoUsuario);
                startActivity(i);
                break;
            case R.id.cardListaHorario:
                i =  new Intent(this, MenuListaHorario.class);
                i.putExtra("OpcionCrud",tipoUsuario);
                startActivity(i);
                break;
            case R.id.cardListaEquipoDidactico:
                i = new Intent( this, MenuListaEquipo.class);
                i.putExtra("OpcionCrud",tipoUsuario);
                startActivity(i);
                break;
            case R.id.cardAsistencia:
                i = new Intent(this, MenuAsistencia.class);
                i.putExtra("OpcionCrud",tipoUsuario);
                startActivity(i);
                break;
            case R.id.cardActividad:
                i = new Intent(this, MenuActividadd.class);
                i.putExtra("OpcionCrud",tipoUsuario);
                startActivity(i);
                break;
        }
    }


}