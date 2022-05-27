package com.edu.ues.fia.eisi.app_proyecto01;

public class Particular {
    private String IDPARTICULAR;
    private String IDPUSUARIO;
    private String NOMBREPARTICULAR;
    private String APELLIDOPARTICULAR;

    public Particular(String idparticular, String idpusuario, String nombreparticular, String apellidoparticular) {
        IDPARTICULAR = idparticular;
        IDPUSUARIO = idpusuario;
        NOMBREPARTICULAR = nombreparticular;
        APELLIDOPARTICULAR = apellidoparticular;
    }

    public Particular(){}


    public String getIDPARTICULAR() {
        return IDPARTICULAR;
    }

    public void setIDPARTICULAR(String IDPARTICULAR) {
        this.IDPARTICULAR = IDPARTICULAR;
    }

    public String getIDPUSUARIO() {
        return IDPUSUARIO;
    }

    public void setIDPUSUARIO(String IDPUSUARIO) {
        this.IDPUSUARIO = IDPUSUARIO;
    }

    public String getNOMBREPARTICULAR() {
        return NOMBREPARTICULAR;
    }

    public void setNOMBREPARTICULAR(String NOMBREPARTICULAR) {
        this.NOMBREPARTICULAR = NOMBREPARTICULAR;
    }

    public String getAPELLIDOPARTICULAR() {
        return APELLIDOPARTICULAR;
    }

    public void setAPELLIDOPARTICULAR(String APELLIDOPARTICULAR) {
        this.APELLIDOPARTICULAR = APELLIDOPARTICULAR;
    }
}