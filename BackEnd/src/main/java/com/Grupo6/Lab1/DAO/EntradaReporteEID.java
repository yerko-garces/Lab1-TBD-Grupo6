package com.Grupo6.Lab1.DAO;

public class EntradaReporteEID {
    String email;
    Integer cantidadReportes;

    public EntradaReporteEID(){

    }

    public void setEmail(String email){
        this.email = email;
    }

    public void setCantidadReportes(Integer cantidadReportes){
        this.cantidadReportes = cantidadReportes;
    }

    public String getEmail(){
        return this.email;
    }

    public Integer getCantidadReportes(){
        return this.cantidadReportes;
    }
}
