package com.o2.liga_bet_play.service;

import com.o2.liga_bet_play.model.entity.Usuario;
import com.o2.liga_bet_play.persistence.UsuarioDAOImpl;
import com.o2.liga_bet_play.model.entity.Rol;
import com.o2.liga_bet_play.model.entity.Permiso;
import com.o2.liga_bet_play.service.AuthService;

@SuppressWarnings("unused")
public class LoginApp {
    public static void main(String[] args) {
        UsuarioDAOImpl usuarioDAO = new UsuarioDAOImpl();
        AuthService authService = new AuthService(usuarioDAO);

        // Crear permisos
        Permiso viewStats = new Permiso("1", "Ver estadísticas");
        Permiso editStats = new Permiso("2", "Editar estadísticas");
        Permiso manageUsers = new Permiso("3", "Gestionar usuarios");

        // Crear roles
        Rol adminRol = new Rol("1", "Administrador");
        adminRol.setLstPermisos(manageUsers);
        adminRol.setLstPermisos(editStats);

        Rol coachRol = new Rol("2", "Entrenador");
        coachRol.setLstPermisos(viewStats);
        coachRol.setLstPermisos(editStats);

        Rol playerRol = new Rol("3", "Jugador");
        playerRol.setLstPermisos(viewStats);

        Rol journalistRol = new Rol("4", "Periodista");
        journalistRol.setLstPermisos(viewStats);

        Rol fanRol = new Rol("5", "Aficionado");
        fanRol.setLstPermisos(viewStats);

        // Crear usuarios con roles
        Usuario admin = new Usuario("1", "Admin", "admin@example.com", "admin123", adminRol);
        Usuario coach = new Usuario("2", "Coach", "coach@example.com", "coach123", coachRol);
        Usuario player = new Usuario("3", "Player", "player@example.com", "player123", playerRol);
        Usuario journalist = new Usuario("4", "Journalist", "journalist@example.com", "journalist123", journalistRol);
        Usuario fan = new Usuario("5", "Fan", "fan@example.com", "fan123", fanRol);

        // Agregar usuarios al DAO
        usuarioDAO.addUsuario(admin);
        usuarioDAO.addUsuario(coach);
        usuarioDAO.addUsuario(player);
        usuarioDAO.addUsuario(journalist);
        usuarioDAO.addUsuario(fan);

        // Autenticar usuarios
        autenticarYMostrar(authService, "admin@example.com", "admin123");
        autenticarYMostrar(authService, "coach@example.com", "coach123");
        autenticarYMostrar(authService, "player@example.com", "player123");
        autenticarYMostrar(authService, "journalist@example.com", "journalist123");
        autenticarYMostrar(authService, "fan@example.com", "fan123");
    }

    private static void autenticarYMostrar(AuthService authService, String email, String password) {
        if (authService.authenticate(email, password)) {
            Usuario authenticatedUser = authService.getUsuario(email);
            System.out.println("Autenticación exitosa para " + authenticatedUser.getNombre() + " con rol " + authenticatedUser.getRol().getNombre());
        } else {
            System.out.println("Autenticación fallida para el email " + email);
        }
    }
}
