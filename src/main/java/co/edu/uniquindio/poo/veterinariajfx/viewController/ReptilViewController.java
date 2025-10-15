package co.edu.uniquindio.poo.veterinariajfx.viewController;

import co.edu.uniquindio.poo.veterinariajfx.App;
import co.edu.uniquindio.poo.veterinariajfx.controller.ReptilController;
import co.edu.uniquindio.poo.veterinariajfx.model.*;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class ReptilViewController implements Initializable {
    ReptilController reptilController;
    ObservableList<Mascota> listMascotas = FXCollections.observableArrayList();
    Mascota selectedReptil;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        // --- AQUÍ VA EL MÉTODO PARA POBLAR EL COMBOBOX ---

        comboHabitat.setItems(FXCollections.observableArrayList(Habitat.values()));

        // Opcional: Establecer un valor por defecto al iniciar
        comboHabitat.getSelectionModel().select(Habitat.MIXTO);

        comboHabitat.setItems(FXCollections.observableArrayList(Habitat.values()));

        comboHabitat.getSelectionModel().select(Habitat.ACUATICO);

        comboNivelPeligrosidad.setItems(FXCollections.observableArrayList(NivelPeligrosidad.values()));

        comboNivelPeligrosidad.getSelectionModel().select(NivelPeligrosidad.ALTO);

        comboNivelPeligrosidad.setItems(FXCollections.observableArrayList(NivelPeligrosidad.values()));

        comboNivelPeligrosidad.getSelectionModel().select(NivelPeligrosidad.MEDIO);

        // --------------------------------------------------
    }

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
    private TableView<Mascota> tblListMascota;


    @FXML
    private Button btnEliminar;


    @FXML
    private Button btnActualizarReptil;


    @FXML
    private TableColumn<Reptil, String> tbcNombre;

    @FXML
    private TableColumn<Reptil, String> tbcPeso;

    @FXML
    private TableColumn<Reptil, String> tbcEdadEnMeses;

    @FXML
    private TableColumn<Reptil, String> tbcEspecie;

    @FXML
    private TableColumn<Reptil, String> tbcHabitat;

    @FXML
    private TableColumn<Reptil, String> tbcTemperaturaOptima;

    @FXML
    private TableColumn<Reptil, String> tbcNivelPeligrosidad;

    @FXML
    private TextField txtRaza;

    @FXML
    private TextField txtPeso;

    @FXML
    private TextField txtEdadEnMeses;

    @FXML
    private ComboBox comboHabitat;

    @FXML
    private TextField txtTemperaturaOptima;

    @FXML
    private ComboBox comboNivelPeligrosidad;

    @FXML
    private TableColumn<Reptil, String> tbcRaza;


    @FXML
    private Button btbAgregarReptil;


    @FXML
    private TableColumn<Reptil, String> tbcId;


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

    private App app;


    @FXML
    void onAgregarReptil() {
        agregarReptil();
    }


    @FXML
    void onActualizarReptil() {
        actualizarReptil();
    }


    @FXML
    void onLimpiar() {
        limpiarSeleccion();
    }


    @FXML
    void onEliminar() {
        eliminarReptil();
    }


    @FXML
    void initialize() {
        this.app = app;
        reptilController = new ReptilController(app.veterinaria);
        initView();
    }


    private void initView() {
        // Traer los datos del cliente a la tabla
        initDataBinding();


        // Obtiene la lista
        obtenerReptil();


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
        tbcEspecie.setCellValueFactory(cellData -> new SimpleObjectProperty(cellData.getValue().getEspecie()));
        tbcHabitat.setCellValueFactory(cellData -> new SimpleObjectProperty(cellData.getValue().getHabitat()));
        tbcTemperaturaOptima.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getTemperaturaOptima()));
        tbcNivelPeligrosidad.setCellValueFactory(cellData -> new SimpleObjectProperty(cellData.getValue().getNivelPeligrosidad()));

        // Usamos SimpleObjectProperty para manejar Double y Integer correctamente
    }

    private void obtenerReptil() {
        listMascotas.addAll(reptilController.obtenerListaMascotas());
    }


    private void listenerSelection() {
        tblListMascota.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            selectedReptil = newSelection;
            mostrarInformacionReptil((Reptil) selectedReptil);
        });
    }


    private void mostrarInformacionReptil(Reptil reptil) {
        if (reptil != null) {
            txtId.setText(reptil.getId());
            txtNombre.setText(reptil.getNombre());
            txtRaza.setText(reptil.getRaza());
            txtPeso.setText(String.valueOf(reptil.getPeso()));
            txtTemperaturaOptima.setText(reptil.getTemperaturaOptima());
            txtEspecie.setText(reptil.getEspecie());
            txtEdadEnMeses.setText(String.valueOf(reptil.getEdadEnMeses()));
            comboHabitat.setValue(reptil.getRaza());
            comboNivelPeligrosidad.setValue(reptil.getRaza());


        }
    }


    private void agregarReptil() {
        Reptil reptil = buildReptil();
        if (reptilController.crearReptil(reptil)) {
            listMascotas.add(reptil);
            limpiarCamposReptil();
        }
    }


    private Reptil buildReptil() {
        Reptil reptil = new Reptil(txtId.getText(), txtNombre.getText(), txtRaza.getText(), Double.parseDouble(txtPeso.getText()), Integer.parseInt(txtEdadEnMeses.getText()), txtEspecie.getText(), (Habitat) comboHabitat.getValue(), txtTemperaturaOptima.getText(), (NivelPeligrosidad) comboNivelPeligrosidad.getValue());
        return reptil;
    }


    private void eliminarReptil() {
        if (reptilController.eliminarReptil(txtId.getText())) {
            listMascotas.remove(selectedReptil);
            limpiarCamposReptil();
            limpiarSeleccion();
        }
    }


    private void actualizarReptil() {


        if (selectedReptil != null &&
                reptilController.actualizarReptil(selectedReptil.getId(), buildReptil())) {


            int index = listMascotas.indexOf(selectedReptil);
            if (index >= 0) {
                listMascotas.set(index, buildReptil());
            }


            tblListMascota.refresh();
            limpiarSeleccion();
            limpiarCamposReptil();
        }
    }


    private void limpiarSeleccion() {
        tblListMascota.getSelectionModel().clearSelection();
        limpiarCamposReptil();
    }


    private void limpiarCamposReptil() {
        txtId.clear();
        txtNombre.clear();
        txtRaza.clear();
        txtPeso.clear();
        txtEdadEnMeses.clear();
        txtEspecie.clear();
        txtTemperaturaOptima.clear();
        comboHabitat.getSelectionModel().clearSelection();
        comboNivelPeligrosidad.getSelectionModel().clearSelection();

    }


    public void setApp(App app) {
        this.app = app;
    }
}

