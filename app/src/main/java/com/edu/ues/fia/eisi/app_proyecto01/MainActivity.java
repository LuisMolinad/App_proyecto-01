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
    String tipoUsuario;
public Integer rol;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BDhelper=new ControlBDActividades(this);
        Intent intent = getIntent();
       tipoUsuario = intent.getExtras().getString("OpcionCrud");
        cardMenuActividad = (CardView) findViewById(R.id.cardActividad);
        cardMenuCatalogo = (CardView) findViewById(R.id.cardCatalogoAcademico);
        cardMenuParticular = (CardView) findViewById(R.id.cardParticular);
        cardMenuMiembro = (CardView) findViewById(R.id.cardMiembroUniversitario);
        cardMenuHorario = (CardView) findViewById(R.id.cardHorario);
        cardMenuEquipo = (CardView) findViewById(R.id.cardEquipo);
        cardMenuCiclo = (CardView) findViewById(R.id.cardCiclo);
        cardMenuLocal = (CardView) findViewById(R.id.cardLocal);

        cardMenuActividad.setOnClickListener(this);
        cardMenuCatalogo.setOnClickListener(this);
        cardMenuParticular.setOnClickListener(this);
        cardMenuMiembro.setOnClickListener(this);
        cardMenuHorario.setOnClickListener(this);
        cardMenuEquipo.setOnClickListener(this);
        cardMenuCiclo.setOnClickListener(this);
        cardMenuLocal.setOnClickListener(this);

        BDhelper.abrir();
        String tost=BDhelper.llenarBDActividad();
        BDhelper.cerrar();
        Toast.makeText(this, tost, Toast.LENGTH_SHORT).show();

       /* if(tipoUsuario!=null){
         //   String opcioncRUD=tipoUsuario;
            switch (tipoUsuario){
                case "0100":

                    cardMenuActividad.setOnClickListener(this);
                    cardMenuCatalogo.setOnClickListener(this);
                    cardMenuParticular.setOnClickListener(this);
                    cardMenuMiembro.setOnClickListener(this);
                    cardMenuHorario.setOnClickListener(this);
                    cardMenuEquipo.setOnClickListener(this);
                    cardMenuCiclo.setOnClickListener(this);
                    cardMenuLocal.setOnClickListener(this);
                    break;
                case "0200":
                    cardMenuActividad.setOnClickListener(this);
                    cardMenuCatalogo.setOnClickListener(this);
                    cardMenuCiclo.setOnClickListener(this);
                    cardMenuParticular.setVisibility(View.GONE);
                    cardMenuMiembro.setVisibility(View.GONE);
                    cardMenuHorario.setOnClickListener(this);
                    cardMenuEquipo.setOnClickListener(this);

                    cardMenuLocal.setVisibility(View.GONE);

                    break;
            }

        }*/

    }

    @Override
    public void onClick(View view) {
        Intent i ;
        switch (view.getId()){
            case R.id.cardActividad:
                i=new Intent(this, ActividadMenuActivity.class);
                //Intent intent;
                i.putExtra("OpcionCrud",tipoUsuario);
                startActivity(i);
                break;
            case R.id.cardCatalogoAcademico:
                i=new Intent(this, CatalogoAcademicoActivity.class);
                i.putExtra("OpcionCrud",tipoUsuario);
                startActivity(i);
                break;
            case R.id.cardParticular:
                i=new Intent(this, MenuParticular.class);
                i.putExtra("OpcionCrud",tipoUsuario);
                startActivity(i);
                break;
            case R.id.cardMiembroUniversitario:
                i=new Intent(this, MenuMiembroUniversitario.class);
                // i.putExtra("Rol",rol);
                i.putExtra("OpcionCrud",tipoUsuario);
                startActivity(i);

                break;
            case R.id.cardHorario:
                i=new Intent(this, MenuHorario.class);
                // i.putExtra("Rol",rol);
                i.putExtra("OpcionCrud",tipoUsuario);
                startActivity(i);
                break;
            case R.id.cardEquipo:
                i=new Intent(this, MenuEquipoDidactico.class);
                // i.putExtra("Rol",rol);
                i.putExtra("OpcionCrud",tipoUsuario);
                startActivity(i);
                break;
            case R.id.cardCiclo:
                i=new Intent(this, MenuCicloActivity.class);
                // i.putExtra("Rol",rol);
                i.putExtra("OpcionCrud",tipoUsuario);
                startActivity(i);
                break;
            case R.id.cardLocal:
                i=new Intent(this, MenuLocal.class);
                // i.putExtra("Rol",rol);
                i.putExtra("OpcionCrud",tipoUsuario);
                startActivity(i);
                break;

        }
        //Para que se inicie la bd al cargar el men[u principal y se inserten todos los datos cargados

    }
}