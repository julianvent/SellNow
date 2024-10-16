package jjvu.projects.sellnow.models;

import java.sql.*;

public class DatabaseDriver {
    private final Connection connection;

    public DatabaseDriver() {
        try {
            connection = DriverManager.getConnection("jdbc:sqlite:sellnow.db");
            System.out.println("Conexion a la BD");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /*
    User
     */
    public ResultSet getUserData(String username, String password) {
        Statement statement;
        ResultSet resultSet;

        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(String.format(
                    "SELECT * FROM %s WHERE username=\"%s\" AND password=\"%s\";"
                    , "user", username, password)
            );
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return resultSet;
    }

    public void createProduct(int userID, String productID, String name, double unitPrice, String category, int stock, int minStock) {
        Statement statement;

        try {
            statement = connection.createStatement();
            statement.executeUpdate(String.format(
                    "INSERT INTO product (%s) VALUES (%d, '%s','%s', %f, '%s', %d, %d);"
                    , "userID, productID, name, unitPrice, category, stock, minStock", userID, productID, name, unitPrice, category, stock, minStock)
            );
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ResultSet getAllProducts() {
        Statement statement;
        ResultSet resultSet;

        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM product WHERE userID = "
                    + Integer.parseInt(Model.getInstance().getLoggedUser().getId()) + ";");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return resultSet;
    }

    public void closeConnection() throws SQLException {
        connection.close();
    }
}
