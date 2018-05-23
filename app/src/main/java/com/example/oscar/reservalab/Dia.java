package com.example.oscar.reservalab;
public class Dia {
    private int idDia;
    private String nomDia;


    public Dia() {
    }

    public Dia(int idDia, String nomDia) {
        this.idDia = idDia;
        this.nomDia = nomDia;
    }

    public int getIdDia() {
        return idDia;
    }

    public void setIdDia(int idDia) {
        this.idDia = idDia;
    }

    public String getNomDia() {
        return nomDia;
    }

    public void setNomDia(String nomDia) {
        this.nomDia = nomDia;
    }
}
