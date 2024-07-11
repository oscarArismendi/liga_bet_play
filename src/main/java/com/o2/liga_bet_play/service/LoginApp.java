package com.o2.liga_bet_play.service;

import com.o2.liga_bet_play.model.entity.Comunicacion;
import com.o2.liga_bet_play.model.entity.Usuario;
import com.o2.liga_bet_play.persistence.UsuarioDAOImpl;
import com.o2.liga_bet_play.utils.ConsoleUtils;
import com.o2.liga_bet_play.persistence.ComunicacionDAOImpl;
import com.o2.liga_bet_play.model.entity.Rol;
import com.o2.liga_bet_play.model.entity.Permiso;
import com.o2.liga_bet_play.model.entity.Premio;
import com.o2.liga_bet_play.persistence.PremioDAOImpl;

import java.util.Hashtable;
import java.util.Scanner;

public class LoginApp {
  

    

    public static void main(String[] args) {
        UsuarioDAOImpl usuarioDAO = new UsuarioDAOImpl();
        ComunicacionDAOImpl comunicacionDAO = new ComunicacionDAOImpl();
        AuthService authService = new AuthService(usuarioDAO);

        // Crear permisos
        Permiso viewStats = new Permiso("1", "Ver estadísticas");
        Permiso editStats = new Permiso("2", "Editar estadísticas");
        Permiso manageUsers = new Permiso("3", "Gestionar usuarios");
        Permiso manageNews = new Permiso("4", "Gestionar noticias");

        // Crear roles
        Rol adminRol = new Rol("1", "Administrador");
        adminRol.setLstPermisos(manageUsers);
        adminRol.setLstPermisos(editStats);
        adminRol.setLstPermisos(manageNews);

        Rol coachRol = new Rol("2", "Entrenador");
        coachRol.setLstPermisos(viewStats);
        coachRol.setLstPermisos(editStats);

        Rol playerRol = new Rol("3", "Jugador");
        playerRol.setLstPermisos(viewStats);

        Rol journalistRol = new Rol("4", "Periodista");
        journalistRol.setLstPermisos(viewStats);
        journalistRol.setLstPermisos(manageNews);

        Rol fanRol = new Rol("5", "Aficionado");
        fanRol.setLstPermisos(viewStats);

        // Crear usuarios con roles
        Usuario admin = new Usuario("1", "Admin", "admin@example.com", "admin123", adminRol);
        Usuario coach = new Usuario("2", "Coach", "coach@example.com", "coach123", coachRol);
        Usuario player = new Usuario("3", "Player", "player@example.com", "player123", playerRol);
        Usuario journalist = new Usuario("4", "Journalist", "journalist@example.com", "journalist123", journalistRol);
        Usuario fan = new Usuario("5", "Fan", "fan@example.com", "fan123", fanRol);

        // Agregar usuarios al DAO
        usuarioDAO.addUsuario(admin);
        usuarioDAO.addUsuario(coach);
        usuarioDAO.addUsuario(player);
        usuarioDAO.addUsuario(journalist);
        usuarioDAO.addUsuario(fan);

        // Interacción con la consola
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.print("Ingrese su email: ");
            String email = scanner.nextLine();

            System.out.print("Ingrese su contraseña: ");
            String password = scanner.nextLine();

            if (authService.authenticate(email, password)) {
                Usuario authenticatedUser = authService.getUsuario(email);
                System.out.println("Autenticación exitosa para " + authenticatedUser.getNombre() + " con rol " + authenticatedUser.getRol().getNombre());
                
                switch (authenticatedUser.getRol().getNombre()) {
                    case "Administrador":
                        mostrarMenuAdministrador(scanner, usuarioDAO, comunicacionDAO);
                        break;
                    case "Entrenador":
                        mostrarMenuEntrenador(scanner);
                        break;
                    case "Jugador":
                        mostrarMenuJugador(scanner);
                        break;
                    case "Periodista":
                        mostrarMenuPeriodista(scanner, comunicacionDAO);
                        break;
                    case "Aficionado":
                        mostrarMenuAficionado(scanner);
                        break;
                    default:
                        System.out.println("Rol no reconocido.");
                }
            } else {
                System.out.println("Autenticación fallida para el email " + email);
            }

            System.out.print("¿Desea salir? (si/no): ");
            String respuesta = scanner.nextLine();
            exit = respuesta.equalsIgnoreCase("si");
        }

