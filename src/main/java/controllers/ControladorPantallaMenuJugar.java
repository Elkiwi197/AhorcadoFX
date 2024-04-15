package controllers;

import javafx.scene.control.Button;

public class ControladorPantallaMenuJugar {
    private ControladorPrincipal borderPane;
    public Button botonPartidaRapida;
    public Button botonCargarPartida;
    public Button botonPartidaNormal;

    public void setBorderPane(ControladorPrincipal controladorPrincipal) {
        borderPane = controladorPrincipal;
    }
}
