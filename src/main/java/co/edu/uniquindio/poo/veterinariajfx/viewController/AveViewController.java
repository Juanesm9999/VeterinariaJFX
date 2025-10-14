package co.edu.uniquindio.poo.veterinariajfx.viewController;

import co.edu.uniquindio.poo.veterinariajfx.App;
import co.edu.uniquindio.poo.veterinariajfx.controller.AveController;
import co.edu.uniquindio.poo.veterinariajfx.model.Mascota;
import co.edu.uniquindio.poo.veterinariajfx.model.Ave;
import co.edu.uniquindio.poo.veterinariajfx.model.Tamanio;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;


import java.net.URL;
import java.util.ResourceBundle;


public class AveViewController {
    AveController aveController;
    ObservableList<Mascota> listMascotas = FXCollections.observableArrayList();
    Ave selectedAve;

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
    private TextField txtTipoDePlumaje;
    @FXML
    private TextField txtIsVueloCorto;
    @FXML
    private TextField txtCantidadDeImitaciones;


    @FXML
    private Button btnLimpiar;


    @FXML
    private TableView<Mascota> tblListMascota;


    @FXML
    private Button btnEliminar;


    @FXML
    private Button btnActualizarPerro;


    @FXML
    private TableColumn<Ave, String> tbcNombre;
    @FXML
    private TableColumn<Ave, String> tbcId;
    @FXML
    private TableColumn<Ave, String> tbcRaza;

    @FXML
    private TableColumn<Ave, String> tbcPeso;

    @FXML
    private TableColumn<Ave, String> tbcEdadEnMeses;

    @FXML
    private TableColumn<Ave, String> tbcEspecie;

    @FXML
    private TableColumn<Ave, String> tbcTipoDePlumaje;

    @FXML
    private TableColumn<Ave, String> tbcIsVueloCorto;

    @FXML
    private TableColumn<Ave, String> tbcCantidadDeImitaciones;


    @FXML
    private Button btbAgregarAve;


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


    @FXML
    void initialize() {
        this.app = app;
        aveController = new AveController(app.veterinaria);
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
        tbcIsVueloCorto.setCellValueFactory(cellData -> new SimpleStringProperty());
        tbcCantidadDeImitaciones.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCantidadDeImitaciones()));


        //faltan los atributos de ave

        // Usamos SimpleObjectProperty para manejar Double y Integer correctamente
    }


    private void obtenerAve() {
        listMascotas.addAll(AveController.obtenerListMascotas());
    }


    private void listenerSelection() {
        tblListMascota.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            selectedAve = (Ave) newSelection;
            mostrarInformacionPerro(selectedAve);
        });
    }


    private void mostrarInformacionPerro(Ave ave) {
        if (ave != null) {
            txtId.setText(ave.getId());
            txtNombre.setText(ave.getNombre());
            txtRaza.setText(ave.getRaza());
            txtEspecie.setText(ave.getEspecie());
            txtEdadEnMeses.setText(String.valueOf(ave.getEdadEnMeses()));
            txtPeso.setText(String.valueOf(ave.getPeso()));
            txtTipoDePlumaje.setText(ave.getTipoDePlumaje());
            txtIsVueloCorto.setText(ave.getIsVueloCorto());
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


        Ave ave = new Ave(txtId.getText(), txtNombre.getText(), txtRaza.getText(), Double.parseDouble(txtPeso.getText()), Integer.parseInt(txtEdadEnMeses.getText()), txtEspecie.getText(), txtTipoDePlumaje.getText(), Boolean.parseBoolean(txtIsVueloCorto.getText()), txtCantidadDeImitaciones.getText());
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
        txtIsVueloCorto.clear();
        txtCantidadDeImitaciones.clear();
    }


    public void setApp(App app) {
        this.app = app;
    }
}