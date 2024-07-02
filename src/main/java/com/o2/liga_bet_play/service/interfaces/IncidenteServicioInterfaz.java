package com.o2.liga_bet_play.service.interfaces;

import com.o2.liga_bet_play.model.entity.Incidente;

public interface IncidenteServicioInterfaz {
    void displayMenu();

    void createIncident();

    // void updateIncident();

    void searchIncident();

    void deleteIncident();

    void listAllIncidents();

    void displayIncidentDetails(Incidente incidente);
}
