package com.edu.ues.fia.eisi.app_proyecto01;

public class ACCESOUSUARIO {
    public ACCESOUSUARIO(String IDUSUARIO, String IDOPCION) {
        this.IDUSUARIO = IDUSUARIO;
        this.IDOPCION = IDOPCION;
    }

    public ACCESOUSUARIO() {
    }

    String IDUSUARIO,IDOPCION;

    public String getIDUSUARIO() {
        return IDUSUARIO;
    }

    public void setIDUSUARIO(String IDUSUARIO) {
        this.IDUSUARIO = IDUSUARIO;
    }

    public String getIDOPCION() {
        return IDOPCION;
    }

    public void setIDOPCION(String IDOPCION) {
        this.IDOPCION = IDOPCION;
    }
}
