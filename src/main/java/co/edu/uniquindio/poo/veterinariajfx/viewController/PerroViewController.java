package co.edu.uniquindio.poo.veterinariajfx.viewController;

import co.edu.uniquindio.poo.veterinariajfx.App;
import co.edu.uniquindio.poo.veterinariajfx.controller.PerroController;
import co.edu.uniquindio.poo.veterinariajfx.controller.SugerenciaVacunacionController;
import co.edu.uniquindio.poo.veterinariajfx.model.Mascota;
import co.edu.uniquindio.poo.veterinariajfx.model.Perro;
import co.edu.uniquindio.poo.veterinariajfx.model.Tamanio;
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


public class PerroViewController implements Initializable {
    PerroController perroController;
    ObservableList<Mascota> listMascotas = FXCollections.observableArrayList();
    Perro selectedPerro;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        // --- AQUÍ VA EL MÉTODO PARA POBLAR EL COMBOBOX ---

        // Paso 3: Obtener todos los valores del Enum y ponerlos en el ComboBox
        comboTamanio.setItems(FXCollections.observableArrayList(Tamanio.values()));

        // Opcional: Establecer un valor por defecto al iniciar
        comboTamanio.getSelectionModel().select(Tamanio.MEDIANO);

        // --------------------------------------------------
    }


    @FXML
    private ResourceBundle resources;


    @FXML
    private URL location;


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
    private ComboBox<Tamanio> comboTamanio;
    @FXML
    private TextField txtNivelAdiestramiento;
    @FXML
    private TextField txtNecesidadPaseosDiarios;


    @FXML
    private Button btnLimpiar;


    @FXML
    private TableView<Mascota> tblListMascota;


    @FXML
    private Button btnEliminar;


    @FXML
    private Button btnActualizarPerro;


    @FXML
    private TableColumn<Perro, String> tbcNombre;
    @FXML
    private TableColumn<Perro, String> tbcId;
    @FXML
    private TableColumn<Perro, String> tbcRaza;

    @FXML
    private TableColumn<Perro, String> tbcPeso;
    
    @FXML
    private TableColumn<Perro, String> tbcEdadEnMeses;

    @FXML
    private TableColumn<Perro, String> tbcEspecie;

    @FXML
    private TableColumn<Perro, String> tbcTamanio;

    @FXML
    private TableColumn<Perro, String> tbcNivelAdiestramiento;

    @FXML
    private TableColumn<Perro, String> tbcNecesidadPaseosDiarios;


    @FXML
    private Button btbAgregarPerro;

    @FXML
    private Button btbFechaVacunacion;

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
    
    private App app;


    @FXML
    void onAgregarPerro() {
        agregarPerro();
    }


    @FXML
    void onActualizarPerro() {
        actualizarPerro();
    }


    @FXML
    void onLimpiar() {
        limpiarSeleccion();
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
    @FXML private Button btbRegresarAlMenu;

    @FXML
    void onEliminar() {
        eliminarMascota();
    }


    @FXML
    void initialize() {
        this.app = app;
        perroController = new PerroController(app.veterinaria);
        initView();
    }


    private void initView() {
        // Traer los datos del cliente a la tabla
        initDataBinding();


        // Obtiene la lista
        obtenerPerro();


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

        // Usamos SimpleObjectProperty para manejar Double y Integer correctamente
    }


    private void obtenerPerro() {
        listMascotas.addAll(perroController.obtenerListMascotas());
    }


    private void listenerSelection() {
        tblListMascota.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            selectedPerro = (Perro) newSelection;
            mostrarInformacionPerro(selectedPerro);
        });
    }


    private void mostrarInformacionPerro(Perro perro) {
        if (perro != null) {
            txtId.setText(perro.getId());
            txtNombre.setText(perro.getNombre());
            txtRaza.setText(perro.getRaza());
            txtEspecie.setText(perro.getEspecie());
            txtEdadEnMeses.setText(String.valueOf(perro.getEdadEnMeses()));
            txtPeso.setText(String.valueOf(perro.getPeso()));
            txtNivelAdiestramiento.setText(perro.getNivelAdiestramiento());
            comboTamanio.setValue(Tamanio.valueOf(perro.getNivelAdiestramiento()));
            txtNecesidadPaseosDiarios.setText(perro.getNivelAdiestramiento());
        }
    }


    private void agregarPerro() {
        Mascota perro = buildPerro();
        if (PerroController.crearPerro(perro)) {
            listMascotas.add(perro);
            limpiarCamposPerro();
        }
    }


    private Perro buildPerro() {


        Perro perro = new Perro(txtId.getText(), txtNombre.getText(), txtRaza.getText(), Double.parseDouble(txtPeso.getText()), Integer.parseInt(txtEdadEnMeses.getText()), txtEspecie.getText(), (Tamanio) comboTamanio.getValue(), txtNivelAdiestramiento.getText(), txtNecesidadPaseosDiarios.getText());
        return perro;
    }


    private void eliminarMascota() {
        if (perroController.eliminarPerro(txtId.getText())) {
            listMascotas.remove(selectedPerro);
            limpiarCamposPerro();
            limpiarSeleccion();
        }
    }


    private void actualizarPerro() {


        if (selectedPerro != null &&
                perroController.actualizarPerro(selectedPerro.getId(), buildPerro())) {


            int index = listMascotas.indexOf(selectedPerro);
            if (index >= 0) {
                listMascotas.set(index, buildPerro());
            }


            tblListMascota.refresh();
            limpiarSeleccion();
            limpiarCamposPerro();
        }
    }


    private void limpiarSeleccion() {
        tblListMascota.getSelectionModel().clearSelection();
        limpiarCamposPerro();
    }


    private void limpiarCamposPerro() {
        txtId.clear();
        txtNombre.clear();
        txtRaza.clear();
        txtNecesidadPaseosDiarios.clear();
        comboTamanio.getSelectionModel().clearSelection();
        txtEdadEnMeses.clear();
        txtEdadEnMeses.setEditable(false);
        txtNivelAdiestramiento.clear();
        txtNecesidadPaseosDiarios.clear();
    }


    public void setApp(App app) {
        this.app = app;
    }
}