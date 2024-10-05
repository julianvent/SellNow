package jjvu.projects.sellnow;

import javafx.application.Application;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import jjvu.projects.sellnow.models.Model;
import jjvu.projects.sellnow.views.ViewFactory;

public class App extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        Model.getInstance().getViewFactory().showLoginWindow();
    }

    public static void main(String[] args) {
        launch();
    }
}
