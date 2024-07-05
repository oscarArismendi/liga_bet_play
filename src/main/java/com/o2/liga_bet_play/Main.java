package com.o2.liga_bet_play;





import java.util.Scanner;

import com.o2.liga_bet_play.controller.EntrenadorController;
import com.o2.liga_bet_play.controller.EquipoController;
import com.o2.liga_bet_play.controller.EstadioController;
import com.o2.liga_bet_play.controller.JugadorController;
import com.o2.liga_bet_play.controller.LesionController;
import com.o2.liga_bet_play.controller.RendimientoController;
import com.o2.liga_bet_play.persistence.EntrenadorDao;
import com.o2.liga_bet_play.persistence.EquipoDao;
import com.o2.liga_bet_play.persistence.EstadioDao;
import com.o2.liga_bet_play.persistence.JugadorDao;
import com.o2.liga_bet_play.persistence.LesionDao;
import com.o2.liga_bet_play.persistence.RendimientoDao;
import com.o2.liga_bet_play.service.EntrenadorServicio;
import com.o2.liga_bet_play.service.EquipoServicio;
import com.o2.liga_bet_play.service.EstadioServicio;
import com.o2.liga_bet_play.service.JugadorServicio;
import com.o2.liga_bet_play.service.LesionServicio;
import com.o2.liga_bet_play.service.RendimientoServicio;
import com.o2.liga_bet_play.utils.ConsoleUtils;
import com.o2.liga_bet_play.view.EntrenadorView;
import com.o2.liga_bet_play.view.EquipoView;
import com.o2.liga_bet_play.view.EstadioView;
import com.o2.liga_bet_play.view.JugadorView;
import com.o2.liga_bet_play.view.LesionView;
import com.o2.liga_bet_play.view.RendimientoView;

public class Main {

    public static void main(String[] args) {
        //controllers
        JugadorController ctrlJugador = new JugadorController();
        LesionController ctrlLesion = new LesionController();
        RendimientoController ctrlRendimiento = new RendimientoController();
        EstadioController ctrlEstadio = new EstadioController();
        EquipoController ctrlEquipo = new EquipoController();
        EntrenadorController  ctrlEntrenador = new EntrenadorController();
        //daos
        JugadorDao jugadorDao = new JugadorDao(ctrlJugador);
        LesionDao lesionDao = new  LesionDao(ctrlLesion); 
        RendimientoDao rendimientoDao = new  RendimientoDao(ctrlRendimiento);
        EstadioDao estadioDao  = new  EstadioDao(ctrlEstadio);
        EquipoDao equipoDao =  new EquipoDao(ctrlEquipo);
        EntrenadorDao entrenadorDao = new EntrenadorDao(ctrlEntrenador);

        //servicios
        JugadorServicio jugadorServicio = new JugadorServicio(jugadorDao,lesionDao,rendimientoDao,equipoDao);
        LesionServicio lesionServicio = new LesionServicio(lesionDao, jugadorDao);
        RendimientoServicio rendimientoServicio =  new  RendimientoServicio(rendimientoDao, jugadorDao);
        EstadioServicio estadioServicio = new EstadioServicio(estadioDao,equipoDao);
        EquipoServicio equipoServicio = new  EquipoServicio(equipoDao,estadioDao,entrenadorDao,jugadorDao);
        EntrenadorServicio entrenadorServicio  = new EntrenadorServicio(entrenadorDao, equipoDao);
        
        
        //views
        JugadorView jugadorView = new JugadorView(jugadorServicio);
        LesionView  lesionView =  new LesionView(lesionServicio);
        EstadioView estadioView = new EstadioView(estadioServicio);
        EquipoView equipoView =  new EquipoView(equipoServicio);
        EntrenadorView entrenadorView = new EntrenadorView(entrenadorServicio);
        RendimientoView rendimientoView = new RendimientoView(rendimientoServicio);
        //scanners
        Scanner scanner = new Scanner(System.in);
        jugadorServicio.setScanner(scanner);
        lesionServicio.setScanner(scanner);
        estadioServicio.setScanner(scanner);
        equipoServicio.setScanner(scanner);
        entrenadorServicio.setScanner(scanner);
        rendimientoServicio.setScanner(scanner);

        while (true) {
            ConsoleUtils.cleanScreen();
            System.out.println("---------------------MENU PRINCIPAL---------------------------");
            System.out.println("1. Gestionar jugador");
            System.out.println("2. Gestionar lesiones");
            System.out.println("3. Gestionar estadios");
            System.out.println("4. Gestionar rendimientos");
            System.out.println("5. Gestionar equipos");
            System.out.println("6. Gestion entrenadores");

            System.out.println("25. Salir");
            int op = ConsoleUtils.option_validation("Opcion: ", 1, 25);
            switch (op) {
                case 1:
                    jugadorView.showMenu();
                    break;
                case 2:
                    lesionView.showMenu();
                    break;
                case 3:
                    estadioView.showMenu();
                    break;
                case 4:
                    rendimientoView.showMenu();
                    break;
                case 5:
                    equipoView.showMenu();
                    break;
                case 6:
                    entrenadorView.showMenu();
                    break;
                case 25:
                    scanner.close();
                    return;
                default:
                    break;
            }
            
        }
    }
}