package com.edu.ues.fia.eisi.app_proyecto01;

public class Ciclo {
    private String idCiclo;
    private int numeroCiclo;
    private String fechaInicio;
    private String fechaFin;
    private String anio;

    public Ciclo(String idCiclo, int numeroCiclo, String fechaInicio, String fechaFin, String anio) {
        this.idCiclo = idCiclo;
        this.numeroCiclo = numeroCiclo;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.anio = anio;
    }

    public Ciclo() {
    }

    public String getIdCiclo() {
        return idCiclo;
    }

    public void setIdCiclo(String idCiclo) {
        this.idCiclo = idCiclo;
    }

    public int getNumeroCiclo() {
        return numeroCiclo;
    }

    public void setNumeroCiclo(int numeroCiclo) {
        this.numeroCiclo = numeroCiclo;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(String fechaFin) {
        this.fechaFin = fechaFin;
    }

    public String getAnio() {
        return anio;
    }

    public void setAnio(String anio) {
        this.anio = anio;
    }
}
