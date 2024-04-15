package controllers;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;

public class ControladorPantallaMenuJugar {
    public Button botonVolver;
    private ControladorPrincipal borderPane;
    public Button botonPartidaRapida;
    public Button botonCargarPartida;
    public Button botonPartidaNormal;

    public void setBorderPane(ControladorPrincipal controladorPrincipal) {
        borderPane = controladorPrincipal;
    }

    public void volverLandingPage(ActionEvent actionEvent) {
        borderPane.cargarLandingPage();
    }

    public void jugarCargarPartida(ActionEvent actionEvent) {
        borderPane.cargarJugar();
    }

    public void jugarPartidaRapida(ActionEvent actionEvent) {
        borderPane.cargarJugar();

    }

    public void pedirDatosPartida(ActionEvent actionEvent) {
        borderPane.cargarPedirDatosPartidaNormal();
    }
}
