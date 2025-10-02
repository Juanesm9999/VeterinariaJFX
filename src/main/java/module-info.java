module co.edu.uniquindio.poo.veterinariajfx {
    requires javafx.controls;
    requires javafx.fxml;


    opens co.edu.uniquindio.poo.veterinariajfx to javafx.fxml;
    exports co.edu.uniquindio.poo.veterinariajfx;
}