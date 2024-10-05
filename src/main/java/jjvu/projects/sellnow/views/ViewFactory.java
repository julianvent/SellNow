package jjvu.projects.sellnow.views;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import jjvu.projects.sellnow.controllers.ClientController;

import java.io.IOException;

public class ViewFactory {
    public ViewFactory() {}

    /*
    Login Window
     */
    public void showLoginWindow() {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/Login.fxml"));
        createStage(loader);
    }

    /*
    MainView Window
     */
    public void showClientWindow() {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/Client.fxml"));
        ClientController controller = new ClientController();
        loader.setController(controller);
        createStage(loader);
    }


    /*
    Utility
     */
    private void createStage(FXMLLoader loader) {
        Scene scene = null;

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
}
