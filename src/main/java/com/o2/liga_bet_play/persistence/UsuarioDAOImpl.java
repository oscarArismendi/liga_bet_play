package com.o2.liga_bet_play.persistence;

import com.o2.liga_bet_play.model.entity.Usuario;
import com.o2.liga_bet_play.persistence.UsuarioDAOEnum.UsuarioDAO;

import java.util.HashMap;
import java.util.Map;

public class UsuarioDAOImpl implements UsuarioDAO {
    private Map<String, Usuario> usuarios = new HashMap<>();

    @Override
    public void addUsuario(Usuario usuario) {
        if (usuario == null || usuario.getEmail() == null) {
            throw new IllegalArgumentException("Usuario o email no puede ser nulo");
        }
        usuarios.put(usuario.getEmail(), usuario);
    }

    @Override
    public Usuario getUsuarioByEmail(String email) {
        return usuarios.get(email);
    }

    @Override
    public String toString() {
        return "UsuarioDAOImpl [usuarios=" + usuarios + "]";
    }
}
