package com.edu.ues.fia.eisi.app_proyecto01;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

public class EditarActividad extends AppCompatActivity {

    ControlBDActividades helper;

    FECHA reserva = new FECHA(), desde = new FECHA(), hasta = new FECHA(), fecha = new FECHA();
    EditText idActividad, idMiembroUniversitario, nombreActividad;
    EditText diaReserva, mesReserva, anioReserva;
    EditText diaDesde, mesDesde, anioDesde;
    EditText diaHasta, mesHasta, anioHasta;
    ToggleButton aprobado;
    TextView txtAprobado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_actividad);

        helper = new ControlBDActividades(this);

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

    public void consultarActividad(View v){
        String id_actividad = idActividad.getText().toString();


        if(id_actividad == null){
            Toast.makeText(this, "Error, ingrese un id de la actividad", Toast.LENGTH_SHORT).show();
        }
        else {
            helper.abrir();
            Actividad actividad = helper.consultarActividad(id_actividad);
            helper.cerrar();

            if(actividad == null){
                Toast.makeText(this, "Error, no se encontro la actividad", Toast.LENGTH_SHORT).show();
            }
            else {

                //Settear la fecha
                reserva = fecha.parseFecha(actividad.getFechaReserva());
                desde = fecha.parseFecha(actividad.getDesdeActividad());
                hasta = fecha.parseFecha(actividad.getHastaActividad());

                idMiembroUniversitario.setText(actividad.getIdMiembroUniversitario());
                nombreActividad.setText(actividad.getNombreActividad());

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

                String variable = actividad.getAprobado();
                boolean var = devolverInformacionToggleButton(variable);
                aprobado.setChecked(var);
            }
        }
    }

    public void actualizarActividad(View v){

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
                regInsertados = helper.actualizarActividad(actividad);
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
}