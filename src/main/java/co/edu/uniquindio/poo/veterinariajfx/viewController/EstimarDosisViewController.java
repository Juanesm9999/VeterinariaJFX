package co.edu.uniquindio.poo.veterinariajfx.viewController;

import co.edu.uniquindio.poo.veterinariajfx.App;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class EstimarDosisViewController {

    @FXML
    private TextField txtPeso;

    @FXML
    private TextField txtMiligramosPorKilo;

    @FXML
    private Button btnCalcular;

    @FXML
    private Button btnLimpiar;

    @FXML
    private Button btnCerrar;

    @FXML
    private VBox vboxResultado;

    @FXML
    private Label lblResultado;

    private App app;

    @FXML
    void initialize() {
        vboxResultado.setVisible(false);
    }

    @FXML
    void onCalcularDosis() {
        try {
            if (txtPeso.getText().isEmpty() || txtMiligramosPorKilo.getText().isEmpty()) {
                mostrarAlerta("Error", "Por favor, complete todos los campos.", Alert.AlertType.WARNING);
                return;
            }

            double peso = Double.parseDouble(txtPeso.getText());
            double miligramosPorKilo = Double.parseDouble(txtMiligramosPorKilo.getText());

            double dosis = estimarDosis(peso, miligramosPorKilo);

            lblResultado.setText(String.format("La dosis estimada es: %.2f mg", dosis));
            vboxResultado.setVisible(true);

        } catch (NumberFormatException e) {
            mostrarAlerta("Error", "Por favor, ingrese valores numéricos válidos.", Alert.AlertType.ERROR);
        } catch (IllegalArgumentException e) {
            mostrarAlerta("Error", e.getMessage(), Alert.AlertType.ERROR);
        }
    }

    @FXML
    void onLimpiar() {
        txtPeso.clear();
        txtMiligramosPorKilo.clear();
        vboxResultado.setVisible(false);
        lblResultado.setText("");
    }

    @FXML
    void onCerrar() {
        Stage stage = (Stage) btnCerrar.getScene().getWindow();
        stage.close();
    }

    private double estimarDosis(double peso, double miligramosPorKilo) {
        if (peso <= 0 || miligramosPorKilo <= 0) {
            throw new IllegalArgumentException("El peso y los miligramos por kilo deben ser mayores a cero");
        }
        return peso * miligramosPorKilo;
    }

    private void mostrarAlerta(String titulo, String mensaje, Alert.AlertType tipo) {
        Alert alert = new Alert(tipo);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }

    public void setApp(App app) {
        this.app = app;
    }
}
