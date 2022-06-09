package com.edu.ues.fia.eisi.app_proyecto01;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class EditarActividadExterno extends AppCompatActivity {

    FECHA reserva = new FECHA(), desde = new FECHA(), hasta = new FECHA(), fecha = new FECHA();
    EditText idActividad, idMiembroUniversitario, nombreActividad;
    EditText diaReserva, mesReserva, anioReserva;
    EditText diaDesde, mesDesde, anioDesde;
    EditText diaHasta, mesHasta, anioHasta;
    ToggleButton aprobado;
    TextView txtAprobado;

    RequestQueue requestQueue;

    //private final String urlLocal = "http://192.168.1.8/Proyecto01Servicios/Actividad/ws_query_actividad.php";
    //private final String urlUpdate = "http://192.168.1.8/Proyecto01Servicios/Actividad/ws_update_actividad.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_actividad_externo);

        //Iniciando variables
        idActividad = findViewById(R.id.idActividad);
        idMiembroUniversitario = findViewById(R.id.idMiembroUniversitario);
        nombreActividad = findViewById(R.id.nombreActividad);
        aprobado = findViewById(R.id.aprobado);
        txtAprobado = findViewById(R.id.txtAprobado);
        //Reserva
        diaReserva = findViewById(R.id.diaFechaReserva);
        mesReserva = findViewById(R.id.mesFechaReserva);
        anioReserva = findViewById(R.id.anioFechaReserva);
        //Desde
        diaDesde = findViewById(R.id.diaDesde);
        mesDesde = findViewById(R.id.mesDesde);
        anioDesde = findViewById(R.id.anioDesde);
        //Hasta
        diaHasta = findViewById(R.id.diaHasta);
        mesHasta = findViewById(R.id.mesHasta);
        anioHasta = findViewById(R.id.anioHasta);
    }

    public void actualizarActividadExterno(View v){

        String validadorDeFechas = validarFechas();

        if(validadorDeFechas == null){
            String id_actividad = idActividad.getText().toString();
            String id_miembro_universitario = idMiembroUniversitario.getText().toString();
            String nombre_actividad = nombreActividad.getText().toString();
            String fecha_reserva = reserva.toString();
            String fecha_desde = desde.toString();
            String fecha_hasta = hasta.toString();
            String _aprobado =  capturaInformacionToggleButton(aprobado);

            if(id_actividad.isEmpty() || id_miembro_universitario.isEmpty() || nombre_actividad.isEmpty() ){
                Toast.makeText(this, "Error, no debe dejar campos vacios", Toast.LENGTH_SHORT).show();
            }
            else {
                String url = Rutas.update("Actividad") + "?IDACTIVIDAD="+id_actividad+"&IDMIEMBROUNIVERSITARIO="+id_miembro_universitario+"&NOMBREACTIVIDAD="+nombre_actividad+"&FECHARESERVA="+fecha_reserva+"&DESDEACTIVIDAD="+fecha_desde+"&HASTAACTIVIDAD="+fecha_hasta+"&APROBADO="+_aprobado;
                JSONObject datosActividad = new JSONObject();
                switch (v.getId()){
                    case R.id.actualizar:
                        ejecutar(url);
                        break;
                }
            }
        }
        else{
            Toast.makeText(this, validadorDeFechas, Toast.LENGTH_SHORT).show();
        }
    }

    public void consultarActividadExternoA(View v){
        String url;
        String id_actividad = idActividad.getText().toString();
        if(id_actividad == null){
            Toast.makeText(this, "Favor ingresar el campo del id", Toast.LENGTH_SHORT).show();
        }
        else{
            url = Rutas.query("Actividad") + "?IDACTIVIDAD="+id_actividad;

            buscarActividadExterno(url);
        }
    }

    public void buscarActividadExterno(String url){

        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(url, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                JSONObject jsonObject = null;
                for (int i = 0; i < response.length(); i++) {
                    try {

                        jsonObject = response.getJSONObject(i);
                        idMiembroUniversitario.setText(jsonObject.getString("IDMIEMBROUNIVERSITARIO"));
                        nombreActividad.setText(jsonObject.getString("NOMBREACTIVIDAD"));
                        //Settear la fecha
                        reserva = fecha.parseFecha(jsonObject.getString("FECHARESERVA"));
                        desde = fecha.parseFecha(jsonObject.getString("DESDEACTIVIDAD"));
                        hasta = fecha.parseFecha(jsonObject.getString("HASTAACTIVIDAD"));

                        //Reserva
                        diaReserva.setText(Integer.toString(reserva.getDia()));
                        mesReserva.setText(Integer.toString(reserva.getMes()));
                        anioReserva.setText(Integer.toString(reserva.getAnio()));

                        //Desde
                        diaDesde.setText(Integer.toString(desde.getDia()));
                        mesDesde.setText(Integer.toString(desde.getMes()));
                        anioDesde.setText(Integer.toString(desde.getAnio()));

                        //Hasta
                        diaHasta.setText(Integer.toString(hasta.getDia()));
                        mesHasta.setText(Integer.toString(hasta.getMes()));
                        anioHasta.setText(Integer.toString(hasta.getAnio()));

                        String variable = jsonObject.getString("APROBADO");
                        boolean var = devolverInformacionToggleButton(variable);
                        aprobado.setChecked(var);
                    } catch (JSONException e) {
                        Toast.makeText(getApplicationContext(), e.getMessage().toString(), Toast.LENGTH_SHORT).show();
                    }
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(), error.getMessage().toString(), Toast.LENGTH_SHORT).show();
            }
        });
        requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(jsonArrayRequest);
    }

    public String capturaInformacionToggleButton(ToggleButton toggle){
        if(toggle.isChecked()){
            return "Si";
        }
        else {
            return "No";
        }
    }

    public boolean devolverInformacionToggleButton(String aprobados){
        boolean variable = false;
        String si = "Si";
        if(aprobados.equals(si)){
            variable = true;
        }
        else if(aprobados == "No") {
            variable = false;
        }

        return variable;
    }

    public String validarFechas(){

        String validador = "";

        //Pasamos todo esto a la clase fecha
        if(diaReserva.getText().toString().isEmpty() || mesReserva.getText().toString().isEmpty() || anioReserva.getText().toString().isEmpty() ||
                diaDesde.getText().toString().isEmpty() || mesDesde.getText().toString().isEmpty() ||anioDesde.getText().toString().isEmpty() ||
                diaHasta.getText().toString().isEmpty() || mesHasta.getText().toString().isEmpty() ||anioHasta.getText().toString().isEmpty()
        ){
            validador = "Favor llenar todos los campos de fecha";
            return validador;
        }
        else{

            reserva.setDia(Integer.parseInt(diaReserva.getText().toString()));
            reserva.setMes(Integer.parseInt(mesReserva.getText().toString()));
            reserva.setAnio(Integer.parseInt(anioReserva.getText().toString()));

            desde.setDia(Integer.parseInt(diaDesde.getText().toString()));
            desde.setMes(Integer.parseInt(mesDesde.getText().toString()));
            desde.setAnio(Integer.parseInt(anioDesde.getText().toString()));

            hasta.setDia(Integer.parseInt(diaHasta.getText().toString()));
            hasta.setMes(Integer.parseInt(mesHasta.getText().toString()));
            hasta.setAnio(Integer.parseInt(anioHasta.getText().toString()));

            if(fecha.validarFecha(reserva) == false){
                validador = "Favor ingresar una fecha valida en el campo de  \"Reserva Fecha\"";
                return validador;
            }
            else if(fecha.validarFecha(desde) == false){
                validador = "Favor ingresar una fecha valida en el campo de \"Desde Actividad\"";
                return validador;
            }
            else if(fecha.validarFecha(hasta) == false){
                validador = "Favor ingresar una fecha valida en el campo de \"Hasta Actividad\"";
                return validador;
            }
            else {
                return null;
            }
        }
    }

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
                parametro.put("IDACTIVIDAD", idActividad.getText().toString());
                parametro.put("IDMIEMBROUNIVERSITARIO", idMiembroUniversitario.getText().toString());
                parametro.put("NOMBREACTIVIDAD", nombreActividad.getText().toString());
                parametro.put("FECHARESERVA", fecha.toString());
                parametro.put("DESDEACTIVIDAD", desde.toString());
                parametro.put("HASTAACTIVIDAD", hasta.toString());
                parametro.put("APROBADO", aprobado.getText().toString());

                return parametro;
            }
        };

        requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }
}