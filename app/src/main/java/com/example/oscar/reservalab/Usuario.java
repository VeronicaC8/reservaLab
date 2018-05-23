package com.example.oscar.reservalab;

/**
 * Created by Melissa on 18/05/2018.
 */

public class Usuario {
    private int idUsuario;
    private String usuario;
    private String contrasenia;
    private int idaccesoUsuario;

    public Usuario(){}


    public Usuario(int idUsuario, String usuario, String contrasenia, int idaccesoUsuario) {
        this.idUsuario = idUsuario;
        this.usuario = usuario;
        this.contrasenia = contrasenia;
        this.idaccesoUsuario = idaccesoUsuario;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public int getIdaccesoUsuario() {
        return idaccesoUsuario;
    }

    public void setIdaccesoUsuario(int idaccesoUsuario) {
        this.idaccesoUsuario = idaccesoUsuario;
    }

    public void setIdUsuario(String s) {
    }
}
