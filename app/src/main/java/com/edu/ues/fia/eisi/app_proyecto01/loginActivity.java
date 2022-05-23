package com.edu.ues.fia.eisi.app_proyecto01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class loginActivity extends AppCompatActivity {
    ControlBDActividades helper;
    EditText nombreusario, password;
    Button Iniciarseion;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login2);
        nombreusario = findViewById(R.id.NombresuarioLogin);
        password = findViewById(R.id.clave);
        Iniciarseion = findViewById(R.id.btn_InicioSesion);

        Iniciarseion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(loginActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}