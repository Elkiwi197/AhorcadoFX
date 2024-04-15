package ui;

import common.Comprobaciones;
import common.Generos;
import common.InputInvalidoException;
import domain.Juego;
import domain.Palabra;
import service.ServicePalabras;

import java.util.InputMismatchException;
import java.util.Scanner;

public abstract class LlamadasUsuario {

    public static void iniciar() {
    }

    public static int elegirOpcion(int min, int max) {
        Scanner scanner = new Scanner(System.in);
        int opcion = 0;
        do {
            try {
                opcion = scanner.nextInt();
                if (opcion < min || opcion > max) {
                    System.out.println("Introduce una opción válida");
                }
            } catch (InputMismatchException e) {
                System.out.println("Introduce un número");
            }
            scanner.nextLine();
        } while (opcion < min || opcion > max);
        return opcion;
    }

    public static String eliminarPalabra() {
        Scanner scanner = new Scanner(System.in);
        String palabraEliminar;
        System.out.println("¿Qué palabra quieres eliminar?");
        palabraEliminar = scanner.next().toUpperCase();
        return palabraEliminar;
    }

    public static Palabra anadirPalabra() {
        Scanner scanner = new Scanner(System.in);
        Palabra palabra = new Palabra();
        String nuevaPalabra;
        int dificultad = 0;
        int categoria = 0;

        System.out.println("Introduce una palabra");
        nuevaPalabra = scanner.next();
        nuevaPalabra = nuevaPalabra.toUpperCase();
        palabra.setValor(nuevaPalabra);
        System.out.println("Introduce la dificultad (de 1 a 5)");
        do {
            try {
                dificultad = scanner.nextInt();
                if (dificultad >= 1 && dificultad <= 5) {
                    palabra.setDificultad(dificultad);
                } else {
                    System.out.println("Introduce un valor válido para la dificultad");
                }
            } catch (InputMismatchException e) {
                System.out.println("Introduce un número");
            }
            scanner.nextLine();
        } while (dificultad < 1 || dificultad > 5);
        System.out.print("""
                Elige la categoría: 
                1 - Series     2 - Películas     3 - Videojuegos     4 - Música     5 - Deportes
                6 - Ciencia    7 - Historia      8 - Geografía       9 - Otros
                """);
        do {
            try {
                categoria = scanner.nextInt();
                if (categoria >= 1 && categoria <= 9) {
                    switch (categoria) {
                        case 1:
                            palabra.setGenero(String.valueOf(Generos.Series));
                            break;
                        case 2:
                            palabra.setGenero(String.valueOf(Generos.Películas));

                            break;
                        case 3:
                            palabra.setGenero(String.valueOf(Generos.Videojuegos));

                            break;
                        case 4:
                            palabra.setGenero(String.valueOf(Generos.Música));

                            break;
                        case 5:
                            palabra.setGenero(String.valueOf(Generos.Deportes));

                            break;
                        case 6:
                            palabra.setGenero(String.valueOf(Generos.Ciencia));

                            break;
                        case 7:
                            palabra.setGenero(String.valueOf(Generos.Historia));

                            break;
                        case 8:
                            palabra.setGenero(String.valueOf(Generos.Geografía));

                            break;
                        case 9:
                            palabra.setGenero(String.valueOf(Generos.Otros));
                            break;
                        default:

                    }
                } else {
                    System.out.println("Introduce un valor válido para la categoría");
                }
            } catch (InputMismatchException e) {
                System.out.println("Introduce un número");
            }
            scanner.nextLine();
        } while (categoria < 1 || categoria > 9);
        return palabra;
    }

    public static boolean introducirContrasena() {
        Juego juego = new Juego();
        Scanner scanner = new Scanner(System.in);
        String intento;
        do {
            System.out.println("Introduce una contraseña de administrador");
            intento = scanner.next();
        } while (!juego.getContrasena().equals(intento));
        return true;
    }

    public static String modificarPalabra(int campo) {
        Scanner scanner = new Scanner(System.in);
        int num = 0;
        String valor = "";
        switch (campo) {
            case 1:
                LlamadasUsuario.modificarPalabra(num);
                System.out.println("Introduce la nueva dificultad (de 1 a 5)");
                do {
                    try {
                        num = scanner.nextInt();
                        if (num > 0 && num < 6) {
                            valor = String.valueOf(num);
                        } else {
                            System.out.println("Introduce una opción válida");
                        }
                    } catch (InputMismatchException e) {
                        System.out.println("Introduce un número");
                        scanner.nextLine();
                    }
                } while (num < 1 || num > 6);
                break;
            case 2:
                System.out.println("Introduce la nueva palabra");
                valor = scanner.next().toUpperCase();
                break;
            case 3:
                num = 0;
                System.out.print("""
                        Elige la nueva categoría: 
                        1 - Series     2 - Películas     3 - Videojuegos     4 - Música     5 - Deportes
                        6 - Ciencia    7 - Historia      8 - Geografía       9 - Otros
                        """);
                do {
                    try {
                        num = scanner.nextInt();
                        if (num > 0 && num < 10) {
                            valor = String.valueOf(num);
                        } else {
                            System.out.println("Introduce una categoría válida");
                        }
                    } catch (InputMismatchException e) {
                        System.out.println("Introduce un número");
                        scanner.next();
                    }
                } while (num < 1 || num > 9);
                break;
        }
        return valor;
    }

    public static String leerCaracter() {
        Scanner scanner = new Scanner(System.in);
        boolean flag = false;
        String entrada = "";
        System.out.println("\nIntroduce una letra para adivinar, + para resolver o - para guardar");
        do {
            try {
                entrada = scanner.next().toUpperCase();
                Comprobaciones.comprobarCaracter(entrada);
                flag = true;

            } catch (InputInvalidoException e) {
                System.out.println(e.getMessage());
                scanner.nextLine();
            }
        } while (!flag);
        return entrada;

    }

    public static String elegirTipoDePalabra(ServicePalabras servicePalabras) {
        Scanner scanner = new Scanner(System.in);
        String palabra = null;
        int dificultad = 0;
        int categoria = 0;
        boolean existe = false;
        while (!existe) {
            Mensajes.eligeLaDificultad();
            dificultad = LlamadasUsuario.elegirOpcion(1, 5);
            Mensajes.eligeLaCategoria();
            categoria = LlamadasUsuario.elegirOpcion(1, 9);
            palabra = servicePalabras.devolverPalabra(dificultad, categoria);
            if (!palabra.isEmpty()) {
                existe = true;
            } else {
                Mensajes.noHayPalabrasConEsasCaracteristicas();
            }
        }
        return palabra;
    }
}
