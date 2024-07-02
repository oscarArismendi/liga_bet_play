package com.o2.liga_bet_play.service.interfaces;

import com.o2.liga_bet_play.model.entity.Entrenador;

public interface EntrenadorServicioInterfaz {
    void displayMenu();

    void createCoach();

    // void updateCoach();

    void searchCoach();

    void deleteCoach();

    void listAllCoachs();

    void displayCoachDetails(Entrenador entrenador);
}