        scanner.close();
    }

    private static void mostrarMenuAdministrador(Scanner scanner, UsuarioDAOImpl usuarioDAO, ComunicacionDAOImpl comunicacionDAO) {
        boolean exit = false;
        while (!exit) {
            ConsoleUtils.cleanScreen();
            System.out.println("\nMenú de Administración:");
            System.out.println("1. Agregar usuario");
            System.out.println("2. Editar usuario");
            System.out.println("3. Eliminar usuario");
            System.out.println("4. Listar usuarios");
            System.out.println("5. Gestionar noticias");
            System.out.println("6. Gestionar premios");
            System.out.println("7. Volver al menú principal");
            int opcion = ConsoleUtils.option_validation("Seleccione una opcion:", 1, 6);

            switch (opcion) {
                case 1:
                    agregarUsuario(scanner, usuarioDAO);
                    break;
                case 2:
                    editarUsuario(scanner, usuarioDAO);
                    break;
                case 3:
                    eliminarUsuario(scanner, usuarioDAO);
                    break;
                case 4:
                    listarUsuarios(usuarioDAO);
                    break;
                case 5:
                    gestionarNoticias(scanner, comunicacionDAO);
                    break;
                    case 6:
                    gestionarPremios(scanner, PremioDAO);
                    exit = true;
                    break;
                case 7:
                    exit = true;
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, intente de nuevo.");
            }
            ConsoleUtils.pause();
        }
    }

    private static void mostrarMenuEntrenador(Scanner scanner) {
        boolean exit = false;
        while (!exit) {
            ConsoleUtils.cleanScreen();
            System.out.println("\nMenú de Entrenador:");
            System.out.println("1. Ver estadísticas");
            System.out.println("2. Editar estadísticas");
            System.out.println("3. Volver al menú principal");
            System.out.print("Seleccione una opción: ");
            int opcion = Integer.parseInt(scanner.nextLine());

            switch (opcion) {
                case 1:
                    System.out.println("Mostrando estadísticas...");
                    break;
                case 2:
                    System.out.println("Editando estadísticas...");
                    break;
                case 3:
                    exit = true;
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, intente de nuevo.");
            }
            ConsoleUtils.pause();
        }
    }

    private static void mostrarMenuJugador(Scanner scanner) {
        boolean exit = false;
        while (!exit) {
            ConsoleUtils.cleanScreen();
            System.out.println("\nMenú de Jugador:");
            System.out.println("1. Ver estadísticas");
            System.out.println("2. Volver al menú principal");
            System.out.print("Seleccione una opción: ");
            int opcion = Integer.parseInt(scanner.nextLine());

            switch (opcion) {
                case 1:
                    System.out.println("Mostrando estadísticas...");
                    break;
                case 2:
                    exit = true;
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, intente de nuevo.");
            }
            ConsoleUtils.pause();
        }
    }

    private static void mostrarMenuPeriodista(Scanner scanner, ComunicacionDAOImpl comunicacionDAO) {
        boolean exit = false;
        while (!exit) {
            ConsoleUtils.cleanScreen();
            System.out.println("\nMenú de Periodista:");
            System.out.println("1. Agregar noticia/comunicado");
            System.out.println("2. Editar noticia/comunicado");
            System.out.println("3. Eliminar noticia/comunicado");
            System.out.println("4. Listar noticias/comunicados");
            System.out.println("5. Volver al menú principal");
            System.out.print("Seleccione una opción: ");
            int opcion = Integer.parseInt(scanner.nextLine());

            switch (opcion) {
                case 1:
                    agregarNoticia(scanner, comunicacionDAO);
                    break;
                case 2:
                    editarNoticia(scanner, comunicacionDAO);
                    break;
                case 3:
                    eliminarNoticia(scanner, comunicacionDAO);
                    break;
                case 4:
                    listarNoticias(comunicacionDAO);
                    break;
                case 5:
                    exit = true;
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, intente de nuevo.");
            }
            ConsoleUtils.pause();
        }
    }

    private static void mostrarMenuAficionado(Scanner scanner) {
        boolean exit = false;
        while (!exit) {
            ConsoleUtils.cleanScreen();
            System.out.println("\nMenú de Aficionado:");
            System.out.println("1. Ver estadísticas");
            System.out.println("2. Volver al menú principal");
            System.out.print("Seleccione una opción: ");
            int opcion = Integer.parseInt(scanner.nextLine());

            switch (opcion) {
                case 1:
                    System.out.println("Mostrando estadísticas...");
                    break;
                case 2:
                    exit = true;
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, intente de nuevo.");
            }
            ConsoleUtils.pause();
        }
    }

    private static void agregarUsuario(Scanner scanner, UsuarioDAOImpl usuarioDAO) {
        ConsoleUtils.cleanScreen();
        System.out.print("Ingrese ID: ");
        String id = scanner.nextLine();
        System.out.print("Ingrese nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese email: ");
        String email = scanner.nextLine();
        System.out.print("Ingrese contraseña: ");
        String password = scanner.nextLine();
        System.out.print("Ingrese rol (1: Administrador, 2: Entrenador, 3: Jugador, 4: Periodista, 5: Aficionado): ");
        int rolSeleccionado = Integer.parseInt(scanner.nextLine());

        Rol rol;
        switch (rolSeleccionado) {
            case 1:
                rol = new Rol("1", "Administrador");
                break;
            case 2:
                rol = new Rol("2", "Entrenador");
                break;
            case 3:
                rol = new Rol("3", "Jugador");
                break;
            case 4:
                rol = new Rol("4", "Periodista");
                break;
            case 5:
                rol = new Rol("5", "Aficionado");
                break;
            default:
                System.out.println("Rol no válido. Usuario no creado.");
                return;
        }

        Usuario nuevoUsuario = new Usuario(id, nombre, email, password, rol);
        usuarioDAO.addUsuario(nuevoUsuario);
        System.out.println("Usuario agregado exitosamente.");
        ConsoleUtils.pause();
    }

    private static void editarUsuario(Scanner scanner, UsuarioDAOImpl usuarioDAO) {
        ConsoleUtils.cleanScreen();
        System.out.print("Ingrese email del usuario a editar: ");
        String email = scanner.nextLine();

        Usuario usuario = usuarioDAO.getUsuarioByEmail(email);
        if (usuario == null) {
            System.out.println("Usuario no encontrado.");
            return;
        }

        System.out.print("Ingrese nuevo nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese nueva contraseña: ");
        String password = scanner.nextLine();
        System.out.print("Ingrese nuevo rol (1: Administrador, 2: Entrenador, 3: Jugador, 4: Periodista, 5: Aficionado): ");
        int rolSeleccionado = Integer.parseInt(scanner.nextLine());

        Rol rol;
        switch (rolSeleccionado) {
            case 1:
                rol = new Rol("1", "Administrador");
                break;
            case 2:
                rol = new Rol("2", "Entrenador");
                break;
            case 3:
                rol = new Rol("3", "Jugador");
                break;
            case 4:
                rol = new Rol("4", "Periodista");
                break;
            case 5:
                rol = new Rol("5", "Aficionado");
                break;
            default:
                System.out.println("Rol no válido. Usuario no editado.");
                return;
        }

        usuario.setNombre(nombre);
        usuario.setPassword(password);
        usuario.setRol(rol);
        usuarioDAO.addUsuario(usuario); // Actualizar usuario
        System.out.println("Usuario editado exitosamente.");
        ConsoleUtils.pause();
    }
   

    private static void eliminarUsuario(Scanner scanner, UsuarioDAOImpl usuarioDAO) {
        ConsoleUtils.cleanScreen();
        System.out.print("Ingrese email del usuario a eliminar: ");
        String email = scanner.nextLine();

        usuarioDAO.deleteUsuario(email);
        System.out.println("Usuario eliminado exitosamente.");
        ConsoleUtils.pause();
    }

    private static void listarUsuarios(UsuarioDAOImpl usuarioDAO) {
        ConsoleUtils.cleanScreen();
        for (Usuario usuario : usuarioDAO.getAllUsuarios()) {
            System.out.println("ID: " + usuario.getId() + ", Nombre: " + usuario.getNombre() + ", Email: " + usuario.getEmail() + ", Rol: " + usuario.getRol().getNombre());
        }
        ConsoleUtils.pause();
    }
    

    private static void gestionarNoticias(Scanner scanner, ComunicacionDAOImpl comunicacionDAO) {
        boolean exit = false;
        while (!exit) {
            ConsoleUtils.cleanScreen();
            System.out.println("\nGestión de Noticias:");
            System.out.println("1. Agregar noticia/comunicado");
            System.out.println("2. Editar noticia/comunicado");
            System.out.println("3. Eliminar noticia/comunicado");
            System.out.println("4. Listar noticias/comunicados");
            System.out.println("5. Volver al menú anterior");
            System.out.print("Seleccione una opción: ");
            int opcion = Integer.parseInt(scanner.nextLine());

            switch (opcion) {
                case 1:
                    agregarNoticia(scanner, comunicacionDAO);
                    break;
                case 2:
                    editarNoticia(scanner, comunicacionDAO);
                    break;
                case 3:
                    eliminarNoticia(scanner, comunicacionDAO);
                    break;
                case 4:
                    listarNoticias(comunicacionDAO);
                    break;
                case 5:
                    exit = true;
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, intente de nuevo.");
            }
            ConsoleUtils.pause();
        }
    }

    private static void agregarNoticia(Scanner scanner, ComunicacionDAOImpl comunicacionDAO) {
        ConsoleUtils.cleanScreen();
        System.out.print("Ingrese ID de la noticia: ");
        String id = scanner.nextLine();
        System.out.print("Ingrese título: ");
        String titulo = scanner.nextLine();
        System.out.print("Ingrese contenido: ");
        String contenido = scanner.nextLine();
        System.out.print("Ingrese fecha de publicación: ");
        String fechaPublicacion = scanner.nextLine();

        Comunicacion nuevaComunicacion = new Comunicacion();
        nuevaComunicacion.setId(id);
        nuevaComunicacion.setTitulo(titulo);
        nuevaComunicacion.setContenido(contenido);
        nuevaComunicacion.setFechaPublicacion(fechaPublicacion);

        comunicacionDAO.addComunicacion(nuevaComunicacion);
        System.out.println("Noticia/comunicado agregado exitosamente.");
        ConsoleUtils.pause();
    }

    private static void editarNoticia(Scanner scanner, ComunicacionDAOImpl comunicacionDAO) {
        ConsoleUtils.cleanScreen();
        System.out.print("Ingrese ID de la noticia a editar: ");
        String id = scanner.nextLine();

        Comunicacion comunicacion = comunicacionDAO.getComunicacionById(id);
        if (comunicacion == null) {
            System.out.println("Noticia/comunicado no encontrado.");
            return;
        }

        System.out.print("Ingrese nuevo título: ");
        String titulo = scanner.nextLine();
        System.out.print("Ingrese nuevo contenido: ");
        String contenido = scanner.nextLine();
        System.out.print("Ingrese nueva fecha de publicación: ");
        String fechaPublicacion = scanner.nextLine();

        comunicacion.setTitulo(titulo);
        comunicacion.setContenido(contenido);
        comunicacion.setFechaPublicacion(fechaPublicacion);
        comunicacionDAO.updateComunicacion(comunicacion);
        System.out.println("Noticia/comunicado editado exitosamente.");
        ConsoleUtils.pause();
    }

    private static void eliminarNoticia(Scanner scanner, ComunicacionDAOImpl comunicacionDAO) {
        ConsoleUtils.cleanScreen();
        System.out.print("Ingrese ID de la noticia a eliminar: ");
        String id = scanner.nextLine();

        comunicacionDAO.deleteComunicacion(id);
        System.out.println("Noticia/comunicado eliminado exitosamente.");
        ConsoleUtils.pause();
    }

    private static void listarNoticias(ComunicacionDAOImpl comunicacionDAO) {
        ConsoleUtils.cleanScreen();
        for (Comunicacion comunicacion : comunicacionDAO.getComunicaciones().values()) {
            System.out.println("ID: " + comunicacion.getId() + ", Título: " + comunicacion.getTitulo() + ", Contenido: " + comunicacion.getContenido() + ", Fecha de Publicación: " + comunicacion.getFechaPublicacion());
        }
        ConsoleUtils.pause();
    }

