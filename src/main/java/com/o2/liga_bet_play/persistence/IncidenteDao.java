package com.o2.liga_bet_play.persistence;

import java.util.Collection;
import java.util.concurrent.atomic.AtomicInteger;

import com.o2.liga_bet_play.controller.IncidenteController;

import com.o2.liga_bet_play.model.entity.Incidente;


public class IncidenteDao {
    public IncidenteController controlador;
    private AtomicInteger idCounter = new AtomicInteger(1); // Contador de IDs

    public IncidenteDao(IncidenteController controlador) {
        this.controlador = controlador;
    }

    public void saveIncidente(Incidente incidente) {

        controlador.incidentes.put(incidente.getId(), incidente);
    }

    public Incidente getIncidenteById(String id) {
        return controlador.incidentes.get(id);
    }

    public Incidente deleteIncidenteById(String id) {
        return controlador.incidentes.remove(id);
    }

    public Collection<Incidente> getAllIncidentes() {
        return controlador.incidentes.values();
    }

    public String uniqueId() {
        int id = idCounter.getAndIncrement();
        return String.format("inc-%d", id);
    }
}
