package com.o2.liga_bet_play.model.entity;
import java.util.List;

public class Equipo {
    private int id;
    private String nombre;
    private String ciudad;
    private List<Integer> estadio;
    private List<Integer> entrenador;
    private List<Integer> jugadores;
    private List<Integer> partidos;
    
    public Equipo(int id, String nombre, String ciudad, List<Integer> estadio, List<Integer> entrenador,
            List<Integer> jugadores, List<Integer> partidos) {
        this.id = id;
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.estadio = estadio;
        this.entrenador = entrenador;
        this.jugadores = jugadores;
        this.partidos = partidos;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public List<Integer> getEstadio() {
        return estadio;
    }

    public void setEstadio(List<Integer> estadio) {
        this.estadio = estadio;
    }

    public List<Integer> getEntrenador() {
        return entrenador;
    }

    public void setEntrenador(List<Integer> entrenador) {
        this.entrenador = entrenador;
    }

    public List<Integer> getJugadores() {
        return jugadores;
    }

    public void setJugadores(List<Integer> jugadores) {
        this.jugadores = jugadores;
    }

    public List<Integer> getPartidos() {
        return partidos;
    }

    public void setPartidos(List<Integer> partidos) {
        this.partidos = partidos;
    }

    
    
}
