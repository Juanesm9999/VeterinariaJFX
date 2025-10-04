package co.edu.uniquindio.poo.veterinariajfx.viewController;

import co.edu.uniquindio.poo.veterinariajfx.App;
import co.edu.uniquindio.poo.veterinariajfx.controller.MascotaController;
import co.edu.uniquindio.poo.veterinariajfx.model.Mascota;
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
    private TextField txtRaza;


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
        this.app=app;
        mascotaController = new MascotaController(app.veterinaria);
        initView();
    }


    private void initView() {
        // Traer los datos del cliente a la tabla
        initDataBinding();


        // Obtiene la lista
        obtenerClientes();


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
        // Usamos SimpleObjectProperty para manejar Double y Integer correctamente
    }


    private void obtenerClientes() {
        listMascotas.addAll(MascotaController.());
    }


    private void listenerSelection() {
        tblListCliente.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            selectedCliente = newSelection;
            mostrarInformacionCliente(selectedCliente);
        });
    }


    private void mostrarInformacionCliente(Cliente cliente) {
        if (cliente != null) {
            txtCedula.setText(cliente.getCedula());
            txtNombre.setText(cliente.getNombre());
            txtApellido.setText(cliente.getApellido());
        }
    }


    private void agregarCliente() {
        Cliente cliente = buildCliente();
        if (clienteController.crearCliente(cliente)) {
            listClientes.add(cliente);
            limpiarCamposCliente();
        }
    }


    private Cliente buildCliente() {
        Cliente cliente = new Cliente(txtCedula.getText(), txtNombre.getText(), txtApellido.getText());
        return cliente;
    }


    private void eliminarCliente() {
        if (clienteController.eliminarCliente(txtCedula.getText())) {
            listClientes.remove(selectedCliente);
            limpiarCamposCliente();
            limpiarSeleccion();
        }
    }


    private void actualizarCliente() {


        if (selectedCliente != null &&
                clienteController.actualizarCliente(selectedCliente.getCedula(), buildCliente())) {


            int index = listClientes.indexOf(selectedCliente);
            if (index >= 0) {
                listClientes.set(index, buildCliente());
            }


            tblListCliente.refresh();
            limpiarSeleccion();
            limpiarCamposCliente();
        }
    }


    private void limpiarSeleccion() {
        tblListCliente.getSelectionModel().clearSelection();
        limpiarCamposCliente();
    }


    private void limpiarCamposCliente() {
        txtCedula.clear();
        txtNombre.clear();
        txtApellido.clear();
    }


    public void setApp(App app) {
        this.app = app;
