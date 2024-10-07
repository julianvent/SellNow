package jjvu.projects.sellnow.models;

import java.sql.*;

public class DatabaseDriver {
    private final Connection connection;

    public DatabaseDriver() {
        try {
            connection = DriverManager.getConnection("jdbc:sqlite:sellnow.db");
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
}
