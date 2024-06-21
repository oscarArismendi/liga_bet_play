package com.o2.liga_bet_play.model.entity;

import java.util.List;

public class Jugador {
    private int id;
    private String nombre;
    private int edad;
    private String posicion;
    private String nacionalidad;
    private int numeroCamiseta;
    private List<Integer> equipo;
    private List<Integer> lesiones;
    private List<Integer> rendimientos;

    public Jugador(int id, String nombre, int edad, String posicion, String nacionalidad, int numeroCamiseta,
            List<Integer> equipo, List<Integer> lesiones, List<Integer> rendimientos) {
        this.id = id;
        this.nombre = nombre;
        this.edad = edad;
        this.posicion = posicion;
        this.nacionalidad = nacionalidad;
        this.numeroCamiseta = numeroCamiseta;
        this.equipo = equipo;
        this.lesiones = lesiones;
        this.rendimientos = rendimientos;
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

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getPosicion() {
        return posicion;
    }

    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public int getNumeroCamiseta() {
        return numeroCamiseta;
    }

    public void setNumeroCamiseta(int numeroCamiseta) {
        this.numeroCamiseta = numeroCamiseta;
    }

    public List<Integer> getEquipo() {
        return equipo;
    }

    public void setEquipo(List<Integer> equipo) {
        this.equipo = equipo;
    }

    public List<Integer> getLesiones() {
        return lesiones;
    }

    public void setLesiones(List<Integer> lesiones) {
        this.lesiones = lesiones;
    }

    public List<Integer> getRendimientos() {
        return rendimientos;
    }

    public void setRendimientos(List<Integer> rendimientos) {
        this.rendimientos = rendimientos;
    }

    

    
}
