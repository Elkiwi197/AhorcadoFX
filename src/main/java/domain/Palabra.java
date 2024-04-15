package domain;

import common.Generos;

import java.io.Serializable;

public class Palabra {
    String valor;
    int dificultad;
    String genero;

    public Palabra(String valor, int dificultad, String genero) {
        this.valor = valor.toUpperCase();
        this.dificultad = dificultad;
        this.genero = genero;
    }

    public Palabra() {
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public int getDificultad() {
        return dificultad;
    }

    public void setDificultad(int dificultad) {
        this.dificultad = dificultad;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    @Override
    public String toString() {
        return dificultad + "|" + valor + "|" + genero;
    }
}
