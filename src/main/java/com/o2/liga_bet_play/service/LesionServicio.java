package com.o2.liga_bet_play.service;

import java.util.Scanner;
import java.util.Set;

import com.o2.liga_bet_play.model.entity.Jugador;
import com.o2.liga_bet_play.model.entity.Lesion;
import com.o2.liga_bet_play.persistence.JugadorDao;
import com.o2.liga_bet_play.persistence.LesionDao;

import com.o2.liga_bet_play.utils.ConsoleUtils;

public class LesionServicio implements LesionServicioInterfaz {
    private LesionDao lesionDao;
    private JugadorDao jugadorDao;
    private Scanner scanner;

    public LesionServicio(LesionDao lesionDao, JugadorDao jugadorDao) {
        this.lesionDao = lesionDao;
        this.jugadorDao = jugadorDao;
    }

    public void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public void displayMenu() {
        ConsoleUtils.cleanScreen();
        System.out.println("---------------------MENU LESION-----------------------------");
        System.out.println("1. Crear lesion");
        System.out.println("2. Actualizar lesion");
        System.out.println("3. Buscar lesion");
        System.out.println("4. Eliminar lesion");
        System.out.println("5. Listar todas las lesiones");
        System.out.println("6. Salir");
    }

    @Override
    public void createInjurie() {
        ConsoleUtils.cleanScreen();
        System.out.println("---------------------MENU CREAR LESION-----------------------");
        String id = lesionDao.uniqueId();
        System.out.println("Ingrese tipo de lesion:");
        String tipo = scanner.nextLine();
        System.out.println("Ingrese la gravedad:");
        String gravedad = scanner.nextLine();
        System.out.println("Ingrese la fecha de inicio:");
        String fechaInicio = scanner.nextLine();
        System.out.println("Ingrese la fecha de fin:");
        String fechaFin = scanner.nextLine();

        Lesion lesion = new Lesion(id, tipo, gravedad, fechaInicio, fechaFin);
        lesionDao.saveLesion(lesion);

        System.out.println("Lesion creada exitosamente!");
        ConsoleUtils.pause();
    }

    @Override
    public void updateInjurie() {
        ConsoleUtils.cleanScreen();
        System.out.println("---------------------MENU ACTUALIZAR LESION------------------");
        System.out.println("Ingrese ID de la lesion a actualizar:");
        String id = scanner.nextLine();
        Lesion lesion = lesionDao.getLesionById(id);

        if (lesion == null) {
            System.out.println("Lesion no encontrada.");
            ConsoleUtils.pause();
            return;
        }

        ConsoleUtils.cleanScreen();
        System.out.println("---------------------MENU ACTUALIZAR LESION------------------");
        System.out.println("1. Cambiar tipo de lesion");
        System.out.println("2. Cambiar gravedad");
        System.out.println("3. Cambiar fecha de inicio");
        System.out.println("4. Cambiar fecha de fin");
        System.out.println("5. Agregar jugador");
        System.out.println("6. Eliminar jugador");
        System.out.println("7. Cancelar");
        int option = ConsoleUtils.option_validation("opcion: ", 1, 7);

        switch (option) {
            case 1:
                System.out.println("Ingrese nuevo Tipo de lesion (actual: " + lesion.getTipo() + "):");
                lesion.setTipo(scanner.nextLine());
                System.out.println("Lesion actualizada exitosamente.");
                ConsoleUtils.pause();
                break;
            case 2:
                System.out.println("Ingrese nueva gravedad (actual: " + lesion.getGravedad() + "):");
                lesion.setGravedad(scanner.nextLine());
                System.out.println("Lesion actualizada exitosamente.");
                ConsoleUtils.pause();
                break;
            case 3:
                System.out.println("Ingrese nueva fecha de inicio (actual: " + lesion.getFechaInicio() + "):");
                lesion.setFechaInicio(scanner.nextLine());
                System.out.println("Lesion actualizada exitosamente.");
                ConsoleUtils.pause();
                break;
            case 4:
                System.out.println("Ingrese nueva fecha de fin (actual: " + lesion.getFechaFin() + "):");
                lesion.setFechaFin(scanner.nextLine());
                System.out.println("Lesion actualizada exitosamente.");
                ConsoleUtils.pause();
                break;
            case 5:
                System.out.println("Ingrese ID del jugador asociado (actual: "
                        + (lesion.getJugador() != null ? lesion.getJugador().getId() : "N/A") + "):");
                String jugadorId = scanner.nextLine();
                Jugador jugador = jugadorDao.getJugadorById(jugadorId);
                if (jugador != null) {
                    lesion.setJugador(jugador);
                    if (!jugador.getLstLesiones().contains(lesion)) {// si no contiene lesion se le agrega
                        jugador.setLstLesiones(lesion);
                        System.out.println("Se le ha añadido al jugador automaticamente");
                    }
                    System.out.println("Lesion actualizada exitosamente.");
                    ConsoleUtils.pause();
                } else {
                    System.out.println("Jugador no encontrado.");
                    ConsoleUtils.pause();
                }
                break;
            case 6:
                Jugador jdor = jugadorDao.getJugadorById(lesion.getJugador().getId());
                lesion.setJugador(null);
                if (jdor.getLstLesiones().remove(lesion) == true) {// true si lo remueve
                    System.out.println("Se le ha eliminado del jugador automaticamente");
                }
                System.out.println("Lesion sin jugador, recuerda relacionarla con un jugador!.");
                ConsoleUtils.pause();
                break;
            case 7:
                return;
            default:
                break;
        }
    }

