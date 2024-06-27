package com.o2.liga_bet_play.model.entity;

public class Entrenador {
    private String id;
    private String nombre;
    private int edad;
    private int experiencia;
    private Equipo equipo;

    public Entrenador(String id, String nombre, int edad, int experiencia) {
        this.id = id;
        this.nombre = nombre;
        this.edad = edad;
        this.experiencia = experiencia;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getExperiencia() {
        return experiencia;
    }

    public void setExperiencia(int experiencia) {
        this.experiencia = experiencia;
    }

    public Equipo getEquipo() {
        return equipo;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }

}
