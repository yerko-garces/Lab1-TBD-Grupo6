package com.Grupo6.Lab1.models;

public class EstadoTarea {
    private Long idEstadoTarea;
    private Boolean estadoTarea;

    public EstadoTarea(Long idEstadoTarea, Boolean estadoTarea) {
        this.idEstadoTarea = idEstadoTarea;
        this.estadoTarea = estadoTarea;
    }

    public Long getIdEstadoTarea() {
        return idEstadoTarea;
    }

    public void setIdEstadoTarea(Long idEstadoTarea) {
        this.idEstadoTarea = idEstadoTarea;
    }

    public Boolean getEstadoTarea() {
        return estadoTarea;
    }

    public void setEstadoTarea(Boolean estadoTarea) {
        this.estadoTarea = estadoTarea;
    }
}
