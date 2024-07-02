package com.o2.liga_bet_play.view;

import com.o2.liga_bet_play.service.EntrenadorServicio;

import com.o2.liga_bet_play.utils.ConsoleUtils;

public class EntrenadorView {
    private EntrenadorServicio entrenadorServicio;

    public EntrenadorView(EntrenadorServicio entrenadorServicio) {
        this.entrenadorServicio = entrenadorServicio;
    }

    public void showMenu() {
        while (true) {
            ConsoleUtils.cleanScreen();
            entrenadorServicio.displayMenu();
            int option = ConsoleUtils.option_validation("Opcion: ", 1, 6);

            switch (option) {
                case 1:
                    entrenadorServicio.createCoach();
                    break;
                case 2:
                    entrenadorServicio.searchCoach();
                    break;
                case 3:
                    entrenadorServicio.deleteCoach();
                    break;
                case 4:
                    entrenadorServicio.listAllCoachs();
                    break;
                case 5:
                    entrenadorServicio.updateCoach();
                    break;
                case 6:
                    return;
                default:
                    System.out.println("Opción inválida. Intente nuevamente.");
                    break;
            }
        }
    }
}
