package com.o2.liga_bet_play.persistence;

import com.o2.liga_bet_play.model.entity.Usuario;
import com.o2.liga_bet_play.persistence.UsuarioDAOEnum.UsuarioDAO;

import java.util.Hashtable;

public class UsuarioDAOImpl implements UsuarioDAO {
    private Hashtable<String, Usuario> usuarios = new Hashtable<>();

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

    public void deleteUsuario(String email) {
        if (usuarios.remove(email) != null) {
            System.out.println("Usuario eliminado exitosamente.");
        } else {
            System.out.println("Usuario no encontrado.");
        }
    }

    public Usuario[] getAllUsuarios() {
        return usuarios.values().toArray(new Usuario[0]);
    }

    public Hashtable<String, Usuario> getUsuarios() {
        return usuarios;
    }
}
