package com.o2.liga_bet_play.model.entity;

import java.util.ArrayList;
import java.util.List;

public class Partido {

    private String id;
    private Equipo equipoLocal;
    private Equipo equipoVisitante;
    private String fecha;
    private String hora;
    private Estadio estadio;
    private List<Gol> lstGoles;
    private List<Tarjeta> lstTarjetas;
    private List<Incidente> lstIncidentes;
    private Resultado resultado;

    public Partido() {
        lstTarjetas = new ArrayList<Tarjeta>();
        lstIncidentes = new ArrayList<Incidente>();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Equipo getEquipoLocal() {
        return equipoLocal;
    }

    public void setEquipoLocal(Equipo equipoLocal) {
        this.equipoLocal = equipoLocal;
    }

    public Equipo getEquipoVisitante() {
        return equipoVisitante;
    }

    public void setEquipoVisitante(Equipo equipoVisitante) {
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

    public Estadio getEstadio() {
        return estadio;
    }

    public void setEstadio(Estadio estadio) {
        this.estadio = estadio;
    }

    public List<Gol> getGoles() {
        return lstGoles;
    }

    public void setGoles(Gol gol) {
        this.lstGoles.add(gol);
    }

    public List<Tarjeta> getLstTarjetas() {
        return lstTarjetas;
    }

    public void setLstTarjetas(Tarjeta tarjeta) {
        this.lstTarjetas.add(tarjeta);
    }

    public List<Incidente> getLstIncidentes() {
        return lstIncidentes;
    }

    public void setLstIncidentes(Incidente incidente) {
        this.lstIncidentes.add(incidente);
    }

    public Resultado getResultado() {
        return resultado;
    }

    public void setResultado(Resultado resultado) {
        this.resultado = resultado;
    }

}
