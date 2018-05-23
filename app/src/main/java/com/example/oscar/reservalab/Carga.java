package com.example.oscar.reservalab;

/**
 * Created by Oscar on 16/05/2018.
 */

public class Carga {

    private String idCarga;
    private String idTipoCarga;
    private String codAsignatura;
    private Integer numGrupo;

    public Carga() {
    }

    public Carga(String idCarga, String idTipoCarga, String codAsignatura, Integer numGrupo) {
        this.idCarga = idCarga;
        this.idTipoCarga = idTipoCarga;
        this.codAsignatura = codAsignatura;
        this.numGrupo = numGrupo;
    }

    public String getIdCarga() {
        return idCarga;
    }

    public void setIdCarga(String idCarga) {
        this.idCarga = idCarga;
    }

    public String getIdTipoCarga() {
        return idTipoCarga;
    }

    public void setIdTipoCarga(String idTipoCarga) {
        this.idTipoCarga = idTipoCarga;
    }

    public String getCodAsignatura() {
        return codAsignatura;
    }

    public void setCodAsignatura(String codAsignatura) {
        this.codAsignatura = codAsignatura;
    }

    public Integer getNumGrupo() {
        return numGrupo;
    }

    public void setNumGrupo(Integer numGrupo) {
        this.numGrupo = numGrupo;
    }
}
