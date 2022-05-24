package com.edu.ues.fia.eisi.app_proyecto01;

import android.content.Intent;
import androidx.cardview.widget.CardView;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

public CardView cardMenuActividad, cardMenuCatalogo,
        cardMenuParticular, cardMenuMiembro, cardMenuHorario,
        cardMenuEquipo, cardMenuCiclo, cardMenuLocal;
    ControlBDActividades BDhelper;

public Integer rol;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BDhelper=new ControlBDActividades(this);
        Intent intent = getIntent();
        String tipoUsuario = intent.getExtras().getString("OpcionCrud");


        BDhelper.abrir();
        String tost=BDhelper.llenarBDActividad();
        BDhelper.cerrar();
        Toast.makeText(this, tost, Toast.LENGTH_SHORT).show();

        //Lineas para la busqueda del cardView

        //rol = i.getIntExtra("Rol",1);
        //rol = i.getIntExtra("Rol",1);
        if(tipoUsuario.equals("0100")){
            cardMenuActividad = (CardView) findViewById(R.id.cardActividad);
            cardMenuActividad.setOnClickListener(this);

            cardMenuCatalogo = (CardView) findViewById(R.id.cardCatalogoAcademico);
            cardMenuCatalogo.setOnClickListener(this);

            cardMenuParticular = (CardView) findViewById(R.id.cardParticular);
            cardMenuParticular.setOnClickListener(this);

            cardMenuMiembro = (CardView) findViewById(R.id.cardMiembroUniversitario);
            cardMenuMiembro.setOnClickListener(this);

            cardMenuHorario = (CardView) findViewById(R.id.cardHorario);
            cardMenuHorario.setOnClickListener(this);

            cardMenuEquipo = (CardView) findViewById(R.id.cardEquipo);
            cardMenuEquipo.setOnClickListener(this);

            cardMenuCiclo = (CardView) findViewById(R.id.cardCiclo);
            cardMenuCiclo.setOnClickListener(this);

            cardMenuLocal = (CardView) findViewById(R.id.cardLocal);
            cardMenuLocal.setOnClickListener(this);
        }else{
            cardMenuActividad = (CardView) findViewById(R.id.cardActividad);
            cardMenuActividad.setVisibility(View.GONE);

            cardMenuCatalogo = (CardView) findViewById(R.id.cardCatalogoAcademico);
            cardMenuCatalogo.setVisibility(View.GONE);

            cardMenuParticular = (CardView) findViewById(R.id.cardParticular);
            cardMenuParticular.setVisibility(View.GONE);

            cardMenuMiembro = (CardView) findViewById(R.id.cardMiembroUniversitario);
            cardMenuMiembro.setVisibility(View.GONE);

            cardMenuHorario = (CardView) findViewById(R.id.cardHorario);
            cardMenuHorario.setVisibility(View.GONE);

            cardMenuEquipo = (CardView) findViewById(R.id.cardEquipo);
            cardMenuEquipo.setVisibility(View.GONE);

            cardMenuCiclo = (CardView) findViewById(R.id.cardCiclo);
            cardMenuCiclo.setVisibility(View.GONE);

            cardMenuLocal = (CardView) findViewById(R.id.cardLocal);
            cardMenuLocal.setVisibility(View.GONE);
        }


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
                i=new Intent(this, MenuMiembroUniversitario.class);
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
        //Para que se inicie la bd al cargar el men[u principal y se inserten todos los datos cargados

    }
}