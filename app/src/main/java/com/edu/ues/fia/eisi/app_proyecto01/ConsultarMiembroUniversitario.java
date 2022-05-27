package com.edu.ues.fia.eisi.app_proyecto01;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ConsultarMiembroUniversitario extends AppCompatActivity {

    ControlBDActividades helper;
    EditText idMiembroUniversitario;
    TextView txtIdAsignatura, txtIdUsuario, txtNombre, txtTipoMiembro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consultar_miembro_universitario);

        //inicaimos la bd
        helper = new ControlBDActividades(this);

        idMiembroUniversitario = findViewById(R.id.idMiembroUniversitario);

        txtIdAsignatura = findViewById(R.id.txtIdAsignatura);
        txtIdUsuario = findViewById(R.id.txtIdUsuario);
        txtNombre = findViewById(R.id.txtNombre);
        txtTipoMiembro = findViewById(R.id.txtTipoMiembro);
    }

    public void consultarMiembroUniversitario(View v){
        helper.abrir();
        MiembroUniversitario miembroUniversitario = helper.consultarMiembroUniversitario(idMiembroUniversitario.getText().toString());
        helper.cerrar();
        if(miembroUniversitario == null){
            Toast.makeText(this, "El miembro universitario con el id "+idMiembroUniversitario.getText().toString() + ", no ha sido encontrado", Toast.LENGTH_LONG).show();
        }
        else {
            txtIdAsignatura.setText("Id asignatura: " + miembroUniversitario.getIdAsignatura());
            txtIdUsuario.setText("Id usuario: "+miembroUniversitario.getIdUsuario());
            txtNombre.setText("Nombre: "+miembroUniversitario.getNombreMiembroUniversitario());
            txtTipoMiembro.setText("Tipo de miembro: "+miembroUniversitario.getTipoMiembro());
        }
    }
}