package jjvu.projects.sellnow.controllers;

import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import jjvu.projects.sellnow.models.Model;
import jjvu.projects.sellnow.models.Product;

import java.net.URL;
import java.util.ResourceBundle;

public class ProductTableController implements Initializable {
    public TableView<Product> productsTableView;


    public TableColumn<Product, String> productID;
    public TableColumn<Product, String> name;
    public TableColumn<Product, String> category;
    public TableColumn<Product, Double> unitPrice;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setProperties();
        initializeData();
        productsTableView.setItems(Model.getInstance().getProducts());
    }

    private void setProperties() {
        productID.setCellValueFactory(new PropertyValueFactory<>("productID"));
        name.setCellValueFactory(new PropertyValueFactory<>("name"));
        category.setCellValueFactory(new PropertyValueFactory<>("category"));
        unitPrice.setCellValueFactory(new PropertyValueFactory<>("unitPrice"));
    }

    public static void initializeData() {
        Model.getInstance().setProducts();
    }
}
