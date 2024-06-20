package com.o2.liga_bet_play;

public class Gol {
    private int id;
    private int jugador;
    private int equipo;
    private int minuto;
    private int partido;
    
    public Gol(int id, int jugador, int equipo, int minuto, int partido) {
        this.id = id;
        this.jugador = jugador;
        this.equipo = equipo;
        this.minuto = minuto;
        this.partido = partido;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getJugador() {
        return jugador;
    }

    public void setJugador(int jugador) {
        this.jugador = jugador;
    }

    public int getEquipo() {
        return equipo;
    }

    public void setEquipo(int equipo) {
        this.equipo = equipo;
    }

    public int getMinuto() {
        return minuto;
    }

    public void setMinuto(int minuto) {
        this.minuto = minuto;
    }

    public int getPartido() {
        return partido;
    }

    public void setPartido(int partido) {
        this.partido = partido;
    }

    

}
