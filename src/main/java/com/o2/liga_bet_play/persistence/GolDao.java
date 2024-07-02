package com.o2.liga_bet_play.persistence;

import java.util.Collection;
import java.util.concurrent.atomic.AtomicInteger;

import com.o2.liga_bet_play.controller.GolController;

import com.o2.liga_bet_play.model.entity.Gol;

public class GolDao {
    public GolController controlador;
    private AtomicInteger idCounter = new AtomicInteger(1); // Contador de IDs

    public GolDao(GolController controlador) {
        this.controlador = controlador;
    }

    public void saveGol(Gol gol) {

        controlador.goles.put(gol.getId(), gol);
    }

    public Gol getGolById(String id) {
        return controlador.goles.get(id);
    }

    public Gol deleteGolById(String id) {
        return controlador.goles.remove(id);
    }

    public Collection<Gol> getAllGoles() {
        return controlador.goles.values();
    }

    public String uniqueId() {
        int id = idCounter.getAndIncrement();
        return String.format("gol-%d", id);
    }
}
