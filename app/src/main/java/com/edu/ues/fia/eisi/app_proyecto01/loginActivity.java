package com.edu.ues.fia.eisi.app_proyecto01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class loginActivity extends AppCompatActivity {
    ControlBDActividades helper;
    EditText nombreusario, password;
    Button Iniciarseion;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login2);
        helper = new ControlBDActividades(this);
        nombreusario = findViewById(R.id.NombresuarioLogin);
        password = findViewById(R.id.clave);
        Iniciarseion = findViewById(R.id.btn_InicioSesion);

        Iniciarseion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                helper.abrir();
                String a = nombreusario.getText().toString();
                USUARIO usua = helper.consultarUsuario(a);
               // String idusuario=usua.getIDUSUARIO();
                //capturo el dato que retorna
                //Evaluo el idusuario con la tabla accesoUsuario para retornar el opcioncrud y ponerlo en inpuyt extra
                //ACCESOUSUARIO idUSUARIO= helper.consultarAccesoUsuario(idusuario);
                if (usua!=null){
                    String respB = usua.getNOMUSUARIO();
                    //captura del id usuario dado el nombre
                    String idusuario=usua.getIDUSUARIO();
                    //Evaluamos el id que exista en la tabla accesoUsuario y retornamos
                    ACCESOUSUARIO acceso = helper.consultarACCESOUSUARIO(idusuario);
                    //almacenamos el idOpcion
                    String opcionCrud= acceso.getIDOPCION();
                   // Integer respRo = usua.getIdRol();

                    String contra = usua.getCLAVE();
                    String compPas = password.getText().toString();


                    if (nombreusario.getText().toString().equals(respB)&&contra.equals(compPas)) {
                        Intent intent = new Intent(loginActivity.this, MainActivity.class);
                        //intent.putExtra("Rol",respRo);
                        intent.putExtra("OpcionCrud",opcionCrud);
                        startActivity(intent);
                    }

                    else {
                        Toast.makeText(getApplicationContext(),"ERROR",Toast.LENGTH_LONG).show();
                    }

                }
                else {
                    Toast.makeText(getApplicationContext(),"ERROR",Toast.LENGTH_LONG).show();
                }

                // Intent intent = new Intent(loginActivity.this, MainActivity.class);
                //startActivity(intent);
            }
        });
    }
}