package com.Grupo6.Lab1.models;

public class voluntarioHabilidad {
    private Long id;
    private Long voluntario_id;
    private Long habilidad_id;

    public Long getId() {
        return id;
    } 

    public void setId(Long id) {
        this.id = id;
    }

    public Long getVoluntario_id() {
        return voluntario_id;
    }

    public void setVoluntario_id(Long voluntario_id) {
        this.voluntario_id = voluntario_id;
    }

    public Long getHabilidad_id() {
        return habilidad_id;
    }

    public void setHabilidad_id(Long habilidad_id) {
        this.habilidad_id = habilidad_id;
    }
}
