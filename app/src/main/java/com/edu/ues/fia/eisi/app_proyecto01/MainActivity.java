package com.edu.ues.fia.eisi.app_proyecto01;

import android.app.ActionBar;
import android.app.ListActivity;
import android.content.Intent;
import androidx.cardview.widget.CardView;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Objects;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

public CardView cardMenuActividad, cardMenuCatalogo,
        cardMenuParticular, cardMenuMiembro, cardMenuHorario,
        cardMenuEquipo, cardMenuCiclo, cardMenuLocal;
public Integer rol;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Lineas para la busqueda del cardView
        Intent i = getIntent();
        //rol = i.getIntExtra("Rol",1);
        //rol = i.getIntExtra("Rol",1);
       cardMenuActividad = (CardView) findViewById(R.id.cardActividad);
       cardMenuCatalogo = (CardView) findViewById(R.id.cardCatalogoAcademico);
       cardMenuParticular = (CardView) findViewById(R.id.cardParticular);
       cardMenuMiembro = (CardView) findViewById(R.id.cardMiembroUniversitario);
       cardMenuHorario = (CardView) findViewById(R.id.cardHorario);
       cardMenuEquipo = (CardView) findViewById(R.id.cardEquipo);
       cardMenuCiclo = (CardView) findViewById(R.id.cardCiclo);
       cardMenuLocal = (CardView) findViewById(R.id.cardLocal);

       //HACEMOS CLICKEABLE CADA CARD
        cardMenuActividad.setOnClickListener(this);
        cardMenuCatalogo.setOnClickListener(this);
        cardMenuParticular.setOnClickListener(this);
        cardMenuMiembro.setOnClickListener(this);
        cardMenuHorario.setOnClickListener(this);
        cardMenuEquipo.setOnClickListener(this);
        cardMenuCiclo.setOnClickListener(this);
        cardMenuLocal.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
        Intent i ;
        switch (view.getId()){
            case R.id.cardActividad:
                i=new Intent(this, ActividadMenuActivity.class);
             //   i.putExtra("Rol",rol);
                startActivity(i);
                break;
            case R.id.cardCatalogoAcademico:
                i=new Intent(this, CatalogoAcademicoActivity.class);
               // i.putExtra("Rol",rol);
                startActivity(i);
                break;
            case R.id.cardParticular:
                i=new Intent(this, MenuParticular.class);
                // i.putExtra("Rol",rol);
                startActivity(i);
                break;
            case R.id.cardMiembroUniversitario:
                i=new Intent(this, MenumiembroUniversitario.class);
                // i.putExtra("Rol",rol);
                startActivity(i);
                break;
            case R.id.cardHorario:
                i=new Intent(this, MenuHorario.class);
                // i.putExtra("Rol",rol);
                startActivity(i);
                break;
            case R.id.cardEquipo:
                i=new Intent(this, MenuEquipoDidactico.class);
                // i.putExtra("Rol",rol);
                startActivity(i);
                break;
            case R.id.cardCiclo:
                i=new Intent(this, MenuCicloActivity.class);
                // i.putExtra("Rol",rol);
                startActivity(i);
                break;
            case R.id.cardLocal:
                i=new Intent(this, MenuLocal.class);
                // i.putExtra("Rol",rol);
                startActivity(i);
                break;

        }
    }
}