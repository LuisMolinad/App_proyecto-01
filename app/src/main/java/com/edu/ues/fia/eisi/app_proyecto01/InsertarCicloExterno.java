package com.edu.ues.fia.eisi.app_proyecto01;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

@SuppressLint("NewApi")
public class InsertarCicloExterno extends AppCompatActivity {
    EditText idCiclo,fechaInicio,fechaFin,anio;
    Spinner comboNumeroCiclo;
    RequestQueue requestQueue;
    String url;
    private final String urlLocal="http://192.168.1.5/Proyecto01Servicios/ciclo/ws_insert_ciclo.php";
    @SuppressLint("NewApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insertar_ciclo_externo);
        comboNumeroCiclo=(Spinner) findViewById(R.id.spinnerNumeroCiclo);
        ArrayAdapter<CharSequence> adapter=ArrayAdapter.createFromResource(this,R.array.opcionesNumeroCiclo, android.R.layout.simple_spinner_item);
        comboNumeroCiclo.setAdapter(adapter);
        idCiclo=findViewById(R.id.idCiclo);
        fechaInicio=findViewById(R.id.edtFechaInicio);
        fechaFin=findViewById(R.id.edtFechaFin);
        anio=findViewById(R.id.edtAnio);
    }
    /*                parametro.put("IDCICLO",idCiclo.getText().toString());
                parametro.put("NUMEROCICLO", comboNumeroCiclo.getSelectedItem().toString());
                parametro.put("FECHAINICIO", fechaInicio.getText().toString());
                parametro.put("FECHAFIN", fechaFin.getText().toString());
                parametro.put("ANIO", anio.getText().toString());
                return parametro;
    * */
    public void ejecutar(String URL){
        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Toast.makeText(getApplicationContext(), "Operacion exitosa", Toast.LENGTH_SHORT).show();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(), error.toString(), Toast.LENGTH_SHORT).show();
            }
        }
        ){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> parametro = new HashMap<String, String>();
                //parametro.put("IDACTIVIDAD", idActividad.getText().toString());
                parametro.put("IDCICLO",idCiclo.getText().toString());
                parametro.put("NUMEROCICLO", Integer.toString(Integer.parseInt(comboNumeroCiclo.getSelectedItem().toString())));
                parametro.put("FECHAINICIO", fechaInicio.getText().toString());
                parametro.put("FECHAFIN", fechaFin.getText().toString());
                parametro.put("ANIO", anio.getText().toString());
                return parametro;
            }
        };

        requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }
    public void insertarCicloExterno(View v){
        String id_ciclo = idCiclo.getText().toString();
        String numero_ciclo = comboNumeroCiclo.getSelectedItem().toString();
        String fecha_inicio = fechaInicio.getText().toString();
        String fecha_fin = fechaFin.getText().toString();
        String anio_ciclo = anio.getText().toString();

        //Validar que no este vacio

        if(id_ciclo.isEmpty() || numero_ciclo.isEmpty()||numero_ciclo.equals("Seleccione")|| fecha_inicio.isEmpty() || fecha_fin.isEmpty() || anio_ciclo.isEmpty() ){
            Toast.makeText(this, "Error, no debe dejar campos vacios", Toast.LENGTH_SHORT).show();
        }
        else {

            url = urlLocal + "?IDCICLO=" + id_ciclo + "&NUMEROCICLO=" + numero_ciclo + "&FECHAINICIO=" + fecha_inicio +"&FECHAFIN=" + fecha_fin + "&ANIO=" + anio_ciclo;

            ejecutar(url);

        }
    }
}