package com.o2.liga_bet_play.view;

import com.o2.liga_bet_play.service.EquipoServicio;
import com.o2.liga_bet_play.utils.ConsoleUtils;

public class EquipoView {
    private EquipoServicio equipoServicio;

    public EquipoView(EquipoServicio equipoServicio) {
        this.equipoServicio = equipoServicio;
    }

    public void showMenu() {
        while (true) {
            ConsoleUtils.cleanScreen();
            equipoServicio.displayMenu();
            int option = ConsoleUtils.option_validation("Opcion: ", 1, 6);

            switch (option) {
                case 1:
                    equipoServicio.createTeam();
                    break;
                case 2:
                    equipoServicio.searchTeam();
                    break;
                case 3:
                    equipoServicio.deleteTeam();
                    break;
                case 4:
                    equipoServicio.listAllTeams();
                    break;
                case 5:
                    equipoServicio.updateTeam();
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
