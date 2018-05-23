package com.example.oscar.reservalab;

/**
 * Created by Oscar on 11/05/2018.
 */

public class Reservacion {



    private String idReservacion;
    private String codLaboratorio;
    private String idProfesor;
    private String idHora;
    private String idDia;

    public Reservacion() {
    }


    public Reservacion(String idReservacion, String codLaboratorio, String idProfesor, String idHora, String idDia) {
        this.idReservacion = idReservacion;
        this.codLaboratorio = codLaboratorio;
        this.idProfesor = idProfesor;
        this.idHora = idHora;
        this.idDia = idDia;
    }


    public String getIdReservacion() {
        return idReservacion;
    }

    public void setIdReservacion(String idReservacion) {
        this.idReservacion = idReservacion;
    }

    public String getCodLaboratorio() {
        return codLaboratorio;
    }

    public void setCodLaboratorio(String codLaboratorio) {
        this.codLaboratorio = codLaboratorio;
    }

    public String getIdProfesor() {
        return idProfesor;
    }

    public void setIdProfesor(String idProfesor) {
        this.idProfesor = idProfesor;
    }

    public String getIdHora() {
        return idHora;
    }

    public void setIdHora(String idHora) {
        this.idHora = idHora;
    }

    public String getIdDia() {
        return idDia;
    }

    public void setIdDia(String idDia) {
        this.idDia = idDia;
    }
}