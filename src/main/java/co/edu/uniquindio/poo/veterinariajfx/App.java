package co.edu.uniquindio.poo.veterinariajfx;

import co.edu.uniquindio.poo.veterinariajfx.model.Ave;
import co.edu.uniquindio.poo.veterinariajfx.model.Consulta;
import co.edu.uniquindio.poo.veterinariajfx.model.Gato;
import co.edu.uniquindio.poo.veterinariajfx.model.Mascota;
import co.edu.uniquindio.poo.veterinariajfx.model.Perro;
import co.edu.uniquindio.poo.veterinariajfx.model.Propietario;
import co.edu.uniquindio.poo.veterinariajfx.model.Reptil;
import co.edu.uniquindio.poo.veterinariajfx.model.TipoConsulta;

import co.edu.uniquindio.poo.veterinariajfx.model.Veterinaria;
import co.edu.uniquindio.poo.veterinariajfx.viewController.PrimaryViewController;
import co.edu.uniquindio.poo.veterinariajfx.viewController.MascotaViewController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;


import java.io.IOException;

public class App extends Application {


    private Stage primaryStage;
    public static Veterinaria veterinaria = new Veterinaria("Vida Animal", "001");


    @Override
    public void start(Stage primaryStage) throws IOException {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Gestion de Mascotas");
        openViewPrincipal();
    }


    private void openViewPrincipal() {
        inicializarData();
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("primary.fxml"));
            javafx.scene.layout.VBox rootLayout = (javafx.scene.layout.VBox) loader.load();
            PrimaryViewController primaryController = loader.getController();
            primaryController.setApp(this);


            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        launch();
    }


    public void openCrudMascota() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("crudMascota.fxml"));
            AnchorPane rootLayout = (AnchorPane) loader.load();
            MascotaViewController mascotaViewController= loader.getController();
            mascotaViewController.setApp(this);


            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }


    //servicios
    public void inicializarData(){
        Ave ave = new Ave("Rocky", "123", "Chihuahua", 10.0, 5, "Perro", "Azul", true, "pocas");
        veterinaria.agregarAve(ave);
    }
}

