package com.edu.ues.fia.eisi.app_proyecto01;

public class DetalleActividad {
    private int ID_DETALLE;
    private String GRUPO;
    private String IDACTIVIDAD;
    private String IDLOCAL;
    private String DESCRIPCIONACTIVIDAD;

    public DetalleActividad(int id_detalle, String grupo, String idactividad, String idlocal, String descripcionactividad) {
        ID_DETALLE = id_detalle;
        GRUPO = grupo;
        IDACTIVIDAD = idactividad;
        IDLOCAL = idlocal;
        DESCRIPCIONACTIVIDAD = descripcionactividad;
    }
    public DetalleActividad() {
    }

    public int getID_DETALLE() {
        return ID_DETALLE;
    }

    public void setID_DETALLE(int ID_DETALLE) {
        this.ID_DETALLE = ID_DETALLE;
    }

    public String getGRUPO() {
        return GRUPO;
    }

    public void setGRUPO(String GRUPO) {
        this.GRUPO = GRUPO;
    }

    public String getIDACTIVIDAD() {
        return IDACTIVIDAD;
    }

    public void setIDACTIVIDAD(String IDACTIVIDAD) {
        this.IDACTIVIDAD = IDACTIVIDAD;
    }

    public String getIDLOCAL() {
        return IDLOCAL;
    }

    public void setIDLOCAL(String IDLOCAL) {
        this.IDLOCAL = IDLOCAL;
    }

    public String getDESCRIPCIONACTIVIDAD() {
        return DESCRIPCIONACTIVIDAD;
    }

    public void setDESCRIPCIONACTIVIDAD(String DESCRIPCIONACTIVIDAD) {
        this.DESCRIPCIONACTIVIDAD = DESCRIPCIONACTIVIDAD;
    }
}
