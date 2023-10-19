package com.Grupo6.Lab1.models;

public class Ranking {
    private Long idRanking;
    private String nombreRanking;
    private Long idVoluntario;
    private Long idTarea;

    public Ranking(Long idRanking, String nombreRanking, Long idVoluntario, Long idTarea) {
        this.idRanking = idRanking;
        this.nombreRanking = nombreRanking;
        this.idVoluntario = idVoluntario;
        this.idTarea = idTarea;
    }

    public Long getIdRanking() {
        return idRanking;
    }

    public void setIdRanking(Long idRanking) {
        this.idRanking = idRanking;
    }

    public String getNombreRanking() {
        return nombreRanking;
    }

    public void setNombreRanking(String nombreRanking) {
        this.nombreRanking = nombreRanking;
    }

    public Long getIdVoluntario() {
        return idVoluntario;
    }

    public void setIdVoluntario(Long idVoluntario) {
        this.idVoluntario = idVoluntario;
    }

    public Long getIdTarea() {
        return idTarea;
    }

    public void setIdTarea(Long idTarea) {
        this.idTarea = idTarea;
    }
}
