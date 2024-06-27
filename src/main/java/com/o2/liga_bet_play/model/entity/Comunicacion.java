package com.o2.liga_bet_play.model.entity;

import java.util.ArrayList;
import java.util.List;

public class Comunicacion {
    private String id;
    private String titulo;
    private String contenido;
    private String fechaPublicacion;
    private List<Usuario> LstDestinatarios; // Lista de usuarios destinatarios de la comunicación.

    public Comunicacion() {
        LstDestinatarios = new ArrayList<Usuario>();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    public List<Usuario> getLstDestinatarios() {
        return LstDestinatarios;
    }

    public void setLstDestinatarios(Usuario usuario) {
        this.LstDestinatarios.add(usuario);
    }

}
