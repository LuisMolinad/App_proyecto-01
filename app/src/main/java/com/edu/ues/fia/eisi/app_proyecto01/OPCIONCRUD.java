package com.edu.ues.fia.eisi.app_proyecto01;

public class OPCIONCRUD {
    public OPCIONCRUD(String IDOPCION, String DESOPCION, String NUMCRUD) {
        this.IDOPCION = IDOPCION;
        this.DESOPCION = DESOPCION;
        this.NUMCRUD = NUMCRUD;
    }

    public OPCIONCRUD() {
    }

    String IDOPCION,DESOPCION,NUMCRUD;

    public String getIDOPCION() {
        return IDOPCION;
    }

    public void setIDOPCION(String IDOPCION) {
        this.IDOPCION = IDOPCION;
    }

    public String getDESOPCION() {
        return DESOPCION;
    }

    public void setDESOPCION(String DESOPCION) {
        this.DESOPCION = DESOPCION;
    }

    public String getNUMCRUD() {
        return NUMCRUD;
    }

    public void setNUMCRUD(String NUMCRUD) {
        this.NUMCRUD = NUMCRUD;
    }
}
