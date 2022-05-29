package com.edu.ues.fia.eisi.app_proyecto01;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import org.json.JSONObject;
@SuppressLint("NewApi")
public class EliminarEscuelaExterno extends AppCompatActivity {
    EditText idescuela;
    private final String urlLocal = "http://192.168.0.3/Proyecto1.2/ws_escuela_delete.php";

    @SuppressLint("NewApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eliminar_escuela_externo);
        idescuela = findViewById(R.id.idEscuelaEliminarExterno);
    }

    public void EliminarEscuelaEXTERNO(View v) {
        String IDESCUELA = idescuela.getText().toString();
        String url = null;
        JSONObject datosNota = new JSONObject();
        JSONObject nota = new JSONObject();
        switch (v.getId()) {
            case R.id.botonEliminarEscuelaExterno:
                url = urlLocal+ "?IDESCUELA=" + IDESCUELA ;
                ControladorServicio.EliminarescuelaExterno(url, this);
                break;
        }
    }
}