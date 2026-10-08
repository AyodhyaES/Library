package lk.library.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

public class LoginController {
    @FXML private TextField usernameField;
    @FXML private PasswordField passwordField;
    @FXML private Label messageLabel;

    @FXML
    private void login() {
        String username = usernameField.getText().trim();
        String password = passwordField.getText();

        if (username.isEmpty() || password.isEmpty()) {
            messageLabel.setText("Please enter both username and password.");
            return;
        }

        if (username.equals("admin") && password.equals("admin123")) {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/lk/library/view/Dashboard.fxml"));
                Scene scene = new Scene(loader.load(), 1200, 760);
                scene.getStylesheets().add(getClass().getResource("/lk/library/css/style.css").toExternalForm());
                Stage stage = (Stage) usernameField.getScene().getWindow();
                stage.setScene(scene);
                stage.setTitle("Nova Library | Dashboard");
                stage.centerOnScreen();
            } catch (Exception e) {
                messageLabel.setText("Unable to open dashboard.");
                e.printStackTrace();
            }
        } else {
            messageLabel.setText("Invalid username or password.");
        }
    }

    @FXML
    private void clear() {
        usernameField.clear();
        passwordField.clear();
        messageLabel.setText("");
    }
}
