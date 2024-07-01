package com.o2.liga_bet_play.view;

import com.o2.liga_bet_play.service.LesionServicio;
import com.o2.liga_bet_play.utils.ConsoleUtils;

public class LesionView {
    private LesionServicio lesionServicio;

    public LesionView(LesionServicio lesionServicio) {
        this.lesionServicio = lesionServicio;
    }

    public void showMenu() {
        while (true) {
            ConsoleUtils.cleanScreen();
            lesionServicio.displayMenu();
            int option = ConsoleUtils.option_validation("Opcion: ", 1, 6);

            switch (option) {
                case 1:
                    lesionServicio.createInjurie();
                    break;
                case 2:
                    lesionServicio.updateInjurie();
                    break;
                case 3:
                    lesionServicio.searchInjurie();
                    break;
                case 4:
                    lesionServicio.deleteInjurie();
                    break;
                case 5:
                    lesionServicio.listAllInjuries();
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
