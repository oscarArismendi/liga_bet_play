package com.o2.liga_bet_play.persistence;

import java.util.Collection;
import java.util.concurrent.atomic.AtomicInteger;

import com.o2.liga_bet_play.controller.EquipoController;
import com.o2.liga_bet_play.model.entity.Equipo;

public class EquipoDao {
    public EquipoController controlador;
    private AtomicInteger idCounter = new AtomicInteger(1); // Contador de IDs

    public EquipoDao(EquipoController controlador) {
        this.controlador = controlador;
    }

    public void saveEquipo(Equipo equipo) {

        controlador.equipos.put(equipo.getId(), equipo);
    }

    public Equipo getEquipoById(String id) {
        return controlador.equipos.get(id);
    }

    public Equipo deleteEquipoById(String id) {
        return controlador.equipos.remove(id);
    }

    public Collection<Equipo> getAllEquipos() {
        return controlador.equipos.values();
    }

    public String uniqueId() {
        int id = idCounter.getAndIncrement();
        return String.format("equ-%d", id);
    }
}
