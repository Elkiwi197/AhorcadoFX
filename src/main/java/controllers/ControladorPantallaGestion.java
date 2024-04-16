package controllers;



import domain.Palabra;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.ArrayList;

public class ControladorPantallaGestion {
    private ControladorPrincipal borderPane;
    public TableView tabla;
    public TableColumn columnaDificultad;
    public TableColumn columnaPalabra;
    public TableColumn columnaCategoria;
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

    public void mostrarDiccionarioListView(ArrayList<String> diccionario) {
        ObservableList<String> observableList = FXCollections.observableArrayList(diccionario);
        listaPalabras.setItems(observableList);
        listaPalabras.setVisible(false);
    }

    public void mostrarDiccionarioTableView(ArrayList<Palabra> diccionarioPalabra) {
        ObservableList<Palabra> diccionarioTabla = FXCollections.observableArrayList(diccionarioPalabra);

        tabla.setItems(diccionarioTabla);

        columnaDificultad.setCellValueFactory(new PropertyValueFactory<>("dificultad"));
        columnaPalabra.setCellValueFactory(new PropertyValueFactory<>("valor"));
        columnaCategoria.setCellValueFactory(new PropertyValueFactory<>("genero"));

    }
}
