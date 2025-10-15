package co.edu.uniquindio.poo.veterinariajfx.viewController;

import co.edu.uniquindio.poo.veterinariajfx.App;
import co.edu.uniquindio.poo.veterinariajfx.controller.ConsultaController;
import co.edu.uniquindio.poo.veterinariajfx.model.Consulta;
import co.edu.uniquindio.poo.veterinariajfx.model.TipoConsulta;
import co.edu.uniquindio.poo.veterinariajfx.model.Veterinaria;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;


public class ConsultaViewController implements Initializable {
    ConsultaController consultaController;
    ObservableList<Consulta> listConsultas = FXCollections.observableArrayList();
    Consulta selectedConsulta;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        consultaController = new ConsultaController();

        comboTipoConsulta.setItems(FXCollections.observableArrayList(TipoConsulta.values()));

        comboTipoConsulta.getSelectionModel().select(TipoConsulta.CONTROL_RUTINARIO);

        comboTipoConsulta.setItems(FXCollections.observableArrayList(TipoConsulta.values()));

        comboTipoConsulta.getSelectionModel().select(TipoConsulta.CONSULTA);

        this.app = app;
        consultaController = new ConsultaController(app.veterinaria);
        initView();
    }


    @FXML
    private ResourceBundle resources;


    @FXML
    private URL location;

    @FXML
    private TextField txtId;

    @FXML
    private TextField txtFecha;

    @FXML
    private ComboBox<TipoConsulta> comboTipoConsulta;

    @FXML
    private TextField txtPrecioBase;

    @FXML
    private TextField txtCostoTotal;



    @FXML
    private Button btnLimpiar;


    @FXML
    private TableView<Consulta> tblListConsultas;


    @FXML
    private Button btnEliminar;


    @FXML
    private Button btnActualizarConsulta;


    @FXML
    private TableColumn<Consulta, String> tbcId;

    @FXML
    private TableColumn<Consulta, String> tbcFecha;

    @FXML
    private TableColumn<Consulta, String> tbcTipoConsulta;

    @FXML
    private TableColumn<Consulta, String> tbcPrecioBase;

    @FXML
    private TableColumn<Consulta, String> tbcCostoTotal;

    @FXML
    private Button btbAgregarConsulta;

    @FXML
    private Button btnRegresarMenu;

    @FXML
    void onRegresarMenu() {
        app.openViewPrincipal();
    }


    private App app;


    @FXML
    void onAgregarConsulta() {
        agregarConsulta();
    }


    @FXML
    void onActualizarConsulta() {
        actualizarConsulta();
    }


    @FXML
    void onLimpiar() {
        limpiarSeleccion();
    }


    @FXML
    void onEliminar() {
        eliminarConsulta();
    }


    private void initView() {
        // Traer los datos del cliente a la tabla
        initDataBinding();


        // Obtiene la lista
        obtenerConsulta();


        // Limpiar la tabla
        tblListConsultas.getItems().clear();


        // Agregar los elementos a la tabla
        tblListConsultas.setItems(listConsultas);


        // Seleccionar elemento de la tabla
        listenerSelection();
    }


    private void initDataBinding() {
        tbcId.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getId()));
        tbcTipoConsulta.setCellValueFactory(cellData -> new SimpleObjectProperty(cellData.getValue().getTipoConsulta()));
        tbcPrecioBase.setCellValueFactory(cellData -> new SimpleObjectProperty(cellData.getValue().getPrecioBase()));
        tbcFecha.setCellValueFactory(cellData -> new SimpleObjectProperty(cellData.getValue().getFecha()));
        tbcCostoTotal.setCellValueFactory(cellData -> new SimpleObjectProperty(cellData.getValue().getCostoTotal()));

        // Usamos SimpleObjectProperty para manejar Double y Integer correctamente
    }


    private void obtenerConsulta() {
        listConsultas.addAll(consultaController.obtenerListaConsultas());
    }


    private void listenerSelection() {
        tblListConsultas.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            selectedConsulta = newSelection;
            mostrarInformacionConsulta(selectedConsulta);
        });
    }

    private void mostrarInformacionConsulta(Consulta consulta) {
        if (consulta != null) {
            txtId.setText(consulta.getId());
            comboTipoConsulta.setValue(consulta.getTipoConsulta());
            txtPrecioBase.setText(String.valueOf(consulta.getPrecioBase()));
            txtCostoTotal.setText(String.valueOf(consulta.getCostoTotal()));
            txtFecha.setText(consulta.getFecha().toString());
        }
    }

    private void agregarConsulta() {
        Consulta consulta = buildConsulta();
        if (consultaController.crearConsulta(consulta)) {
            listConsultas.add(consulta);
            limpiarCamposConsulta();
        }
    }


    private Consulta buildConsulta() {
        Consulta consulta = new Consulta(txtId.getText(), LocalDate.now(), comboTipoConsulta.getValue(), Double.parseDouble(txtPrecioBase.getText()), Double.parseDouble(txtCostoTotal.getText()));
        return consulta;
    }


    private void eliminarConsulta() {
        if (consultaController.eliminarConsulta(txtId.getText())) {
            listConsultas.remove(selectedConsulta);
            limpiarCamposConsulta();
            limpiarSeleccion();
        }
    }


    private void actualizarConsulta() {


        if (selectedConsulta != null &&
                consultaController.actualizarConsulta(selectedConsulta.getId(), buildConsulta())) {


            int index = listConsultas.indexOf(selectedConsulta);
            if (index >= 0) {
                listConsultas.set(index, buildConsulta());
            }


            tblListConsultas.refresh();
            limpiarSeleccion();
            limpiarCamposConsulta();
        }
    }


    private void limpiarSeleccion() {
        tblListConsultas.getSelectionModel().clearSelection();
        limpiarCamposConsulta();
    }


    private void limpiarCamposConsulta() {
        txtId.clear();
        txtFecha.clear();
        txtPrecioBase.clear();
        comboTipoConsulta.getSelectionModel().clearSelection();
        txtCostoTotal.clear();
    }


    public void setApp(App app) {
        this.app = app;
    }

    public ConsultaController getConsultaController() {
        return consultaController;
    }

    public void setConsultaController(ConsultaController consultaController) {
        this.consultaController = consultaController;
    }


    public void setVeterinaria(Veterinaria veterinaria) {
        consultaController = new ConsultaController(veterinaria);
    }


}