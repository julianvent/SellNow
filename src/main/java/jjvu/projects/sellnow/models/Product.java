package jjvu.projects.sellnow.models;

import javafx.beans.property.*;

public class Product {
    private IntegerProperty id;
    private StringProperty productID;
    private StringProperty name;
    private DoubleProperty unitPrice;
    private StringProperty category;
    private IntegerProperty stock;
    private IntegerProperty minStock;

    public Product(String productID, String name, double unitPrice, String category, int stock, int minStock) {
        this.productID = new SimpleStringProperty(this, "productID", productID);
        this.name = new SimpleStringProperty(this, "name", name);
        this.unitPrice = new SimpleDoubleProperty(this, "unitPrice", unitPrice);
        this.category = new SimpleStringProperty(this, "category", category);
        this.stock = new SimpleIntegerProperty(this, "stock", stock);
        this.minStock = new SimpleIntegerProperty(this, "minStock", minStock);
    }

    public int getId() {
        return id.get();
    }

    public IntegerProperty idProperty() {
        return id;
    }

    public void setId(int id) {
        this.id.set(id);
    }

    public String getProductID() {
        return productID.get();
    }

    public StringProperty productIDProperty() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID.set(productID);
    }

    public String getName() {
        return name.get();
    }

    public StringProperty nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public double getUnitPrice() {
        return unitPrice.get();
    }

    public DoubleProperty unitPriceProperty() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice.set(unitPrice);
    }

    public String getCategory() {
        return category.get();
    }

    public StringProperty categoryProperty() {
        return category;
    }

    public void setCategory(String category) {
        this.category.set(category);
    }

    public int getStock() {
        return stock.get();
    }

    public IntegerProperty stockProperty() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock.set(stock);
    }

    public int getMinStock() {
        return minStock.get();
    }

    public IntegerProperty minStockProperty() {
        return minStock;
    }

    public void setMinStock(int minStock) {
        this.minStock.set(minStock);
    }
}
