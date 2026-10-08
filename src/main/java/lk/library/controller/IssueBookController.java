package lk.library.controller;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import java.time.LocalDate;

public class IssueBookController {
    @FXML private ComboBox<String> memberBox, bookBox;
    @FXML private DatePicker issueDate, dueDate;
    @FXML private Label statusLabel;

    @FXML
    private void initialize() {
        memberBox.getItems().addAll("M001 - Nethmi Perera", "M002 - Kavindu Silva", "M003 - Hiruni Fernando");
        bookBox.getItems().addAll("B001 - Clean Code", "B002 - Java Fundamentals", "B003 - The Alchemist");
        issueDate.setValue(LocalDate.now());
        dueDate.setValue(LocalDate.now().plusDays(14));
    }

    @FXML
    private void issue() {
        if (memberBox.getValue() == null || bookBox.getValue() == null ||
            issueDate.getValue() == null || dueDate.getValue() == null) {
            statusLabel.setText("Please select all required details.");
            return;
        }
        if (dueDate.getValue().isBefore(issueDate.getValue())) {
            statusLabel.setText("Due date cannot be before issue date.");
            return;
        }
        Alert a = new Alert(Alert.AlertType.INFORMATION);
        a.setTitle("Book Issued");
        a.setHeaderText("Borrowing record created");
        a.setContentText(bookBox.getValue() + "\nIssued to: " + memberBox.getValue());
        a.showAndWait();
        statusLabel.setText("Book issued successfully.");
    }

    @FXML private void clear() {
        memberBox.getSelectionModel().clearSelection();
        bookBox.getSelectionModel().clearSelection();
        issueDate.setValue(LocalDate.now());
        dueDate.setValue(LocalDate.now().plusDays(14));
        statusLabel.setText("");
    }
}
