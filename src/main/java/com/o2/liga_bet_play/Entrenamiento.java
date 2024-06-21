package com.o2.liga_bet_play;

import java.util.List;

public class Entrenamiento {
    private int id;
    private int equipo;
    private String fecha;
    private String hora;
    private String lugar;
    private List<Integer> actividades;
    private List<Integer> jugadoresConvocados;
    
    public Entrenamiento(int id, int equipo, String fecha, String hora, String lugar, List<Integer> actividades,
            List<Integer> jugadoresConvocados) {
        this.id = id;
        this.equipo = equipo;
        this.fecha = fecha;
        this.hora = hora;
        this.lugar = lugar;
        this.actividades = actividades;
        this.jugadoresConvocados = jugadoresConvocados;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEquipo() {
        return equipo;
    }

    public void setEquipo(int equipo) {
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

    public List<Integer> getActividades() {
        return actividades;
    }

    public void setActividades(List<Integer> actividades) {
        this.actividades = actividades;
    }

    public List<Integer> getJugadoresConvocados() {
        return jugadoresConvocados;
    }

    public void setJugadoresConvocados(List<Integer> jugadoresConvocados) {
        this.jugadoresConvocados = jugadoresConvocados;
    }

    
}
