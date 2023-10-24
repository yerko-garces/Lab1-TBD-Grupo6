package com.Grupo6.Lab1.models;

public class Emergencia {
    private Long idEmergencia;
    private String nombreEmergencia;
    private Long idInstitucion;

    public Emergencia(Long idEmergencia, String nombreEmergencia, Long idInstitucion) {
        this.idEmergencia = idEmergencia;
        this.nombreEmergencia = nombreEmergencia;
        this.idInstitucion = idInstitucion;
    }

    public Long getIdEmergencia() {
        return idEmergencia;
    }

    public void setIdEmergencia(Long idEmergencia) {
        this.idEmergencia = idEmergencia;
    }

    public String getNombreEmergencia() {
        return nombreEmergencia;
    }

    public void setNombreEmergencia(String nombreEmergencia) {
        this.nombreEmergencia = nombreEmergencia;
    }

    public Long getIdInstitucion() {
        return idInstitucion;
    }

    public void setIdInstitucion(Long idInstitucion) {
        this.idInstitucion = idInstitucion;
    }

    @Override
    public String toString() {
        return "Emergencia{" +
                "idEmergencia=" + idEmergencia +
                ", nombreEmergencia='" + nombreEmergencia + '\'' +
                ", idInstitucion=" + idInstitucion +
                '}';
    }
}
