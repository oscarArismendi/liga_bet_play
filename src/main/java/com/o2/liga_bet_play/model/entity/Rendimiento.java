package com.o2.liga_bet_play.model.entity;

import java.util.List;

public class Rendimiento {
    private int id;
    private int jugador;
    private int partido;
    private int minutosJugados;
    private List<Integer> goles;
    private int asistencias;
    private List<Integer> tarjetasAmarillas;
    private int tarjetaRoja;
    
    public Rendimiento(int id, int jugador, int partido, int minutosJugados, List<Integer> goles, int asistencias,
            List<Integer> tarjetasAmarillas, int tarjetaRoja) {
        this.id = id;
        this.jugador = jugador;
        this.partido = partido;
        this.minutosJugados = minutosJugados;
        this.goles = goles;
        this.asistencias = asistencias;
        this.tarjetasAmarillas = tarjetasAmarillas;
        this.tarjetaRoja = tarjetaRoja;
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

    public int getPartido() {
        return partido;
    }

    public void setPartido(int partido) {
        this.partido = partido;
    }

    public int getMinutosJugados() {
        return minutosJugados;
    }

    public void setMinutosJugados(int minutosJugados) {
        this.minutosJugados = minutosJugados;
    }

    public List<Integer> getGoles() {
        return goles;
    }

    public void setGoles(List<Integer> goles) {
        this.goles = goles;
    }

    public int getAsistencias() {
        return asistencias;
    }

    public void setAsistencias(int asistencias) {
        this.asistencias = asistencias;
    }

    public List<Integer> getTarjetasAmarillas() {
        return tarjetasAmarillas;
    }

    public void setTarjetasAmarillas(List<Integer> tarjetasAmarillas) {
        this.tarjetasAmarillas = tarjetasAmarillas;
    }

    public int getTarjetaRoja() {
        return tarjetaRoja;
    }

    public void setTarjetaRoja(int tarjetaRoja) {
        this.tarjetaRoja = tarjetaRoja;
    }

    

}
