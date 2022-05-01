package com.edu.ues.fia.eisi.app_proyecto01;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ActividadMenuActivity extends AppCompatActivity implements View.OnClickListener {

    /*Varibles*/
    public CardView DetalleActividad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad_menu);

        DetalleActividad = (CardView) findViewById(R.id.cardDetalleActividad);
        DetalleActividad.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent i ;
        switch (view.getId()) {
            case R.id.cardDetalleActividad:
                i = new Intent(this, MenuDetalleActividad.class);
                //   i.putExtra("Rol",rol);
                startActivity(i);
                break;
        }
    }


}