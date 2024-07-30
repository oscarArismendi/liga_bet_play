package com.o2.liga_bet_play.model.entity;

public class Premio {
    private String id;
    private String nombre;
    private String descripcion;
    private String criterios;
    private String destinatarios;
    private String fecha;

    public Premio(String id, String nombre, String descripcion, String criterios, String destinatarios, String fecha) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.criterios = criterios;
        this.destinatarios = destinatarios;
        this.fecha = fecha;
    }

    // Getters y Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public String getCriterios() { return criterios; }
    public void setCriterios(String criterios) { this.criterios = criterios; }

    public String getDestinatarios() { return destinatarios; }
    public void setDestinatarios(String destinatarios) { this.destinatarios = destinatarios; }

    public String getFecha() { return fecha; }
    public void setFecha(String fecha) { this.fecha = fecha; }
}
