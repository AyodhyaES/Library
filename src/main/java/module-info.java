module lk.library {
    requires javafx.controls;
    requires javafx.fxml;

    opens lk.library to javafx.fxml;
    opens lk.library.controller to javafx.fxml;
    exports lk.library;
}
