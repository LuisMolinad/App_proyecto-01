package com.edu.ues.fia.eisi.app_proyecto01;

public class Carrera {
    private String IDCARRERA, NOMBRECARRERA;

    public Carrera(String IDCARRERA, String NOMBRECARRERA) {
        this.IDCARRERA = IDCARRERA;
        this.NOMBRECARRERA = NOMBRECARRERA;
    }

    public Carrera() {
    }

    public String getIDCARRERA() {
        return IDCARRERA;
    }

    public void setIDCARRERA(String IDCARRERA) {
        this.IDCARRERA = IDCARRERA;
    }

    public String getNOMBRECARRERA() {
        return NOMBRECARRERA;
    }

    public void setNOMBRECARRERA(String NOMBRECARRERA) {
        this.NOMBRECARRERA = NOMBRECARRERA;
    }


}
