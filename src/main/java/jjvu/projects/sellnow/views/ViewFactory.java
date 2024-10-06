package jjvu.projects.sellnow.views;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import jjvu.projects.sellnow.controllers.ClientController;

import java.io.IOException;

public class ViewFactory {
    private final ObjectProperty<SubmenuOptions> clientSelectedMenuItem;
    private AnchorPane dashboardView;
    private AnchorPane createProductView;
    private AnchorPane productTableView;

    public ViewFactory() {
        clientSelectedMenuItem = new SimpleObjectProperty<>(SubmenuOptions.MAIN_MENU);
    }

    public ObjectProperty<SubmenuOptions> clientSelectedMenuItemProperty() {
        return clientSelectedMenuItem;
    }

    /*
        Login Window
         */
    public void showLoginWindow() {
        FXMLLoader loader = createLoader("Login.fxml");
        createStage(loader);
    }

    /*
    Client Window
     */
    public void showClientWindow() {
        FXMLLoader loader = createLoader("Client.fxml");
        ClientController controller = new ClientController();
        loader.setController(controller);
        createStage(loader);
    }


    /*
    Submenus
     */
    public AnchorPane getDashboardView() {
        return getView(dashboardView, "Dashboard.fxml");
    }

    public AnchorPane getCreateProductView() {
        return getView(createProductView, "CreateProduct.fxml");
    }

    public AnchorPane getProductTableView() {
        return getView(productTableView, "ProductTable.fxml");
    }

    /*
        Utility
        */
    private void createStage(FXMLLoader loader) {
        Scene scene;

        try {
            scene = new Scene(loader.load());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setResizable(false);
        stage.setTitle("SellNow");
        stage.show();
    }

    public void closeStage(Stage stage) {
        stage.close();
    }

    public FXMLLoader createLoader(String source) {
        return new FXMLLoader(getClass().getResource("/fxml/" + source));
    }

    public <T> T getView(T view, String source) {
        if (view == null) {
            try {
                view = createLoader(source).load();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return view;
    }
}
