package com.edu.ues.fia.eisi.app_proyecto01;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
@SuppressLint("NewApi")

public class ConsultarCarreraExterno extends AppCompatActivity {
    private final String urlLocal = "http://192.168.0.3/Proyecto1.2/ws_db_Carrera_Consultar.php";

    EditText IDCARRERA,NombreCarrera;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consultar_carrera_externo);

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()
                .permitAll().build();
        StrictMode.setThreadPolicy(policy);
        IDCARRERA = findViewById(R.id.idCarreraConsultarExterna);
        NombreCarrera = findViewById( R.id.NOMBRECARRERAConsultarExterna);

    }
    public void consultarCARRERALocal(View v) {
        String IDCARRERA1 = IDCARRERA.getText().toString();
        String url = urlLocal + "?IDCARRERA=" + IDCARRERA1;
        String notaPromedioJSON = ControladorServicio.obtenerRespuestaPeticion(url, this);
        NombreCarrera.setText("CARRERA " + ControladorServicio.obtenerCarreraJSON(notaPromedioJSON,this));
    }

}


