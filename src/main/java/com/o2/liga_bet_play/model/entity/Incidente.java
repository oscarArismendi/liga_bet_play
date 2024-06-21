package com.o2.liga_bet_play.model.entity;

public class Incidente {
    private int id;
    private int partido;
    private String descripcion;
    private int minuto;
    
    public Incidente(int id, int partido, String descripcion, int minuto) {
        this.id = id;
        this.partido = partido;
        this.descripcion = descripcion;
        this.minuto = minuto;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPartido() {
        return partido;
    }

    public void setPartido(int partido) {
        this.partido = partido;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getMinuto() {
        return minuto;
    }

    public void setMinuto(int minuto) {
        this.minuto = minuto;
    }

    
}
