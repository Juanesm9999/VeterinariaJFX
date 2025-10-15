package co.edu.uniquindio.poo.veterinariajfx.controller;

import co.edu.uniquindio.poo.veterinariajfx.model.Especie;
import co.edu.uniquindio.poo.veterinariajfx.model.TipoConsulta;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.net.URL;
import java.util.Arrays;
import java.util.ResourceBundle;

public class SugerenciaVacunacionController implements Initializable {

    @FXML
    private ComboBox<Especie> comboEspecie;

    @FXML
    private VBox vboxResultado;

    @FXML
    private Label lblResultado;

    @Override
    public void initialize(URL url, ResourceBundle rb) {


        comboEspecie.setItems(FXCollections.observableArrayList(Especie.values()));

        comboEspecie.getSelectionModel().select(Especie.GATO);

        comboEspecie.setItems(FXCollections.observableArrayList(Especie.values()));

        comboEspecie.getSelectionModel().select(Especie.PERRO);

    }

    @FXML
    private void consultarVacunacion() {
        String especieSeleccionada = String.valueOf(comboEspecie.getValue());

        if (especieSeleccionada == null || especieSeleccionada.isEmpty()) {
            mostrarAlerta("Error", "Por favor seleccione una especie", Alert.AlertType.WARNING);
            return;
        }

        String resultado = sugerirProximaVacunacion(especieSeleccionada);

        lblResultado.setText(resultado);
        vboxResultado.setVisible(true);
    }

    public String sugerirProximaVacunacion(String especie) {
        String fechaVacunacion = "";

        if (especie.equalsIgnoreCase("Perro") || especie.equalsIgnoreCase("Gato")) {
            fechaVacunacion = "Se le sugiere vacunar a su mascota cada 12 meses";
        } else if (especie.equalsIgnoreCase("Ave")) {
            fechaVacunacion = "Se le sugiere vacunar a su mascota cada 8 meses";
        } else if (especie.equalsIgnoreCase("Reptil")) {
            fechaVacunacion = "Se le sugiere vacunar a su mascota cada 18 meses";
        } else {
            fechaVacunacion = "Especie no reconocida para vacunación";
        }

        return fechaVacunacion;
    }

    @FXML
    private void cerrarVentana() {
        Stage stage = (Stage) comboEspecie.getScene().getWindow();
        stage.close();
    }

    private void mostrarAlerta(String titulo, String mensaje, Alert.AlertType tipo) {
        Alert alerta = new Alert(tipo);
        alerta.setTitle(titulo);
        alerta.setHeaderText(null);
        alerta.setContentText(mensaje);
        alerta.showAndWait();
    }
}