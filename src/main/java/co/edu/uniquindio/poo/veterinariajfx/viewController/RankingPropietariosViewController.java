package co.edu.uniquindio.poo.veterinariajfx.viewController;

import co.edu.uniquindio.poo.veterinariajfx.App;
import co.edu.uniquindio.poo.veterinariajfx.controller.RankingPropietariosController;
import co.edu.uniquindio.poo.veterinariajfx.model.Propietario;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class RankingPropietariosViewController {

    RankingPropietariosController rankingController;
    ObservableList<PropietarioRanking> listaPropietarios = FXCollections.observableArrayList();

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableView<PropietarioRanking> tblRanking;

    @FXML
    private TableColumn<PropietarioRanking, Integer> colPosicion;

    @FXML
    private TableColumn<PropietarioRanking, String> colNombre;

    @FXML
    private TableColumn<PropietarioRanking, String> colId;

    @FXML
    private TableColumn<PropietarioRanking, Double> colVisitas;

    @FXML
    private TableColumn<PropietarioRanking, String> colDireccion;

    @FXML
    private Label lblTotalPropietarios;

    @FXML
    private Label lblTotalVisitas;

    @FXML
    private Button btnActualizar;

    @FXML
    private Button btnCerrar;

    @FXML
    private Button btnRegresarMenu;

    private App app;

    @FXML
    void onActualizar() {
        cargarRanking();
    }

    @FXML
    void onCerrar() {
        cerrarVentana();
    }

    @FXML
    void onRegresarMenu() {
        app.openViewPrincipal();
    }

    @FXML
    void initialize() {
        initDataBinding();
    }

    private void initView() {
        initDataBinding();

        cargarRanking();

        tblRanking.getItems().clear();

        tblRanking.setItems(listaPropietarios);
    }

    private void initDataBinding() {
        colPosicion.setCellValueFactory(cellData ->
                new SimpleIntegerProperty(cellData.getValue().getPosicion()).asObject());

        colNombre.setCellValueFactory(cellData ->
                new SimpleStringProperty(cellData.getValue().getNombre()));

        colId.setCellValueFactory(cellData ->
                new SimpleStringProperty(cellData.getValue().getId()));

        colVisitas.setCellValueFactory(cellData ->
                new SimpleObjectProperty(cellData.getValue().getVisitas()));

        colDireccion.setCellValueFactory(cellData ->
                new SimpleStringProperty(cellData.getValue().getDireccion()));
    }

    private void cargarRanking() {
        listaPropietarios.clear();

        List<Propietario> ranking = rankingController.obtenerRanking();

        int posicion = 1;
        double totalVisitas = 0;

        for (Propietario prop : ranking) {
            PropietarioRanking propRanking = new PropietarioRanking(
                    posicion,
                    prop.getNombre(),
                    prop.getId(),
                    prop.getPuntajeFidelidad(),
                    prop.getDireccion()
            );
            listaPropietarios.add(propRanking);
            totalVisitas += prop.getPuntajeFidelidad();
            posicion++;
        }

        tblRanking.setItems(listaPropietarios);

        lblTotalPropietarios.setText("Total de propietarios: " + ranking.size());
        lblTotalVisitas.setText("Total de visitas: " + (int)totalVisitas);
    }

    private void cerrarVentana() {
        app.openViewPrincipal();
    }

    public void setApp(App app) {
        this.app = app;
        rankingController = new RankingPropietariosController(app.veterinaria);
        initView();
    }

    public static class PropietarioRanking {
        private int posicion;
        private String nombre;
        private String id;
        private double visitas;
        private String direccion;

        public PropietarioRanking(int posicion, String nombre, String id, double visitas, String direccion) {
            this.posicion = posicion;
            this.nombre = nombre;
            this.id = id;
            this.visitas = visitas;
            this.direccion = direccion;
        }

        public int getPosicion() {
            return posicion;
        }

        public String getNombre() {
            return nombre;
        }

        public String getId() {
            return id;
        }

        public double getVisitas() {
            return visitas;
        }

        public String getDireccion() {
            return direccion;
        }
    }
}