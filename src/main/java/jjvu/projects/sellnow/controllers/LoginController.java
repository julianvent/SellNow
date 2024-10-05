package jjvu.projects.sellnow.controllers;

import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import jjvu.projects.sellnow.models.Model;

import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable {
    public TextField usernameField;
    public TextField passwordField;
    public Button loginButton;
    public Label errorLabel;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        loginButton.setOnAction(actionEvent -> onLogin());
    }

    public void onLogin() {
        Model.getInstance().getViewFactory().showClientWindow();
    }
}
