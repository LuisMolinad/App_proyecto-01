package com.edu.ues.fia.eisi.app_proyecto01;

public class Asistencia {
    private String idAsistencia;
    private int idDetalle;
    private String idMiembroUniversitario;
    private  int califacion;

    public Asistencia(){}

    public Asistencia(String idAsistencia, int idDetalle, String idMiembroUniversitario, int califacion) {
        this.idAsistencia = idAsistencia;
        this.idDetalle = idDetalle;
        this.idMiembroUniversitario = idMiembroUniversitario;
        this.califacion = califacion;
    }


    public String getIdAsistencia() {
        return idAsistencia;
    }

    public void setIdAsistencia(String idAsistencia) {
        this.idAsistencia = idAsistencia;
    }

    public int getIdDetalle() {
        return idDetalle;
    }

    public void setIdDetalle(int idDetalle) {
        this.idDetalle = idDetalle;
    }

    public String getIdMiembroUniversitario() {
        return idMiembroUniversitario;
    }

    public void setIdMiembroUniversitario(String idMiembroUniversitario) {
        this.idMiembroUniversitario = idMiembroUniversitario;
    }

    public int getCalifacion() {
        return califacion;
    }

    public void setCalifacion(int califacion) {
        this.califacion = califacion;
    }
}