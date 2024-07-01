package com.o2.liga_bet_play.persistence;

import java.util.Collection;
import java.util.concurrent.atomic.AtomicInteger;

import com.o2.liga_bet_play.controller.LesionController;
import com.o2.liga_bet_play.model.entity.Lesion;

public class LesionDao {

    public LesionController controlador;
    private AtomicInteger idCounter = new AtomicInteger(1);

    public LesionDao(LesionController controlador) {
        this.controlador = controlador;
    }

    public void saveLesion(Lesion lesion) {

        controlador.lesiones.put(lesion.getId(), lesion);
    }

    public Lesion getLesionById(String id) {
        return controlador.lesiones.get(id);
    }

    public Lesion deleteLesionById(String id) {
        return controlador.lesiones.remove(id);
    }

    public Collection<Lesion> getAllLesiones() {
        return controlador.lesiones.values();
    }

    public String uniqueId() {
        int id = idCounter.getAndIncrement();
        return String.format("les-%d", id);
    }
}