    @Override
    public void searchInjurie() {
        ConsoleUtils.cleanScreen();
        System.out.println("---------------------MENU BUSCAR LESION-------------------------");
        System.out.println("Ingresa el codigo de la lesion:");
        String codigoLesion = scanner.nextLine();
        Lesion lesion = lesionDao.getLesionById(codigoLesion);

        if (lesion != null) {
            displayInjurieDetails(lesion);
        } else {
            System.out.println("No se encontró una lesion con el codigo " + codigoLesion);
        }
        ConsoleUtils.pause();
    }

    @Override
    public void deleteInjurie() {
        ConsoleUtils.cleanScreen();
        System.out.println("---------------------MENU BUSCAR JUGADOR------------------------");
        System.out.println("Ingresa el codigo de la lesion:");
        String codigoLesion = scanner.nextLine();
        Lesion lesion = lesionDao.getLesionById(codigoLesion);
        Jugador jdor = jugadorDao.getJugadorById(lesion.getJugador().getId());

        if (jdor.getLstLesiones().remove(lesion) == true) {// true si lo remueve
            System.out.println("Se le ha eliminado del jugador automaticamente");
        }
        if (lesionDao.deleteLesionById(codigoLesion) != null) {
            System.out.println("Se elimino la lesion con el codigo " + codigoLesion);
        } else {
            System.out.println("No se encontró una lesion con el codigo " + codigoLesion);
        }
        ConsoleUtils.pause();
    }

    @Override
    public void listAllInjuries() {
        ConsoleUtils.cleanScreen();
        System.out.println("---------------------MENU TODOS LAS LESIONES------------------");
        Set<String> keys = lesionDao.controlador.lesiones.keySet();
        for (String key : keys) {
            Lesion lesion = lesionDao.controlador.lesiones.get(key);
            displayInjurieDetails(lesion);
        }
        ConsoleUtils.pause();
    }

    @Override
    public void displayInjurieDetails(Lesion lesion) {
        System.out.println("ID: " + lesion.getId());
        System.out.println("Tipo: " + lesion.getTipo());
        System.out.println("Gravedad: " + lesion.getGravedad());
        System.out.println("Fecha de inicio: " + lesion.getFechaInicio());
        System.out.println("Fecha de fin: " + lesion.getFechaFin());
        System.out.println("Jugador:");
        System.out.println(lesion.getJugador() != null
                ? " - id: " + lesion.getJugador().getId() + " | nombre: " + lesion.getJugador().getNombre()
                : "");
        System.out.println("--------------------------------------------------------------");
    }
}
