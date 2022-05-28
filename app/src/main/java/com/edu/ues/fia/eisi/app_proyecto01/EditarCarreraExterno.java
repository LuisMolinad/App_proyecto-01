package com.edu.ues.fia.eisi.app_proyecto01;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import org.json.JSONObject;

public class EditarCarreraExterno extends AppCompatActivity {
    EditText idCarrera, nombreCarrera;
    //Duque
    private final String urlLocal = "http://192.168.0.3/Proyecto1.2/ws_CARRERA_update.php";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_carrera_externo);

        idCarrera = findViewById(R.id.idCarreraEditarExterno);
        nombreCarrera = findViewById(R.id.nombreCarreraEditarExterno);

    }
    public void EDITARCarreraEXTERNO(View v) {
        String IDCARRERA = idCarrera.getText().toString();
        String NOMBRECARREARA = nombreCarrera.getText().toString();
        String url = null;
        JSONObject datosNota = new JSONObject();
        JSONObject nota = new JSONObject();
        switch (v.getId()) {
            case R.id.botonEditarCarrera:
                url = urlLocal+ "?IDCARRERA=" + IDCARRERA + "&NOMBRECARRERA=" + NOMBRECARREARA ;
                ControladorServicio.ActualizarCarreraExterno(url, this);
                break;
        }
    }
}