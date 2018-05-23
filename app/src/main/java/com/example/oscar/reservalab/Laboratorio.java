package com.example.oscar.reservalab;

public class Laboratorio {
    private String codLaboratorio;
    private int idTipoComputo;
    private int plantaLaboratorio;
    private int cantidadEquiposLaboratorio;

    public Laboratorio() {
    }

    public Laboratorio(String codLaboratorio, int idTipoComputo, int plantaLaboratorio, int cantidadEquiposLaboratorio) {
        this.codLaboratorio = codLaboratorio;
        this.idTipoComputo = idTipoComputo;
        this.plantaLaboratorio = plantaLaboratorio;
        this.cantidadEquiposLaboratorio = cantidadEquiposLaboratorio;
    }

    public String getCodLaboratorio() {
        return codLaboratorio;
    }


    public void setCodLaboratorio(String codLaboratorio) {
        this.codLaboratorio = codLaboratorio;
    }

    public int getIdTipoComputo() {
        return idTipoComputo;
    }

    public void setIdTipoComputo(int idTipoComputo) {
        this.idTipoComputo = idTipoComputo;
    }

    public int getPlantaLaboratorio() {
        return plantaLaboratorio;
    }

    public void setPlantaLaboratorio(int plantaLaboratorio) {
        this.plantaLaboratorio = plantaLaboratorio;
    }

    public int getCantidadEquiposLaboratorio() {
        return cantidadEquiposLaboratorio;
    }

    public void setCantidadEquiposLaboratorio(int cantidadEquiposLaboratorio) {
        this.cantidadEquiposLaboratorio = cantidadEquiposLaboratorio;
    }
}
