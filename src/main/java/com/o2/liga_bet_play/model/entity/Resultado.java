package com.o2.liga_bet_play.model.entity;

import java.util.ArrayList;
import java.util.List;

public class Resultado {
    private String id;
    private Partido partido;
    private List<Gol> lstGolesEquipoLocal;
    private List<Gol> lstGolesEquipoVisitante;

    public Resultado() {
        lstGolesEquipoLocal = new ArrayList<Gol>();
        lstGolesEquipoVisitante = new ArrayList<Gol>();
    }

    public Resultado(String id) {
        this.id = id;
        lstGolesEquipoLocal = new ArrayList<Gol>();
        lstGolesEquipoVisitante = new ArrayList<Gol>();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Partido getPartido() {
        return partido;
    }

    public void setPartido(Partido partido) {
        this.partido = partido;
    }

    public List<Gol> getLstGolesEquipoLocal() {
        return lstGolesEquipoLocal;
    }

    public void setLstGolesEquipoLocal(Gol gol) {
        this.lstGolesEquipoLocal.add(gol);
    }

    public void deleteLstGolesEquipoLocal(Gol gol) {
        this.lstGolesEquipoLocal.remove(gol);
    }

    public List<Gol> getLstGolesEquipoVisitante() {
        return lstGolesEquipoVisitante;
    }

    public void setLstGolesEquipoVisitante(Gol gol) {
        this.lstGolesEquipoVisitante.add(gol);
    }

    public void deleteLstGolesEquipoVisitante(Gol gol) {
        this.lstGolesEquipoVisitante.remove(gol);
    }

}
