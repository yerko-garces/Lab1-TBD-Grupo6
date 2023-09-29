package com.Grupo6.Lab1.models;

public class emeHabilidad {
    private String idEmehabilidad;
    private String nombreHabilidad;


    public emeHabilidad(String idEmehabilidad, String nombreHabilidad) {
        this.idEmehabilidad = idEmehabilidad;
        this.nombreHabilidad = nombreHabilidad;
    }

    public String getIdEmehabilidad() {
        return idEmehabilidad;
    }

    public void setIdEmehabilidad(String idEmehabilidad) {
        this.idEmehabilidad = idEmehabilidad;
    }

    public String getNombreHabilidad() {
        return nombreHabilidad;
    }

    public void setNombreHabilidad(String nombreHabilidad) {
        this.nombreHabilidad = nombreHabilidad;
    }
}
