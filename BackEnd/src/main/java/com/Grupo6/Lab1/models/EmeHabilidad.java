package com.Grupo6.Lab1.models;

public class EmeHabilidad {
    private Long idEmehabilidad;
    private Long idEmergencia;
    private Long idHabilidad;


    public EmeHabilidad(Long idEmehabilidad, Long idEmergencia, Long idHabilidad) {
        this.idEmehabilidad = idEmehabilidad;
        this.idEmergencia = idEmergencia;
        this.idHabilidad = idHabilidad;
    }

    public Long getIdEmehabilidad() {
        return idEmehabilidad;
    }

    public void setIdEmehabilidad(Long idEmehabilidad) {
        this.idEmehabilidad = idEmehabilidad;
    }

    public Long getIdEmergencia() {
        return idEmergencia;
    }

    public void setIdEmergencia(Long idEmergencia) {
        this.idEmergencia = idEmergencia;
    }

    public Long getIdHabilidad() {
        return idHabilidad;
    }

    public void setIdHabilidad(Long idHabilidad) {
        this.idHabilidad = idHabilidad;
    }
}
