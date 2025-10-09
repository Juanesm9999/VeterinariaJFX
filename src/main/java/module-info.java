module co.edu.uniquindio.poo.veterinariajfx {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens co.edu.uniquindio.poo.veterinariajfx to javafx.fxml;
    exports co.edu.uniquindio.poo.veterinariajfx;


    exports co.edu.uniquindio.poo.veterinariajfx.viewController;
    opens co.edu.uniquindio.poo.veterinariajfx.viewController to javafx.fxml;


    exports co.edu.uniquindio.poo.veterinariajfx.controller;
    opens co.edu.uniquindio.poo.veterinariajfx.controller to javafx.fxml;

}