package com.edu.ues.fia.eisi.app_proyecto01;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MenuParticular extends AppCompatActivity implements View.OnClickListener {
CardView cardInsertarParticular, cardEditarParticular, cardEliminarParticular, cardConsultarParticular;
    String tipoUsuario;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_particular);

        //captura de datos
        cardInsertarParticular = (CardView) findViewById(R.id.cardInsertarParticular);
        cardEditarParticular = (CardView) findViewById(R.id.cardEditarParticular);
        cardEliminarParticular = (CardView) findViewById(R.id.cardEliminarParticular);
        cardConsultarParticular = (CardView) findViewById(R.id.cardConsultarParticular);


        Intent intent = getIntent();
        tipoUsuario = intent.getExtras().getString("OpcionCrud");
        if (tipoUsuario != null) {
            //   String opcioncRUD=tipoUsuario;
            switch (tipoUsuario) {
                case "0100":
                    cardInsertarParticular.setOnClickListener(this);
                    cardEditarParticular.setOnClickListener(this);
                    cardEliminarParticular.setOnClickListener(this);
                    cardConsultarParticular.setOnClickListener(this);
                    break;
                case "0200":
                    cardInsertarParticular.setVisibility(View.GONE);
                    cardEditarParticular.setVisibility(View.GONE);
                    cardEliminarParticular.setVisibility(View.GONE);
                    cardConsultarParticular.setOnClickListener(this);
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

        cardInsertarParticular.setOnClickListener(this);
        cardEditarParticular.setOnClickListener(this);
        cardEliminarParticular.setOnClickListener(this);
        cardConsultarParticular.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
        Intent i ;
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