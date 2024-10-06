package jjvu.projects.sellnow.controllers;

import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import jjvu.projects.sellnow.models.Model;
import jjvu.projects.sellnow.views.SubmenuOptions;

import java.net.URL;
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
    }

    public void onMainMenu() {
        setSelectedMenu(SubmenuOptions.MAIN_MENU);
    }

    public void onCreateProduct() {
        setSelectedMenu(SubmenuOptions.CREATE_PRODUCT);
    }

    public void onProductTable() {
        setSelectedMenu(SubmenuOptions.PRODUCT_TABLE);
    }

    // Utility
    public void setSelectedMenu(SubmenuOptions submenu) {
        Model.getInstance().getViewFactory().clientSelectedMenuItemProperty().set(submenu);
    }
}
