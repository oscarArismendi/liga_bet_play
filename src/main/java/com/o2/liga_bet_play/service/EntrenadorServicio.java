package com.o2.liga_bet_play.service;

import java.util.Scanner;
import java.util.Set;

import com.o2.liga_bet_play.model.entity.Entrenador;
import com.o2.liga_bet_play.model.entity.Equipo;
import com.o2.liga_bet_play.persistence.EntrenadorDao;
import com.o2.liga_bet_play.persistence.EquipoDao;
import com.o2.liga_bet_play.service.interfaces.EntrenadorServicioInterfaz;
import com.o2.liga_bet_play.utils.ConsoleUtils;

public class EntrenadorServicio implements EntrenadorServicioInterfaz {
    private EntrenadorDao entrenadorDao;
    private EquipoDao equipoDao;
    private Scanner scanner;

    public EntrenadorServicio(EntrenadorDao entrenadorDao, EquipoDao equipoDao) {
        this.entrenadorDao = entrenadorDao;
        this.equipoDao = equipoDao;
    }

    public void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public void displayMenu() {
        ConsoleUtils.cleanScreen();
        System.out.println("---------------------MENU ENTRENADOR------------------------------------");
        System.out.println("1. Crear Entrenador");
        System.out.println("2. Buscar Entrenador");
        System.out.println("3. Eliminar Entrenador");
        System.out.println("4. Listar Todos los Entrenadores");
        System.out.println("5. Salir");
    }

    @Override
    public void createCoach() {
        System.out.println("---------------------MENU CREAR ENTRENADOR------------------------------");
        String id = entrenadorDao.uniqueId();
        System.out.println("Ingrese nombre del entrenador: ");
        String nombre = scanner.nextLine();
        System.out.println("Ingrese edad del entrenador: ");
        int edad = Integer.parseInt(scanner.nextLine());
        System.out.println("Ingrese nacionalidad del entrenador: ");
        String nacionalidad = scanner.nextLine();
        System.out.println("Ingrese experiencia del entrenador (en años): ");
        int experiencia = Integer.parseInt(scanner.nextLine());

        Entrenador entrenador = new Entrenador(id, nombre, edad, nacionalidad, experiencia);
        entrenadorDao.saveEntrenador(entrenador);
        System.out.println("Entrenador creado exitosamente.");
        ConsoleUtils.pause();
    }

    @Override
    public void searchCoach() {
        System.out.println("---------------------MENU BUSCAR ENTRENADOR-----------------------------");
        System.out.println("Ingrese el código del entrenador: ");
        String id = scanner.nextLine();
        Entrenador entrenador = entrenadorDao.getEntrenadorById(id);
        if (entrenador != null) {
            displayCoachDetails(entrenador);
        } else {
            System.out.println("No se encontró un entrenador con el código " + id);
        }
        ConsoleUtils.pause();
    }

    @Override
    public void deleteCoach() {
        ConsoleUtils.cleanScreen();
        System.out.println("---------------------MENU ELIMINAR ENTRENADOR---------------------------");
        System.out.println("Ingrese el código del entrenador: ");
        String id = scanner.nextLine();
        Entrenador entrenador = entrenadorDao.getEntrenadorById(id);
        if (entrenador != null) {
            Equipo equipo = entrenador.getEquipo();
            if (equipo != null) {
                equipo.setEntrenador(null);
                System.out.println("Se ha removido el entrenador del equipo con el ID: " + equipo.getId());
            }
            entrenadorDao.deleteEntrenadorById(id);
            System.out.println("Entrenador eliminado exitosamente.");
        } else {
            System.out.println("No se encontró un entrenador con el código " + id);
        }
        ConsoleUtils.pause();
    }

    @Override
    public void listAllCoachs() {
        ConsoleUtils.cleanScreen();
        System.out.println("----------------------LISTA DE TODOS LOS ENTRENADORES-------------------");
        Set<String> keys = entrenadorDao.controlador.entrenadores.keySet();
        for (String key : keys) {
            Entrenador entrenador = entrenadorDao.getEntrenadorById(key);
            displayCoachDetails(entrenador);
        }
        ConsoleUtils.pause();
    }

    @Override
    public void displayCoachDetails(Entrenador entrenador) {
        if (entrenador != null) {
            System.out.println("ID: " + entrenador.getId());
            System.out.println("Nombre: " + entrenador.getNombre());
            System.out.println("Edad: " + entrenador.getEdad());
            System.out.println("Nacionalidad: " + entrenador.getNacionalidad());
            System.out.println("Experiencia: " + entrenador.getExperiencia());
            if (entrenador.getEquipo() != null) {
                System.out.println("Equipo: " + entrenador.getEquipo().getNombre());
            } else {
                System.out.println("Equipo: Sin asignar");
            }
        } else {
            System.out.println("Entrenador no encontrado.");
        }
        System.out.println("------------------------------------------------------------------------");
    }
}
