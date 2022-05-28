package com.edu.ues.fia.eisi.app_proyecto01;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import org.json.JSONObject;

@SuppressLint("NewApi")
public class EliminarCarreraExterno extends AppCompatActivity {

    EditText idCarrera;

    private final String urlLocal = "http://192.168.0.3/Proyecto1.2/ws_carrera_delete.php";
    @SuppressLint("NewApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eliminar_carrera_externo);
        idCarrera = findViewById(R.id.idCarreraEliminarExterno);

    }
    public void EliminarCarreraEXTERNO(View v) {
        String IDCARRERA = idCarrera.getText().toString();
        String url = null;
        JSONObject datosNota = new JSONObject();
        JSONObject nota = new JSONObject();
        switch (v.getId()) {
            case R.id.botonEliminarCarreraExterno:
                url = urlLocal+ "?IDCARRERA=" + IDCARRERA ;
                ControladorServicio.ActualizarCarreraExterno(url, this);
                break;
        }
    }
}