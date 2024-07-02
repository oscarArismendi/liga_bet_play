package com.o2.liga_bet_play.service.interfaces;

import com.o2.liga_bet_play.model.entity.Estadio;

public interface EstadioServicioInterfaz {

    void displayMenu();

    void createStadium();

    void updateStadium();

    void searchStadium();

    void deleteStadium();

    void listAllStadiums();

    void displayStadiumDetails(Estadio estadio);
}
