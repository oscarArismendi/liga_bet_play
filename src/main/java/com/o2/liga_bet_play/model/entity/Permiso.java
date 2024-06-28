package com.o2.liga_bet_play.model.entity;

public class Permiso {
    private String id;
    private String descripcion;

    // Constructor sin argumentos
    public Permiso() {
    }

    // Constructor con argumentos
    public Permiso(String id, String descripcion) {
        this.id = id;
        this.descripcion = descripcion;
    }

    // Métodos Getters y Setters
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

    // Método para actualizar la descripción
    public void updateDescripcion(String nuevaDescripcion) {
        this.descripcion = nuevaDescripcion;
    }
}
