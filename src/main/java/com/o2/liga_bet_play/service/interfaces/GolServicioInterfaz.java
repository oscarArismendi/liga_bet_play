package com.o2.liga_bet_play.service.interfaces;

import com.o2.liga_bet_play.model.entity.Gol;

public interface GolServicioInterfaz {
    void displayMenu();

    void createGoal();

    // void updateGoal();

    void searchGoal();

    void deleteGoal();

    void listAllGoals();

    void displayGoalDetails(Gol gol);
}
