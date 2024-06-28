package com.o2.liga_bet_play.model.entity;

public class Entrenador extends Persona {

    private int experiencia;
    private Equipo equipo;

    public Entrenador() {
        super();
    }

    public Entrenador(String id, String nombre, int edad, String nacionalidad, int experiencia) {
        super(id, nombre, edad, nacionalidad);
        this.experiencia = experiencia;
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
