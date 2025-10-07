package co.edu.uniquindio.poo.veterinariajfx.viewController;

import co.edu.uniquindio.poo.veterinariajfx.App;
import co.edu.uniquindio.poo.veterinariajfx.controller.MascotaController;
import co.edu.uniquindio.poo.veterinariajfx.model.Mascota;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;


import java.net.URL;
import java.util.ResourceBundle;


public class MascotaViewController {
    MascotaController mascotaController;
    ObservableList<Mascota> listMascotas = FXCollections.observableArrayList();
    Mascota selectedMascota;


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
    private Button btnActualizarCliente;


    @FXML
    private TableColumn<Mascota, String> tbcNombre;

    @FXML
    private TableColumn<Mascota, String> tbcPeso;

    @FXML
    private TableColumn<Mascota, String> tbcEdadEnMeses;

    @FXML
    private TableColumn<Mascota, String> tbcEspecie;

    @FXML
    private TextField txtRaza;

    @FXML
    private TextField txtPeso;

    @FXML
    private TextField txtEdadEnMeses;

    @FXML
    private TableColumn<Mascota, String> tbcRaza;


    @FXML
    private Button btbAgregarMascota;


    @FXML
    private TableColumn<Mascota, String> tbcId;


    @FXML
    private TextField txtId;
    private App app;


    @FXML
    void onAgregarMascota() {
        agregarMascota();
    }


    @FXML
    void onActualizarMascota() {
        actualizarMascota();
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
        mascotaController = new MascotaController(app.veterinaria);
        initView();
    }


    private void initView() {
        // Traer los datos del cliente a la tabla
        initDataBinding();


        // Obtiene la lista
        obtenerMascota();


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


    private void obtenerMascota() {
        listMascotas.addAll(mascotaController.obtenerListaMascotas());
    }


    private void listenerSelection() {
        tblListMascota.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            selectedMascota = newSelection;
            mostrarInformacionMascota(selectedMascota);
        });
    }


    private void mostrarInformacionMascota(Mascota mascota) {
        if (mascota != null) {
            txtId.setText(mascota.getId());
            txtNombre.setText(mascota.getNombre());
            txtRaza.setText(mascota.getRaza());
        }
    }


    private void agregarMascota() {
        Mascota mascota = buildMascota();
        if (mascotaController.crearMascota(mascota)) {
            listMascotas.add(mascota);
            limpiarCamposMascota();
        }
    }


    private Mascota buildMascota() {
        Mascota mascota = new Mascota(txtId.getText(), txtNombre.getText(), txtRaza.getText(), Double.parseDouble(txtPeso.getText()), Integer.parseInt(txtEdadEnMeses.getText()), txtEspecie.getText());
        return mascota;
    }


    private void eliminarMascota() {
        if (mascotaController.eliminarMascota(txtId.getText())) {
            listMascotas.remove(selectedMascota);
            limpiarCamposMascota();
            limpiarSeleccion();
        }
    }


    private void actualizarMascota() {


        if (selectedMascota != null &&
                mascotaController.actualizarMascota(selectedMascota.getId(), buildMascota())) {


            int index = listMascotas.indexOf(selectedMascota);
            if (index >= 0) {
                listMascotas.set(index, buildMascota());
            }


            tblListMascota.refresh();
            limpiarSeleccion();
            limpiarCamposMascota();
        }
    }


    private void limpiarSeleccion() {
        tblListMascota.getSelectionModel().clearSelection();
        limpiarCamposMascota();
    }


    private void limpiarCamposMascota() {
        txtId.clear();
        txtNombre.clear();
        txtRaza.clear();
    }


    public void setApp(App app) {
        this.app = app;
    }
}