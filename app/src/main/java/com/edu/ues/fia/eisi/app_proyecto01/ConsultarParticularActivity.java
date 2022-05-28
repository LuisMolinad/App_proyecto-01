package com.edu.ues.fia.eisi.app_proyecto01;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ConsultarParticularActivity extends AppCompatActivity {

    ControlBDActividades helper;
    EditText idParticular;
    TextView txtidUsuario, txtnombreParticular, txtapellidoParticular;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consultar_particular);

        //Iniciamos la base de datos
        helper = new ControlBDActividades(this);

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
            helper.abrir();
            Particular particular = helper.consultarParticular(id_particular);
            helper.cerrar();

            if(particular == null){
                Toast.makeText(this, "Error no se ha encontrado un particular con el id "+id_particular+", favor intente de nuevo", Toast.LENGTH_SHORT).show();
            }
            else{
                txtidUsuario.setText("Id usuario: " + particular.getIDPUSUARIO().toString());
                txtnombreParticular.setText("Nombre: "+particular.getNOMBREPARTICULAR().toString());
                txtapellidoParticular.setText("Apellido: "+particular.getAPELLIDOPARTICULAR().toString());
            }
        }
    }
}