private static void agregarPremio(Scanner scanner, PremioDAOImpl premioDAO) {
        System.out.print("Ingrese el ID del premio: ");
        String id = scanner.nextLine();
        System.out.print("Ingrese el nombre del premio: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese la descripción del premio: ");
        String descripcion = scanner.nextLine();
        System.out.print("Ingrese los criterios del premio: ");
        String criterios = scanner.nextLine();
        System.out.print("Ingrese los destinatarios del premio: ");
        String destinatarios = scanner.nextLine();
        System.out.print("Ingrese la fecha del premio: ");
        String fecha = scanner.nextLine();

        Premio premio = new Premio(id, nombre, descripcion, criterios, destinatarios, fecha);
        premioDAO.addPremio(premio);
        System.out.println("Premio agregado con éxito.");
    }

    private static void editarPremio(Scanner scanner, PremioDAOImpl premioDAO) {
        System.out.print("Ingrese el ID del premio a editar: ");
        String id = scanner.nextLine();
        Premio premio = premioDAO.getPremioById(id);
        if (premio != null) {
            System.out.print("Ingrese el nuevo nombre del premio: ");
            String nombre = scanner.nextLine();
            System.out.print("Ingrese la nueva descripción del premio: ");
            String descripcion = scanner.nextLine();
            System.out.print("Ingrese los nuevos criterios del premio: ");
            String criterios = scanner.nextLine();
            System.out.print("Ingrese los nuevos destinatarios del premio: ");
            String destinatarios = scanner.nextLine();
            System.out.print("Ingrese la nueva fecha del premio: ");
            String fecha = scanner.nextLine();

            premio.setNombre(nombre);
            premio.setDescripcion(descripcion);
            premio.setCriterios(criterios);
            premio.setDestinatarios(destinatarios);
            premio.setFecha(fecha);

            premioDAO.updatePremio(premio);
            System.out.println("Premio editado con éxito.");
        } else {
            System.out.println("Premio no encontrado.");
        }
    }

    private static void eliminarPremio(Scanner scanner, PremioDAOImpl premioDAO) {
        System.out.print("Ingrese el ID del premio a eliminar: ");
        String id = scanner.nextLine();
        premioDAO.deletePremio(id);
        System.out.println("Premio eliminado con éxito.");
    }

    private static void listarPremios(PremioDAOImpl premioDAO) {
        Hashtable<String, Premio> premios = premioDAO.getAllPremios();
        if (premios.isEmpty()) {
            System.out.println("No hay premios registrados.");
        } else {
            premios.forEach((id, premio) -> {
                System.out.println("ID: " + premio.getId());
                System.out.println("Nombre: " + premio.getNombre());
                System.out.println("Descripción: " + premio.getDescripcion());
                System.out.println("Criterios: " + premio.getCriterios());
                System.out.println("Destinatarios: " + premio.getDestinatarios());
                System.out.println("Fecha: " + premio.getFecha());
                System.out.println("---------------------------");
            });
        }


}
}