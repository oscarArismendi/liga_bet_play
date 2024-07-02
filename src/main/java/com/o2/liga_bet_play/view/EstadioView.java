package com.o2.liga_bet_play.view;

import com.o2.liga_bet_play.service.EstadioServicio;

import com.o2.liga_bet_play.utils.ConsoleUtils;

public class EstadioView {
    private EstadioServicio estadioServicio;

    public EstadioView(EstadioServicio estadioServicio) {
        this.estadioServicio = estadioServicio;
    }

    public void showMenu() {
        while (true) {
            ConsoleUtils.cleanScreen();
            estadioServicio.displayMenu();
            int option = ConsoleUtils.option_validation("Opcion: ", 1, 6);

            switch (option) {
                case 1:
                    estadioServicio.createStadium();
                    ;
                    break;
                case 2:
                    estadioServicio.searchStadium();
                    ;
                    break;
                case 3:
                    estadioServicio.deleteStadium();
                    ;
                    break;
                case 4:
                    estadioServicio.listAllStadiums();
                    ;
                    break;
                case 5:
                    estadioServicio.updateStadium();
                    ;
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
