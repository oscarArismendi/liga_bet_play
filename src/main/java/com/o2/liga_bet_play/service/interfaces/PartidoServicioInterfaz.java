package com.o2.liga_bet_play.service.interfaces;

import com.o2.liga_bet_play.model.entity.Partido;

public interface PartidoServicioInterfaz {
    void displayMenu();

    void createMatch();

    // void updateMatch();

    void searchMatch();

    void deleteMatch();

    void listAllMatchs();

    void displayMatchDetails(Partido partido);
}
