package ui;

import domain.Palabra;


public abstract class Mensajes  {

    //MENSAJES DE INICIO
    public static void mostrarBienvenida() {
        System.out.println("Bienvenido al ahorcado");
    }

    public static void mostrarMenuPrincipal() {
        System.out.println("1 - Jugar     2 - Gestionar     3 - Salir");

    }

    public static void mostrarMenuJugar() {
        System.out.println("1 - Cargar partida     2- Partida rápida     3 - Partida normal     4 - Menú principal");
    }

    public static void mostrarMenuGestionar() {
        System.out.println("1 - Listar diccionario     2 - Añadir palabra     3 - Modificar palabra      4 - Eliminar palabra     5 - Menú principal");
    }


    // MENSAJES DE JUEGO
    public static void imprimirCategoria(String categoria) {
        System.out.println("Categoría: " + categoria);
    }

    public static void imprimirIncognita(char[] incognita) {
        System.out.print(incognita);
    }

    public static void imprimirVidasyLetrasUsadas(int fallos, String letrasUsadas) {
        System.out.println("          Vidas: " + (5 - fallos) + "     Letras introducidas: " + letrasUsadas);
    }

    public static void introduceLaPalabraCompleta() {
        System.out.println("Introduce la palabra completa");
    }

    public static void introduceUnaLetraOpcion() {
        System.out.println("Introduce una letra/opción");
    }

    public static void eligeLaCategoria() {
        System.out.print("""
                Elige la categoría: 
                1 - Series     2 - Películas     3 - Videojuegos     4 - Música     5 - Deportes
                6 - Ciencia    7 - Historia      8 - Geografía       9 - Otros
                """);
    }

    public static void eligeLaDificultad() {
        System.out.println("Elige la dificultad (1-5)");
    }


    // MENSAJES DE GESTIÓN
    public static void palabraAnadida() {
        System.out.println("Palabra añadida correctamente");
    }

    public static void introducePalabraModificar() {
        System.out.println("Introduce la palabra que quieres modificar");
    }

    public static void palabraModificada() {
        System.out.println("Palabra modificada correctamente");
    }

    public static void palabraEliminada() {
        System.out.println("Palabra eliminada correctamente");
    }

    public static void introduceCampoModificar() {
        System.out.println("\n¿Qué campo quieres modificar?");
    }

    public static void mostrarCampos() {
        System.out.println("1 - Dificultad     2 - Palabra     3 - Género");
    }


    // MENSAJES DE ERROR

    public static void mostrarError() {
        System.out.println("Ha habido un error");
    }

    public static void noHayNingunaPartidaGuardada() {
        System.out.println("No hay ninguna partida guardada");
    }

    public static void noSeEncontroElArchivo() {
        System.out.println("No se encontró el archivo");
    }

    public static void noSePudoLeerElArchivo() {
        System.out.println("No se pudo leer el archivo");
    }

    public static void noSePudoEscribirEnElArchivo() {
        System.out.println("No se pudo escribir en el archivo");
    }

    public static void laLineaEstaVacia() {
        System.out.println("La línea está vacía");
    }

    public static void noSePudoCerrarElStream() {
        System.out.println("No se pudo cerrar el stream");
    }

    public static void esaPalabraYaEsta() {
        System.out.println("Esa palabra ya está en el diccionario");
    }

    public static void errorModificandoPalabra() {
        System.out.println("Hubo un error modificando la palabra");
    }

    public static void errorEliminandoPalabra() {
        System.out.println("Hubo un error eliminando la palabra");
    }

    public static void noHayPalabrasConEsasCaracteristicas() {
        System.out.println("No existen palabras de esas características en tu diccionario, prueba otra dificultad/categoría");
    }

    public static void errorBufferedReader() {
        System.out.println("Hubo un error leyendo el buffered reader");
    }


    // MENSAJES DE INFORMACION AL USUARIO

    public static void letraRepetida() {
        System.out.println("Letra repetida");

    }

    public static void guardandoPartida() {
        System.out.println("Guardando partida...");
    }

    public static void partidaGuardada() {
        System.out.println("Partida guardada");
    }

    public static void enhorabuenaGanaste() {
        System.out.println("\nEnhorabuena, ganaste!");
    }

    public static void ohPerdiste() {
        System.out.println("Ohh, perdiste");
    }

    public static void laPalabraEra(String palabra) {
        System.out.println("La palabra era " + palabra);
    }

    public static void introduceNumero() {
        System.out.println("Introduce un número");
    }

    public static void introduceOpcionValida() {
        System.out.println("Introduce una opción válida");
    }

    public static void noSeEncontroEsaPalabra() {
        System.out.println("No se encontró esa palabra en el diccionario");
    }

    public static void noSePudoLeerLaLinea() {
        System.out.println("No se pudo leer la línea");
    }

    // OTROS MENSAJES

    public static void mostrarCreditos() {
        System.out.println("Written and directed by Quentin Tarantino");
    }

    public static void imprimirPalabra(Palabra palabra) {
        System.out.println("\n" + palabra);
    }




}
