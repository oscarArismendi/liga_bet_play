package com.o2.liga_bet_play.persistence;

import com.o2.liga_bet_play.model.entity.Premio;

import java.util.Hashtable;

public class PremioDAOImpl {
    private Hashtable<String, Premio> premios = new Hashtable<>();

    public void addPremio(Premio premio) {
        premios.put(premio.getId(), premio);
    }

    public Premio getPremioById(String id) {
        return premios.get(id);
    }

    public void updatePremio(Premio premio) {
        premios.put(premio.getId(), premio);
    }

    public void deletePremio(String id) {
        premios.remove(id);
    }

    public Hashtable<String, Premio> getAllPremios() {
        return premios;
    }
}
