package com.o2.liga_bet_play.service;

import java.util.Scanner;
import java.util.Set;

import com.o2.liga_bet_play.model.entity.Jugador;
import com.o2.liga_bet_play.model.entity.Rendimiento;
import com.o2.liga_bet_play.model.entity.Gol;
import com.o2.liga_bet_play.model.entity.Tarjeta;
import com.o2.liga_bet_play.persistence.JugadorDao;
import com.o2.liga_bet_play.persistence.RendimientoDao;
import com.o2.liga_bet_play.service.interfaces.RendimientoServicioInterfaz;
import com.o2.liga_bet_play.utils.ConsoleUtils;

public class RendimientoServicio implements RendimientoServicioInterfaz {
    private RendimientoDao rendimientoDao;
    private JugadorDao jugadorDao;
    
    private Scanner scanner;

    public RendimientoServicio(RendimientoDao rendimientoDao, JugadorDao jugadorDao) {
        this.rendimientoDao = rendimientoDao;
        this.jugadorDao = jugadorDao;
    }

    public void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public void displayMenu() {
        ConsoleUtils.cleanScreen();
        System.out.println("---------------------MENU RENDIMIENTO-----------------------------------");
        System.out.println("1. Crear rendimiento");
        System.out.println("2. Actualizar rendimiento");
        System.out.println("3. Buscar rendimiento");
        System.out.println("4. Eliminar rendimiento");
        System.out.println("5. Listar todos los rendimientos");
        System.out.println("6. Salir");
    }

    @Override
    public void createPerformance() {
        ConsoleUtils.cleanScreen();
        System.out.println("---------------------MENU CREAR RENDIMIENTO-----------------------------");
        String id = rendimientoDao.uniqueId();
        System.out.println("Ingrese minutos jugados:");
        int minutosJugados = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Ingrese asistencias:");
        int asistencias = scanner.nextInt();
        scanner.nextLine();

        Rendimiento rendimiento = new Rendimiento(id, minutosJugados, asistencias);
        rendimientoDao.saveRendimiento(rendimiento);

        System.out.println("Rendimiento creado exitosamente!");
        ConsoleUtils.pause();
    }

    @Override
    public void updatePerformance() {
        ConsoleUtils.cleanScreen();
        System.out.println("---------------------MENU ACTUALIZAR RENDIMIENTO------------------------");
        System.out.println("Ingrese ID del rendimiento a actualizar:");
        String id = scanner.nextLine();
        Rendimiento rendimiento = rendimientoDao.getRendimientoById(id);

        if (rendimiento == null) {
            System.out.println("Rendimiento no encontrado.");
            ConsoleUtils.pause();
            return;
        }

        ConsoleUtils.cleanScreen();
        System.out.println("---------------------MENU ACTUALIZAR RENDIMIENTO------------------------");
        System.out.println("1. Cambiar minutos jugados");
        System.out.println("2. Cambiar asistencias");
        System.out.println("3. Agregar gol");
        System.out.println("4. Eliminar gol");
        System.out.println("5. Agregar tarjeta amarilla");
        System.out.println("6. Eliminar tarjeta amarilla");
        System.out.println("7. Agregar tarjeta roja");
        System.out.println("8. Eliminar tarjeta roja");
        System.out.println("9. Agregar jugador");
        System.out.println("10. Eliminar jugador");
        System.out.println("11. Cancelar");
        int option = ConsoleUtils.option_validation("opcion: ", 1, 11);

        switch (option) {
            case 1:
                System.out.println("Ingrese nuevos minutos jugados (actual: " + rendimiento.getMinutosJugados() + "):");
                rendimiento.setMinutosJugados(scanner.nextInt());
                scanner.nextLine();
                System.out.println("Rendimiento actualizado exitosamente.");
                ConsoleUtils.pause();
                break;
            case 2:
                System.out.println("Ingrese nuevas asistencias (actual: " + rendimiento.getAsistencias() + "):");
                rendimiento.setAsistencias(scanner.nextInt());
                scanner.nextLine();
                System.out.println("Rendimiento actualizado exitosamente.");
                ConsoleUtils.pause();
                break;
            // case 3:
            //     System.out.println("Ingrese ID del gol a agregar:");
            //     String golId = scanner.nextLine();
            //     Gol gol = new Gol(golId); // asumiendo un constructor básico de Gol
            //     rendimiento.setLstGoles(gol);
            //     System.out.println("Gol agregado exitosamente.");
            //     ConsoleUtils.pause();
            //     break;
            // case 4:
            //     System.out.println("Ingrese ID del gol a eliminar:");
            //     golId = scanner.nextLine();
            //     gol = new Gol(golId);
            //     rendimiento.deleteLstGoles(gol);
            //     System.out.println("Gol eliminado exitosamente.");
            //     ConsoleUtils.pause();
            //     break;
            // case 5:
            //     System.out.println("Ingrese ID de la tarjeta amarilla a agregar:");
            //     String tarjetaId = scanner.nextLine();
            //     Tarjeta tarjetaAmarilla = new Tarjeta(tarjetaId); // asumiendo un constructor básico de Tarjeta
            //     rendimiento.setLstTarjetasAmarillas(tarjetaAmarilla);
            //     System.out.println("Tarjeta amarilla agregada exitosamente.");
            //     ConsoleUtils.pause();
            //     break;
            // case 6:
            //     System.out.println("Ingrese ID de la tarjeta amarilla a eliminar:");
            //     tarjetaId = scanner.nextLine();
            //     tarjetaAmarilla = new Tarjeta(tarjetaId);
            //     rendimiento.deleteLstTarjetasAmarillas(tarjetaAmarilla);
            //     System.out.println("Tarjeta amarilla eliminada exitosamente.");
            //     ConsoleUtils.pause();
            //     break;
            // case 7:
            //     System.out.println("Ingrese ID de la tarjeta roja a agregar:");
            //     tarjetaId = scanner.nextLine();
            //     Tarjeta tarjetaRoja = new Tarjeta(tarjetaId);
            //     rendimiento.setTarjetaRoja(tarjetaRoja);
            //     System.out.println("Tarjeta roja agregada exitosamente.");
            //     ConsoleUtils.pause();
            //     break;
            case 8:
                rendimiento.setTarjetaRoja(null);
                System.out.println("Tarjeta roja eliminada exitosamente.");
                ConsoleUtils.pause();
                break;
            case 9:
                System.out.println("Ingrese ID del jugador asociado (actual: "
                        + (rendimiento.getJugador() != null ? rendimiento.getJugador().getId() : "N/A") + "):");
                String jugadorId = scanner.nextLine();
                Jugador jugador = jugadorDao.getJugadorById(jugadorId);
                if (jugador != null) {
                    rendimiento.setJugador(jugador);
                    if (!jugador.getLstRendimientos().contains(rendimiento)) {
                        jugador.setLstRendimientos(rendimiento);
                        System.out.println("Se le ha añadido al jugador automaticamente");
                    }
                    System.out.println("Rendimiento actualizado exitosamente.");
                    ConsoleUtils.pause();
                } else {
                    System.out.println("Jugador no encontrado.");
                    ConsoleUtils.pause();
                }
                break;
            case 10:
                Jugador jdor = jugadorDao.getJugadorById(rendimiento.getJugador().getId());
                rendimiento.setJugador(null);
                if (jdor.getLstRendimientos().remove(rendimiento)) {
                    System.out.println("Se le ha eliminado del jugador automaticamente");
                }
                System.out.println("Rendimiento sin jugador, recuerda relacionarlo con un jugador!.");
                ConsoleUtils.pause();
                break;
            case 11:
                return;
            default:
                break;
        }
    }

