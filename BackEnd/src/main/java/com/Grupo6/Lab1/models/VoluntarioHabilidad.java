package com.Grupo6.Lab1.models;

public class VoluntarioHabilidad {
    private Long idVoluntarioHabilidad;
    private Long idVoluntario;
    private Long idHabilidad;

    public VoluntarioHabilidad(Long idVoluntario, Long idHabilidad) {
        this.idVoluntario = idVoluntario;
        this.idHabilidad = idHabilidad;
    }

    public Long getIdVoluntarioHabilidad() {
        return idVoluntarioHabilidad;
    } 

    public void setIdVoluntarioHabilidad(Long idVoluntarioHabilidad) {
        this.idVoluntarioHabilidad = idVoluntarioHabilidad;
    }

    public Long getIdVoluntario() {
        return idVoluntario;
    }

    public void setIdVoluntario(Long idVoluntario) {
        this.idVoluntario = idVoluntario;
    }

    public Long getIdHabilidad() {
        return idHabilidad;
    }

    public void setIdHabilidad(Long idHabilidad) {
        this.idHabilidad = idHabilidad;
    }
}
