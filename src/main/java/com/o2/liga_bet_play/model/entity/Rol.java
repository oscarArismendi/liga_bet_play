package com.o2.liga_bet_play.model.entity;

import java.util.ArrayList;
import java.util.List;

public class Rol {
    private String id;
    private String nombre;
    private List<Permiso> lstPermisos;

    // Constructor sin argumentos
    public Rol() {
        lstPermisos = new ArrayList<Permiso>();
    }

    // Constructor con argumentos
    public Rol(String id, String nombre) {
        this.id = id;
        this.nombre = nombre;
        this.lstPermisos = new ArrayList<>();
    }

    // Métodos Getters y Setters
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

    public List<Permiso> getLstPermisos() {
        return lstPermisos;
    }

    public void setLstPermisos(Permiso permiso) {
        this.lstPermisos.add(permiso);
    }

    // Método para eliminar un permiso de la lista
    public void deleteLstPermiso(Permiso permiso) {
        this.lstPermisos.remove(permiso);
    }
}
