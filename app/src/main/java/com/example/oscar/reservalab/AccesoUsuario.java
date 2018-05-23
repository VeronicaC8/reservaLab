package com.example.oscar.reservalab;

/**
 * Created by hp intel i7 on 13/05/2018.
 */

public class AccesoUsuario {
    private int tipoUsuario;
    private String descripcion;

    public AccesoUsuario(){}

    public AccesoUsuario(int tipoUsuario, String descripcion) {
        this.tipoUsuario = tipoUsuario;
        this.descripcion = descripcion;
    }

    public int getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(int tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
