package com.edu.ues.fia.eisi.app_proyecto01;

public class Local {
    private String IDLOCAL;
    private String NOMBRELOCAL;
    private int CUPO;


    public Local(String idlocal, String nombrelocal, int cupo) {
        IDLOCAL = idlocal;
        NOMBRELOCAL = nombrelocal;
        CUPO = cupo;
    }

    public Local(){}


    public String getIDLOCAL() {
        return IDLOCAL;
    }

    public void setIDLOCAL(String IDLOCAL) {
        this.IDLOCAL = IDLOCAL;
    }

    public String getNOMBRELOCAL() {
        return NOMBRELOCAL;
    }

    public void setNOMBRELOCAL(String NOMBRELOCAL) {
        this.NOMBRELOCAL = NOMBRELOCAL;
    }

    public int getCUPO() {
        return CUPO;
    }

    public void setCUPO(int CUPO) {
        this.CUPO = CUPO;
    }
}
