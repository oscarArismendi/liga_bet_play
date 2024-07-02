package com.o2.liga_bet_play.persistence;

import java.util.Collection;
import java.util.concurrent.atomic.AtomicInteger;

import com.o2.liga_bet_play.controller.EntrenadorController;

import com.o2.liga_bet_play.model.entity.Entrenador;

public class EntrenadorDao {
    public EntrenadorController controlador;
    private AtomicInteger idCounter = new AtomicInteger(1); // Contador de IDs

    public EntrenadorDao(EntrenadorController controlador) {
        this.controlador = controlador;
    }

    public void saveEntrenador(Entrenador entrenador) {

        controlador.entrenadores.put(entrenador.getId(), entrenador);
    }

    public Entrenador getEntrenadorById(String id) {
        return controlador.entrenadores.get(id);
    }

    public Entrenador deleteEntrenadorById(String id) {
        return controlador.entrenadores.remove(id);
    }

    public Collection<Entrenador> getAllEntrenadores() {
        return controlador.entrenadores.values();
    }

    public String uniqueId() {
        int id = idCounter.getAndIncrement();
        return String.format("ent-%d", id);
    }
}
