package com.o2.liga_bet_play.persistence;

import java.util.Collection;
import java.util.concurrent.atomic.AtomicInteger;

import com.o2.liga_bet_play.controller.PartidoController;

import com.o2.liga_bet_play.model.entity.Partido;

public class PartidoDao {
    public PartidoController controlador;
    private AtomicInteger idCounter = new AtomicInteger(1); // Contador de IDs

    public PartidoDao(PartidoController controlador) {
        this.controlador = controlador;
    }

    public void savePartido(Partido partido) {

        controlador.partidos.put(partido.getId(), partido);
    }

    public Partido getPartidoById(String id) {
        return controlador.partidos.get(id);
    }

    public Partido deletePartidoById(String id) {
        return controlador.partidos.remove(id);
    }

    public Collection<Partido> getAllPartidos() {
        return controlador.partidos.values();
    }

    public String uniqueId() {
        int id = idCounter.getAndIncrement();
        return String.format("par-%d", id);
    }
}
