package com.o2.liga_bet_play.model.entity;

import java.util.List;

public class Resultado {
    private int id;
    private int partido;
    private List<Integer> golesEquipoLocal;
    private List<Integer> golesEquipoVisitante;
    
    public Resultado(int id, int partido, List<Integer> golesEquipoLocal, List<Integer> golesEquipoVisitante) {
        this.id = id;
        this.partido = partido;
        this.golesEquipoLocal = golesEquipoLocal;
        this.golesEquipoVisitante = golesEquipoVisitante;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPartido() {
        return partido;
    }

    public void setPartido(int partido) {
        this.partido = partido;
    }

    public List<Integer> getGolesEquipoLocal() {
        return golesEquipoLocal;
    }

    public void setGolesEquipoLocal(List<Integer> golesEquipoLocal) {
        this.golesEquipoLocal = golesEquipoLocal;
    }

    public List<Integer> getGolesEquipoVisitante() {
        return golesEquipoVisitante;
    }

    public void setGolesEquipoVisitante(List<Integer> golesEquipoVisitante) {
        this.golesEquipoVisitante = golesEquipoVisitante;
    }


    
}
