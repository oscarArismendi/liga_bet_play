package com.o2.liga_bet_play.service.interfaces;

import com.o2.liga_bet_play.model.entity.Tarjeta;

public interface TarjetaServicioInterfaz {
    void displayMenu();

    void createCard();

    // void updateCard();

    void searchCard();

    void deleteCard();

    void listAllCards();

    void displayCardDetails(Tarjeta tarjeta);
}
