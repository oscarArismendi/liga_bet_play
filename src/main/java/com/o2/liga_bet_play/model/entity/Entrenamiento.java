package com.o2.liga_bet_play.model.entity;

import java.util.ArrayList;
import java.util.List;

public class Entrenamiento {
    private String id;
    private Equipo equipo;
    private String fecha;
    private String hora;
    private String lugar;
    private List<Actividad> lstActividades;
    private List<Jugador> lstJugadoresConvocados;

    public Entrenamiento(String id, String fecha, String hora, String lugar) {
        this.id = id;
        this.fecha = fecha;
        this.hora = hora;
        this.lugar = lugar;
        lstActividades = new ArrayList<Actividad>();
        lstJugadoresConvocados = new ArrayList<Jugador>();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Equipo getEquipo() {
        return equipo;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public List<Actividad> getLstActividades() {
        return lstActividades;
    }

    public void setLstActividades(Actividad actividad) {
        this.lstActividades.add(actividad);
    }

    public void deleteLstActividades(Actividad actividad) {
        this.lstActividades.remove(actividad);
    }

    public List<Jugador> getLstJugadoresConvocados() {
        return lstJugadoresConvocados;
    }

    public void setLstJugadoresConvocados(Jugador jugador) {
        this.lstJugadoresConvocados.add(jugador);
    }

    public void deleteLstJugadoresConvocados(Jugador jugador) {
        this.lstJugadoresConvocados.remove(jugador);
    }

}