    @Override
    public void searchPerformance() {
        ConsoleUtils.cleanScreen();
        System.out.println("---------------------MENU BUSCAR RENDIMIENTO----------------------------");
        System.out.println("Ingresa el codigo del rendimiento:");
        String codigoRendimiento = scanner.nextLine();
        Rendimiento rendimiento = rendimientoDao.getRendimientoById(codigoRendimiento);

        if (rendimiento != null) {
            displayPerformanceDetails(rendimiento);
        } else {
            System.out.println("No se encontró un rendimiento con el codigo " + codigoRendimiento);
        }
        ConsoleUtils.pause();
    }

    @Override
    public void deletePerformance() {
        ConsoleUtils.cleanScreen();
        System.out.println("---------------------MENU BUSCAR RENDIMIENTO----------------------------");
        System.out.println("Ingresa el codigo del rendimiento:");
        String codigoRendimiento = scanner.nextLine();
        Rendimiento rendimiento = rendimientoDao.getRendimientoById(codigoRendimiento);
        Jugador jdor = jugadorDao.getJugadorById(rendimiento.getJugador().getId());

        if (jdor.getLstRendimientos().remove(rendimiento)) {
            System.out.println("Se le ha eliminado del jugador automaticamente");
        }
        if (rendimientoDao.deleteRendimientoById(codigoRendimiento) != null) {
            System.out.println("Se elimino el rendimiento con el codigo " + codigoRendimiento);
        } else {
            System.out.println("No se encontró un rendimiento con el codigo " + codigoRendimiento);
        }
        ConsoleUtils.pause();
    }

    @Override
    public void listAllPerformances() {
        ConsoleUtils.cleanScreen();
        System.out.println("---------------------MENU TODOS LOS RENDIMIENTOS------------------------");
        Set<String> keys = rendimientoDao.controlador.rendimientos.keySet();
        for (String key : keys) {
            Rendimiento rendimiento = rendimientoDao.controlador.rendimientos.get(key);
            displayPerformanceDetails(rendimiento);
        }
        ConsoleUtils.pause();
    }

    @Override
    public void displayPerformanceDetails(Rendimiento rendimiento) {
        // Default strings if performance doesn't have atributes
        String strTarjetaRoja = rendimiento.getTarjetaRoja() != null? 
        "ID: " + rendimiento.getTarjetaRoja().getId() + " | minuto: " + rendimiento.getTarjetaRoja().getMinuto():
        "N/A";
        String strJugador = rendimiento.getJugador() != null?
        "ID: " + rendimiento.getJugador().getId() + " | nombre: " + rendimiento.getJugador().getNombre() :
        "N/A";
        String strGol = rendimiento.getLstGoles().size() == 0 ? "N/A" : "";
        String strTarjetasAmarillas = rendimiento.getLstTarjetasAmarillas().size() == 0 ? "N/A" : "";
        System.out.println("ID: " + rendimiento.getId());
        System.out.println("Minutos Jugados: " + rendimiento.getMinutosJugados());
        System.out.println("Asistencias: " + rendimiento.getAsistencias());
        System.out.println("Goles: " + strGol);
        for (Gol gol : rendimiento.getLstGoles()) {
            System.out.println("    Gol ID: " + gol.getId());
        }
        System.out.println("Tarjetas Amarillas: " + strTarjetasAmarillas);
        for (Tarjeta tarjetaAmarilla : rendimiento.getLstTarjetasAmarillas()) {
            System.out.println("    Tarjeta Amarilla ID: " + tarjetaAmarilla.getId());
        }
        System.out.println("Tarjeta Roja: " + strTarjetaRoja);
        System.out.println("Jugador: " + strJugador );
        System.out.println();
        System.out.println("-------------------------------------------------------------------------");
    }
}
