package co.edu.uniquindio.poo.veterinariajfx.viewController;

import co.edu.uniquindio.poo.veterinariajfx.App;
import co.edu.uniquindio.poo.veterinariajfx.controller.AveController;
import co.edu.uniquindio.poo.veterinariajfx.model.Mascota;
import co.edu.uniquindio.poo.veterinariajfx.model.Ave;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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


public class AveViewController {
    AveController aveController;
    ObservableList<Ave> listMascotas = FXCollections.observableArrayList();
    Ave selectedAve;

    @FXML
    private ResourceBundle resources;


    @FXML
    private URL location;

    @FXML
    private RadioButton rbIsVueloCortoSi;

    @FXML
    private RadioButton rbIsVueloCortoNo;


    @FXML
    private TextField txtNombre;

    @FXML
    private TextField txtId;


    @FXML
    private TextField txtRaza;
    @FXML
    private TextField txtPeso;
    @FXML
    private TextField txtEdadEnMeses;
    @FXML
    private TextField txtEspecie;
    @FXML
    private TextField txtTipoDePlumaje;

    @FXML
    private TextField txtCantidadDeImitaciones;


    @FXML
    private Button btnLimpiar;


    @FXML
    private TableView<Ave> tblListMascota;


    @FXML
    private Button btnEliminar;


    @FXML
    private Button btnActualizarAve;


    @FXML
    private TableColumn<Ave, String> tbcNombre;
    @FXML
    private TableColumn<Ave, String> tbcId;
    @FXML
    private TableColumn<Ave, String> tbcRaza;

    @FXML
    private TableColumn<Ave, Double> tbcPeso;

    @FXML
    private TableColumn<Ave, Integer> tbcEdadEnMeses;

    @FXML
    private TableColumn<Ave, String> tbcEspecie;

    @FXML
    private TableColumn<Ave, String> tbcTipoDePlumaje;

    @FXML
    private TableColumn<Ave, Boolean> tbcIsVueloCorto;

    @FXML
    private TableColumn<Ave, String> tbcCantidadDeImitaciones;


    @FXML
    private Button btbAgregarAve;

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


    private App app;


    @FXML
    void onAgregarAve() {
        agregarAve();
    }


    @FXML
    void onActualizarAve() {
       actualizarAve();
    }


    @FXML
    void onLimpiar() {
        limpiarSeleccion();
    }


    @FXML
    void onEliminar() {
        eliminarAve();
    }

    private ToggleGroup toggleGroupIsVueloCorto;


    @FXML
    void initialize() {
        aveController = new AveController(App.veterinaria); // Usa la instancia estática si la tienes
        toggleGroupIsVueloCorto = new ToggleGroup();
        rbIsVueloCortoSi.setToggleGroup(toggleGroupIsVueloCorto);
        rbIsVueloCortoNo.setToggleGroup(toggleGroupIsVueloCorto);
        initView();
    }


    private void initView() {
        // Traer los datos del cliente a la tabla
        initDataBinding();


        // Obtiene la lista
        obtenerAve();


        // Limpiar la tabla
        tblListMascota.getItems().clear();


        // Agregar los elementos a la tabla
        tblListMascota.setItems(listMascotas);


        // Seleccionar elemento de la tabla
        listenerSelection();
    }


    private void initDataBinding() {
        tbcId.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getId()));
        tbcNombre.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNombre()));
        tbcRaza.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getRaza()));
        tbcPeso.setCellValueFactory(cellData -> new SimpleObjectProperty(cellData.getValue().getPeso()));
        tbcEdadEnMeses.setCellValueFactory(cellData -> new SimpleObjectProperty(cellData.getValue().getEdadEnMeses()));
        tbcEspecie.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getEspecie()));
        tbcTipoDePlumaje.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getTipoDePlumaje()));
        tbcIsVueloCorto.setCellValueFactory(cellData -> new SimpleObjectProperty(cellData.getValue().getIsVueloCorto()));
        tbcCantidadDeImitaciones.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCantidadDeImitaciones()));


        //faltan los atributos de ave

        // Usamos SimpleObjectProperty para manejar Double y Integer correctamente
    }


    private void obtenerAve() {
        listMascotas.addAll(AveController.obtenerListaMascotas());
    }


    private void listenerSelection() {
        tblListMascota.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            selectedAve = (Ave) newSelection;
            mostrarInformacionAve(selectedAve);
        });
    }


    private void mostrarInformacionAve(Ave ave) {
        if (ave != null) {
            txtId.setText(ave.getId());
            txtNombre.setText(ave.getNombre());
            txtRaza.setText(ave.getRaza());
            txtEspecie.setText(ave.getEspecie());
            txtEdadEnMeses.setText(String.valueOf(ave.getEdadEnMeses()));
            txtPeso.setText(String.valueOf(ave.getPeso()));
            txtTipoDePlumaje.setText(ave.getTipoDePlumaje());
            if (ave.getIsVueloCorto()) {
                rbIsVueloCortoSi.setSelected(true);
            } else {
                rbIsVueloCortoNo.setSelected(false);
            }
            txtCantidadDeImitaciones.setText(ave.getCantidadDeImitaciones());
        }
    }


    private void agregarAve() {
        Ave ave = buildAve();
            if (aveController.crearAve(ave)) {
            listMascotas.add(ave);
            limpiarCamposAve();
        }
    }


    private Ave buildAve() {

        boolean isVueloCorto = rbIsVueloCortoSi.isSelected();
        Ave ave = new Ave(txtId.getText(), txtNombre.getText(), txtRaza.getText(), Double.parseDouble(txtPeso.getText()), Integer.parseInt(txtEdadEnMeses.getText()), txtEspecie.getText(), txtTipoDePlumaje.getText(), isVueloCorto, txtCantidadDeImitaciones.getText());
        return ave;
    }


    private void eliminarAve() {
        if (aveController.eliminarAve(txtId.getText())) {
            listMascotas.remove(selectedAve);
            limpiarCamposAve();
            limpiarSeleccion();
        }
    }


    private void actualizarAve() {


        if (selectedAve != null &&
                aveController.actualizarAve(selectedAve.getId(), buildAve())) {


            int index = listMascotas.indexOf(selectedAve);
            if (index >= 0) {
                listMascotas.set(index, buildAve());
            }


            tblListMascota.refresh();
            limpiarSeleccion();
            limpiarCamposAve();
        }
    }


    private void limpiarSeleccion() {
        tblListMascota.getSelectionModel().clearSelection();
        limpiarCamposAve();
    }


    private void limpiarCamposAve() {
        txtId.clear();
        txtNombre.clear();
        txtRaza.clear();
        txtCantidadDeImitaciones.clear();
        txtEspecie.clear();
        txtEdadEnMeses.clear();
        txtPeso.clear();
        txtTipoDePlumaje.clear();
        toggleGroupIsVueloCorto.selectToggle(null);
        txtCantidadDeImitaciones.clear();
    }


    public void setApp(App app) {
        this.app = app;
    }
}