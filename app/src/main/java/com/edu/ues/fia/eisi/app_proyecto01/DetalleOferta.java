package com.edu.ues.fia.eisi.app_proyecto01;

public class DetalleOferta {
    private String idGrupo;
    private String idMateriaActiva;
    private String tipoGrupo;
    private int numeroGrupo;
    private int tamanoGrupo;

    public DetalleOferta(String idGrupo, String idMateriaActiva, String tipoGrupo, int numeroGrupo, int tamanoGrupo) {
        this.idGrupo = idGrupo;
        this.idMateriaActiva = idMateriaActiva;
        this.tipoGrupo = tipoGrupo;
        this.numeroGrupo = numeroGrupo;
        this.tamanoGrupo = tamanoGrupo;
    }

    public DetalleOferta() {
    }

    public String getIdGrupo() {
        return idGrupo;
    }

    public void setIdGrupo(String idGrupo) {
        this.idGrupo = idGrupo;
    }

    public String getIdMateriaActiva() {
        return idMateriaActiva;
    }

    public void setIdMateriaActiva(String idMateriaActiva) {
        this.idMateriaActiva = idMateriaActiva;
    }

    public String getTipoGrupo() {
        return tipoGrupo;
    }

    public void setTipoGrupo(String tipoGrupo) {
        this.tipoGrupo = tipoGrupo;
    }

    public int getNumeroGrupo() {
        return numeroGrupo;
    }

    public void setNumeroGrupo(int numeroGrupo) {
        this.numeroGrupo = numeroGrupo;
    }

    public int getTamanoGrupo() {
        return tamanoGrupo;
    }

    public void setTamanoGrupo(int tamanoGrupo) {
        this.tamanoGrupo = tamanoGrupo;
    }
}
