package com.edu.ues.fia.eisi.app_proyecto01;

public class EquipoDidactico {
    private String IDEQUIPO;
    private String NOMBRE;
    private String DESCRIPCIONEQUIPO;

    public EquipoDidactico(String idequipo, String nombre, String descripcionequipo){
        IDEQUIPO = idequipo;
        NOMBRE = nombre;
        DESCRIPCIONEQUIPO = descripcionequipo;
    }


    public EquipoDidactico(){}


    public String getIDEQUIPO() {
        return IDEQUIPO;
    }

    public void setIDEQUIPO(String IDEQUIPO) {
        this.IDEQUIPO = IDEQUIPO;
    }

    public String getNOMBRE() {
        return NOMBRE;
    }

    public void setNOMBRE(String NOMBRE) {
        this.NOMBRE = NOMBRE;
    }

    public String getDESCRIPCIONEQUIPO() {
        return DESCRIPCIONEQUIPO;
    }

    public void setDESCRIPCIONEQUIPO(String DESCRIPCIONEQUIPO) {
        this.DESCRIPCIONEQUIPO = DESCRIPCIONEQUIPO;
    }
}
