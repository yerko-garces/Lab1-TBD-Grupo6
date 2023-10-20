package com.Grupo6.Lab1.models;

import java.sql.Timestamp;

public class Logs {

    private Long id;
    private Long idUsuario;
    private String descripcion;
    private Timestamp CURRENT_TIMESTAMP;

    public Logs(Long id, Long idUsuario, String descripcion, Timestamp CURRENT_TIMESTAMP) {
        this.id = id;
        this.idUsuario = idUsuario;
        this.descripcion = descripcion;
        this.CURRENT_TIMESTAMP = CURRENT_TIMESTAMP;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Timestamp getCURRENT_TIMESTAMP() {
        return CURRENT_TIMESTAMP;
    }

    public void setCURRENT_TIMESTAMP(Timestamp CURRENT_TIMESTAMP) {
        this.CURRENT_TIMESTAMP = CURRENT_TIMESTAMP;
    }
}
