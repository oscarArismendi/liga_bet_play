package com.o2.liga_bet_play;

import java.util.List;

public class Rol {
    private int id;
    private String nombre;
    private List<Integer> permisos;
    
    public Rol(int id, String nombre, List<Integer> permisos) {
        this.id = id;
        this.nombre = nombre;
        this.permisos = permisos;
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

    public List<Integer> getPermisos() {
        return permisos;
    }

    public void setPermisos(List<Integer> permisos) {
        this.permisos = permisos;
    }

    
}
