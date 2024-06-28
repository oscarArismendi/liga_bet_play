package com.o2.liga_bet_play.model.entity;

import java.util.ArrayList;
import java.util.List;

public class Rendimiento {
    private String id;
    private Jugador jugador;
    private Partido partido;
    private int minutosJugados;
    private List<Gol> lstGoles;
    private int asistencias;
    private List<Tarjeta> lstTarjetasAmarillas;
    private Tarjeta tarjetaRoja;
    

    

    public Rendimiento() {
        lstGoles = new ArrayList<Gol>();
        lstTarjetasAmarillas = new ArrayList<Tarjeta>();
    }


    public Rendimiento(String id, int minutosJugados, int asistencias) {
        this.id = id;
        this.minutosJugados = minutosJugados;
        this.asistencias = asistencias;
        lstGoles = new ArrayList<Gol>();
        lstTarjetasAmarillas = new ArrayList<Tarjeta>();
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


    public int getMinutosJugados() {
        return minutosJugados;
    }


    public void setMinutosJugados(int minutosJugados) {
        this.minutosJugados = minutosJugados;
    }


    public List<Gol> getLstGoles() {
        return lstGoles;
    }


    public void setLstGoles(Gol gol) {
        this.lstGoles.add(gol);
    }

    public void deleteLstGoles(Gol gol){
        this.lstGoles.remove(gol);
    }


    public int getAsistencias() {
        return asistencias;
    }


    public void setAsistencias(int asistencias) {
        this.asistencias = asistencias;
    }


    public List<Tarjeta> getLstTarjetasAmarillas() {
        return lstTarjetasAmarillas;
    }


    public void setLstTarjetasAmarillas(Tarjeta tarjetaAmarilla) {
        this.lstTarjetasAmarillas.add(tarjetaAmarilla);
    }

    public void deleteLstTarjetasAmarillas(Tarjeta tarjetaAmarilla){
        this.lstTarjetasAmarillas.remove(tarjetaAmarilla);
    }


    public Tarjeta getTarjetaRoja() {
        return tarjetaRoja;
    }


    public void setTarjetaRoja(Tarjeta tarjetaRoja) {
        this.tarjetaRoja = tarjetaRoja;
    }

    


    

}
