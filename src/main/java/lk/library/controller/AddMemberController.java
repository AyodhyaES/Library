package lk.library.controller;

import javafx.fxml.FXML;
import javafx.scene.control.*;

public class AddMemberController {
    @FXML private TextField idField, nameField, emailField, phoneField, addressField;
    @FXML private Label statusLabel;

    @FXML
    private void register() {
        if (idField.getText().isBlank() || nameField.getText().isBlank() ||
            emailField.getText().isBlank() || phoneField.getText().isBlank() ||
            addressField.getText().isBlank()) {
            statusLabel.setText("Please complete all fields.");
            return;
        }

        if (!emailField.getText().matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$")) {
            statusLabel.setText("Please enter a valid email address.");
            return;
        }

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Member Registered");
        alert.setHeaderText("Registration successful");
        alert.setContentText("Member: " + nameField.getText());
        alert.showAndWait();
        clear();
    }

    @FXML private void clear() {
        idField.clear(); nameField.clear(); emailField.clear(); phoneField.clear(); addressField.clear();
        statusLabel.setText("");
    }
}
