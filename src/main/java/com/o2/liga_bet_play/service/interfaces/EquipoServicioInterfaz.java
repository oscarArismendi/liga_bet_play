package com.o2.liga_bet_play.service.interfaces;

import com.o2.liga_bet_play.model.entity.Equipo;

public interface EquipoServicioInterfaz {
    void displayMenu();

    void createTeam();

    void updateTeam();

    void searchTeam();

    void deleteTeam();

    void listAllTeams();

    void displayTeamDetails(Equipo equipo);
}
