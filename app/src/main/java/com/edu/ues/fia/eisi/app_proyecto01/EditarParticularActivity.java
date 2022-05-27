package com.edu.ues.fia.eisi.app_proyecto01;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class EditarParticularActivity extends AppCompatActivity {

    ControlBDActividades helper;
    EditText idParticular, idUsuario, nombreParticular, apellidoParticular;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_particular);

        //Iniciar base de datos
        helper = new ControlBDActividades(this);

        idParticular = findViewById(R.id.idParticular);
        idUsuario = findViewById(R.id.idUsuario);
        nombreParticular = findViewById(R.id.nombreParticular);
        apellidoParticular = findViewById(R.id.apellidoParticular);
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
                idUsuario.setText(particular.getIDPUSUARIO().toString());
                nombreParticular.setText(particular.getNOMBREPARTICULAR().toString());
                apellidoParticular.setText(particular.getAPELLIDOPARTICULAR().toString());
            }
        }
    }

    public void actualizarParticular(View v){
        String id_particular = idParticular.getText().toString();
        String id_usuario = idUsuario.getText().toString();
        String nombre_particular = nombreParticular.getText().toString();
        String apellido_particular = apellidoParticular.getText().toString();

        //Validar que no este vacio
        if(id_particular.isEmpty() || id_usuario.isEmpty() || nombre_particular.isEmpty() || apellido_particular.isEmpty()){
            Toast.makeText(this, "Todos los campos tiene que estar llenos", Toast.LENGTH_SHORT).show();
        }
        else {
            String regActualizados;

            Particular particular = new Particular();

            particular.setIDPARTICULAR(id_particular);
            particular.setIDPUSUARIO(id_usuario);
            particular.setNOMBREPARTICULAR(nombre_particular);
            particular.setAPELLIDOPARTICULAR(apellido_particular);

            helper.abrir();
            regActualizados = helper.actualizarParticular(particular);
            helper.cerrar();

            Toast.makeText(this, regActualizados, Toast.LENGTH_SHORT).show();
        }
    }
}