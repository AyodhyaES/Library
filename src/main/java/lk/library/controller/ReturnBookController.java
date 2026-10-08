package lk.library.controller;

import javafx.fxml.FXML;
import javafx.scene.control.*;

public class ReturnBookController {
    @FXML private TextField searchField;
    @FXML private Label memberLabel, bookLabel, borrowedLabel, dueLabel, statusLabel;

    @FXML
    private void search() {
        if (searchField.getText().isBlank()) {
            statusLabel.setText("Enter a Book ID or member ID.");
            return;
        }
        memberLabel.setText("Nethmi Perera (M001)");
        bookLabel.setText("Clean Code (B001)");
        borrowedLabel.setText("2026-10-01");
        dueLabel.setText("2026-10-15");
        statusLabel.setText("Borrowing record found.");
    }

    @FXML
    private void returnBook() {
        if (bookLabel.getText().equals("-")) {
            statusLabel.setText("Search for a borrowed book first.");
            return;
        }
        Alert a = new Alert(Alert.AlertType.INFORMATION);
        a.setTitle("Book Returned");
        a.setHeaderText("Return completed");
        a.setContentText("The book has been marked as returned.");
        a.showAndWait();
        statusLabel.setText("Returned successfully.");
    }
}
