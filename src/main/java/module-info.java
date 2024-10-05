module jjvu.projects.sellnow {
    requires javafx.controls;
    requires javafx.fxml;
    requires de.jensd.fx.glyphs.fontawesome;
    requires java.sql;
    requires org.xerial.sqlitejdbc;


    opens jjvu.projects.sellnow to javafx.fxml;
    exports jjvu.projects.sellnow;
    exports jjvu.projects.sellnow.controllers;
    exports jjvu.projects.sellnow.models;
    exports jjvu.projects.sellnow.views;
}