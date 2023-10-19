package com.Grupo6.Lab1.models;

public class Institucion {

    private Long idInstitucion;
    private String nombreInstitucion;
    private String correoInstitucion;
    private String contraseniaInstitucion;

    public Institucion(Long idInstitucion, String nombreInstitucion, String correoInstitucion, String contraseniaInstitucion) {
        this.idInstitucion = idInstitucion;
        this.nombreInstitucion = nombreInstitucion;
        this.correoInstitucion = correoInstitucion;
        this.contraseniaInstitucion = contraseniaInstitucion;
    }

    public Long getIdInstitucion() {
        return idInstitucion;
    }

    public void setIdInstitucion(Long idInstitucion) {
        this.idInstitucion = idInstitucion;
    }

    public String getNombreInstitucion() {
        return nombreInstitucion;
    }

    public void setNombreInstitucion(String nombreInstitucion) {
        this.nombreInstitucion = nombreInstitucion;
    }

    public String getCorreoInstitucion() {
        return correoInstitucion;
    }

    public void setCorreoInstitucion(String correoInstitucion) {
        this.correoInstitucion = correoInstitucion;
    }

    public String getContraseniaInstitucion() {
        return contraseniaInstitucion;
    }

    public void setContraseniaInstitucion(String contraseniaInstitucion) {
        this.contraseniaInstitucion = contraseniaInstitucion;
    }
}
