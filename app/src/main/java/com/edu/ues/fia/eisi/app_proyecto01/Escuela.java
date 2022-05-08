package com.edu.ues.fia.eisi.app_proyecto01;

public class Escuela {
    public Escuela() {
    }

    public Escuela(String IDESCUELA, String IDCARRERA, String NOMBRE_ESCUELA) {
        this.IDESCUELA = IDESCUELA;
        this.IDCARRERA = IDCARRERA;
        this.NOMBRE_ESCUELA = NOMBRE_ESCUELA;
    }

    public String getIDESCUELA() {
        return IDESCUELA;
    }

    public void setIDESCUELA(String IDESCUELA) {
        this.IDESCUELA = IDESCUELA;
    }

    public String getIDCARRERA() {
        return IDCARRERA;
    }

    public void setIDCARRERA(String IDCARRERA) {
        this.IDCARRERA = IDCARRERA;
    }

    public String getNOMBRE_ESCUELA() {
        return NOMBRE_ESCUELA;
    }

    public void setNOMBRE_ESCUELA(String NOMBRE_ESCUELA) {
        this.NOMBRE_ESCUELA = NOMBRE_ESCUELA;
    }

    private String IDESCUELA, IDCARRERA, NOMBRE_ESCUELA  ;
}
