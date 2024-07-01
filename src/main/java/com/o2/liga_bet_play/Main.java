package com.o2.liga_bet_play;





import java.util.Scanner;

import com.o2.liga_bet_play.controller.JugadorController;
import com.o2.liga_bet_play.controller.LesionController;
import com.o2.liga_bet_play.persistence.JugadorDao;
import com.o2.liga_bet_play.persistence.LesionDao;
import com.o2.liga_bet_play.service.JugadorServicio;
import com.o2.liga_bet_play.service.LesionServicio;
import com.o2.liga_bet_play.utils.ConsoleUtils;
import com.o2.liga_bet_play.view.JugadorView;
import com.o2.liga_bet_play.view.LesionView;

public class Main {

    public static void main(String[] args) {
        //controllers
        JugadorController ctrlJugador = new JugadorController();
        LesionController ctrlLesion = new LesionController();
        //daos
        JugadorDao jugadorDao = new JugadorDao(ctrlJugador);
        LesionDao lesionDao = new  LesionDao(ctrlLesion); 

        //servicios
        JugadorServicio jugadorServicio = new JugadorServicio(jugadorDao,lesionDao);
        LesionServicio lesionServicio = new LesionServicio(lesionDao, jugadorDao);
        
        //views
        JugadorView jugadorView = new JugadorView(jugadorServicio);
        LesionView  lesionView =  new LesionView(lesionServicio);
        
        //scanners
        Scanner scanner = new Scanner(System.in);
        jugadorServicio.setScanner(scanner);
        lesionServicio.setScanner(scanner);
        
        while (true) {
            ConsoleUtils.cleanScreen();
            System.out.println("---------------------MENU PRINCIPAL---------------------------");
            System.out.println("1. Gestionar jugador");
            System.out.println("2. Gestionar lesiones");
            System.out.println("25. Salir");
            int op = ConsoleUtils.option_validation("Opcion: ", 1, 25);
            switch (op) {
                case 1:
                    jugadorView.showMenu();
                    break;
                case 2:
                    lesionView.showMenu();
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