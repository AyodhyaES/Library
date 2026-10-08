package lk.library.controller;

import javafx.fxml.FXML;
import javafx.scene.control.*;

public class AddBookController {
    @FXML private TextField idField, titleField, authorField, categoryField, yearField, quantityField;
    @FXML private Label statusLabel;

    @FXML
    private void addBook() {
        if (idField.getText().isBlank() || titleField.getText().isBlank() ||
            authorField.getText().isBlank() || categoryField.getText().isBlank() ||
            yearField.getText().isBlank() || quantityField.getText().isBlank()) {
            statusLabel.setText("Please complete all fields.");
            return;
        }
        if (!yearField.getText().matches("\\d{4}") || !quantityField.getText().matches("\\d+")) {
            statusLabel.setText("Year must be 4 digits and quantity must be a number.");
            return;
        }

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Book Added");
        alert.setHeaderText("Book successfully added");
        alert.setContentText("Title: " + titleField.getText() + "\nBook ID: " + idField.getText());
        alert.showAndWait();
        clear();
    }

    @FXML private void clear() {
        idField.clear(); titleField.clear(); authorField.clear(); categoryField.clear();
        yearField.clear(); quantityField.clear(); statusLabel.setText("");
    }
}
