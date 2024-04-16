package dao;

import com.github.javafaker.Faker;
import common.Generos;
import domain.Palabra;
import ui.Mensajes;

import java.io.*;
import java.util.*;

public class DAOpalabras {

    private List<Palabra> diccionario = new ArrayList<>();

    public DAOpalabras() {
    }

    public List<Palabra> getDiccionario() {
        return diccionario;
    }

    public void setDiccionario(ArrayList<Palabra> diccionario) {
        this.diccionario = diccionario;
    }

    public void init() {
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;
        String line = null;
        Faker faker = new Faker();

        try {
            fileReader = new FileReader("src\\main\\java\\utils\\diccionario.txt");
        } catch (FileNotFoundException e) {
            Mensajes.noSePudoLeerElArchivo();
        }

        try {
            bufferedReader = new BufferedReader(fileReader);
            line = bufferedReader.readLine();
        } catch (IOException e) {
            Mensajes.noSePudoLeerElArchivo();
        } catch (NullPointerException e) {
            Mensajes.noSePudoLeerElArchivo();
        }
        try {
            if (line == null) {
                diccionario.add(new Palabra("Hola", 1, "Otros"));
                diccionario.add(new Palabra("Homer", 1, "Series"));
                diccionario.add(new Palabra("Heisenberg", 3, "Series"));
                diccionario.add(new Palabra("Hermione Granger", 1, "Películas"));
                diccionario.add(new Palabra("Men in Black", 2, "Películas"));
                diccionario.add(new Palabra("GTA V", 1, "Videojuegos"));
                diccionario.add(new Palabra("Call of Duty", 1, "Videojuegos"));
                diccionario.add(new Palabra("Red Dead Redemption", 1, "Videojuegos"));
                diccionario.add(new Palabra("Fifa", 1, "Videojuegos"));
                diccionario.add(new Palabra("Messi", 1, "Deportes"));
                diccionario.add(new Palabra("Rafa Nadal", 1, "Deportes"));
                diccionario.add(new Palabra("Mesa", 1, "Otros"));
                diccionario.add(new Palabra("Santa Maria", 3, "Historia"));
                diccionario.add(new Palabra("Trafalgar", 4, "Historia"));
                diccionario.add(new Palabra("The Beatles", 1, "Música"));
                diccionario.add(new Palabra("The Rolling Stones", 1, "Música"));
                diccionario.add(new Palabra("Piano", 1, "Música"));
                diccionario.add(new Palabra("Fuera de juego", 4, "Deportes"));
                diccionario.add(new Palabra("Nepal", 2, "Geografía"));
                diccionario.add(new Palabra("Tombolo", 5, "Geografía"));
                diccionario.add(new Palabra("Oasis", 1, "Geografía"));
                diccionario.add(new Palabra("Probeta", 1, "Ciencia"));
                diccionario.add(new Palabra("Laboratorio", 1, "Ciencia"));
                diccionario.add(new Palabra("Radiacion", 2, "Ciencia"));
                diccionario.add(new Palabra("Newton", 2, "Ciencia"));
                diccionario.add(new Palabra("Ohmio", 4, "Ciencia"));
                diccionario.add(new Palabra("Pollo", 4, "Otros"));


                // (OPCIONAL) METER PALABRAS CON JAVA FAKER

                //NO FUNCIONA
                /*

                for (int i = 0; i < 10; i++) {
                    String valor;
                    String genero = Generos.Series.toString();
                    int dificultad = faker.number().numberBetween(1, 5);
                    boolean unico;

                    do {
                        unico = true;
                        valor = faker.harryPotter().character().toUpperCase();
                        for (Palabra palabraUnica : diccionario) {
                            if (palabraUnica.getValor().equals(valor)) {
                                unico = false;
                            }
                        }
                    } while (!unico);
                    diccionario.add(new Palabra(valor, dificultad, genero));
                }

                for (int i = 0; i < 10; i++) {
                    String valor;
                    String genero = Generos.Series.toString();
                    int dificultad = faker.number().numberBetween(1, 5);
                    boolean unico;

                    do {
                        unico = true;
                        valor = faker.twinPeaks().character().toUpperCase();
                        for (Palabra palabraUnica : diccionario) {
                            if (palabraUnica.getValor().equals(valor)) {
                                unico = false;
                            }
                        }
                    } while (!unico);
                    diccionario.add(new Palabra(valor, dificultad, genero));
                }
                for (int i = 0; i < 10; i++) {
                    String valor;
                    String genero = Generos.Videojuegos.toString();
                    int dificultad = faker.number().numberBetween(1, 5);
                    boolean unico;

                    do {
                        unico = true;
                        valor = faker.leagueOfLegends().champion().toUpperCase();
                        for (Palabra palabraUnica : diccionario) {
                            if (palabraUnica.getValor().equals(valor)) {
                                unico = false;
                            }
                        }
                    } while (!unico);
                    diccionario.add(new Palabra(valor, dificultad, genero));
                }

                for (int i = 0; i < 50; i++) {
                    String valor;
                    String genero = Generos.Geografía.toString();
                    int dificultad = faker.number().numberBetween(1, 5);
                    boolean unico;

                    do {
                        unico = true;
                        valor = faker.country().name().toUpperCase();
                        for (Palabra palabraUnica : diccionario) {
                            if (palabraUnica.getValor().equals(valor)) {
                                unico = false;
                            }
                        }
                    } while (!unico);
                    diccionario.add(new Palabra(valor, dificultad, genero));
                }

                for (Palabra palabraEliminar : diccionario) {
                    if (palabraEliminar.getValor().equals("HEROMINE GRANGER")){
                        diccionario.remove(palabraEliminar);
                    }
                }
                 */

                ordenarDiccionario();
                sobreescribirFichero();
            } else {
                do {
                    Palabra palabra = new Palabra();
                    try {
                        char[] linea = line.toCharArray();
                        String cadena = "";
                        int barra = 0;
                        for (char letra : linea) {
                            if (letra == '|') {
                                barra++;
                                cadena = "";
                            } else {
                                if (barra == 0) { //Si barra es 0 leo la dificultad
                                    cadena = String.valueOf(letra);
                                    try {
                                        palabra.setDificultad(Integer.parseInt(cadena));
                                    } catch (NumberFormatException e) {
                                        Mensajes.mostrarError();
                                    }
                                } else if (barra == 1) { //Si barra es 1 leo el valor
                                    cadena += letra;
                                    palabra.setValor(cadena);
                                } else if (barra == 2) {//Si barra es 2 leo el genero
                                    cadena += letra;
                                    palabra.setGenero(cadena);
                                }
                            }
                        }
                    } catch (NullPointerException e) {
                        Mensajes.errorBufferedReader();
                    }

                    diccionario.add(palabra);
                } while ((line = bufferedReader.readLine()) != null);
            }
        } catch (IOException e) {
            Mensajes.mostrarError();
        }
        try {
            bufferedReader.close();
        } catch (IOException e) {
            Mensajes.errorBufferedReader();
        } catch (NullPointerException e) {
            Mensajes.noSeEncontroElArchivo();
        }
        try {
            fileReader.close();
        } catch (IOException e) {
            Mensajes.noSePudoCerrarElStream();
        } catch (NullPointerException e) {
            Mensajes.noSePudoCerrarElStream();
        }
    }


