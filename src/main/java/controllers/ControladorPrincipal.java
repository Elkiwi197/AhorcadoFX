package controllers;

import domain.Palabra;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import service.ServicePalabras;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ControladorPrincipal implements Initializable {
    // BORDERPANE PRINCIPAL
    @FXML
    private BorderPane pantallaPrincipal;
    // ANCHORPANES (UNO POR PANTALLA)
    @FXML
    private AnchorPane landingPageAnchorPane;
    @FXML
    private AnchorPane pantallaMenuJugarAnchorPane;
    @FXML
    private AnchorPane pantallaGestionAnchorPane;
    @FXML
    private AnchorPane pantallaJugarAnchorPane;
    @FXML
    private AnchorPane pantallaPedirDatosPartida;
    // LOADERS (UNO POR PANTALLA/ANCHORPANE)
    @FXML
    private FXMLLoader loaderLandingPage = new FXMLLoader();
    @FXML
    private FXMLLoader loaderPantallaMenuJugar = new FXMLLoader();
    @FXML
    private FXMLLoader loaderPantallaGestion = new FXMLLoader();
    @FXML
    private FXMLLoader loaderPantallaJugar = new FXMLLoader();
    @FXML
    private FXMLLoader loaderPantallaPedirDatosPartida = new FXMLLoader();
    // CONTROLADORES (UNO POR PANTALLA)
    public ControladorLandingPage controladorLandingPage;
    public ControladorPantallaMenuJugar controladorPantallaMenuJugar;
    public ControladorPantallaGestion controladorPantallaGestion;
    public ControladorPantallaJugar controladorPantallaJugar;
    public ControladorPantallaDatosPartidaNormal controladorPantallaDatosPartidaNormal;

    // CLASES Y OBJETOS DE LA LOGICA
    private ServicePalabras servicePalabras = new ServicePalabras();




    public ControladorPrincipal() {
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        servicePalabras.init();
        cargarLandingPage();
    }

    public void cargarLandingPage() {
        try {
            if (landingPageAnchorPane == null) {
                landingPageAnchorPane = loaderLandingPage.load(getClass().getResourceAsStream("/fxml/pantalla-landing-page.fxml"));
                controladorLandingPage = loaderLandingPage.getController();
                controladorLandingPage.setBorderPane(this);
            }
            controladorLandingPage.labelIntroduceContrasena.setText("");
            pantallaPrincipal.setCenter(landingPageAnchorPane);
        } catch (IOException e) {
            System.out.println("ERROR CARGANDO LANDING PAGE");
        }
    }

    public void cargarPantallaMenuJugar() {
        try {
            if (pantallaMenuJugarAnchorPane == null) {
                pantallaMenuJugarAnchorPane = loaderPantallaMenuJugar.load(getClass().getResourceAsStream("/fxml/pantalla-menu-jugar.fxml"));
                controladorPantallaMenuJugar = loaderPantallaMenuJugar.getController();
                controladorPantallaMenuJugar.setBorderPane(this);
            }
            pantallaPrincipal.setCenter(pantallaMenuJugarAnchorPane);
        } catch (IOException e) {
            System.out.println("ERROR CARGANDO PANTALLA MENU JUGAR");
        }
    }

    public void cargarPantallaGestion() {
        ArrayList<String> diccionarioString = servicePalabras.devolverDiccionarioRAMstring();
        ArrayList<Palabra> diccionarioPalabra = servicePalabras.devolverDiccionarioRAMpalabra();
        try {
            if (pantallaGestionAnchorPane == null) {
                pantallaGestionAnchorPane = loaderPantallaGestion.load(getClass().getResourceAsStream("/fxml/pantalla-gestion.fxml"));
                controladorPantallaGestion = loaderPantallaGestion.getController();
                controladorPantallaGestion.setBorderPane(this);
            }
            pantallaPrincipal.setCenter(pantallaGestionAnchorPane);
            controladorPantallaGestion.mostrarDiccionarioListView(diccionarioString);
            controladorPantallaGestion.mostrarDiccionarioTableView(diccionarioPalabra);
            controladorPantallaGestion.ocultarCampos();
        } catch (IOException e) {
            System.out.println("ERROR CARGANDO GESTION");
        }
    }

    public void cargarJugar(){
        try{
            if(pantallaJugarAnchorPane == null){
                pantallaJugarAnchorPane = loaderPantallaJugar.load(getClass().getResourceAsStream("/fxml/pantalla-jugar.fxml"));
                controladorPantallaJugar = loaderPantallaJugar.getController();
                controladorPantallaJugar.setBorderPane(this);
            }
            pantallaPrincipal.setCenter(pantallaJugarAnchorPane);
        } catch (IOException e) {
            System.out.println("ERROR CARGANDO JUGAR");
        }
    }

    public void cargarPedirDatosPartidaNormal(){
        try {
            if (pantallaPedirDatosPartida == null){
                pantallaPedirDatosPartida = loaderPantallaPedirDatosPartida.load(getClass().getResourceAsStream("/fxml/pantalla-datos-partida-normal.fxml"));
                controladorPantallaDatosPartidaNormal = loaderPantallaPedirDatosPartida.getController();
                controladorPantallaDatosPartidaNormal.setBorderPane(this);
            }
            pantallaPrincipal.setCenter(pantallaPedirDatosPartida);
        } catch (IOException e) {
            System.out.println("ERROR CARGANDO PEDIR DATOS");
        }
    }

    public void eliminarPalabra(String palabra){
        servicePalabras.eliminarPalabra(palabra);
        controladorPantallaGestion.mostrarDiccionarioTableView(servicePalabras.devolverDiccionarioRAMpalabra());
    }

    public void modificarPalabra(String palabraAntigua, String palabraNueva, int dificultad, String categoria){
        servicePalabras.modificarPalabra(palabraAntigua, palabraNueva, dificultad, categoria);
        controladorPantallaGestion.mostrarDiccionarioTableView(servicePalabras.devolverDiccionarioRAMpalabra());

    }

    public void anadirPalabra(Palabra palabra) {
        try {
            servicePalabras.anadirPalabra(palabra);
            controladorPantallaGestion.mostrarDiccionarioTableView(servicePalabras.devolverDiccionarioRAMpalabra());
        } catch (IOException e) {
            System.out.println("No se pudo añadir la palabra");
        }

    }
}