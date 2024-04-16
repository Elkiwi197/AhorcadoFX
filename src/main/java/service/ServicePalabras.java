package service;

import dao.DAOpalabras;
import domain.Palabra;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class ServicePalabras  {

    DAOpalabras daopalabras = new DAOpalabras();

    public ServicePalabras() {
    }

    public void init() {
        daopalabras.init();
    }

    public boolean anadirPalabra(Palabra palabra) throws IOException {
        return daopalabras.anadirPalabra(palabra);
    }

    public void listarPalabras() throws FileNotFoundException {
        daopalabras.listarPalabras();
    }

    public ArrayList<Palabra> listarPalabras2() throws IOException {
        return daopalabras.listarPalabras2();
    }

    public ArrayList<String> devolverDiccionarioRAMstring(){
        return daopalabras.devolverDiccionarioRAMstring();
    }
    public ArrayList<Palabra> devolverDiccionarioRAMpalabra(){
        return daopalabras.devolverDiccionarioRAMpalabra();
    }

    public boolean eliminarPalabra(String palabraEliminar) {
        return daopalabras.eliminarPalabra(palabraEliminar);
    }

    public boolean modificarPalabra(String palabraModificar, int campo, String valor) {
        return daopalabras.modificarPalabra(palabraModificar, campo, valor);
    }

    public Palabra devolverPalabra(String palabraDevolver) {
        return daopalabras.devolverPalabra(palabraDevolver);
    }

    public String devolverPalabraAleatoria() {
        return daopalabras.devolverPalabraAleatoria();
    }

    public String devolverPalabra(int dificultad, int categoria) {
        return daopalabras.devolverPalabra(dificultad, categoria);
    }
}
