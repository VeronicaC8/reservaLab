package com.example.oscar.reservalab;

/**
 * Created by cbren on 16/5/2018.
 */

public class TipoComputo {
    private int idTipoComputo;
    private String nombreTipo;
    private String especificacionTecnica;

    public TipoComputo() {

    }
    public TipoComputo(int idTipoComputo, String nombreTipo, String especificacionTecnica) {
        this.idTipoComputo = idTipoComputo;
        this.nombreTipo = nombreTipo;
        this.especificacionTecnica = especificacionTecnica;
    }

    public int getIdTipoComputo() {
        return idTipoComputo;
    }

    public String getNombreTipo() {
        return nombreTipo;
    }

    public String getEspecificacionTecnica() {
        return especificacionTecnica;
    }

    public void setIdTipoComputo(int idTipoComputo) {
        this.idTipoComputo = idTipoComputo;
    }

    public void setNombreTipo(String nombreTipo) {
        this.nombreTipo = nombreTipo;
    }

    public void setEspecificacionTecnica(String especificacionTecnica) {
        this.especificacionTecnica = especificacionTecnica;
    }
}