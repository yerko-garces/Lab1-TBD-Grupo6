package com.Grupo6.Lab1.models;
//Ejemplo entidad

public class EntidadEj {

    private String atributo1;
    private String atributo2;

    public EntidadEj(String atributo1, String atributo2) {
        this.atributo1 = atributo1;
        this.atributo2 = atributo2;
    }

    public String getAtributo1() {
        return atributo1;
    }

    public void setAtributo1(String atributo1) {
        this.atributo1 = atributo1;
    }

    public String getAtributo2() {
        return atributo2;
    }

    public void setAtributo2(String atributo2) {
        this.atributo2 = atributo2;
    }
}
