package jjvu.projects.sellnow.controllers;

import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

import java.net.URL;
import java.util.ResourceBundle;

public class DashboardController implements Initializable {
    public Label shopNameLabel;
    public Label currentDateLabel;
    public FontAwesomeIconView fastSaleCreateButton;
    public Label totalImportLabel;
    public ListView lastSalesListView;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
