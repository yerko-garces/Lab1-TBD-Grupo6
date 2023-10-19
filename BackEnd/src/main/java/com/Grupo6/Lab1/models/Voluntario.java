package com.Grupo6.Lab1.models;

public class Voluntario {
    private Long idVoluntario;
    private String emailVoluntario;
    private String rutVoluntario;
    private String nombreCompletoVoluntario;
    private String contraseniaVoluntario;

    public String getContraseniaVoluntario() {
        return contraseniaVoluntario;
    }

    public void setContraseniaVoluntario(String contraseniaVoluntario) {
        this.contraseniaVoluntario = contraseniaVoluntario;
    }

    public Long getIdVoluntario() {
        return idVoluntario;
    }

    public void setIdVoluntario(Long idVoluntario) {
        this.idVoluntario = idVoluntario;
    }

    public String getEmailVoluntario() {
        return emailVoluntario;
    }

    public void setEmailVoluntario(String emailVoluntario) {
        this.emailVoluntario = emailVoluntario;
    }

    public String getRutVoluntario() {
        return rutVoluntario;
    }

    public void setRutVoluntario(String rutVoluntario) {
        this.rutVoluntario = rutVoluntario;
    }

    public String getNombreCompletoVoluntario() {
        return nombreCompletoVoluntario;
    }

    public void setNombreCompletoVoluntario(String nombreCompletoVoluntario) {
        this.nombreCompletoVoluntario = nombreCompletoVoluntario;
    }

}
