package jjvu.projects.sellnow.models;

import jjvu.projects.sellnow.views.ViewFactory;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Model {
    private static Model model;
    private final ViewFactory viewFactory;
    private final DatabaseDriver databaseDriver;

    private User loggedUser;
    private boolean loginSuccessFlag;

    private Model() {
        viewFactory = new ViewFactory();
        databaseDriver = new DatabaseDriver();
        loginSuccessFlag = false;
        loggedUser = new User("", "", "");
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

    public void resetModel() {
        model = new Model();
    }
}
