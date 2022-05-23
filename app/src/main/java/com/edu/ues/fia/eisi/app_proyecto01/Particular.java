package com.edu.ues.fia.eisi.app_proyecto01;

public class Particular {
    private String idParticular;
    private String idUsuario;
    private String nombreParticular;
    private String apellidoParticular;

    public Particular(){}

    public Particular(String idParticular, String idUsuario, String nombreParticular, String apellidoParticular) {
        this.idParticular = idParticular;
        this.idUsuario = idUsuario;
        this.nombreParticular = nombreParticular;
        this.apellidoParticular = apellidoParticular;
    }


    public String getIdParticular() {
        return idParticular;
    }

    public void setIdParticular(String idParticular) {
        this.idParticular = idParticular;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombreParticular() {
        return nombreParticular;
    }

    public void setNombreParticular(String nombreParticular) {
        this.nombreParticular = nombreParticular;
    }

    public String getApellidoParticular() {
        return apellidoParticular;
    }

    public void setApellidoParticular(String apellidoParticular) {
        this.apellidoParticular = apellidoParticular;
    }
}