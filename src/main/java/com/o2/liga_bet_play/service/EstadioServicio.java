package com.o2.liga_bet_play.service;

import java.util.Scanner;
import java.util.Set;

import com.o2.liga_bet_play.model.entity.Equipo;
import com.o2.liga_bet_play.model.entity.Estadio;
import com.o2.liga_bet_play.persistence.EquipoDao;
import com.o2.liga_bet_play.persistence.EstadioDao;
import com.o2.liga_bet_play.service.interfaces.EstadioServicioInterfaz;
import com.o2.liga_bet_play.utils.ConsoleUtils;

public class EstadioServicio implements EstadioServicioInterfaz {
    private EstadioDao estadioDao;
    private EquipoDao equipoDao;
    private Scanner scanner;

    public EstadioServicio(EstadioDao estadioDao, EquipoDao equipoDao) {
        this.estadioDao = estadioDao;
        this.equipoDao = equipoDao;
    }

    public void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public void displayMenu() {
        ConsoleUtils.cleanScreen();
        System.out.println("---------------------MENU ESTADIO---------------------------------------");
        System.out.println("1. Crear estadio");
        System.out.println("2. Buscar estadio");
        System.out.println("3. Eliminar estadio");
        System.out.println("4. Listar todos los estadios");
        System.out.println("5. Actualizar estadio");
        System.out.println("6. Salir");
    }

    @Override
    public void createStadium() {
        ConsoleUtils.cleanScreen();
        System.out.println("---------------------MENU CREAR ESTADIO---------------------------------");
        String id = estadioDao.uniqueId();
        System.out.println("Ingrese nombre del estadio: ");
        String nombre = scanner.nextLine();
        System.out.println("Ingrese ubicación del estadio: ");
        String ubicacion = scanner.nextLine();
        System.out.println("Ingrese capacidad del estadio: ");
        int capacidad = Integer.parseInt(scanner.nextLine());

        Estadio estadio = new Estadio(id, nombre, ubicacion, capacidad);
        estadioDao.saveEstadio(estadio);
        System.out.println("Estadio creado exitosamente.");
        ConsoleUtils.pause();
    }

    @Override
    public void searchStadium() {
        ConsoleUtils.cleanScreen();
        System.out.println("---------------------MENU BUSCAR ESTADIO--------------------------------");
        System.out.println("Ingrese el código del estadio: ");
        String id = scanner.nextLine();
        Estadio estadio = estadioDao.getEstadioById(id);
        if (estadio != null) {
            displayStadiumDetails(estadio);
        } else {
            System.out.println("No se encontró un estadio con el código " + id);
        }
        ConsoleUtils.pause();
    }

    @Override
    public void deleteStadium() {
        ConsoleUtils.cleanScreen();
        System.out.println("---------------------MENU ELIMINAR ESTADIO------------------------------");
        System.out.println("Ingrese el código del estadio: ");
        String id = scanner.nextLine();
        Estadio estadio = estadioDao.getEstadioById(id);
        if (estadio != null) {
            Set<String> equipoKeys = equipoDao.controlador.equipos.keySet();
            for (String key : equipoKeys) {
                Equipo equipo = equipoDao.controlador.equipos.get(key);
                if (equipo.getEstadio() != null && equipo.getEstadio().getId().equals(id)) {
                    equipo.setEstadio(null);
                    System.out.println("Se ha removido el estadio del equipo con el ID: " + equipo.getId());
                }
            }
            estadioDao.deleteEstadioById(id);
            System.out.println("Estadio eliminado exitosamente.");
        } else {
            System.out.println("No se encontró un estadio con el código " + id);
        }
        ConsoleUtils.pause();
    }

    @Override
    public void listAllStadiums() {
        ConsoleUtils.cleanScreen();
        System.out.println("----------------------LISTA DE TODOS LOS ESTADIOS-----------------------");
        Set<String> keys = estadioDao.controlador.estadios.keySet();
        for (String key : keys) {
            Estadio estadio = estadioDao.controlador.estadios.get(key);
            displayStadiumDetails(estadio);
        }
        ConsoleUtils.pause();
    }

    @Override
    public void displayStadiumDetails(Estadio estadio) {
        if (estadio != null) {
            System.out.println("ID: " + estadio.getId());
            System.out.println("Nombre: " + estadio.getNombre());
            System.out.println("Ubicación: " + estadio.getUbicacion());
            System.out.println("Capacidad: " + estadio.getCapacidad());
        } else {
            System.out.println("Estadio no encontrado.");
        }
        System.out.println("------------------------------------------------------------------------");
    }

    @Override
    public void updateStadium() {
        ConsoleUtils.cleanScreen();
        System.out.println("---------------------MENU ACTUALIZAR ESTADIO----------------------------");
        System.out.println("Ingrese el código del estadio: ");
        String id = scanner.nextLine();
        Estadio estadio = estadioDao.getEstadioById(id);

        if (estadio == null) {
            System.out.println("Estadio no encontrado.");
            ConsoleUtils.pause();
            return;
        }

        ConsoleUtils.cleanScreen();
        System.out.println("---------------------MENU ACTUALIZAR LESION------------------");
        System.out.println("1. Cambiar nombre");
        System.out.println("2. Cambiar ubicacion");
        System.out.println("3. Cambiar capacidad");
        System.out.println("4. Salir");

        int option = ConsoleUtils.option_validation("opcion: ", 1, 4);

        switch (option) {
            case 1:
            System.out.println("Ingrese el nuevo nombre del estadio (actual: " + estadio.getNombre() + ")");
            estadio.setNombre(scanner.nextLine());
            System.out.println("Estadio actualizado exitosamente");
            ConsoleUtils.pause();
            break;
            case 2:
            System.out.println("Ingrese la nueva ubicacion del estadio (actual: " + estadio.getUbicacion() + ")");
            estadio.setUbicacion(scanner.nextLine());
            System.out.println("Estadio actualizado exitosamente");
            ConsoleUtils.pause();
            break;
            case 3:
            System.out.println("Ingrese la nueva capacidad del estadio (actual: " + estadio.getCapacidad() + ")");
            estadio.setCapacidad(scanner.nextInt());
            scanner.nextLine();
            System.out.println("Estadio actualizado exitosamente");
            ConsoleUtils.pause();
            break;
            case 4:
                return;
            default:
                break;
        }
    }
}
