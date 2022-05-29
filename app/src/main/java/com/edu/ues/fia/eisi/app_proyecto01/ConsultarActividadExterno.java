package com.edu.ues.fia.eisi.app_proyecto01;

import static android.provider.ContactsContract.CommonDataKinds.Website.URL;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

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


@SuppressLint("NewApi")
public class ConsultarActividadExterno extends AppCompatActivity {

    EditText idActividad;
    TextView txtIdMiembroUniversitario, txtNombreActividad, txtFechaReserva, txtDesdeActividad, txtHastaActividad, txtAprobado;
    RequestQueue requestQueue;

    private final String urlLocal = "http://192.168.1.8/Proyecto01Servicios/Actividad/ws_query_actividad.php";

    @SuppressLint("NewApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consultar_actividad_externo);

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()
                .permitAll().build();
        StrictMode.setThreadPolicy(policy);

        //Cargamos los ids
        idActividad = findViewById(R.id.idActividadE);
        txtIdMiembroUniversitario = findViewById(R.id.txtMiembroUniversitario);
        txtNombreActividad = findViewById(R.id.txtNombreActividad);
        txtFechaReserva = findViewById(R.id.txtFecha);
        txtDesdeActividad = findViewById(R.id.txtDesdeActividad);
        txtHastaActividad = findViewById(R.id.txtHastaActividad);
        txtAprobado = findViewById(R.id.txtAprobado);

    }

    /*
    public void ejecutarServicios(String url){
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Toast.makeText(getApplicationContext(), "Operacion exitosa", Toast.LENGTH_SHORT).show();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(), error.getMessage().toString(), Toast.LENGTH_SHORT).show();
            }
        }
        ){
          @Override
          protected Map<String, String> getParams() throws AuthFailureError{
              Map <String, String> parametros = new HashMap<String, String>();

              return parametros;
          }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }*/

    public void consultarActividadExterno(View v){
        String url;
        String id_actividad = idActividad.getText().toString();
        if(id_actividad == null){
            Toast.makeText(this, "Favor ingresar el campo del id", Toast.LENGTH_SHORT).show();
        }
        else{
            url = urlLocal + "?IDACTIVIDAD="+id_actividad;

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
                        txtIdMiembroUniversitario.setText("Id miembro universitario: "+jsonObject.getString("IDMIEMBROUNIVERSITARIO"));
                        txtNombreActividad.setText("Nombre actividad: "+jsonObject.getString("NOMBREACTIVIDAD"));
                        txtFechaReserva.setText("Fecha reserva: "+jsonObject.getString("FECHARESERVA"));
                        txtDesdeActividad.setText("Desde: "+jsonObject.getString("DESDEACTIVIDAD"));
                        txtHastaActividad.setText("Hasta: "+jsonObject.getString("HASTAACTIVIDAD"));
                        txtAprobado.setText("Aprobado: "+jsonObject.getString("APROBADO"));
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
}