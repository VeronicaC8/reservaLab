package com.example.oscar.reservalab;



public class asignacionAsignatura {

   private Integer idAsignacionAsignatura;
   private String codAsignatura;
   private String codLaboratorio;

    public asignacionAsignatura() {
    }

    public asignacionAsignatura(Integer idAsignacionAsignatura, String codAsignatura, String codLaboratorio) {
        this.idAsignacionAsignatura = idAsignacionAsignatura;
        this.codAsignatura = codAsignatura;
        this.codLaboratorio = codLaboratorio;
    }

    public Integer getIdAsignacionAsignatura() {
        return idAsignacionAsignatura;
    }

    public void setIdAsignacionAsignatura(Integer idAsignacionAsignatura) {
        this.idAsignacionAsignatura = idAsignacionAsignatura;
    }

    public String getCodAsignatura() {
        return codAsignatura;
    }

    public void setCodAsignatura(String codAsignatura) {
        this.codAsignatura = codAsignatura;
    }

    public String getCodLaboratorio() {
        return codLaboratorio;
    }

    public void setCodLaboratorio(String codLaboratorio) {
        this.codLaboratorio = codLaboratorio;
    }
}

