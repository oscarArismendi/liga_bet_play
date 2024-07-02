package com.o2.liga_bet_play.service;

import com.o2.liga_bet_play.model.entity.Usuario;
import com.o2.liga_bet_play.persistence.UsuarioDAOImpl;

public class AuthService {
    private UsuarioDAOImpl usuarioDAO;

    public AuthService(UsuarioDAOImpl usuarioDAO2) {
        this.usuarioDAO = usuarioDAO2;
    }

   

    public boolean authenticate(String email, String password) {
        Usuario usuario = usuarioDAO.getUsuarioByEmail(email);
        if (usuario != null && usuario.getPassword().equals(password)) {
            return true;
        }
        return false;
    }

    public Usuario getUsuario(String email) {
        return usuarioDAO.getUsuarioByEmail(email);
    }
}
