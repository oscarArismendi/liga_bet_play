package com.o2.liga_bet_play.utils;

import java.io.IOException;
import java.util.Scanner;

public class ConsoleUtils {
    private static Scanner scanner = new Scanner(System.in);

    public static void pause() {
        System.out.println("Presiona enter para continuar");
        try {
            System.in.read();
        } catch (IOException e) {
            System.out.println("Error al pausar la pantalla: " + e.getMessage());
        }
    }

    public static void cleanScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static int option_validation(String statement, int lower, int upper) {// return a int >= lower and <= upper
        while (true) {
            try {
                System.out.println(statement);
                int option = scanner.nextInt();
                scanner.nextLine();
                if (option >= lower && option <= upper) {
                    return option;
                } else {
                    System.out.println(String.format("No escogiste una opcion en el intervalo: %1$d-%2$d",
                            lower, upper));
                }

            } catch (Exception e) {
                System.out.println("Ingresa un  numero valido.");
                scanner.nextLine();
            }
        }
    }
}
