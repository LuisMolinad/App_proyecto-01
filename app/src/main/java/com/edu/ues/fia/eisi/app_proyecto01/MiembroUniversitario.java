package com.edu.ues.fia.eisi.app_proyecto01;

public class MiembroUniversitario {

    private String idAsignatura;
    private String idEscuela;
    private String nombreAsignatura;
    int unidadesValorativas;

    public MiembroUniversitario(){

    }

    public MiembroUniversitario(String idAsignatura, String idEscuela, int unidadesValorativas, String nombreAsignatura){
        this.idAsignatura = idAsignatura;
        this.idEscuela = idEscuela;
        this.unidadesValorativas = unidadesValorativas;
        this.nombreAsignatura = nombreAsignatura;
    }

    public String getIdAsignatura() {
        return idAsignatura;
    }

    public void setIdAsignatura(String idAsignatura) {
        this.idAsignatura = idAsignatura;
    }

    public String getIdEscuela() {
        return idEscuela;
    }

    public void setIdEscuela(String idEscuela) {
        this.idEscuela = idEscuela;
    }

    public String getNombreAsignatura() {
        return nombreAsignatura;
    }

    public void setNombreAsignatura(String nombreAsignatura) {
        this.nombreAsignatura = nombreAsignatura;
    }

    public void setUnidadesValorativas(int unidadesValorativas){
        this.unidadesValorativas = unidadesValorativas;
    }

    public int getUnidadesValorativas(int unidadesValorativas){
        return unidadesValorativas;
    }
}
