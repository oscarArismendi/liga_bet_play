package com.o2.liga_bet_play.service.interfaces;

import com.o2.liga_bet_play.model.entity.Rendimiento;

public interface RendimientoServicioInterfaz {
    void displayMenu();

    void createPerformance();

    void updatePerformance();

    void searchPerformance();

    void deletePerformance();

    void listAllPerformances();

    void displayPerformanceDetails(Rendimiento rendimiento);
}
