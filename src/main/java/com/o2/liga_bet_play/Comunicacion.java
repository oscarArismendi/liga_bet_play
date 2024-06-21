package com.o2.liga_bet_play;

import java.util.List;

public class Comunicacion {
    private int id;
    private String titulo;
    private String contenido;
    private String fechaPublicacion;
    private List<Integer> destinatarios; // Lista de usuarios destinatarios de la comunicación.
    
    public Comunicacion(int id, String titulo, String contenido, String fechaPublicacion, List<Integer> destinatarios) {
        this.id = id;
        this.titulo = titulo;
        this.contenido = contenido;
        this.fechaPublicacion = fechaPublicacion;
        this.destinatarios = destinatarios;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public String getFechaPublicacion() {
        return fechaPublicacion;
    }

    public void setFechaPublicacion(String fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }

    public List<Integer> getDestinatarios() {
        return destinatarios;
    }

    public void setDestinatarios(List<Integer> destinatarios) {
        this.destinatarios = destinatarios;
    }

    
    
}
