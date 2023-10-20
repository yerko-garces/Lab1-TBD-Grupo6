package com.Grupo6.Lab1.models;

public class Habilidad {
    private Long idHabilidad;
    private String nombreHabilidad;

    public Habilidad(Long idHabilidad, String nombreHabilidad) {
        this.idHabilidad = idHabilidad;
        this.nombreHabilidad = nombreHabilidad;
    }

    public Long getId_habilidad() {
        return idHabilidad;
    }

    public void setId_habilidad(Long id_habilidad) {
        this.idHabilidad = id_habilidad;
    }

    public String getNombreHabilidad() {
        return nombreHabilidad;
    }

    public void setNombreHabilidad(String nombreHabilidad) {
        this.nombreHabilidad = nombreHabilidad;
    }

    @Override
    public String toString() {
        return "Habilidad{" +
                "idHabilidad=" + idHabilidad +
                ", nombreHabilidad='" + nombreHabilidad;
    }
}
