package com.o2.liga_bet_play.view;

import com.o2.liga_bet_play.service.RendimientoServicio;
import com.o2.liga_bet_play.utils.ConsoleUtils;

public class RendimientoView {
    private RendimientoServicio rendimientoServicio;

    // Constructor que permite la inyección de dependencias
    public RendimientoView(RendimientoServicio rendimientoServicio) {
        this.rendimientoServicio = rendimientoServicio;
    }

    public void showMenu() {
        while (true) {
            ConsoleUtils.cleanScreen();
            rendimientoServicio.displayMenu();
            int opcion = ConsoleUtils.option_validation("Opción: ", 1, 6);
            switch (opcion) {
                case 1:
                    rendimientoServicio.createPerformance();
                    break;
                case 2:
                    rendimientoServicio.updatePerformance();
                    break;
                case 3:
                    rendimientoServicio.searchPerformance();
                    break;
                case 4:
                    rendimientoServicio.deletePerformance();
                    break;
                case 5:
                    rendimientoServicio.listAllPerformances();
                    break;
                case 6:
                    return;
                default:
                    break;
            }
        }
    }
}
