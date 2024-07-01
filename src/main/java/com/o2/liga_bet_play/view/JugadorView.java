package com.o2.liga_bet_play.view;

import com.o2.liga_bet_play.service.JugadorServicio;
import com.o2.liga_bet_play.utils.ConsoleUtils;

public class JugadorView {
    private JugadorServicio jugadorServicio;

    // Constructor que permite la inyección de dependencias
    public JugadorView(JugadorServicio jugadorServicio) {
        this.jugadorServicio = jugadorServicio;
    }

    public void showMenu() {
        while (true) {
            ConsoleUtils.cleanScreen();
            jugadorServicio.displayMenu();
            int opcion = ConsoleUtils.option_validation("Opcion: ", 1, 6);
            switch (opcion) {
                case 1:
                    jugadorServicio.createPlayer();
                    break;
                case 2:
                    jugadorServicio.updatePlayer();
                    break;
                case 3:
                    jugadorServicio.searchPlayer();
                    break;
                case 4:
                    jugadorServicio.deletePlayer();
                    break;
                case 5:
                    jugadorServicio.listAllPlayers();
                    break;
                case 6:
                    return;
                default:
                    break;
            }
        }

    }
}
