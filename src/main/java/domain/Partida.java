package domain;

public class Partida {
    private String palabra;
    private String categoria;
    private String incognita;
    private int fallos;
    private String letrasUsadas;

    public Partida(String palabra, String categoria, String incognita, int fallos, String letrasUsadas) {
        this.palabra = palabra;
        this.categoria = categoria;
        this.incognita = incognita;
        this.fallos = fallos;
        this.letrasUsadas = letrasUsadas;
    }

    public Partida() {
    }

    public String getPalabra() {
        return palabra;
    }

    public void setPalabra(String palabra) {
        this.palabra = palabra;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getIncognita() {
        return incognita;
    }

    public void setIncognita(String incognita) {
        this.incognita = incognita;
    }

    public int getFallos() {
        return fallos;
    }

    public void setFallos(int fallos) {
        this.fallos = fallos;
    }

    public String getLetrasUsadas() {
        return letrasUsadas;
    }

    public void setLetrasUsadas(String letrasUsadas) {
        this.letrasUsadas = letrasUsadas;
    }

    @Override
    public String toString() {
        return palabra + ";" + categoria + ";" + incognita + ";" + fallos + ";" + letrasUsadas;
    }
}
