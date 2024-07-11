package com.o2.liga_bet_play.persistence;

import com.o2.liga_bet_play.model.entity.Comunicacion;

import java.util.Hashtable;

public interface ComunicacionDAO {
    void addComunicacion(Comunicacion comunicacion);
    Comunicacion getComunicacionById(String id);
    void updateComunicacion(Comunicacion comunicacion);
    void deleteComunicacion(String id);
    Hashtable<String, Comunicacion> getComunicaciones();
}

