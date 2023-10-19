package com.Grupo6.Lab1.models;

public class TareaHabilidad {
    private Long idTareaHabilidad;
    private Long idTarea;
    private Long idHabilidad;

    public TareaHabilidad(Long idTareaHabilidad, Long idTarea, Long idHabilidad) {
        this.idTareaHabilidad = idTareaHabilidad;
        this.idTarea = idTarea;
        this.idHabilidad = idHabilidad;
    }

    public Long getIdTareaHabilidad() {
        return idTareaHabilidad;
    }

    public void setIdTareaHabilidad(Long idTareaHabilidad) {
        this.idTareaHabilidad = idTareaHabilidad;
    }

    public Long getIdTarea() {
        return idTarea;
    }

    public void setIdTarea(Long idTarea) {
        this.idTarea = idTarea;
    }

    public Long getIdHabilidad() {
        return idHabilidad;
    }

    public void setIdHabilidad(Long idHabilidad) {
        this.idHabilidad = idHabilidad;
    }
}
