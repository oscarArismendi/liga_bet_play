package com.o2.liga_bet_play.model.entity;

public class Incidente {
    private String id;
    private Partido partido;
    private String descripcion;
    private int minuto;

    public Incidente(String id, String descripcion, int minuto) {
        this.id = id;
        this.descripcion = descripcion;
        this.minuto = minuto;
    }

    public Incidente(String id, Partido partido, String descripcion, int minuto) {
        this.id = id;
        this.partido = partido;
        this.descripcion = descripcion;
        this.minuto = minuto;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Partido getPartido() {
        return partido;
    }

    public void setPartido(Partido partido) {
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
