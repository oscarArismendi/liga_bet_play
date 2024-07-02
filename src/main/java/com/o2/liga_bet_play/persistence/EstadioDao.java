package com.o2.liga_bet_play.persistence;

import java.util.Collection;
import java.util.concurrent.atomic.AtomicInteger;

import com.o2.liga_bet_play.controller.EstadioController;

import com.o2.liga_bet_play.model.entity.Estadio;

public class EstadioDao {
    public EstadioController controlador;
    private AtomicInteger idCounter = new AtomicInteger(1); // Contador de IDs

    public EstadioDao(EstadioController controlador) {
        this.controlador = controlador;
    }

    public void saveEstadio(Estadio estadio) {

        controlador.estadios.put(estadio.getId(), estadio);
    }

    public Estadio getEstadioById(String id) {
        return controlador.estadios.get(id);
    }

    public Estadio deleteEstadioById(String id) {
        return controlador.estadios.remove(id);
    }

    public Collection<Estadio> getAllEstadios() {
        return controlador.estadios.values();
    }

    public String uniqueId() {
        int id = idCounter.getAndIncrement();
        return String.format("est-%d", id);
    }
}
