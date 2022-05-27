package com.edu.ues.fia.eisi.app_proyecto01;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import org.json.JSONObject;
@SuppressLint("NewApi")
public class InsertarCarreraExterno extends AppCompatActivity {
    EditText idCarrera, nombreCarrera;
    //Duque
    private final String urlLocal = "http://192.168.0.3/Proyecto1.2/ws_nota_insertCarrera.php";
//aca pueden poner sus propias ur si quieren o solo cambian la mia
@SuppressLint("NewApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insertar_carrera_externo);
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()
                .permitAll().build();
        StrictMode.setThreadPolicy(policy);
        idCarrera = findViewById(R.id.idCarreraInsertarExterno);
        nombreCarrera = findViewById(R.id.nombreCarreraExterno);



    }
    public void insertarCarreraEXTERNO(View v) {
        String IDCARRERA = idCarrera.getText().toString();
        String NOMBRECARREARA = nombreCarrera.getText().toString();
        String url = null;
        JSONObject datosNota = new JSONObject();
        JSONObject nota = new JSONObject();
        switch (v.getId()) {
            case R.id.botonguardarCarreraExterno:
                url = urlLocal+ "?IDCARRERA=" + IDCARRERA + "&NOMBRECARREARA=" + NOMBRECARREARA ;
                ControladorServicio.insertarCarreraExterno(url, this);
                break;

        }
    }

}


