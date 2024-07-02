package com.o2.liga_bet_play.dao;

import com.o2.liga_bet_play.model.entity.Usuario;
import java.util.List;

public interface UsuarioDao {
    Usuario getUsuarioByEmail(String email);
    void addUsuario(Usuario usuario);
    void updateUsuario(Usuario usuario);
    void deleteUsuario(String id);
    List<Usuario> getAllUsuarios();
}
