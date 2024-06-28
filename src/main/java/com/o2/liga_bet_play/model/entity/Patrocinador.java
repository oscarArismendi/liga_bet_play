package com.o2.liga_bet_play.model.entity;

public class Patrocinador {
    private String id;
    private String nombre;
    private String tipo; //  (por ejemplo, principal, secundario, etc.).
    private double monto;
    private String fechaInicio;
    private String fechaFin;

    public Patrocinador(String id, String nombre, String tipo, double monto, String fechaInicio, String fechaFin) {
        this.id = id;
        this.nombre = nombre;
        this.tipo = tipo;
        this.monto = monto;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(String fechaFin) {
        this.fechaFin = fechaFin;
    }

    
    
}
