package co.edu.uniquindio.poo.veterinariajfx.viewController;

import co.edu.uniquindio.poo.veterinariajfx.App;
import javafx.fxml.FXML;
import javafx.scene.control.Button;


import java.net.URL;
import java.util.ResourceBundle;


public class PrimaryViewController {
    @FXML
    private ResourceBundle resources;


    App app;
    @FXML
    private URL location;


    @FXML
    private Button primaryButton;


    @FXML
    void onOpenCrudMascota() {
        app.openCrudMascota();
    }

    @FXML
   /* void onOpenCrudAve() {
        app.openCrudAve();
*/

    public void setApp(App app) {
        this.app = app;
    }


    @FXML
    void initialize() {


    }
}


