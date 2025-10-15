package co.edu.uniquindio.poo.veterinariajfx.viewController;

import co.edu.uniquindio.poo.veterinariajfx.App;
import co.edu.uniquindio.poo.veterinariajfx.controller.GatoController;
import co.edu.uniquindio.poo.veterinariajfx.model.Gato;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class GatoViewController {
    GatoController gatoController;
    ObservableList<Gato> listMascotas = FXCollections.observableArrayList();
    Gato selectedGato;


    @FXML
    private ResourceBundle resources;


    @FXML
    private URL location;


    @FXML
    private TextField txtNombre;

    @FXML
    private TextField txtEspecie;


    @FXML
    private Button btnLimpiar;


    @FXML
    private TableView<Gato> tblListMascota;


    @FXML
    private Button btnEliminar;


    @FXML
    private Button btnActualizarGato;


    @FXML
    private TableColumn<Gato, String> tbcNombre;

    @FXML
    private TableColumn<Gato, String> tbcPeso;

    @FXML
    private TableColumn<Gato, String> tbcEdadEnMeses;

    @FXML
    private TableColumn<Gato, String> tbcEspecie;

    @FXML
    private TableColumn<Gato, String> tbcIsIndoor;

    @FXML
    private TableColumn<Gato, String> tbcCantidadHorasSuenio;

    @FXML
    private TableColumn<Gato, String> tbcNivelIndependencia;

    @FXML
    private TextField txtRaza;

    @FXML
    private TextField txtPeso;

    @FXML
    private TextField txtEdadEnMeses;

    @FXML
    private RadioButton rbIsIndoorSi;

    @FXML
    private RadioButton rbIsIndoorNo;

    @FXML
    private TextField txtCantidadHorasSuenio;

    @FXML
    private TextField txtNivelIndependencia;

    @FXML
    private TableColumn<Gato, String> tbcRaza;


    @FXML
    private Button btbAgregarGato;


    @FXML
    private TableColumn<Gato, String> tbcId;


    @FXML
    private TextField txtId;

    @FXML
    private Button btnRegresarMenu;

    @FXML
    void onRegresarMenu() {
        app.openViewPrincipal();
    }

    @FXML
    private Button btnEstimarDosis;

    @FXML
    void onEstimarDosis() {
        abrirVentanaEstimarDosis();
    }

    private void abrirVentanaEstimarDosis() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("estimarDosis.fxml"));
            VBox rootLayout = (VBox) loader.load();

            EstimarDosisViewController controller = loader.getController();
            controller.setApp(app);

            // Crear nueva ventana (Stage)
            Stage stage = new Stage();
            stage.setTitle("Estimación de Dosis");
            Scene scene = new Scene(rootLayout);
            stage.setScene(scene);
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void onProximaVacunacion() {
        abrirVentanaSugerenciaVacunacion();
    }
    private void abrirVentanaSugerenciaVacunacion() {
        try {
            // Cargar el archivo FXML
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/co/edu/uniquindio/poo/veterinariajfx/sugerenciaVacunacion.fxml"));
            Parent root = loader.load();

            // Crear nueva ventana (Stage)
            Stage stage = new Stage();
            stage.setTitle("Sugerencia de Vacunación");
            stage.setScene(new Scene(root));

            // Hacer la ventana modal (bloquea la ventana anterior)
            stage.initModality(javafx.stage.Modality.APPLICATION_MODAL);

            // Mostrar la ventana
            stage.showAndWait();

        } catch (IOException e) {
            e.printStackTrace();
            mostrarAlerta("Error", "No se pudo abrir la ventana de sugerencia de vacunación: " + e.getMessage());
        }
    }

    private void mostrarAlerta(String titulo, String mensaje) {
        Alert alerta = new Alert(Alert.AlertType.ERROR);
        alerta.setTitle(titulo);
        alerta.setHeaderText(null);
        alerta.setContentText(mensaje);
        alerta.showAndWait();
    }



    private ToggleGroup toggleGroupIsIndoor;

    private App app;


    @FXML
    void onAgregarGato() {
        agregarGato();
    }


    @FXML
    void onActualizarGato() {
        actualizarGato();
    }


    @FXML
    void onLimpiar() {
        limpiarSeleccion();
    }


    @FXML
    void onEliminar() {
        eliminarGato();
    }


    @FXML
    void initialize() {
        this.app = app;
        gatoController = new GatoController(app.veterinaria);

        toggleGroupIsIndoor = new ToggleGroup();
        rbIsIndoorSi.setToggleGroup(toggleGroupIsIndoor);
        rbIsIndoorNo.setToggleGroup(toggleGroupIsIndoor);
        initView();
    }


    private void initView() {
        // Traer los datos del cliente a la tabla
        initDataBinding();


        // Obtiene la lista
        obtenerGato();


        // Limpiar la tabla
        tblListMascota.getItems().clear();


        // Agregar los elementos a la tabla
        tblListMascota.setItems(listMascotas);


        // Seleccionar elemento de la tabla
        listenerSelection();
    }
