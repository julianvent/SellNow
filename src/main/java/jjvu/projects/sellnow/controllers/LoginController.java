package jjvu.projects.sellnow.controllers;

import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import jjvu.projects.sellnow.models.Model;

import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable {
    public TextField usernameField;
    public PasswordField passwordField;
    public Button loginButton;
    public Label errorLabel;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        loginButton.setOnAction(actionEvent -> onLogin());
    }

    private void onLogin() {
        // Close Login window
        Stage stage = (Stage)loginButton.getScene().getWindow();

        Model.getInstance().evaluateCredentials(usernameField.getText(), passwordField.getText());

        if (Model.getInstance().getLoginSuccessFlag()) {
            Model.getInstance().getViewFactory().closeStage(stage);
            Model.getInstance().getViewFactory().showClientWindow();
        } else {
            errorLabel.setText("Nombre de usuario o contraseña incorrectos.");
        }
    }
}
