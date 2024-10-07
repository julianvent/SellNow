package jjvu.projects.sellnow.models;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class User {
    private StringProperty id;
    private StringProperty username;
    private StringProperty shopName;

    public User(String id, String username, String shopName) {
        this.id = new SimpleStringProperty(this, "id", id);
        this.username = new SimpleStringProperty(this, "username", username);
        this.shopName = new SimpleStringProperty(this, "shopName", shopName);
    }

    public String getId() {
        return id.get();
    }

    public StringProperty idProperty() {
        return id;
    }

    public void setId(String id) {
        this.id.set(id);
    }

    public String getUsername() {
        return username.get();
    }

    public StringProperty usernameProperty() {
        return username;
    }

    public void setUsername(String username) {
        this.username.set(username);
    }

    public String getShopName() {
        return shopName.get();
    }

    public StringProperty shopNameProperty() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName.set(shopName);
    }
}
