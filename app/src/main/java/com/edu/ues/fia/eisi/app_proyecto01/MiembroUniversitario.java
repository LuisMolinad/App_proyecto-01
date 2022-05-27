package com.edu.ues.fia.eisi.app_proyecto01;

public class MiembroUniversitario {

    private String idMiembroUniversitario;
    private String idAsignatura;
    private String idUsuario;
    private String nombreMiembroUniversitario;
    private String tipoMiembro;

    public MiembroUniversitario(String idMiembroUniversitario, String idAsignatura, String idUsuario, String nombreMiembroUniversitario, String tipoMiembro) {
        this.idMiembroUniversitario = idMiembroUniversitario;
        this.idAsignatura = idAsignatura;
        this.idUsuario = idUsuario;
        this.nombreMiembroUniversitario = nombreMiembroUniversitario;
        this.tipoMiembro = tipoMiembro;
    }

    public MiembroUniversitario(){

    }

    public String getIdMiembroUniversitario() {
        return idMiembroUniversitario;
    }

    public void setIdMiembroUniversitario(String idMiembroUniversitario) {
        this.idMiembroUniversitario = idMiembroUniversitario;
    }

    public String getIdAsignatura() {
        return idAsignatura;
    }

    public void setIdAsignatura(String idAsignatura) {
        this.idAsignatura = idAsignatura;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombreMiembroUniversitario() {
        return nombreMiembroUniversitario;
    }

    public void setNombreMiembroUniversitario(String nombreMiembroUniversitario) {
        this.nombreMiembroUniversitario = nombreMiembroUniversitario;
    }

    public String getTipoMiembro() {
        return tipoMiembro;
    }

    public void setTipoMiembro(String tipoMiembro) {
        this.tipoMiembro = tipoMiembro;
    }
}
