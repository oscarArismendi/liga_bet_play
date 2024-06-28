package com.o2.liga_bet_play.model.entity;

public class Transferencia {
    private String id;
    private Jugador jugador;
    private Equipo equipoOrigen;
    private Equipo equipoDestino;
    private double monto;
    private String fecha;

    public Transferencia(String id, double monto, String fecha) {
        this.id = id;
        this.monto = monto;
        this.fecha = fecha;
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

    public Equipo getEquipoOrigen() {
        return equipoOrigen;
    }

    public void setEquipoOrigen(Equipo equipoOrigen) {
        this.equipoOrigen = equipoOrigen;
    }

    public Equipo getEquipoDestino() {
        return equipoDestino;
    }

    public void setEquipoDestino(Equipo equipoDestino) {
        this.equipoDestino = equipoDestino;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

}
