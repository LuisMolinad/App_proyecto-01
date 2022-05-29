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
public class ConsultarEscuelaExterno extends AppCompatActivity {
    static List<Escuela> listaMaterias;
    static List<String> nombreMaterias;
    EditText fechaTxt;
    ListView listViewMaterias;
    private final String urlLocal = "http://192.168.0.3/Proyecto1.2/ws_escuela_query.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consultar_escuela_externo);
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()
                .permitAll().build();
        StrictMode.setThreadPolicy(policy);

        listaMaterias = new ArrayList<Escuela>();
        nombreMaterias = new ArrayList<String>();
        fechaTxt = (EditText) findViewById(R.id.idEscuelaConsultarExterno);
        listViewMaterias = (ListView) findViewById(R.id.listView1);
    }

    public void servicioPHP(View v) {
        String fecha = fechaTxt.getText().toString();
        String url = "";
        switch (v.getId()) {
            case R.id.consultarEscuelaExterno:
                // it was the first button
                url = urlLocal + "?IDESCUELA=" + fecha;
                break;

        }
        String materiasExternas =
                ControladorServicio.obtenerRespuestaPeticion(url, this);
        try {

            listaMaterias.addAll(ControladorServicio.obtenerEscuelaExterno(materiasExternas, this));
            actualizarListView();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private void actualizarListView() {
        String dato = "";
        nombreMaterias.clear();
        for (int i = 0; i < listaMaterias.size(); i++) {
            dato = listaMaterias.get(i).getIDESCUELA() + " " + listaMaterias.get(i).getIDCARRERA() +" " + listaMaterias.get(i).getNOMBRE_ESCUELA();
            nombreMaterias.add(dato);
        }
        eliminarElementosDuplicados();
        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, nombreMaterias);
        listViewMaterias.setAdapter(adaptador);
    }
    private void eliminarElementosDuplicados() {
        HashSet<Escuela> conjuntoMateria = new HashSet<Escuela>();
        conjuntoMateria.addAll(listaMaterias);
        listaMaterias.clear();
        listaMaterias.addAll(conjuntoMateria);
        HashSet<String> conjuntoNombre = new HashSet<String>();
        conjuntoNombre.addAll(nombreMaterias);
        nombreMaterias.clear();
        nombreMaterias.addAll(conjuntoNombre);
    }

}