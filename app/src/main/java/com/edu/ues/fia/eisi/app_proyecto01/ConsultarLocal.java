package com.edu.ues.fia.eisi.app_proyecto01;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ConsultarLocal extends AppCompatActivity {

    ControlBDActividades helper;
    EditText idLocal;
    TextView txtNombreLocal, txtCupo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consultar_local);

        //Iniciamos la base de datos
        helper = new ControlBDActividades(this);

        //Cargamos los ids
        idLocal = findViewById(R.id.idLocal);
        txtNombreLocal = findViewById(R.id.txtNombreLocal);
        txtCupo = findViewById(R.id.txtCupo);
    }

    public void consultarLocal(View v) {
        String id_local = idLocal.getText().toString();

        if (id_local == null) {
            Toast.makeText(this, "Error, ingrese un id del local", Toast.LENGTH_SHORT).show();
        } else {
            helper.abrir();
            Local local = helper.consultarLocal(id_local);
            helper.cerrar();

            if (local == null) {
                Toast.makeText(this, "Error no se ha encontrado un local con el id " + id_local + ", favor intente de nuevo", Toast.LENGTH_SHORT).show();
            } else {
                txtNombreLocal.setText("Nombre del local: " + local.getNOMBRELOCAL().toString());
                txtCupo.setText("Cupo: " + Integer.toString(local.getCUPO()));
            }
        }
    }
}