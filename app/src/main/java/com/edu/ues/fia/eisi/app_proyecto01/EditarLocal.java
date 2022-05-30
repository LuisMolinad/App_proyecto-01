package com.edu.ues.fia.eisi.app_proyecto01;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.ThemedSpinnerAdapter;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class EditarLocal extends AppCompatActivity {

    ControlBDActividades helper;
    EditText idLocal,cupo;
    TextView idNombreLocal;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_local);

        helper = new ControlBDActividades(this);

        //Cargamos los ids
        idLocal = findViewById(R.id.idLocal);
        idNombreLocal = findViewById(R.id.idNombreLocal);
        cupo = findViewById(R.id.cupoEditar);
    }
    public void consultarLocalEditar(View v){
        String id_local = idLocal.getText().toString();

        if(id_local == null){
            Toast.makeText(this, "Error, ingrese un id del horario", Toast.LENGTH_SHORT).show();
        }
        else {
            helper.abrir();
            Local local = helper.consultarLocal(id_local);
            helper.cerrar();

            if(local == null){
                Toast.makeText(this, "Error no se ha encontrado el local con el id "+id_local+", favor intente de nuevo", Toast.LENGTH_SHORT).show();
            }
            else{
                //idLocal.setText(local.getIDLOCAL());
                idNombreLocal.setText(local.getNOMBRELOCAL());
                cupo.setText(local.getCUPO());

            }
        }
    }
    public void actualizarLocal(View v){

        String id_local = idLocal.getText().toString();
        String id_nombreLocal = idNombreLocal.getText().toString();
        String id_cupo = cupo.getText().toString();


        if(id_local.isEmpty() ||  id_nombreLocal.isEmpty() ||  id_cupo.isEmpty()){
            Toast.makeText(this, "Todos los campos tiene que estar llenos", Toast.LENGTH_SHORT).show();
        }
        else {
            String regActualizados;

            Local local = new Local();

            local.setIDLOCAL(id_local);
            local.setNOMBRELOCAL(id_nombreLocal);
            local.setCUPO(Integer.parseInt(id_cupo));

            helper.abrir();
            regActualizados = helper.actualizarLocal(local);
            helper.cerrar();

            Toast.makeText(this, regActualizados, Toast.LENGTH_SHORT).show();
        }
    }
}