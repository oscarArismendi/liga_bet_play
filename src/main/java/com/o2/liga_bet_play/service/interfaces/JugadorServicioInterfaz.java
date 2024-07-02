package com.o2.liga_bet_play.service.interfaces;

import com.o2.liga_bet_play.model.entity.Jugador;

public interface JugadorServicioInterfaz {
    void displayMenu();

    void createPlayer();

    void updatePlayer();

    void searchPlayer();

    void deletePlayer();

    void listAllPlayers();

    void displayPlayerDetails(Jugador jugador);
}
