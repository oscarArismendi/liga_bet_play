package com.o2.liga_bet_play.persistence;

import java.util.Collection;
import java.util.concurrent.atomic.AtomicInteger;

import com.o2.liga_bet_play.controller.JugadorController;
import com.o2.liga_bet_play.model.entity.Jugador;

public class JugadorDao {
    public JugadorController controlador;
    private AtomicInteger idCounter = new AtomicInteger(1); // Contador de IDs

    public JugadorDao(JugadorController controlador) {
        this.controlador = controlador;
    }

    public void saveJugador(Jugador jugador) {

        controlador.jugadores.put(jugador.getId(), jugador);
    }

    public Jugador getJugadorById(String id) {
        return controlador.jugadores.get(id);
    }

    public Jugador deleteJugadorById(String id) {
        return controlador.jugadores.remove(id);
    }

    public Collection<Jugador> getAllJugadores() {
        return controlador.jugadores.values();
    }

    public String uniqueId() {
        int id = idCounter.getAndIncrement();
        return String.format("jug-%d", id);
    }
}
