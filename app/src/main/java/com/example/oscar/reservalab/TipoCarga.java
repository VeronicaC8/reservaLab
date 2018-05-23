package com.example.oscar.reservalab;

/**
 * Created by Oscar on 12/05/2018.
 */

public class TipoCarga {

    private String idTipoCarga;
    private String nombreTipoCarga;

    public TipoCarga(){
    }


    public TipoCarga(String idTipoCarga, String nombreTipoCarga) {
        this.idTipoCarga = idTipoCarga;
        this.nombreTipoCarga = nombreTipoCarga;
    }

    public String getIdTipoCarga() {
        return idTipoCarga;
    }

    public void setIdTipoCarga(String idTipoCarga) {
        this.idTipoCarga = idTipoCarga;
    }

    public String getNombreTipoCarga() {
        return nombreTipoCarga;
    }

    public void setNombreTipoCarga(String nombreTipoCarga) {
        this.nombreTipoCarga = nombreTipoCarga;
    }
}
