package com.o2.liga_bet_play.persistence;

import com.o2.liga_bet_play.dao.UsuarioDao;
import com.o2.liga_bet_play.model.entity.Usuario;
import java.util.ArrayList;
import java.util.List;

public class RolDAOImpl implements UsuarioDao {
    private List<Usuario> usuarios;

    public RolDAOImpl() {
        usuarios = new ArrayList<>();
    }

    @Override
    public Usuario getUsuarioByEmail(String email) {
        for (Usuario usuario : usuarios) {
            if (usuario.getEmail().equals(email)) {
                return usuario;
            }
        }
        return null;
    }

    @Override
    public void addUsuario(Usuario usuario) {
        usuarios.add(usuario);
    }

    @Override
    public void updateUsuario(Usuario usuario) {
        for (int i = 0; i < usuarios.size(); i++) {
            if (usuarios.get(i).getId().equals(usuario.getId())) {
                usuarios.set(i, usuario);
                break;
            }
        }
    }

    @Override
    public void deleteUsuario(String id) {
        usuarios.removeIf(usuario -> usuario.getId().equals(id));
    }

    @Override
    public List<Usuario> getAllUsuarios() {
        return usuarios;
    }
}
