package com.o2.liga_bet_play.service;

import java.util.Scanner;
import java.util.Set;

import com.o2.liga_bet_play.model.entity.Entrenador;
import com.o2.liga_bet_play.model.entity.Equipo;
import com.o2.liga_bet_play.model.entity.Jugador;
import com.o2.liga_bet_play.model.entity.Partido;

import com.o2.liga_bet_play.persistence.EntrenadorDao;
import com.o2.liga_bet_play.persistence.EquipoDao;
import com.o2.liga_bet_play.persistence.EstadioDao;
import com.o2.liga_bet_play.persistence.JugadorDao;
import com.o2.liga_bet_play.persistence.PartidoDao;

import com.o2.liga_bet_play.service.interfaces.EquipoServicioInterfaz;

import com.o2.liga_bet_play.utils.ConsoleUtils;

public class EquipoServicio implements EquipoServicioInterfaz {
    private EquipoDao equipoDao;
    private EstadioDao estadioDao;
    private EntrenadorDao entrenadorDao;
    private JugadorDao jugadorDao;
    private PartidoDao partidoDao;

    private Scanner scanner;

    public EquipoServicio(EquipoDao equipoDao) {// para pruebas
        this.equipoDao = equipoDao;
    }

    // Constructor que permite la inyección de dependencias
    public EquipoServicio(EquipoDao equipoDao, EstadioDao estadioDao, EntrenadorDao entrenadorDao,
            JugadorDao jugadorDao, PartidoDao partidoDao) {
        this.equipoDao = equipoDao;
        this.estadioDao = estadioDao;
        this.entrenadorDao = entrenadorDao;
        this.jugadorDao = jugadorDao;
        this.partidoDao = partidoDao;
    }

    public void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public void displayMenu() {
        ConsoleUtils.cleanScreen();
        System.out.println("---------------------MENU EQUIPO----------------------------------------");
        System.out.println("1. Crear Equipo");
        System.out.println("2. Buscar Equipo");
        System.out.println("3. Eliminar Equipo");
        System.out.println("4. Listar Todos los Equipos");
        System.out.println("5. Actualizar Equipo");
        System.out.println("6. Salir");
    }

    @Override
    public void createTeam() {
        ConsoleUtils.cleanScreen();
        System.out.println("---------------------MENU CREAR EQUIPO----------------------------------");
        String id = equipoDao.uniqueId();
        System.out.println("Ingrese nombre del equipo: ");
        String nombre = scanner.nextLine();
        System.out.println("Ingrese ciudad del equipo:  ");
        String ciudad = scanner.nextLine();

        Equipo equipo = new Equipo(id, nombre, ciudad);

        equipoDao.saveEquipo(equipo);
        System.out.println("Equipo creado exitosamente.");
        ConsoleUtils.pause();
    }

    @Override
    public void searchTeam() {
        ConsoleUtils.cleanScreen();
        System.out.println("---------------------MENU BUSCAR EQUIPO---------------------------------");
        System.out.println("Ingresa el codigo del equipo:");
        String id = scanner.nextLine();
        Equipo equipo = equipoDao.getEquipoById(id);
        if (equipo != null) {
            displayTeamDetails(equipo);
        } else {
            System.out.println("No se encontró un equipo con el codigo " + id);
        }
        ConsoleUtils.pause();
    }

    @Override
    public void deleteTeam() {
        ConsoleUtils.cleanScreen();
        System.out.println("---------------------MENU ELIMINAR EQUIPO-------------------------------");
        System.out.println("Ingresa el codigo del equipo:");
        String codigoEquipo = scanner.nextLine();
        Equipo equipo = equipoDao.getEquipoById(codigoEquipo);
        Entrenador entrenador = equipo.getEntrenador();

        if (entrenador != null) {
            entrenador.setEquipo(null);
            System.out
                    .println("Se ha removido automaticamente el equipo del entrenado con la id: " + entrenador.getId());
        }

        for (Jugador jugador : equipo.getLstJugadores()) {
            jugador.setEquipo(null);
            System.out.println("Se elimino el equipo del jugador con  id:  " + jugador.getId());
        }
        if (equipoDao.deleteEquipoById(codigoEquipo) != null) {
            System.out.println("Se elimino el equipo con el codigo " + codigoEquipo);
        } else {
            System.out.println("No se encontró un equipo con el codigo " + codigoEquipo);
        }
        ConsoleUtils.pause();
    }

    @Override
    public void listAllTeams() {
        ConsoleUtils.cleanScreen();
        System.out.println("------------------------MENU TODOS LOS EQUIPOS--------------------------");
        Set<String> keys = equipoDao.controlador.equipos.keySet();
        for (String key : keys) {
            Equipo equipo = equipoDao.controlador.equipos.get(key);
            displayTeamDetails(equipo);
        }
        ConsoleUtils.pause();
    }

    @Override
    public void displayTeamDetails(Equipo equipo) {
        if (equipo != null) {
            String strEstadio = equipo.getEstadio() != null
            ? " - id: " + equipo.getEstadio().getId() + " | nombre : " + equipo.getEstadio().getNombre()
            : "N/A"; 
            String strEntrenador = equipo.getEntrenador() != null
            ? " - id: " + equipo.getEntrenador().getId() + " | nombre : " + equipo.getEntrenador().getNombre()
            : "N/A";
            String strJugadores = equipo.getLstJugadores().size() == 0 ? "N/A" : "";
            String strPartidos = equipo.getLstPartidos().size() == 0 ? "N/A" : "";
            System.out.println("ID: " + equipo.getId());
            System.out.println("Nombre: " + equipo.getNombre());
            System.out.println("Ciudad: " + equipo.getCiudad());
            System.out.println("Estadio: " + strEstadio);
            System.out.println("Entrenador: " + strEntrenador);
            System.out.println("Jugadores: " + strJugadores);
            for (Jugador jugador : equipo.getLstJugadores()) {
                System.out.println("  - id: " + jugador.getId() + " | nombre: " + jugador.getNombre());
            }
            System.out.println("Partidos: " + strPartidos);
            for (Partido partido : equipo.getLstPartidos()) {
                System.out.println("  - id: " + partido.getId() + " | fecha: " + partido.getFecha());
            }
        } else {
            System.out.println("Equipo no encontrado.");
        }
        System.out.println("------------------------------------------------------------------------");
    }

}
