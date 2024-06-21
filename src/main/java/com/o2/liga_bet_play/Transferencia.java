package com.o2.liga_bet_play;


public class Transferencia {
    private int id;
    private int jugador;
    private int equipoOrigen;
    private int equipoDestino;
    private double monto;
    private String fecha;
    
    public Transferencia(int id, int jugador, int equipoOrigen, int equipoDestino, double monto, String fecha) {
        this.id = id;
        this.jugador = jugador;
        this.equipoOrigen = equipoOrigen;
        this.equipoDestino = equipoDestino;
        this.monto = monto;
        this.fecha = fecha;
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

    public int getEquipoOrigen() {
        return equipoOrigen;
    }

    public void setEquipoOrigen(int equipoOrigen) {
        this.equipoOrigen = equipoOrigen;
    }

    public int getEquipoDestino() {
        return equipoDestino;
    }

    public void setEquipoDestino(int equipoDestino) {
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