// String TipoDePlumaje,Boolean CapacidadDeVuelo,String CapacidadDeImitaciones

    private void initDataBinding() {
        tbcId.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getId()));
        tbcNombre.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNombre()));
        tbcRaza.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getRaza()));
        tbcPeso.setCellValueFactory(cellData -> new SimpleObjectProperty(cellData.getValue().getPeso()));
        tbcEdadEnMeses.setCellValueFactory(cellData -> new SimpleObjectProperty(cellData.getValue().getEdadEnMeses()));
        tbcEspecie.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getEspecie()));
        tbcIsIndoor.setCellValueFactory(cellData -> new SimpleObjectProperty(cellData.getValue().getIsIndoor()));
        tbcCantidadHorasSuenio.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCantidadHorasSuenio()));
        tbcNivelIndependencia.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNivelIndependencia()));

        // Usamos SimpleObjectProperty para manejar Double y Integer correctamente
    }


    private void obtenerGato() {
        listMascotas.addAll(gatoController.obtenerListaMascotas());
    }


    private void listenerSelection() {
        tblListMascota.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            selectedGato = newSelection;
            mostrarInformacionGato(selectedGato);
        });
    }


    private void mostrarInformacionGato(Gato gato) {
        if (gato != null) {
            txtId.setText(gato.getId());
            txtNombre.setText(gato.getNombre());
            txtRaza.setText(gato.getRaza());
            txtNivelIndependencia.setText(gato.getNivelIndependencia());
            txtEspecie.setText(gato.getEspecie());
            txtPeso.setText(String.valueOf(gato.getPeso()));
            txtEdadEnMeses.setText(String.valueOf(gato.getEdadEnMeses()));
            if (gato.getIsIndoor()) {
                rbIsIndoorSi.setSelected(true);
            } else {
                rbIsIndoorNo.setSelected(false);
            }
            txtCantidadHorasSuenio.setText(String.valueOf(gato.getCantidadHorasSuenio()));
        }
    }


    private void agregarGato() {
        Gato gato = buildGato();
        if (gatoController.crearGato(gato)) {
            listMascotas.add(gato);
            limpiarCamposGato();
        }
    }


    private Gato buildGato() {
        boolean isIndoor = rbIsIndoorSi.isSelected();
        Gato gato = new Gato(txtId.getText(), txtNombre.getText(), txtRaza.getText(), Double.parseDouble(txtPeso.getText()), Integer.parseInt(txtEdadEnMeses.getText()), txtEspecie.getText(), isIndoor, txtCantidadHorasSuenio.getText(), txtNivelIndependencia.getText());
        return gato;
    }


    private void eliminarGato() {
        if (gatoController.eliminarGato(txtId.getText())) {
            listMascotas.remove(selectedGato);
            limpiarCamposGato();
            limpiarSeleccion();
        }
    }


    private void actualizarGato() {


        if (selectedGato != null &&
                gatoController.actualizarGato(selectedGato.getId(), buildGato())) {


            int index = listMascotas.indexOf(selectedGato);
            if (index >= 0) {
                listMascotas.set(index, buildGato());
            }


            tblListMascota.refresh();
            limpiarSeleccion();
            limpiarCamposGato();
        }
    }


    private void limpiarSeleccion() {
        tblListMascota.getSelectionModel().clearSelection();
        limpiarCamposGato();
    }


    private void limpiarCamposGato() {
        txtId.clear();
        txtNombre.clear();
        txtRaza.clear();
        txtPeso.clear();
        txtEdadEnMeses.clear();
        toggleGroupIsIndoor.selectToggle(null);
        txtCantidadHorasSuenio.clear();
        txtNivelIndependencia.clear();
        txtEspecie.clear();
    }


    public void setApp(App app) {
        this.app = app;
    }
}

