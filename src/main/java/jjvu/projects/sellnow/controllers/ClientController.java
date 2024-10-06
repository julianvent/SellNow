package jjvu.projects.sellnow.controllers;

import javafx.fxml.Initializable;
import javafx.scene.layout.HBox;
import jjvu.projects.sellnow.models.Model;
import jjvu.projects.sellnow.views.SubmenuOptions;

import java.net.URL;
import java.util.ResourceBundle;

public class ClientController implements Initializable {
    public HBox clientParent;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Model.getInstance().getViewFactory().clientSelectedMenuItemProperty().addListener(
                ((observableValue, oldValue, newValue) -> {
                    switch (newValue) {
                        case CREATE_PRODUCT :
                            clientParent.getChildren().remove(1);
                            clientParent.getChildren().add(Model.getInstance().getViewFactory().getCreateProductView());
                            break;
                        default:
                            clientParent.getChildren().remove(1);
                            clientParent.getChildren().add(Model.getInstance().getViewFactory().getDashboardView());
                    }
                })
        );
    }
}
