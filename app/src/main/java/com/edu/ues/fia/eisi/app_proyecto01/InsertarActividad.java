package com.edu.ues.fia.eisi.app_proyecto01;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.ToggleButton;


public class InsertarActividad extends AppCompatActivity {

    ControlBDActividades helper;

    FECHA reserva = new FECHA(), desde = new FECHA(), hasta = new FECHA(), fecha = new FECHA();
    EditText idActividad, idMiembroUniversitario, nombreActividad;
    EditText diaReserva, mesReserva, anioReserva;
    EditText diaDesde, mesDesde, anioDesde;
    EditText diaHasta, mesHasta, anioHasta;
    ToggleButton aprobado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insertar_actividad);

        helper = new ControlBDActividades(this);

        //Iniciando variables
        idActividad = findViewById(R.id.idActividad);
        idMiembroUniversitario = findViewById(R.id.idMiembroUniversitario);
        nombreActividad = findViewById(R.id.nombreActividad);
        aprobado = findViewById(R.id.aprobado);
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

    public void insertarActividad(View v){

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
                String regInsertados;

                Actividad actividad = new Actividad();
                actividad.setIdActividad(id_actividad);
                actividad.setNombreActividad(nombre_actividad);
                actividad.setIdMiembroUniversitario(id_miembro_universitario);
                actividad.setFechaReserva(fecha_reserva);
                actividad.setDesdeActividad(fecha_desde);
                actividad.setHastaActividad(fecha_hasta);
                actividad.setAprobado(_aprobado);

                helper.abrir();
                regInsertados = helper.insertarActividad(actividad);
                helper.cerrar();
                Toast.makeText(this, regInsertados, Toast.LENGTH_SHORT).show();
            }
        }
        else{
            Toast.makeText(this, validadorDeFechas, Toast.LENGTH_SHORT).show();
        }
    }

    public String capturaInformacionToggleButton(ToggleButton toggle){
        if(toggle.isChecked()){
            return "Si";
        }
        else {
            return "No";
        }
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
}