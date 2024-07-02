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
        System.out.println("1. Crear entrenador");
        System.out.println("2. Buscar entrenador");
        System.out.println("3. Eliminar entrenador");
        System.out.println("4. Listar todos los entrenadores");
        System.out.println("5. Actualizar entrenador");
        System.out.println("6. Salir");
    }

    @Override
    public void createCoach() {
        ConsoleUtils.cleanScreen();
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
        ConsoleUtils.cleanScreen();
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

    @Override
    public void updateCoach() {
        ConsoleUtils.cleanScreen();
        System.out.println("---------------------MENU ACTUALIZAR ENTRENADOR-------------------------");
        System.out.println("Ingresa el codigo del entrenador:");
        String codigoEntrenador = scanner.nextLine();
        Entrenador entrenador = entrenadorDao.getEntrenadorById(codigoEntrenador);
        if (entrenador == null) {
            System.out.println("No se encontró un entrenador con el codigo " + codigoEntrenador);
            ConsoleUtils.pause();
            return;
        }

        ConsoleUtils.cleanScreen();
        System.out.println("---------------------MENU ACTUALIZAR ENTRENADOR-------------------------");
        System.out.println("1. Cambiar nombre");
        System.out.println("2. Cambiar edad");
        System.out.println("3. Cambiar nacionalidad");
        System.out.println("4. Cambiar  experiencia");
        System.out.println("5. Agregar equipo");
        System.out.println("6. Eliminar equipo");
        System.out.println("7. Cancelar");
        int option = ConsoleUtils.option_validation("opcion: ", 1, 7);

        switch (option) {
            case 1:
                System.out.println("Ingrese el nuevo nombre (actual: " + entrenador.getNombre() + ")");
                entrenador.setNombre(scanner.nextLine());
                System.out.println("Entrenador actualizado exitosamente.");
                ConsoleUtils.pause();
                break;
            case 2:
                System.out.println("Ingrese la nueva edad (actual: " + entrenador.getEdad() + ")");
                entrenador.setEdad(scanner.nextInt());
                scanner.nextLine();
                System.out.println("Entrenador actualizado exitosamente.");
                ConsoleUtils.pause();
                break;
            case 3:
                System.out.println("Ingrese la nueva nacionalidad (actual: " + entrenador.getNacionalidad() + ")");
                entrenador.setNacionalidad(scanner.nextLine());
                System.out.println("Entrenador actualizado exitosamente.");
                ConsoleUtils.pause();
                break;
            case 4:
                System.out.println("Ingrese los años de experiencia (actual: " + entrenador.getExperiencia() + ")");
                entrenador.setExperiencia(scanner.nextInt());
                System.out.println("Entrenador actualizado exitosamente.");
                ConsoleUtils.pause();
                break;
            case 5:
                System.out.println("Ingrese ID del equipo asociado (actual: "
                        + (entrenador.getEquipo() != null ? entrenador.getEquipo().getId() : "N/A") + "):");
                String equipoID = scanner.nextLine();
                Equipo equipo = equipoDao.getEquipoById(equipoID);
                if (equipo != null) {
                    if (entrenador.getEquipo() != null && equipo != entrenador.getEquipo()) {
                        System.out.println("Se ha removido automaticamente del equipo con la id "
                                + entrenador.getEquipo().getId());
                        entrenador.getEquipo().setEntrenador(null);
                    }
                    entrenador.setEquipo(equipo);
                    equipo.setEntrenador(entrenador);
                    System.out.println("Se le ha añadido al equipo automaticamente");
                    System.out.println("Entrenador actualizado exitosamente.");
                    ConsoleUtils.pause();
                } else {
                    System.out.println("Equipo no encontrado.");
                    ConsoleUtils.pause();
                }
                break;
            case 6:
                Equipo eqp = entrenador.getEquipo();
                entrenador.setEquipo(null);
                if (eqp.getEntrenador() != null) {
                    eqp.setEntrenador(null);
                    System.out.println("Se le ha eliminado del equipo automaticamente.");
                }
                System.out.println("El entrenador ya no tiene equipo.");
                ConsoleUtils.pause();
                break;
            case 7:
                return;
            default:
                break;
        }
    }
}
