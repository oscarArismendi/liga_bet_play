package com.o2.liga_bet_play.persistence;

import com.o2.liga_bet_play.model.entity.Premio;
import java.util.Hashtable;

public interface PremioDAO {
    void addPremio(Premio premio);
    void updatePremio(Premio premio);
    void deletePremio(String id);
    Premio getPremioById(String id);
    Hashtable<String, Premio> getAllPremios();
}
