package com.o2.liga_bet_play.model.entity;

import java.util.ArrayList;
import java.util.List;

public class Jugador extends Persona {
    private String posicion;

    private int numeroCamiseta;
    private Equipo equipo;
    private List<Lesion> lstLesiones;
    private List<Rendimiento> lstRendimientos;

    public Jugador() {
        lstLesiones = new ArrayList<Lesion>();
        lstRendimientos = new ArrayList<Rendimiento>();
    }

    public Jugador(String id, String nombre, int edad, String nacionalidad, String posicion, int numeroCamiseta) {
        super(id, nombre, edad, nacionalidad);
        this.numeroCamiseta = numeroCamiseta;
        this.posicion = posicion;
    }

    public String getPosicion() {
        return posicion;
    }

    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }

    public int getNumeroCamiseta() {
        return numeroCamiseta;
    }

    public void setNumeroCamiseta(int numeroCamiseta) {
        this.numeroCamiseta = numeroCamiseta;
    }

    public Equipo getEquipo() {
        return equipo;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }

    public List<Lesion> getLstLesiones() {
        return lstLesiones;
    }

    public void setLstLesiones(Lesion lesion) {
        this.lstLesiones.add(lesion);
    }

    public List<Rendimiento> getLstRendimientos() {
        return lstRendimientos;
    }

    public void setLstRendimientos(Rendimiento rendimiento) {
        this.lstRendimientos.add(rendimiento);
    }

}
