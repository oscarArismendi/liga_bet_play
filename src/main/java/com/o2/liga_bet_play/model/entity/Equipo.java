package com.o2.liga_bet_play.model.entity;
import java.util.ArrayList;
import java.util.List;

public class Equipo {
    private String id;
    private String nombre;
    private String ciudad;
    private Estadio estadio;
    private Entrenador entrenador;
    private List<Jugador> lstJugadores;
    private List<Partido> lstPartidos;
    
    public Equipo() {
        lstJugadores = new ArrayList<Jugador>();
        lstPartidos = new ArrayList<Partido>();
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

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public Estadio getEstadio() {
        return estadio;
    }

    public void setEstadio(Estadio estadio) {
        this.estadio = estadio;
    }

    public Entrenador getEntrenador() {
        return entrenador;
    }

    public void setEntrenador(Entrenador entrenador) {
        this.entrenador = entrenador;
    }

    public List<Jugador> getLstJugadores() {
        return lstJugadores;
    }

    public void setLstJugadores(Jugador jugador) {
        this.lstJugadores.add(jugador);
    }

    public List<Partido> getLstPartidos() {
        return lstPartidos;
    }

    public void setLstPartidos(Partido partido) {
        this.lstPartidos.add(partido);
    }
    
    
    
    
    
}
