package com.o2.liga_bet_play.service;

import java.util.Scanner;
import java.util.Set;

import com.o2.liga_bet_play.model.entity.Equipo;
import com.o2.liga_bet_play.model.entity.Jugador;
import com.o2.liga_bet_play.model.entity.Lesion;
import com.o2.liga_bet_play.model.entity.Rendimiento;
import com.o2.liga_bet_play.persistence.EquipoDao;
import com.o2.liga_bet_play.persistence.JugadorDao;
import com.o2.liga_bet_play.persistence.LesionDao;
import com.o2.liga_bet_play.persistence.RendimientoDao;
import com.o2.liga_bet_play.service.interfaces.JugadorServicioInterfaz;
import com.o2.liga_bet_play.utils.ConsoleUtils;

public class JugadorServicio implements JugadorServicioInterfaz {
    private JugadorDao jugadorDao;
    private LesionDao lesionDao;
    private RendimientoDao rendimientoDAO;
    private EquipoDao equipoDao;
    private Scanner scanner;

    public void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }

    // Constructor que permite la inyección de dependencias
    public JugadorServicio(JugadorDao jugadorDao, LesionDao lesionDao, RendimientoDao rendimientoDao,
            EquipoDao equipoDao) {
        this.jugadorDao = jugadorDao;
        this.lesionDao = lesionDao;
        this.rendimientoDAO = rendimientoDao;
        this.equipoDao = equipoDao;
    }

    @Override
    public void displayMenu() {
        ConsoleUtils.cleanScreen();
        System.out.println("---------------------MENU JUGADOR-----------------------------");
        System.out.println("1. Crear jugador");
        System.out.println("2. Actualizar jugador");
        System.out.println("3. Buscar jugador");
        System.out.println("4. Eliminar jugador");
        System.out.println("5. Listar todos los jugadores");
        System.out.println("6. Salir");
    }

    @Override
    public void createPlayer() {
        ConsoleUtils.cleanScreen();
        System.out.println("---------------------MENU CREAR JUGADOR-----------------------");
        String id = jugadorDao.uniqueId();
        System.out.println("Ingrese Nombre del jugador:");
        String nombre = scanner.nextLine();
        System.out.println("Ingrese la edad:");
        int edad = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Ingrese la nacionalidad del jugador:");
        String nacionalidad = scanner.nextLine();
        System.out.println("Ingrese la posicion:");
        String posicion = scanner.nextLine();
        System.out.println("Ingrese la dorsal:");
        int dorsal = scanner.nextInt();
        scanner.nextLine();

        Jugador jugador = new Jugador(id, nombre, edad, nacionalidad, posicion, dorsal);
        jugadorDao.saveJugador(jugador);
        System.out.println("Jugador creado exitosamente.");
        ConsoleUtils.pause();
    }

    @Override
    public void updatePlayer() {
        ConsoleUtils.cleanScreen();
        System.out.println("---------------------MENU ACTUALIZAR JUGADOR------------------");
        System.out.println("Ingresa el codigo del jugador:");
        String codigoJugador = scanner.nextLine();
        Jugador jugador = jugadorDao.getJugadorById(codigoJugador);
        if (jugador == null) {
            System.out.println("No se encontró un jugador con ese codigo");
            ConsoleUtils.pause();
            return;
        }

        ConsoleUtils.cleanScreen();
        System.out.println("---------------------MENU ACTUALIZAR JUGADOR------------------");
        System.out.println("1. Cambiar nombre");
        System.out.println("2. Cambiar edad");
        System.out.println("3. Cambiar nacionalidad");
        System.out.println("4. Cambiar posicion");
        System.out.println("5. Cambiar dorsal");
        System.out.println("6. Agregar lesion");
        System.out.println("7. Agregar rendimiento");
        System.out.println("8. Agregar equipo");
        System.out.println("9. Eliminar rendimiento");
        System.out.println("10. Eliminar lesion");
        System.out.println("11. Eliminar equipo");
        System.out.println("12. Cancelar");
        int option = ConsoleUtils.option_validation("opcion: ", 1, 12);

        switch (option) {
            case 1:
                System.out.println("Ingrese el nuevo nombre (actual: " + jugador.getNombre() +"):");
                jugador.setNombre(scanner.nextLine());
                System.out.println("Jugador actualizado exitosamente.");
                ConsoleUtils.pause();
                break;
            case 2:

                System.out.println("Ingrese la nueva edad (actual: "+ jugador.getEdad() + "): ");
                jugador.setEdad(scanner.nextInt());
                scanner.nextLine();
                System.out.println("Jugador actualizado exitosamente.");
                ConsoleUtils.pause();
                break;
            case 3:
                System.out.println("Ingrese la nueva nacionalidad (actual: " + jugador.getNacionalidad()+ "):");
                jugador.setNacionalidad(scanner.nextLine());
                System.out.println("Jugador actualizado exitosamente.");
                ConsoleUtils.pause();
                break;
            case 4:
                System.out.println("Ingrese la nueva posicion (actual: " + jugador.getPosicion()+ "):") ;
                jugador.setPosicion(scanner.nextLine());
                System.out.println("Jugador actualizado exitosamente.");
                ConsoleUtils.pause();
                break;
            case 5:

                System.out.println("Ingrese la nueva dorsal (actual: "+jugador.getNumeroCamiseta() + "):");
                jugador.setNumeroCamiseta(scanner.nextInt());
                scanner.nextLine();
                System.out.println("Jugador actualizado exitosamente.");
                ConsoleUtils.pause();
                break;
            case 6:

                System.out.println("Ingrese la id de la lesion a añadir:");
                String lesionId = scanner.nextLine();
                Lesion lesion = lesionDao.getLesionById(lesionId);
                if (lesion == null) {
                    System.out.println("No se encontro una lesion con la id: " + lesionId);
                } else {
                    if (!jugador.getLstLesiones().contains(lesion)) {// si no contiene lesion se le agrega
                        Jugador jd2 = lesion.getJugador();
                        if (jd2 != null) {
                            jd2.deleteLstLesiones(lesion);
                            System.out.println(
                                    "Se ha removido automaticamente la lesion del jugador con la id: " + jd2.getId());
                        }
                        jugador.setLstLesiones(lesion);
                        lesion.setJugador(jugador);
                        System.out.println("Jugador y lesion actualizados exitosamente.");

                    } else {
                        System.out.println("El jugador ya tenia la lesion en su historial.");
                    }
                }
                ConsoleUtils.pause();
                break;
            case 7:

                System.out.println("Ingrese la id del rendimiento a añadir:");
                String rendimientoId = scanner.nextLine();
                Rendimiento rendimiento = rendimientoDAO.getRendimientoById(rendimientoId);
                if (rendimiento == null) {
                    System.out.println("No se encontro un rendimiento con la id: " + rendimientoId);
                } else {
                    if (!jugador.getLstRendimientos().contains(rendimiento)) {// si no contiene lesion se le agrega
                        Jugador jd2 = rendimiento.getJugador();
                        if (jd2 != null) {
                            jd2.deleteLstRendimientos(rendimiento);
                            System.out.println("Se ha removido automaticamente el rendimiento del jugador con la id: "
                                    + jd2.getId());
                        }
                        jugador.setLstRendimientos(rendimiento);
                        rendimiento.setJugador(jugador);
                        System.out.println("Jugador y rendimiento actualizados exitosamente.");
                    } else {
                        System.out.println("El jugador ya tenia el rendimiento en su historial.");
                    }
                }
                ConsoleUtils.pause();
                break;
            case 8:
                System.out.println("Ingrese ID del equipo asociado (actual: "
                        + (jugador.getEquipo() != null ? jugador.getEquipo().getId() : "N/A") + "):");
                String equipoID = scanner.nextLine();
                Equipo equipo = equipoDao.getEquipoById(equipoID);
                if (equipo != null) {
                    if (jugador.getEquipo() != null && equipo != jugador.getEquipo()) {
                        System.out.println(
                                "Se ha removido automaticamente del equipo con la id " + jugador.getEquipo().getId());
                        jugador.getEquipo().getLstJugadores().remove(jugador);
                    }
                    jugador.setEquipo(equipo);
                    if (!equipo.getLstJugadores().contains(jugador)) {// si no contiene jugador se le agrega
                        equipo.setLstJugadores(jugador);
                        System.out.println("Se le ha añadido al equipo automaticamente");
                    }
                    System.out.println("Jugador actualizado exitosamente.");
                    ConsoleUtils.pause();
                } else {
                    System.out.println("Equipo no encontrado.");
                    ConsoleUtils.pause();
                }
                break;

            case 9:

                System.out.println("Ingrese la id del rendimiento a eliminar:");
                String renId = scanner.nextLine();
                Rendimiento ren = rendimientoDAO.getRendimientoById(renId);
                if (ren == null) {
                    System.out.println("No se encontro un rendimiento con la id: " + renId);
                } else {
                    ren.setJugador(null);
                    jugador.deleteLstRendimientos(ren);
                    System.out.println("Jugador y rendimiento actualizado exitosamente.");
                }
                ConsoleUtils.pause();
                break;
            case 10:
                System.out.println("Ingrese la id de la lesion a eliminar:");
                String lesId = scanner.nextLine();
                Lesion les = lesionDao.getLesionById(lesId);
                if (les == null) {
                    System.out.println("No se encontro una lesion con la id: " + lesId);
                } else {
                    les.setJugador(null);
                    jugador.deleteLstLesiones(les);
                    System.out.println("Jugador  y lesion actualizado exitosamente.");
                }
                ConsoleUtils.pause();
                break;
            case 11:
                Equipo eqp = jugador.getEquipo();
                jugador.setEquipo(null);
                if (eqp.getLstJugadores().remove(jugador) == true) {// true si lo remueve
                    System.out.println("Se le ha eliminado del equipo automaticamente.");
                }
                System.out.println("El jugador ya no tiene equipo.");
                ConsoleUtils.pause();
                break;
            case 12:
                return;
            default:
                System.out.println("Opción inválida.");
        }
    }

    @Override
    public void searchPlayer() {
        ConsoleUtils.cleanScreen();
        System.out.println("---------------------MENU BUSCAR JUGADOR------------------------");
        System.out.println("Ingresa el codigo del jugador:");
        String codigoJugador = scanner.nextLine();
        Jugador jugador = jugadorDao.getJugadorById(codigoJugador);
        if (jugador != null) {
            displayPlayerDetails(jugador);
        } else {
            System.out.println("No se encontró un jugador con el codigo " + codigoJugador);
        }
        ConsoleUtils.pause();
    }

    @Override
    public void deletePlayer() {
        ConsoleUtils.cleanScreen();
        System.out.println("---------------------MENU BUSCAR JUGADOR------------------------");
        System.out.println("Ingresa el codigo del jugador:");
        String codigoJugador = scanner.nextLine();

        if (jugadorDao.getJugadorById(codigoJugador) == null) {
            System.out.println("No se encontro el jugador con el codigo: " + codigoJugador);
            ConsoleUtils.pause();
            return;
        }

        Jugador jugador = jugadorDao.getJugadorById(codigoJugador);
        Equipo equipo = jugador.getEquipo();

        if (equipo != null) {
            equipo.deleteLstJugadores(jugador);
            System.out.println("Se elimino el jugador del equipo con id: " + equipo.getId());
        }
        /* Uncomment this if you want to delete all historial for the player 
        for (Lesion lesion : jugadorDao.getJugadorById(codigoJugador).getLstLesiones()) {
            lesion.setJugador(null);
            System.out.println("Se elimino el jugador de la lesion con  id:  " + lesion.getId());
        }
        for (Rendimiento rendimiento : jugadorDao.getJugadorById(codigoJugador).getLstRendimientos()) {
            rendimiento.setJugador(null);
            System.out.println("Se elimino el jugador del rendimiento con  id:  " + rendimiento.getId());
        }*/
        if (jugadorDao.deleteJugadorById(codigoJugador) != null) {
            System.out.println("Se elimino el jugador con el codigo " + codigoJugador);
        } else {
            System.out.println("No se encontró un jugador con el codigo " + codigoJugador);
        }
        ConsoleUtils.pause();
    }

    @Override
    public void listAllPlayers() {
        ConsoleUtils.cleanScreen();
        System.out.println("---------------------MENU TODOS LOS JUGADORES-----------------");
        Set<String> keys = jugadorDao.controlador.jugadores.keySet();
        for (String key : keys) {
            Jugador jugador = jugadorDao.controlador.jugadores.get(key);
            displayPlayerDetails(jugador);
        }
        ConsoleUtils.pause();
    }

    @Override
    public void displayPlayerDetails(Jugador jugador) {
        String strEquipo = jugador.getEquipo() != null
                ? " id: " + jugador.getEquipo().getId() + " | nombre: " + jugador.getEquipo().getNombre()
                : "N/A";
        String strLesion = jugador.getLstLesiones().size() == 0 ? "N/A" : "";
        String strRendimiento = jugador.getLstRendimientos().size() == 0 ? "N/A" : "";
        
        System.out.println("id: " + jugador.getId());
        System.out.println("Nombre: " + jugador.getNombre());
        System.out.println("Edad: " + jugador.getEdad());
        System.out.println("Nacionalidad: " + jugador.getNacionalidad());
        System.out.println("Dorsal: " + jugador.getNumeroCamiseta());
        System.out.println("Posicion: " + jugador.getPosicion());
        System.out.println("Equipo: " + strEquipo);
        System.out.println("Lesion: " + strLesion);
        for (Lesion lesion : jugador.getLstLesiones()) {
            System.out.println(" -id: " + lesion.getId() + " | gravedad: " + lesion.getGravedad());
        }
        System.out.println("Rendimiento: " + strRendimiento);
        for (Rendimiento rendimiento : jugador.getLstRendimientos()) {
            System.out
                    .println(" -id: " + rendimiento.getId() + " | minutos jugados: " + rendimiento.getMinutosJugados());
        }

        System.out.println("-------------------------------------------------------------------------");

    }
}
