package controllers;

import domain.Juego;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.Arrays;
import java.util.ResourceBundle;

public class ControladorPantallaJugar implements Initializable {
    private ControladorPrincipal borderPane;
    public Label labelIncognita;
    public Label labelVidas;
    public Label labelLetrasUsadas;
    public Label labelCategoria;
    public Label labelDificultad;
    public Button botonSalir;
    public Button botonGuardarSalir;
    // CLASES DE LÓGICA
    private Juego juego = new Juego();


    public void setBorderPane(ControladorPrincipal controladorPrincipal) {
        borderPane = controladorPrincipal;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void jugarPartidaRapida(String palabra, int fallos, char[] incognita, String letrasUsadas) {


        labelIncognita.setText(palabra);
        labelCategoria.setText("añadir categoria");




       // juego.jugarPartida(palabra, fallos, incognita, letrasUsadas);
    }

    public void volverMenuJugar(ActionEvent actionEvent) {
        borderPane.cargarPantallaMenuJugar();
    }

    public void guardarYsalir(ActionEvent actionEvent) {
    }


}
