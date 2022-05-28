package com.edu.ues.fia.eisi.app_proyecto01;

public class ListaEquipo {
    private int IDLISTAEQUIPO;
    private int ID_DETALLE;
    private String IDEQUIPO;

    public ListaEquipo(int idlistaequipo, int id_detalle, String idequipo) {
        IDLISTAEQUIPO = idlistaequipo;
        ID_DETALLE = id_detalle;
        IDEQUIPO = idequipo;
    }

    public ListaEquipo() {
    }


    public int getIDLISTAEQUIPO() {
        return IDLISTAEQUIPO;
    }

    public void setIDLISTAEQUIPO(int IDLISTAEQUIPO) {
        this.IDLISTAEQUIPO = IDLISTAEQUIPO;
    }

    public int getID_DETALLE() {
        return ID_DETALLE;
    }

    public void setID_DETALLE(int ID_DETALLE) {
        this.ID_DETALLE = ID_DETALLE;
    }

    public String getIDEQUIPO() {
        return IDEQUIPO;
    }

    public void setIDEQUIPO(String IDEQUIPO) {
        this.IDEQUIPO = IDEQUIPO;
    }
}
