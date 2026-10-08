package lk.library.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.StackPane;
import javafx.scene.control.Label;
import javafx.scene.control.Alert;

public class DashboardController {
    @FXML private StackPane contentArea;
    @FXML private Label pageTitle;

    @FXML
    private void initialize() {
        openPage("Overview", "/lk/library/view/Overview.fxml");
    }

    private void openPage(String title, String path) {
        try {
            Parent page = FXMLLoader.load(getClass().getResource(path));
            contentArea.getChildren().setAll(page);
            pageTitle.setText(title);
        } catch (Exception e) {
            e.printStackTrace();
            showError("Could not load " + title + " page.");
        }
    }

    @FXML private void overview() { openPage("Overview", "/lk/library/view/Overview.fxml"); }
    @FXML private void addBook() { openPage("Add Book", "/lk/library/view/AddBook.fxml"); }
    @FXML private void addMember() { openPage("Add Member", "/lk/library/view/AddMember.fxml"); }
    @FXML private void members() { openPage("Manage Members", "/lk/library/view/Members.fxml"); }
    @FXML private void issueBook() { openPage("Issue Book", "/lk/library/view/IssueBook.fxml"); }
    @FXML private void returnBook() { openPage("Return Book", "/lk/library/view/ReturnBook.fxml"); }
    @FXML private void history() { openPage("Borrowing History", "/lk/library/view/History.fxml"); }

    @FXML
    private void logout() {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/lk/library/view/Login.fxml"));
            contentArea.getScene().setRoot(root);
        } catch (Exception e) {
            showError("Unable to logout.");
        }
    }

    private void showError(String text) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Nova Library");
        alert.setHeaderText(null);
        alert.setContentText(text);
        alert.showAndWait();
    }
}
