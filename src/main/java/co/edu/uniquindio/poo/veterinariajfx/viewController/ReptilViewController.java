package co.edu.uniquindio.poo.veterinariajfx.viewController;

import co.edu.uniquindio.poo.veterinariajfx.App;
import co.edu.uniquindio.poo.veterinariajfx.controller.ReptilController;
import co.edu.uniquindio.poo.veterinariajfx.model.Habitat;
import co.edu.uniquindio.poo.veterinariajfx.model.NivelPeligrosidad;
import co.edu.uniquindio.poo.veterinariajfx.model.Reptil;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;


import java.net.URL;
import java.util.ResourceBundle;


public class ReptilViewController {
    ReptilController reptilController;
    ObservableList<Reptil> listMascotas = FXCollections.observableArrayList();
    Reptil selectedReptil;


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
    private TableView<Reptil> tblListMascota;


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
    private Button btbAgregarGato;


    @FXML
    private TableColumn<Reptil, String> tbcId;


    @FXML
    private TextField txtId;

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
        listMascotas.addAll((Reptil) reptilController.obtenerListaMascotas());
    }


    private void listenerSelection() {
        tblListMascota.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            selectedReptil = newSelection;
            mostrarInformacionReptil(selectedReptil);
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

