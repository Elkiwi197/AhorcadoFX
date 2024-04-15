package controllers;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;

public class ControladorLandingPage {
    public Button botonJugar;
    public Button botonGestionar;
    public Label labelIntroduceContrasena;
    public PasswordField inputContrasena;
    private ControladorPrincipal borderPane;
    public void setBorderPane(ControladorPrincipal controladorPrincipal) {
        borderPane = controladorPrincipal;
    }

    public void cargarJugar(ActionEvent actionEvent) {
        borderPane.cargarPantallaMenuJugar();
    }

    public void cargarGestionar(ActionEvent actionEvent) {
        String contrasena = inputContrasena.getText();
        if (contrasena.equals("vaca")){
            borderPane.cargarPantallaGestion();
        } else {
            labelIntroduceContrasena.setText("Introduce una contraseña \n correcta");
        }
    }
}
