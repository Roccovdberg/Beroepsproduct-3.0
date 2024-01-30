package com.example.beroepsproduct.screens;

import com.example.beroepsproduct.classes.Database;
import com.example.beroepsproduct.classes.Product;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.sql.*;

public class Homescreen extends BorderPane {
    public Homescreen(Stage stage) {
        // Maken van sidebar waar pagina's komen te staan
        FlowPane sidebar = new FlowPane();
        sidebar.setStyle("-fx-background-color: #292c33");
        sidebar.setPrefSize(140, getHeight());
        sidebar.setMaxSize(140, getHeight());
        sidebar.setOrientation(Orientation.VERTICAL);

        // Titel van de applicatie rechts boven in het scherm
        Label logo = new Label("MyTurn");
        logo.setPrefSize(sidebar.getMaxWidth(), 80);
        logo.setStyle("-fx-background-color: #ffffff;");
        logo.setAlignment(Pos.CENTER);

        Button Toevoegen = new Button("Product Toevoegen");
        Toevoegen.setStyle("-fx-background-color: #ff0000;");
        Toevoegen.setOnAction(e -> {
            Toevoegen toevoegen = new Toevoegen(stage);
            stage.setScene(toevoegen.getScene());
            stage.show();
        });

        // Flowpane waar de toegevoegde producten in komen te staan
        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setStyle("-fx-background-color: #ffffff;");
        scrollPane.setPrefSize(500, 500);

        // VBox waar de producten in komen te staan
        VBox content = new VBox(10);
        content.setPrefWidth(400);
        content.setPrefHeight(400);

        // Producten ophalen uit de database en laten zien
        try {
            Database connector = new Database();
            ResultSet producten = connector.getConnection().createStatement().executeQuery("SELECT * FROM product");

            while (producten.next()) content.getChildren().add(new Product(producten));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        scrollPane.setContent(content);
        sidebar.getChildren().addAll(logo, Toevoegen);
        setLeft(sidebar);
        setCenter(scrollPane);
    }
}
