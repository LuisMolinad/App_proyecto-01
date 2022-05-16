package com.edu.ues.fia.eisi.app_proyecto01;

public class Materia {


    public Materia(String IDASIGNATURA, String NOMBREASIGNATURA, String IDESCUELA, Integer UNIDADESVALORATIVAS) {
        this.IDASIGNATURA = IDASIGNATURA;
        this.NOMBREASIGNATURA  = NOMBREASIGNATURA;
        this.IDESCUELA = IDESCUELA;
        this.UNIDADESVALORATIVAS = UNIDADESVALORATIVAS;
    }

    String IDASIGNATURA, NOMBREASIGNATURA , IDESCUELA;

    public Materia() {
    }

    Integer UNIDADESVALORATIVAS;

    public String getIDASIGNATURA() {
        return IDASIGNATURA;
    }

    public void setIDASIGNATURA(String IDASIGNATURA) {
        this.IDASIGNATURA = IDASIGNATURA;
    }

    public String getNOMBREMATERIA() {
        return NOMBREASIGNATURA ;
    }

    public void setNOMBREASIGNATURA(String NOMBREASIGNATURA) {
        this.NOMBREASIGNATURA  = NOMBREASIGNATURA;
    }

    public String getIDESCUELA() {
        return IDESCUELA;
    }

    public void setIDESCUELA(String IDESCUELA) {
        this.IDESCUELA = IDESCUELA;
    }

    public Integer getUNIDADESVALORATIVAS() {
        return UNIDADESVALORATIVAS;
    }

    public void setUNIDADESVALORATIVAS(Integer UNIDADESVALORATIVAS) {
        this.UNIDADESVALORATIVAS = UNIDADESVALORATIVAS;
    }
}
