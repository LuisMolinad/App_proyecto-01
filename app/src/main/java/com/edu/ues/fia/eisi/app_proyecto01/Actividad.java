package com.edu.ues.fia.eisi.app_proyecto01;

import java.util.Date;

public class Actividad {
    private String idActividad;
    private String idMiembroUniversitario;
    private String nombreActividad;
    private String fechaReserva;
    private String desdeActividad;
    private String hastaActividad;
    private int aprobado;

    public Actividad(){}

    public Actividad(String idActividad, String idMiembroUniversitario, String nombreActividad, String fechaReserva, String desdeActividad, String hastaActividad, int aprobado){
        idActividad = this.idActividad;
        idMiembroUniversitario = this.idMiembroUniversitario;
        nombreActividad = this.nombreActividad;
        fechaReserva = this.fechaReserva;
        desdeActividad = this.desdeActividad;
        hastaActividad = this.hastaActividad;
        aprobado = this.aprobado;
    }

    public String getIdActividad() {
        return idActividad;
    }

    public void setIdActividad(String idActividad) {
        this.idActividad = idActividad;
    }

    public String getIdMiembroUniversitario() {
        return idMiembroUniversitario;
    }

    public void setIdMiembroUniversitario(String idMiembroUniversitario) {
        this.idMiembroUniversitario = idMiembroUniversitario;
    }

    public String getNombreActividad() {
        return nombreActividad;
    }

    public void setNombreActividad(String nombreActividad) {
        this.nombreActividad = nombreActividad;
    }


    public int getAprobado() {
        return aprobado;
    }

    public void setAprobado(int aprobado) {
        this.aprobado = aprobado;
    }

    public String getFechaReserva() {
        return fechaReserva;
    }

    public void setFechaReserva(String fechaReserva) {
        this.fechaReserva = fechaReserva;
    }

    public String getDesdeActividad() {
        return desdeActividad;
    }

    public void setDesdeActividad(String desdeActividad) {
        this.desdeActividad = desdeActividad;
    }

    public String getHastaActividad() {
        return hastaActividad;
    }

    public void setHastaActividad(String hastaActividad) {
        this.hastaActividad = hastaActividad;
    }
}