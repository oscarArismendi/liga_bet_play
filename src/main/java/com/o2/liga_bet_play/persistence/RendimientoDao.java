package com.o2.liga_bet_play.persistence;

import java.util.Collection;

import java.util.concurrent.atomic.AtomicInteger;

import com.o2.liga_bet_play.controller.RendimientoController;
import com.o2.liga_bet_play.model.entity.Rendimiento;

public class RendimientoDao {

    public RendimientoController controlador;
    private AtomicInteger idCounter = new AtomicInteger(1); // Contador de IDs


    public RendimientoDao(RendimientoController controlador){
        this.controlador  = controlador;
    }
    public void saveRendimiento(Rendimiento rendimiento) {

        controlador.rendimientos.put(rendimiento.getId(), rendimiento);
    }

    public Rendimiento getRendimientoById(String id) {
        return controlador.rendimientos.get(id);
    }

    public Rendimiento deleteRendimientoById(String id) {
        return controlador.rendimientos.remove(id);
    }

    public Collection<Rendimiento> getAllRendimientos() {
        return controlador.rendimientos.values();
    }

    public String uniqueId() {
        int id = idCounter.getAndIncrement();
        return String.format("ren-%d", id);
    }
}
