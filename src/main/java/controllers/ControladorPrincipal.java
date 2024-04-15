package controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ControladorPrincipal implements Initializable {
    @FXML
    private BorderPane pantallaPrincipal;
    @FXML
    private AnchorPane landingPageAnchorPane;
    @FXML
    private AnchorPane pantallaJugarAnchorPane;
    @FXML
    private FXMLLoader loaderLandingPage = new FXMLLoader();
    @FXML
    private FXMLLoader loaderPantallaJugar = new FXMLLoader();
    public ControladorLandingPage controladorLandingPage;
    public ControladorPantallaMenuJugar controladorPantallaJugar;

    public ControladorPrincipal() {
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        cargarLandingPage();
    }

    public void cargarLandingPage() {
        try {
            if (landingPageAnchorPane == null) {
                landingPageAnchorPane = loaderLandingPage.load(getClass().getResourceAsStream("/fxml/pantalla-landing-page.fxml"));
                controladorLandingPage =loaderLandingPage.getController();
                controladorLandingPage.setBorderPane(this);
            }
            pantallaPrincipal.setCenter(landingPageAnchorPane);
        } catch (IOException e) {
            System.out.println("ERROR CARGANDO LANDING PAGE");
        }
    }

    public void cargarPantallaMenuJugar() {
        try {
            if (pantallaJugarAnchorPane == null){
                pantallaJugarAnchorPane = loaderPantallaJugar.load(getClass().getResourceAsStream("/fxml/pantalla-menu-jugar.fxml"));
                controladorPantallaJugar = loaderPantallaJugar.getController();
                controladorPantallaJugar.setBorderPane(this);
            }
            pantallaPrincipal.setCenter(pantallaJugarAnchorPane);
        } catch (IOException e) {
            System.out.println("ERROR CARGANDO PANTALLA MENU JUGAR");
        }
    }
}
