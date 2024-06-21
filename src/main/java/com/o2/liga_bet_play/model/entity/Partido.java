package com.o2.liga_bet_play.model.entity;

import java.util.List;

public class Partido {

    private int id;
    private int equipoLocal;
    private int equipoVisitante;
    private String fecha;
    private String hora;
    private int estadio;
    private List<Integer> goles;
    private List<Integer> tarjetas;
    private List<Integer> incidentes;
    private List<Integer> resultado;
    
    public Partido(int id, int equipoLocal, int equipoVisitante, String fecha, String hora, int estadio,
            List<Integer> goles, List<Integer> tarjetas, List<Integer> incidentes, List<Integer> resultado) {
        this.id = id;
        this.equipoLocal = equipoLocal;
        this.equipoVisitante = equipoVisitante;
        this.fecha = fecha;
        this.hora = hora;
        this.estadio = estadio;
        this.goles = goles;
        this.tarjetas = tarjetas;
        this.incidentes = incidentes;
        this.resultado = resultado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEquipoLocal() {
        return equipoLocal;
    }

    public void setEquipoLocal(int equipoLocal) {
        this.equipoLocal = equipoLocal;
    }

    public int getEquipoVisitante() {
        return equipoVisitante;
    }

    public void setEquipoVisitante(int equipoVisitante) {
        this.equipoVisitante = equipoVisitante;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public int getEstadio() {
        return estadio;
    }

    public void setEstadio(int estadio) {
        this.estadio = estadio;
    }

    public List<Integer> getGoles() {
        return goles;
    }

    public void setGoles(List<Integer> goles) {
        this.goles = goles;
    }

    public List<Integer> getTarjetas() {
        return tarjetas;
    }

    public void setTarjetas(List<Integer> tarjetas) {
        this.tarjetas = tarjetas;
    }

    public List<Integer> getIncidentes() {
        return incidentes;
    }

    public void setIncidentes(List<Integer> incidentes) {
        this.incidentes = incidentes;
    }

    public List<Integer> getResultado() {
        return resultado;
    }

    public void setResultado(List<Integer> resultado) {
        this.resultado = resultado;
    }
    
    
    
}
