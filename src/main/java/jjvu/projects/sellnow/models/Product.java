package jjvu.projects.sellnow.models;

public class Product {
    private int id;
    private String name;
    private double unitPrice;
    private String category;
    private int stock;
    private int minStock;

    public Product(int id, String name, double unitPrice, String category, int stock, int minStock) {
        this.id = id;
        this.name = name;
        this.unitPrice = unitPrice;
        this.category = category;
        this.stock = stock;
        this.minStock = minStock;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getMinStock() {
        return minStock;
    }

    public void setMinStock(int minStock) {
        this.minStock = minStock;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
