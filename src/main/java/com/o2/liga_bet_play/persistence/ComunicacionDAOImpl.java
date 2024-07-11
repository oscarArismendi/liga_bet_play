package com.o2.liga_bet_play.persistence;

import com.o2.liga_bet_play.model.entity.Comunicacion;

import java.util.Hashtable;

public class ComunicacionDAOImpl implements ComunicacionDAO {
    private Hashtable<String, Comunicacion> comunicaciones = new Hashtable<>();

    @Override
    public void addComunicacion(Comunicacion comunicacion) {
        if (comunicacion == null || comunicacion.getId() == null) {
            throw new IllegalArgumentException("Comunicación o ID no puede ser nulo");
        }
        comunicaciones.put(comunicacion.getId(), comunicacion);
    }

    @Override
    public Comunicacion getComunicacionById(String id) {
        return comunicaciones.get(id);
    }

    @Override
    public void updateComunicacion(Comunicacion comunicacion) {
        if (comunicacion == null || comunicacion.getId() == null) {
            throw new IllegalArgumentException("Comunicación o ID no puede ser nulo");
        }
        comunicaciones.put(comunicacion.getId(), comunicacion);
    }

    @Override
    public void deleteComunicacion(String id) {
        comunicaciones.remove(id);
    }

    @Override
    public Hashtable<String, Comunicacion> getComunicaciones() {
        return comunicaciones;
    }
}
