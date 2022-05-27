package com.edu.ues.fia.eisi.app_proyecto01;

public class USUARIO {
    public String getIDUSUARIO() {
        return IDUSUARIO;
    }

    public void setIDUSUARIO(String IDUSUARIO) {
        this.IDUSUARIO = IDUSUARIO;
    }

    public String getNOMUSUARIO() {
        return NOMUSUARIO;
    }

    public void setNOMUSUARIO(String NOMUSUARIO) {
        this.NOMUSUARIO = NOMUSUARIO;
    }

    public String getCLAVE() {
        return CLAVE;
    }

    public void setCLAVE(String CLAVE) {
        this.CLAVE = CLAVE;
    }

    public String getTIPOUSUARIO() {
        return TIPOUSUARIO;
    }

    public void setTIPOUSUARIO(String TIPOUSUARIO) {
        this.TIPOUSUARIO = TIPOUSUARIO;
    }

    public USUARIO(String IDUSUARIO, String NOMUSUARIO, String CLAVE, String TIPOUSUARIO) {
        this.IDUSUARIO = IDUSUARIO;
        this.NOMUSUARIO = NOMUSUARIO;
        this.CLAVE = CLAVE;
        this.TIPOUSUARIO = TIPOUSUARIO;
    }

    public USUARIO() {
    }

    String IDUSUARIO, NOMUSUARIO, CLAVE, TIPOUSUARIO;

}
