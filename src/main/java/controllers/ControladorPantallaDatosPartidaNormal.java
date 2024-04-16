package controllers;

import domain.Palabra;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class ControladorPantallaDatosPartidaNormal implements Initializable {
    private ControladorPrincipal borderPane;
    public ChoiceBox choiceDificultad;
    public ChoiceBox choiceCategoria;
    public Button botonJugar;
    public Label labelDificultad;
    public Label labelCategoria;
    public Button buttonVolver;

    public void setBorderPane(ControladorPrincipal controladorPrincipal) {
        borderPane = controladorPrincipal;
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        choiceDificultad.getItems().addAll(1, 2, 3, 4, 5);
        choiceCategoria.getItems().addAll("Series", "Películas", "Videojuegos", "Música", "Deportes", "Ciencia", "Historia", "Geografía", "Otros");
        choiceDificultad.setValue(1);
        choiceCategoria.setValue("Series");

    }

    public void volverMenuJugar(ActionEvent actionEvent) {
        borderPane.cargarPantallaMenuJugar();
    }

    public void jugarPartidaNormal(ActionEvent actionEvent) {
        borderPane.cargarJugar();
    }
}
