package jjvu.projects.sellnow.models;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import jjvu.projects.sellnow.views.ViewFactory;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Model {
    private static Model model;
    private final ViewFactory viewFactory;
    private final DatabaseDriver databaseDriver;

    private User loggedUser;
    private boolean loginSuccessFlag;
    private ObservableList<Product> products;

    private Model() {
        viewFactory = new ViewFactory();
        databaseDriver = new DatabaseDriver();
        loginSuccessFlag = false;
        loggedUser = new User("", "", "");
        products = FXCollections.observableArrayList();
    }

    public static synchronized Model getInstance() {
        if (model == null) {
            model = new Model();
        }
        return model;
    }

    public ViewFactory getViewFactory() {
        return viewFactory;
    }

    public DatabaseDriver getDatabaseDriver() {
        return databaseDriver;
    }

    public User getLoggedUser() {
        return loggedUser;
    }

    public boolean getLoginSuccessFlag() {
        return loginSuccessFlag;
    }

    public void setLoginSuccessFlag(boolean loginSuccessFlag) {
        this.loginSuccessFlag = loginSuccessFlag;
    }

    public ObservableList<Product> getProducts() {
        return products;
    }

    public void evaluateCredentials(String username, String password) {
        ResultSet resultSet = databaseDriver.getUserData(username, password);

        try {
            if (resultSet.isBeforeFirst()) {
                this.loggedUser.idProperty().set(resultSet.getString("id"));
                this.loggedUser.usernameProperty().set(resultSet.getString("username"));
                this.loggedUser.shopNameProperty().set(resultSet.getString("shopName"));
                this.loginSuccessFlag = true;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void setProducts() {
        ResultSet resultSet = databaseDriver.getAllProducts();
        System.out.println("set products");
        products.clear();

        try {
            while (resultSet.next()) {
                String productID = resultSet.getString("productID");
                String name = resultSet.getString("name");
                double unitPrice = resultSet.getDouble("unitPrice");
                String category = resultSet.getString("category");
                int stock = resultSet.getInt("stock");
                int minStock = resultSet.getInt("minStock");
                products.add(new Product(productID, name, unitPrice, category, stock, minStock));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void resetModel() throws SQLException {
        model.getDatabaseDriver().closeConnection();
        model = new Model();
    }
}
