package com.o2.liga_bet_play.persistence;

import com.o2.liga_bet_play.model.entity.Usuario;

public enum UsuarioDAOEnum {
    ;

    public interface UsuarioDAO {
        void addUsuario(Usuario usuario);
        Usuario getUsuarioByEmail(String email);
    }

    Usuario getUsuarioByEmail(String email) {
        throw new UnsupportedOperationException("Unimplemented method 'getUsuarioByEmail'");
    }
}
