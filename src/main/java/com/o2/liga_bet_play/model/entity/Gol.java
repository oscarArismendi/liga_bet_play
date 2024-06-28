package com.o2.liga_bet_play.model.entity;

public class Gol {
    private String id;
    private Jugador jugador;
    private Equipo equipo;
    private int minuto;
    private Partido partido;

    public Gol(String id, int minuto) {
        this.id = id;
        this.minuto = minuto;
    }

    public Gol(String id, Jugador jugador, Equipo equipo, int minuto, Partido partido) {
        this.id = id;
        this.jugador = jugador;
        this.equipo = equipo;
        this.minuto = minuto;
        this.partido = partido;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Jugador getJugador() {
        return jugador;
    }

    public void setJugador(Jugador jugador) {
        this.jugador = jugador;
    }

    public Equipo getEquipo() {
        return equipo;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }

    public int getMinuto() {
        return minuto;
    }

    public void setMinuto(int minuto) {
        this.minuto = minuto;
    }

    public Partido getPartido() {
        return partido;
    }

    public void setPartido(Partido partido) {
        this.partido = partido;
    }

}
