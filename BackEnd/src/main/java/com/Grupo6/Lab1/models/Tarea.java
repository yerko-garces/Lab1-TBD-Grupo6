package com.Grupo6.Lab1.models;

public class Tarea {
    private Long idTarea;
    private String nombreTarea;
    private Long idEstadoTarea;

    public Tarea(Long idTarea, String nombreTarea, Long idEstadoTarea) {
        this.idTarea = idTarea;
        this.nombreTarea = nombreTarea;
        this.idEstadoTarea = idEstadoTarea;
    }

    public Long getIdTarea() {
        return idTarea;
    }

    public void setIdTarea(Long idTarea) {
        this.idTarea = idTarea;
    }

    public String getNombreTarea() {
        return nombreTarea;
    }

    public void setNombreTarea(String nombreTarea) {
        this.nombreTarea = nombreTarea;
    }

    public Long getIdEstadoTarea() {
        return idEstadoTarea;
    }

    public void setIdEstadoTarea(Long idEstadoTarea) {
        this.idEstadoTarea = idEstadoTarea;
    }
}
