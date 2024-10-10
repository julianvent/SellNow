package jjvu.projects.sellnow.controllers;

import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import jjvu.projects.sellnow.models.Model;

import java.net.URL;
import java.util.ResourceBundle;

public class CreateProductController implements Initializable {
    public TextField productIDField;
    public TextField productNameField;
    public TextField unitPriceField;
    public TextField categoryField;
    public TextField stockField;
    public TextField minStockField;
    public Button createProductButton;
    public Label createStatusLabel;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        createProductButton.setOnAction(actionEvent -> onCreateProduct());
    }

    public void onCreateProduct() {
        try {
            Model.getInstance().getDatabaseDriver().createProduct(
                    Integer.parseInt(Model.getInstance().getLoggedUser().getId())
                    , productIDField.getText()
                    , productNameField.getText()
                    , Double.parseDouble(unitPriceField.getText())
                    , categoryField.getText()
                    , Integer.parseInt(stockField.getText())
                    , Integer.parseInt(minStockField.getText())
            );
            createStatusLabel.setText("Producto Creado con Éxito");
            createStatusLabel.setStyle("-fx-text-fill: #00AA00;");
        } catch (Exception e) {
            createStatusLabel.setText("ERROR: No fue Posible Crear el Producto.");
            createStatusLabel.setStyle("-fx-text-fill: #EE0004");
            throw new RuntimeException(e);
        }
        emptyFields();
    }

    private void emptyFields() {
        productIDField.setText("");
        productNameField.setText("");
        unitPriceField.setText("");
        categoryField.setText("");
        stockField.setText("");
        minStockField.setText("");
    }
}
