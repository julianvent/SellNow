package jjvu.projects.sellnow.controllers;

import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import jjvu.projects.sellnow.models.Model;
import jjvu.projects.sellnow.views.SubmenuOptions;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class SiderBarController implements Initializable {
    public Button mainMenuButton;
    public Button userButton;
    public Button logoutButton;
    public Button createSaleButton;
    public Button listSalesButton;
    public Button createProductButton;
    public Button productTableButton;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        mainMenuButton.setOnAction(actionEvent -> onMainMenu());
        createProductButton.setOnAction(actionEvent -> onCreateProduct());
        productTableButton.setOnAction(actionEvent -> onProductTable());
        logoutButton.setOnAction(actionEvent -> onLogout());
    }

    private void onMainMenu() {
        setSelectedMenu(SubmenuOptions.MAIN_MENU);
    }

    private void onCreateProduct() {
        setSelectedMenu(SubmenuOptions.CREATE_PRODUCT);
    }

    private void onProductTable() {
        setSelectedMenu(SubmenuOptions.PRODUCT_TABLE);
    }

    private void onLogout() {
        Stage stage = (Stage)logoutButton.getScene().getWindow();
        Model.getInstance().getViewFactory().closeStage(stage);

        try {
            Model.getInstance().resetModel();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        Model.getInstance().getViewFactory().showLoginWindow();
        Model.getInstance().setLoginSuccessFlag(false);
    }

    // Utility
    public void setSelectedMenu(SubmenuOptions submenu) {
        Model.getInstance().getViewFactory().clientSelectedMenuItemProperty().set(submenu);
    }
}
