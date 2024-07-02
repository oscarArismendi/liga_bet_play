package com.o2.liga_bet_play.service.interfaces;

import com.o2.liga_bet_play.model.entity.Lesion;

public interface LesionServicioInterfaz {
    void displayMenu();

    void createInjurie();

    void updateInjurie();

    void searchInjurie();

    void deleteInjurie();

    void listAllInjuries();

    void displayInjurieDetails(Lesion lesion);
}
