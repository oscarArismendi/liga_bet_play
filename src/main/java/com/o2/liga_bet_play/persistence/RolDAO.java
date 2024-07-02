package com.o2.liga_bet_play.persistence;

import com.o2.liga_bet_play.model.entity.Rol;

public interface RolDAO {
    Rol getRolById(String id);
    void addRol(Rol rol);
    void updateRol(Rol rol);
    void deleteRol(String id);
}
