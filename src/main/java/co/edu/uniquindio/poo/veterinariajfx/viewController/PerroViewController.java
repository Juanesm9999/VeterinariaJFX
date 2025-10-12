package co.edu.uniquindio.poo.veterinariajfx.viewController;

import co.edu.uniquindio.poo.veterinariajfx.App;
import co.edu.uniquindio.poo.veterinariajfx.controller.PerroController;
import co.edu.uniquindio.poo.veterinariajfx.model.Mascota;
import co.edu.uniquindio.poo.veterinariajfx.model.Perro;
import co.edu.uniquindio.poo.veterinariajfx.model.Tamanio;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;


import java.net.URL;
import java.util.ResourceBundle;


public class PerroViewController {
    PerroController perroController;
    ObservableList<Mascota> listMascotas = FXCollections.observableArrayList();
    Perro selectedPerro;


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