    public boolean anadirPalabra(Palabra palabra) throws IOException {
        FileWriter fileWriter = new FileWriter("src\\main\\java\\utils\\diccionario.txt", true);
        boolean flag = true;
        for (Palabra palabraDiccionario : diccionario) {
            if (palabraDiccionario.getValor().equals(palabra.getValor())) {
                flag = false;
                break;
            }
        }

        if (flag) {
            diccionario.add(palabra);
            ordenarDiccionario();
            sobreescribirFichero();
        }
        return flag;
    }

    public void listarPalabras() throws FileNotFoundException {
        ordenarDiccionario();
        FileReader fileReader = new FileReader("src\\main\\java\\utils\\diccionario.txt");
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String linea = " ";
        while (linea != null) {
            try {
                linea = bufferedReader.readLine();
                if (linea == null) {
                    System.out.println("\n");
                } else {
                    System.out.println(linea);
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public ArrayList<Palabra> listarPalabras2() {
        FileReader fileReader = null;
        try {
            fileReader = new FileReader("src\\main\\java\\utils\\diccionario.txt");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        ArrayList<Palabra> orderedList = new ArrayList<>();
        String linea;

        while (true) {
            try {
                if ((linea = bufferedReader.readLine()) == null) break;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            String cadena = "";
            Palabra palabra = new Palabra();
            int barra = 0;
            for (char letra : linea.toCharArray()) {
                if (letra == '|') {
                    barra++;
                    cadena = "";
                } else {
                    if (barra == 0) { //Si barra es 0 leo la dificultad
                        cadena += letra;
                        palabra.setDificultad(Integer.parseInt(cadena));
                    } else if (barra == 1) { //Si barra es 1 leo el valor
                        cadena += letra;
                        palabra.setValor(cadena);
                    } else if (barra == 2) {//Si barra es 2 leo el genero
                        cadena += letra;
                        palabra.setGenero(cadena);
                    }
                }
            }
            orderedList.add(palabra);
        }
        //   Collections.sort(orderedList);

        // System.out.println(orderedList);
        try {
            fileReader.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            bufferedReader.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        FileReader fileReaderOrdenado = null;
        try {
            fileReaderOrdenado = new FileReader("src\\main\\java\\utils\\diccionario.txt");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        BufferedReader bufferedReaderOrdenado = new BufferedReader(fileReaderOrdenado);

        do {
            try {
                linea = bufferedReaderOrdenado.readLine();
                if (linea != null) {
                    System.out.println(linea);
                }
            } catch (IOException e) {
                Mensajes.noSePudoLeerLaLinea();
            }
        } while (linea != null);


        return null;
    }


    public ArrayList<String> devolverDiccionarioRAMstring(){
        ArrayList<String> diccionarioDevolver = new ArrayList<>();
        for (Palabra palabra: diccionario) {
            diccionarioDevolver.add(palabra.toString());
        }
        return diccionarioDevolver;
    }

    public ArrayList<Palabra> devolverDiccionarioRAMpalabra(){
        return (ArrayList<Palabra>) diccionario;

    }

    public boolean modificarPalabra(String palabraModificar, int campo, String valor) {
        Palabra palabra = new Palabra();
        boolean flag = false;

        for (Palabra palabraDiccionario : diccionario) {
            if (palabraDiccionario.getValor().equals(palabraModificar)) {
                palabra = palabraDiccionario;
            }
        }
        switch (campo) {
            case 1:
                palabra.setDificultad(Integer.parseInt(valor));
                flag = true;
                break;
            case 2:
                palabra.setValor(valor);
                flag = true;
                break;
            case 3:
                switch (Integer.parseInt(valor)) {
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
                flag = true;
                break;
            default:
        }
        ordenarDiccionario();
        sobreescribirFichero();
        return flag;
    }

    public boolean eliminarPalabra(String palabraEliminar) {
        boolean flag = false;
        int index = 0;
        for (Palabra palabra : diccionario) {
            if (palabra.getValor().equals(palabraEliminar)) {
                index = diccionario.indexOf(palabra);
                flag = true;
            }
        }
        diccionario.remove(index);
        sobreescribirFichero();
        return flag;
    }

    private void ordenarDiccionario() {
        diccionario.sort(new Comparator<Palabra>() {
            @Override
            public int compare(Palabra palabra1, Palabra palabra2) {
                return palabra1.getValor().compareTo(palabra2.getValor());
            }
        });
    }

    private void sobreescribirFichero() {
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter("src\\main\\java\\utils\\diccionario.txt", false);
            for (Palabra palabra : diccionario) {
                fileWriter.write(palabra.toString());
                fileWriter.write("\r\n");
            }
            fileWriter.close();
        } catch (IOException e) {
            Mensajes.noSeEncontroElArchivo();
        }
    }

    public Palabra devolverPalabra(String palabraDevolver) {
        Palabra palabra = null;
        for (Palabra palabraDiccionario : diccionario) {
            if (palabraDiccionario.getValor().equals(palabraDevolver)) {
                palabra = palabraDiccionario;
            }
        }
        return palabra;
    }

    public String devolverPalabraAleatoria() {
        int index = (int) (Math.random() * diccionario.size());
        return diccionario.get(index).getValor();

    }

    public String devolverPalabra(int dificultad, int categoria) {
        String genero = "";
        String palabra = "";
        List<String> palabrasPosibles = new ArrayList<>();
        boolean flag = false;
        int index = 0;

        switch (categoria) {
            case 1:
                genero = "Series";
                break;
            case 2:
                genero = "Películas";
                break;
            case 3:
                genero = "Videojuegos";
                break;
            case 4:
                genero = "Música";
                break;
            case 5:
                genero = "Deportes";
                break;
            case 6:
                genero = "Ciencia";
                break;
            case 7:
                genero = "Historia";
                break;
            case 8:
                genero = "Geografía";
                break;
            case 9:
                genero = "Otros";
                break;
        }

        for (Palabra palabraCopiar : diccionario) {
            if (palabraCopiar.getDificultad() == dificultad && palabraCopiar.getGenero().equals(genero)) {
                palabrasPosibles.add(palabraCopiar.getValor());
            }
        }

        if (!palabrasPosibles.isEmpty()) {
            index = (int) (Math.random() * palabrasPosibles.size());
            palabra = palabrasPosibles.get(index);
        }

        return palabra;
    }
}
