package controllers;

import javafx.event.ActionEvent;
import javafx.scene.control.*;

public class ControladorPantallaGestion {
    private ControladorPrincipal borderPane;
    public ListView listaPalabras;
    public ChoiceBox choiceDificultad;
    public ChoiceBox choiceCategoria;
    public Button botonVolver;
    public Button botonEliminar;
    public Button botonModificar;
    public Button botonAnadir;
    public Button botonAceptar;
    public Label labelDificultad;
    public Label labelCategoria;
    public Label labelPalabra;
    public TextField inputPalabra;

    public void setBorderPane(ControladorPrincipal controladorPrincipal) {
        borderPane = controladorPrincipal;
    }

    public void volverMenuPrincipal(ActionEvent actionEvent) {
        borderPane.cargarLandingPage();
    }
}
