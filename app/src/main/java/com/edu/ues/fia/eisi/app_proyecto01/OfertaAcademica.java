package com.edu.ues.fia.eisi.app_proyecto01;

public class OfertaAcademica {
    private String idMateriaActiva;
    private String idCiclo;
    private String idAsignatura;
    private String nombreMateriaActiva;

    public OfertaAcademica(String idMateriaActiva, String idCiclo, String idAsignatura, String nombreMateriaActiva) {
        this.idMateriaActiva = idMateriaActiva;
        this.idCiclo = idCiclo;
        this.idAsignatura = idAsignatura;
        this.nombreMateriaActiva = nombreMateriaActiva;
    }

    public OfertaAcademica() {
    }

    public String getIdMateriaActiva() {
        return idMateriaActiva;
    }

    public void setIdMateriaActiva(String idMateriaActiva) {
        this.idMateriaActiva = idMateriaActiva;
    }

    public String getIdCiclo() {
        return idCiclo;
    }

    public void setIdCiclo(String idCiclo) {
        this.idCiclo = idCiclo;
    }

    public String getIdAsignatura() {
        return idAsignatura;
    }

    public void setIdAsignatura(String idAsignatura) {
        this.idAsignatura = idAsignatura;
    }

    public String getNombreMateriaActiva() {
        return nombreMateriaActiva;
    }

    public void setNombreMateriaActiva(String nombreMateriaActiva) {
        this.nombreMateriaActiva = nombreMateriaActiva;
    }
}
