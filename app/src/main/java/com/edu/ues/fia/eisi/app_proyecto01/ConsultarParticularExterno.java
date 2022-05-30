package com.edu.ues.fia.eisi.app_proyecto01;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@SuppressLint("NewApi")
public class ConsultarParticularExterno extends AppCompatActivity {

    EditText idParticular;
    TextView txtidUsuario, txtnombreParticular, txtapellidoParticular;

    RequestQueue requestQueue;
    String url;

    private final String urlLocal = "http://192.168.1.8/Proyecto01Servicios/Particular/ws_query_particular.php";

    @SuppressLint("NewApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consultar_particular_externo);

        //Cargamos los ids
        idParticular = findViewById(R.id.idParticular);
        txtidUsuario = findViewById(R.id.txtIdUsuario);
        txtnombreParticular = findViewById(R.id.txtNombreParticular);
        txtapellidoParticular = findViewById(R.id.txtApellidoParticular);
    }

    public void consultarParticular(View v){
        String id_particular = idParticular.getText().toString();

        if(id_particular == null){
            Toast.makeText(this, "Error, ingrese un id del particular", Toast.LENGTH_SHORT).show();
        }
        else {
            url = urlLocal + "?IDPARTICULAR=" + id_particular;

            ejecutarJSON(url);
        }
    }

    public void ejecutarJSON(String url){

        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(url, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                JSONObject jsonObject = null;
                for (int i = 0; i < response.length(); i++) {
                    try {
                        jsonObject = response.getJSONObject(i);
                        txtidUsuario.setText("Id usuario: "+jsonObject.getString("IDUSUARIO"));
                        txtnombreParticular.setText("Nombre: "+jsonObject.getString("NOMBREPARTICULAR"));
                        txtapellidoParticular.setText("Apellido: "+jsonObject.getString("APELLIDOPARTICULAR"));
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