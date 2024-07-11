package com.o2.liga_bet_play.model.entity;

public class Persona {
    private String id;
    private String nombre;
    private int edad;
    private String nacionalidad;

    public Persona() {
    }

    public Persona(String id, String nombre, int edad, String nacionalidad) {
        this.id = id;
        this.nombre = nombre;
        this.edad = edad;
        this.nacionalidad = nacionalidad;
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

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

}
