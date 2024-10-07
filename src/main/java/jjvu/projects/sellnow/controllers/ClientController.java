package jjvu.projects.sellnow.controllers;

import javafx.fxml.Initializable;
import javafx.scene.layout.HBox;
import jjvu.projects.sellnow.models.Model;

import java.net.URL;
import java.util.ResourceBundle;

public class ClientController implements Initializable {
    public HBox clientParent;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Model.getInstance().getViewFactory().clientSelectedMenuItemProperty().addListener(
                ((observableValue, oldValue, newValue) -> {
                    System.out.println("Current view: " + Model.getInstance().getViewFactory().clientSelectedMenuItemProperty());
                    switch (newValue) {
                        case CREATE_PRODUCT -> clientParent.getChildren().set(1, Model.getInstance().getViewFactory().getCreateProductView());
                        case PRODUCT_TABLE -> clientParent.getChildren().set(1, Model.getInstance().getViewFactory().getProductTableView());
                        default -> clientParent.getChildren().set(1, Model.getInstance().getViewFactory().getMainMenuView());
                    }
                })
        );
    }
}
