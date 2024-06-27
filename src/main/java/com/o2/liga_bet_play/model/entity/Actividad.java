package com.o2.liga_bet_play.model.entity;

public class Actividad {
    private String id;
    private String descripcion;
    private String duracion;

    public Actividad(String id, String descripcion, String duracion) {
        this.id = id;
        this.descripcion = descripcion;
        this.duracion = duracion;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

}
