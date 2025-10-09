package co.edu.uniquindio.poo.veterinariajfx.viewController;

import co.edu.uniquindio.poo.veterinariajfx.App;
import co.edu.uniquindio.poo.veterinariajfx.controller.PerroController;
import co.edu.uniquindio.poo.veterinariajfx.model.Perro;
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


public class PerroViewController {
    PerroController perroController;
    ObservableList<Perro> listPerros = FXCollections.observableArrayList();
    Perro selectedPerro;


    @FXML
    private ResourceBundle resources;


    @FXML
    private URL location;


    @FXML
    private TextField txtnombre;

    @FXML
    private TextField txtid;


    @FXML
    private TextField txtraza;
    @FXML
    private TextField txtpeso;
    @FXML
    private TextField txtedadEnMeses;
    @FXML
    private TextField txtespecie;
    @FXML
    private TextField txttamanio;
    @FXML
    private TextField txtivelAdiestramiento;
    @FXML
    private TextField txtNecesidadPaseosDiarios;


    @FXML
    private Button btnLimpiar;


    @FXML
    private TableView<Perro> tblListPerro;


    @FXML
    private Button btnEliminar;


    @FXML
    private Button btnActualizarPerro;


    @FXML
    private TableColumn<Perro, String> tbcnombre;
    @FXML
    private TableColumn<Perro, String> tbcid;
    @FXML
    private TableColumn<Perro, String> tbcraza;

    @FXML
    private TableColumn<Perro, String> tbcPeso;
    
    @FXML
    private TableColumn<Perro, String> tbcEdadEnMeses;

    @FXML
    private TableColumn<Perro, String> tbcEspecie;




    @FXML
    private TableColumn<Perro, String> tbcRaza;


    @FXML
    private Button btbAgregarPerro;

    
    private App app;


    @FXML
    void onAgregarPerro() {
        agregarPerro();
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
        Mascota mascota = new Mascota(txtId.getText(), txtNombre.getText(), txtRaza.getText(), Double.parseDouble(txtPeso.getText()), Integer.parseInt(txtEdadEnMeses.getText()), txtEspecie.getText()) {
            @Override
            public double CalcularCostoConsulta(boolean tipoConsulta, double precioBase, Integer edadEnMeses, double costoTotal, String Especie) {
                return 0;
            }
        };
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