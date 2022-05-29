package com.edu.ues.fia.eisi.app_proyecto01;

import android.annotation.SuppressLint;
import android.database.Cursor;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import org.json.JSONObject;

import java.util.ArrayList;

@SuppressLint("NewApi")
public class InsertarEscuelaExterno extends AppCompatActivity {
    ControlBDActividades helper;
    EditText idescuela, nombreescuela;
    Spinner spinneridCarrera;
    ArrayList<String> fkIdCarrera=new ArrayList<String>();
    ArrayAdapter<String> adapter;

    private final String urlLocal = "http://192.168.0.3/Proyecto1.2/ws_escuela_insert.php";
    @SuppressLint("NewApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insertar_escuela_externo);

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        helper = new ControlBDActividades(this);
        spinneridCarrera = findViewById(R.id.spinneridCarreraInsertarExterno);
        idescuela= findViewById(R.id.idEscuelaInsertarExterno);
        nombreescuela = findViewById(R.id.nombreEscuelaInsertarExterna);

        llenarSpinnerFKIdCarrera();

    }

    public void insertarEscuelaEXTERNO(View v) {
        String IDESCUELA = idescuela.getText().toString();
        String fkidCarrera = spinneridCarrera.getSelectedItem().toString();
        String NOMBRE_ESCUELA = nombreescuela.getText().toString();
        if (IDESCUELA.isEmpty()&& NOMBRE_ESCUELA.isEmpty())
        {
            Toast.makeText(this,"Campos vacios",Toast.LENGTH_SHORT).show();
        }
        else {
            String url = null;
            JSONObject datosNota = new JSONObject();
            JSONObject nota = new JSONObject();
            switch (v.getId()) {
                case R.id.botonguardarEscuelaExterno:
                    url = urlLocal+ "?IDESCUELA=" + IDESCUELA +"&IDCARRERA="+fkidCarrera+ "&NOMBRE_ESCUELA=" + NOMBRE_ESCUELA ;
                    ControladorServicio.insertar(url, this);
                    break;

            }
        }

    }

    public void llenarSpinnerFKIdCarrera(){
        //declaramos un nuevo adaptador que sera llenado por la nd
        adapter=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,fkIdCarrera);
        //
        final ControlBDActividades db=new ControlBDActividades(this);
        //abrimos la bd
        db.abrir();
        //Cargar lso datos a spinner
        Cursor c=db.getAllValuesIdCARRERA();
        while(c.moveToNext())
        {
            String name=c.getString(0);
            //captura los id que luego llenan el adaptador
            fkIdCarrera.add(name);
        }
        //CLOSE
        db.cerrar();
        //SET IT TO SPINNER
        spinneridCarrera.setAdapter(adapter);
    }
}