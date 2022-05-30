package com.edu.ues.fia.eisi.app_proyecto01;

import java.sql.Date;

public class Horario {
    private String IDHORARIO;
    private String DESDEHORARIO;
    private String HASTAHORARIO;
    private String DIA;


    public Horario(String idhorario, String desdehorario, String hastahorario, String dia) {
        IDHORARIO = idhorario;
        DESDEHORARIO = desdehorario;
        HASTAHORARIO = hastahorario;
        DIA = dia;
    }

    public Horario(){}


    public String getIDHORARIO() {
        return IDHORARIO;
    }

    public void setIDHORARIO(String IDHORARIO) {
        this.IDHORARIO = IDHORARIO;
    }


    public String getDESDEHORARIO() {
        return DESDEHORARIO;
    }

    public void setDESDEHORARIO(String DESDEHORARIO) {
        this.DESDEHORARIO = DESDEHORARIO;
    }


    public String getHASTAHORARIO() {
        return HASTAHORARIO;
    }

    public void setHASTAHORARIO(String HASTAHORARIO) {
        this.HASTAHORARIO = HASTAHORARIO;
    }


    public String getDIA() {
        return DIA;
    }

    public void setDIA(String DIA) {
        this.DIA = DIA;
    }
}
