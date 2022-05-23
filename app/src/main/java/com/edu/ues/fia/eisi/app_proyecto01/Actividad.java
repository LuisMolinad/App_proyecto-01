package com.edu.ues.fia.eisi.app_proyecto01;

import java.util.Date;

public class Actividad {
    private String idActividad;
    private String idMiembroUniversitario;
    private String nombreActividad;
    private Date fechaReserva;
    private Date desdeActividad;
    private Date hastaActividad;
    private int aprobado;

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

    public Date getFechaReserva() {
        return fechaReserva;
    }

    public void setFechaReserva(Date fechaReserva) {
        this.fechaReserva = fechaReserva;
    }

    public Date getDesdeActividad() {
        return desdeActividad;
    }

    public void setDesdeActividad(Date desdeActividad) {
        this.desdeActividad = desdeActividad;
    }

    public Date getHastaActividad() {
        return hastaActividad;
    }

    public void setHastaActividad(Date hastaActividad) {
        this.hastaActividad = hastaActividad;
    }

    public int getAprobado() {
        return aprobado;
    }

    public void setAprobado(int aprobado) {
        this.aprobado = aprobado;
    }
}