package com.o2.liga_bet_play.persistence;

import java.util.Collection;
import java.util.concurrent.atomic.AtomicInteger;

import com.o2.liga_bet_play.controller.TarjetaController;

import com.o2.liga_bet_play.model.entity.Tarjeta;

public class TarjetaDao {
    public TarjetaController controlador;
    private AtomicInteger idCounter = new AtomicInteger(1); // Contador de IDs

    public TarjetaDao(TarjetaController controlador) {
        this.controlador = controlador;
    }

    public void saveTarjeta(Tarjeta tarjeta) {

        controlador.tarjetas.put(tarjeta.getId(), tarjeta);
    }

    public Tarjeta getTarjetaById(String id) {
        return controlador.tarjetas.get(id);
    }

    public Tarjeta deleteTarjetaById(String id) {
        return controlador.tarjetas.remove(id);
    }

    public Collection<Tarjeta> getAllTarjetas() {
        return controlador.tarjetas.values();
    }

    public String uniqueId() {
        int id = idCounter.getAndIncrement();
        return String.format("tar-%d", id);
    }
}
