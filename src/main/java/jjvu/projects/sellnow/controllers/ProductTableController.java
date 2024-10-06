package jjvu.projects.sellnow.controllers;

import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import jjvu.projects.sellnow.models.Product;

import java.net.URL;
import java.util.ResourceBundle;

public class ProductTableController implements Initializable {
    public TableView<Product> productsTableView;


    public TableColumn<Product, Integer> id;
    public TableColumn<Product, String> name;
    public TableColumn<Product, String> category;
    public TableColumn<Product, Double> unitPrice;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setProperties();
        productsTableView.getItems().add(new Product(1, "Pepsi 3L", 41.0, "Bebidas", 10, 1));
    }

    private void setProperties() {
        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        name.setCellValueFactory(new PropertyValueFactory<>("name"));
        category.setCellValueFactory(new PropertyValueFactory<>("category"));
        unitPrice.setCellValueFactory(new PropertyValueFactory<>("unitPrice"));
    }
}
