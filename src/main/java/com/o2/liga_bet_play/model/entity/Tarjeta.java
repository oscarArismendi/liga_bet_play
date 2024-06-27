package com.o2.liga_bet_play.model.entity;

public class Tarjeta {
    private String id;
    private Jugador jugador;
    private Partido partido;
    private String tipo;// amarilla o roja
    private int minuto;
    
    public Tarjeta(String id, Jugador jugador, Partido partido, String tipo, int minuto) {
        this.id = id;
        this.jugador = jugador;
        this.partido = partido;
        this.tipo = tipo;
        this.minuto = minuto;
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

    public Partido getPartido() {
        return partido;
    }

    public void setPartido(Partido partido) {
        this.partido = partido;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getMinuto() {
        return minuto;
    }

    public void setMinuto(int minuto) {
        this.minuto = minuto;
    }

    
}
