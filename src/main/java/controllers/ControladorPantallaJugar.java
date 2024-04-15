package controllers;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class ControladorPantallaJugar {
    private ControladorPrincipal borderPane;
    public Label labelIncognita;
    public Label labelVidas;
    public Label labelLetrasUsadas;
    public Label labelCategoria;
    public Label labelDificultad;
    public Button botonSalir;
    public Button botonGuardarSalir;

    public void setBorderPane(ControladorPrincipal controladorPrincipal) {
        borderPane = controladorPrincipal;
    }

    public void volverMenuJugar(ActionEvent actionEvent) {
        borderPane.cargarPantallaMenuJugar();
    }

    public void guardarYsalir(ActionEvent actionEvent) {
    }
}
