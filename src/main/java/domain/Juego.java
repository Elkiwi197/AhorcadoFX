package domain;

import service.ServicePalabras;
import ui.LlamadasUsuario;
import ui.Mensajes;

import java.io.*;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Juego {
    private ServicePalabras servicePalabras = new ServicePalabras();
    private String contrasena = "vaca";

    public Juego() {

    }

    public String getContrasena() {
        return contrasena;
    }

    public void iniciar() {
        Scanner scanner = new Scanner(System.in);
        int opcion = 0;
        servicePalabras.init();
        Mensajes.mostrarBienvenida();
        do {
            Mensajes.mostrarMenuPrincipal();
            opcion = LlamadasUsuario.elegirOpcion(1, 3);

            switch (opcion) {
                case 1:
                    Mensajes.mostrarMenuJugar();
                    opcion = LlamadasUsuario.elegirOpcion(1, 4);
                    switch (opcion) {
                        case 1:
                            try {
                                jugarPartidaGuardada();
                            } catch (NullPointerException e) {
                                Mensajes.noHayNingunaPartidaGuardada();
                            }
                            break;
                        case 2:
                            jugarPartida(servicePalabras.devolverPalabraAleatoria(), 0, null, "");
                            break;
                        case 3:
                            jugarPartida(LlamadasUsuario.elegirTipoDePalabra(servicePalabras), 0, null, "");
                            break;
                        default:
                    }
                    opcion = 0;
                    break;
                case 2:
                    if (LlamadasUsuario.introducirContrasena()) {
                        Mensajes.mostrarMenuGestionar();
                        opcion = LlamadasUsuario.elegirOpcion(1, 5);
                        switch (opcion) {
                            case 1:
                                listarPalabras();
                                break;
                            case 2:
                                anadirPalabra();
                                break;
                            case 3:
                                modificarPalabra();
                                break;
                            case 4:
                                eliminarPalabra();
                                break;
                            default:
                        }
                    }
                    opcion = 0;
                    break;
                case 3:
                    Mensajes.mostrarCreditos();
                    break;
                default:
            }
        } while (opcion != 3);




    }


    public void jugarPartidaGuardada() throws NullPointerException {
        FileInputStream fileInputStream = null;
        ObjectInputStream objectInputStream = null;
        DataInputStream dataInputStream = null;

        String entrada = "";
        char caracter = 0;
        int separador = 0;

        String palabra = "";
        String categoria = "";
        String incognita = "";
        String letrasUsadas = "";
        int fallos = 0;


        try {
            fileInputStream = new FileInputStream("src\\main\\java\\utils\\partidaGuardada.txt");
        } catch (FileNotFoundException e) {
            Mensajes.noSeEncontroElArchivo();
        }

        try {
            objectInputStream = new ObjectInputStream(fileInputStream);
            if (fileInputStream != null) {
                dataInputStream = new DataInputStream(fileInputStream);
            }
        } catch (IOException e) {
            Mensajes.noSePudoLeerElArchivo();
        }


        try {
            if (dataInputStream != null) {
                entrada = dataInputStream.readUTF();
            }
        } catch (IOException e) {
            Mensajes.laLineaEstaVacia();
        }

        for (int i = 0; i < entrada.length(); i++) {
            caracter = entrada.charAt(i);
            if (caracter == ';') {
                separador++;
            } else {
                switch (separador) {
                    case 0:
                        palabra = palabra.concat(String.valueOf(caracter));
                        break;
                    case 1:
                        categoria = categoria.concat(String.valueOf(caracter));
                        break;
                    case 2:
                        if (caracter != '[' && caracter != ']' && caracter != ',') {
                            if ((caracter == ' ' && entrada.charAt(i + 1) == ' ') || Character.isAlphabetic(caracter) || caracter == '-') {
                                incognita = incognita.concat(String.valueOf(caracter));
                            }
                        }
                        break;
                    case 3:
                        fallos = caracter;
                        break;
                    case 4:
                        letrasUsadas = letrasUsadas.concat(String.valueOf(caracter));
                        break;
                }

            }
        }
        jugarPartida(palabra, fallos, incognita.toCharArray(), letrasUsadas);
    }

    public void guardarPartida(String palabra, String categoria, String incognita, int fallos, String letrasUsadas) {
        FileOutputStream fileOutputStream = null;
        ObjectOutputStream objectOutputStream = null;
        DataOutputStream dataOutputStream = null;
        Partida partida = new Partida(palabra, categoria, incognita, fallos, letrasUsadas);
        try {
            fileOutputStream = new FileOutputStream("src\\main\\java\\utils\\partidaGuardada.txt");
        } catch (FileNotFoundException e) {
            Mensajes.noSeEncontroElArchivo();
        }
        try {
            objectOutputStream = new ObjectOutputStream(fileOutputStream);
            dataOutputStream = new DataOutputStream(fileOutputStream);
        } catch (IOException e) {
            Mensajes.noSePudoEscribirEnElArchivo();
        }


        try {
            if (dataOutputStream != null) {
                /*
                dataOutputStream.writeUTF(palabra);
                dataOutputStream.writeUTF(Arrays.toString(incognita));
                dataOutputStream.writeUTF(String.valueOf(fallos));
                dataOutputStream.writeUTF(letrasUsadas);
                 */
                dataOutputStream.writeUTF(partida.toString());
                Mensajes.partidaGuardada();
            }
        } catch (IOException e) {
            Mensajes.noSePudoEscribirEnElArchivo();
        }

        /*
        try {
            if (objectOutputStream != null) {

                // ESCRIBE LOS DATOS NECESARIOS
                objectOutputStream.writeChars(palabra);
                objectOutputStream.writeChars(Arrays.toString(incognita));
                objectOutputStream.write(fallos);
                objectOutputStream.writeChars(letrasUsadas);


                // ESCRIBE UNA INSTAANCIA DE JUEGO
                objectOutputStream.writeObject(this);


                System.out.println("Partida guardada correctamente");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        */
        try {
            if (objectOutputStream != null) {
                objectOutputStream.close();
            }
            if (fileOutputStream != null) {
                fileOutputStream.close();
            }
            if (dataOutputStream != null) {
                dataOutputStream.close();
            }
        } catch (IOException e) {
            Mensajes.noSePudoCerrarElStream();
        }

    }


    public void jugarPartida(String palabra, int fallos, char[] incognita, String letrasUsadas) {
        Scanner scanner = new Scanner(System.in);
        String entrada = "";
        boolean fallo;
        boolean seguir = true;

        if (incognita == null) {
            incognita = palabra.toCharArray();
            for (int i = 0; i < incognita.length; i++) {
                if (incognita[i] != ' ') {
                    incognita[i] = '-';
                }
            }
        }


        while (seguir) {
            Mensajes.imprimirCategoria(servicePalabras.devolverPalabra(palabra).getGenero());
            Mensajes.imprimirIncognita(incognita);
            Mensajes.imprimirVidasyLetrasUsadas(fallos, letrasUsadas);
            boolean repetida = false;
            do {
                entrada = LlamadasUsuario.leerCaracter();
                repetida = false;
                for (int i = 0; i < letrasUsadas.length(); i++) {
                    if (entrada.charAt(0) == (letrasUsadas.charAt(i))) {
                        repetida = true;
                        Mensajes.letraRepetida();
                    }
                }
            } while (repetida);

            if (!entrada.equals("+") && !entrada.equals("-")) {
                fallo = true;
                for (int i = 0; i < palabra.length(); i++) {
                    if (entrada.charAt(0) == (palabra.charAt(i))) {
                        fallo = false;
                        incognita[i] = palabra.charAt(i);
                    }
                }
                if (fallo) {
                    fallos++;
                }
                letrasUsadas = letrasUsadas.concat(" " + entrada);
            } else if (entrada.equals("+")) {
                Mensajes.introduceLaPalabraCompleta();
                entrada = scanner.nextLine().toUpperCase();

                if (palabra.equals(entrada)) {
                    incognita = palabra.toCharArray();
                } else {
                    fallos++;
                }
            } else if (entrada.equals("-")) {
                Mensajes.guardandoPartida();
                guardarPartida(palabra, servicePalabras.devolverPalabra(palabra).getGenero(), Arrays.toString(incognita), fallos, letrasUsadas);
                seguir = false;
            } else {
                Mensajes.introduceUnaLetraOpcion();
            }
            if (Arrays.equals(incognita, palabra.toCharArray())) {
                Mensajes.imprimirIncognita(incognita);
                Mensajes.enhorabuenaGanaste();
                seguir = false;
            }
            if (fallos == 5) {
                Mensajes.ohPerdiste();
                Mensajes.laPalabraEra(palabra);
                seguir = false;
            }
        }
    }





    public void anadirPalabra() {
        Palabra palabra = LlamadasUsuario.anadirPalabra();
        try {
            if (servicePalabras.anadirPalabra(palabra)) {
                Mensajes.palabraAnadida();
            } else {
                Mensajes.esaPalabraYaEsta();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void listarPalabras() {
        try {
            servicePalabras.listarPalabras();
        } catch (FileNotFoundException e) {
            Mensajes.mostrarError();
        }
    }

    public void eliminarPalabra() {
        listarPalabras();
        String palabraEliminar = LlamadasUsuario.eliminarPalabra();
        if (servicePalabras.eliminarPalabra(palabraEliminar.toUpperCase())) {
            Mensajes.palabraEliminada();
        } else {
            Mensajes.errorEliminandoPalabra();
        }
    }

    public void modificarPalabra() {
        Scanner scanner = new Scanner(System.in);
        String palabraModificar = "";
        String valor;
        int campo = 0;
        Mensajes.introducePalabraModificar();
        palabraModificar = scanner.next().toUpperCase();
        if (servicePalabras.devolverPalabra(palabraModificar) != null) {
            Mensajes.imprimirPalabra(servicePalabras.devolverPalabra(palabraModificar));
            Mensajes.introduceCampoModificar();
            Mensajes.mostrarCampos();
            do {
                campo = 0;
                try {
                    campo = scanner.nextInt();
                    if (campo >= 1 && campo <= 3) {
                        valor = LlamadasUsuario.modificarPalabra(campo);
                        if (servicePalabras.modificarPalabra(palabraModificar, "a", campo, valor)) {
                            Mensajes.palabraModificada();
                        } else {
                            Mensajes.errorModificandoPalabra();
                        }
                    } else {
                        Mensajes.introduceOpcionValida();
                    }
                } catch (InputMismatchException e) {
                    Mensajes.introduceNumero();
                }
            } while (campo < 1 || campo > 3);
        } else {
            Mensajes.noSeEncontroEsaPalabra();
        }
    }


}
