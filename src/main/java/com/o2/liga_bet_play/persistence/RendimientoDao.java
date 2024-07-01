package com.o2.liga_bet_play.persistence;

import java.util.Collection;
import java.util.UUID;

import com.o2.liga_bet_play.controller.RendimientoController;
import com.o2.liga_bet_play.model.entity.Rendimiento;

public class RendimientoDao {

    public static RendimientoController controlador;

    public void saveRendimiento(Rendimiento rendimiento) {

        controlador.rendimientos.put(rendimiento.getId(), rendimiento);
    }

    public Rendimiento getRendimientoById(String id) {
        return controlador.rendimientos.get(id);
    }

    public Collection<Rendimiento> getAllRendimientos() {
        return controlador.rendimientos.values();
    }

    public String uniqueId() {
        UUID uuid = UUID.randomUUID();
        return uuid.toString();
    }
}
