package com.edu.ues.fia.eisi.app_proyecto01;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MenuParticular extends AppCompatActivity implements View.OnClickListener {
CardView cardInsertarParticular, cardEditarParticular, cardEliminarParticular, cardConsultarParticular;
    Intent i;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_particular);

        //captura de datos
        cardInsertarParticular = (CardView) findViewById(R.id.cardInsertarParticular);
        cardEditarParticular = (CardView) findViewById(R.id.cardEditarParticular);
        cardEliminarParticular = (CardView) findViewById(R.id.cardEliminarParticular);
        cardConsultarParticular = (CardView) findViewById(R.id.cardConsultarParticular);


        cardInsertarParticular.setOnClickListener(this);
        cardEditarParticular.setOnClickListener(this);
        cardEliminarParticular.setOnClickListener(this);
        cardConsultarParticular.setOnClickListener(this);

        //Para Ocultar
        //cardEditarParticular.setVisibility(View.GONE);
        //enviados a la siguiente vista como lo hace el Ing
        /*cardInsertarParticular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                i = new Intent(getApplicationContext(), InsertarParticularActivity.class);
                startActivity(i);
            }
        });*/
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.cardInsertarParticular:
                i=new Intent(this, InsertarParticularActivity.class);
                //   i.putExtra("Rol",rol);
                 startActivity(i);
                break;
            case R.id.cardEditarParticular:
                i=new Intent(this, EditarParticularActivity.class);
                //   i.putExtra("Rol",rol);
                startActivity(i);
                break;
            case R.id.cardConsultarParticular:
                i=new Intent(this, ConsultarParticularActivity.class);
                //   i.putExtra("Rol",rol);
                startActivity(i);
                break;
            case R.id.cardEliminarParticular:
                i=new Intent(this, EliminarParticularActivity.class);
                //   i.putExtra("Rol",rol);
                startActivity(i);
                break;


        }
    }
}