package com.edu.ues.fia.eisi.app_proyecto01;

public class ListaHorario {
    private int IDLISTAHORARIO;
    private int ID_DETALLE;
    private String IDHORARIO;


    public ListaHorario(int idlistahorario, int id_detalle, String idhorario) {
        IDLISTAHORARIO = idlistahorario;
        ID_DETALLE = id_detalle;
        IDHORARIO = idhorario;
    }

    public ListaHorario(){}


    public int getIDLISTAHORARIO() {
        return IDLISTAHORARIO;
    }

    public void setIDLISTAHORARIO(int IDLISTAHORARIO) {
        this.IDLISTAHORARIO = IDLISTAHORARIO;
    }


    public int getID_DETALLE() {
        return ID_DETALLE;
    }

    public void setID_DETALLE(int ID_DETALLE) {
        this.ID_DETALLE = ID_DETALLE;
    }

    public String getIDHORARIO() {
        return IDHORARIO;
    }

    public void setIDHORARIO(String IDHORARIO) {
        this.IDHORARIO = IDHORARIO;
    }
}
