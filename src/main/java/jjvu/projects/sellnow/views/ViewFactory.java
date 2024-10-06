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
    private AnchorPane mainMenuView;
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
    public AnchorPane getMainMenuView() {
        mainMenuView = getView(mainMenuView, "MainMenu.fxml");
        return mainMenuView;
    }

    public AnchorPane getCreateProductView() {
        createProductView = getView(createProductView, "CreateProduct.fxml");
        return createProductView;
    }

    public AnchorPane getProductTableView() {
        productTableView = getView(productTableView, "ProductTable.fxml");
        return productTableView;
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

    private FXMLLoader createLoader(String source) {
        return new FXMLLoader(getClass().getResource("/fxml/" + source));
    }

    // Singleton
    private <T> T getView(T view, String source) {
        if (view == null) {
            try {
                return createLoader(source).load();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return view;
    }
}
