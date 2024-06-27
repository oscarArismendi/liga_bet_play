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
    

    
}
