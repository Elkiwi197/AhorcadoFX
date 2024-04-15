package controllers;

import domain.Palabra;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;

public class ControladorPantallaDatosPartidaNormal {
    private ControladorPrincipal borderPane;
    public ChoiceBox<String> choiceDificultad;
    public ChoiceBox<String> choiceCategoria;
    public Button botonJugar;
    public Label labelDificultad;
    public Label labelCategoria;
    public Button buttonVolver;

    public void setBorderPane(ControladorPrincipal controladorPrincipal) {
        borderPane = controladorPrincipal;
    }

    public void volverMenuJugar(ActionEvent actionEvent) {
        borderPane.cargarPantallaMenuJugar();
    }

    public void jugarPartidaNormal(ActionEvent actionEvent) {
        borderPane.cargarJugar();
    }
}
