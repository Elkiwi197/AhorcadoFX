package controllers;


import domain.Palabra;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ControladorPantallaGestion implements Initializable {
    private ControladorPrincipal borderPane;
    public TableView tablaPalabras;
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
    public Button botonSubmitModificar;
    public Button botonSubmitAnadir;
    public Label labelDificultad;
    public Label labelCategoria;
    public Label labelPalabra;
    public TextField inputPalabra;

    public void setBorderPane(ControladorPrincipal controladorPrincipal) {
        borderPane = controladorPrincipal;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        choiceDificultad.getItems().addAll(1, 2, 3, 4, 5);
        choiceCategoria.getItems().addAll("Series", "Películas", "Videojuegos", "Música", "Deportes", "Ciencia", "Historia", "Geografía", "Otros");
        ocultarCampos();

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

        tablaPalabras.setItems(diccionarioTabla);

        columnaDificultad.setCellValueFactory(new PropertyValueFactory<>("dificultad"));
        columnaPalabra.setCellValueFactory(new PropertyValueFactory<>("valor"));
        columnaCategoria.setCellValueFactory(new PropertyValueFactory<>("genero"));

    }

    public void eliminarPalabra(ActionEvent actionEvent) {
        Palabra palabra = (Palabra) tablaPalabras.getSelectionModel().getSelectedItem();
        ocultarCampos();
        borderPane.eliminarPalabra(palabra.getValor());

    }

    public void modificarPalabra(ActionEvent actionEvent) {
        Palabra palabra = (Palabra) tablaPalabras.getSelectionModel().getSelectedItem();

        choiceDificultad.setValue(palabra.getDificultad());
        choiceCategoria.setValue(palabra.getGenero());
        inputPalabra.setText(palabra.getValor());
        mostrarCampos();
        botonSubmitModificar.setVisible(true);

    }

    public void anadirPalabra(ActionEvent actionEvent) {
        mostrarCampos();
        botonSubmitAnadir.setVisible(true);
    }

    public void mostrarCampos() {
        labelDificultad.setVisible(true);
        labelCategoria.setVisible(true);
        labelPalabra.setVisible(true);

        choiceDificultad.setVisible(true);
        choiceCategoria.setVisible(true);
        inputPalabra.setVisible(true);

    }

    public void ocultarCampos() {
        labelDificultad.setVisible(false);
        labelCategoria.setVisible(false);
        labelPalabra.setVisible(false);

        choiceDificultad.setVisible(false);
        choiceCategoria.setVisible(false);
        inputPalabra.setVisible(false);

        botonSubmitAnadir.setVisible(false);
        botonSubmitModificar.setVisible(false);

    }


    public void submitAnadirPalabra(ActionEvent actionEvent) {
        Palabra palabra = new Palabra();

        palabra.setDificultad((Integer) choiceDificultad.getValue());
        palabra.setGenero((String) choiceCategoria.getValue());
        palabra.setValor(inputPalabra.getText().toUpperCase());

        borderPane.anadirPalabra(palabra);
        tablaPalabras.refresh();
    }

    public void submitModificarPalabra(ActionEvent actionEvent) {
        Palabra palabraModificar = (Palabra) tablaPalabras.getSelectionModel().getSelectedItem();
        String palabraVieja = palabraModificar.getValor();
        String palabraNueva = inputPalabra.getText().toUpperCase();
        int dificultad = (int) choiceDificultad.getValue();
        String categoria = (String) choiceCategoria.getValue();


        borderPane.modificarPalabra(palabraVieja, palabraNueva, dificultad, categoria);
        tablaPalabras.refresh();
    }
}
