package com.example.beroepsproduct.screens;

import com.example.beroepsproduct.classes.Database;
import com.example.beroepsproduct.classes.Product;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Homescreen {
    private final Scene scene;

    public Homescreen(Stage stage, Scene scene) {
        this.scene = scene;
        Pane root = new Pane();
        Scene scene1 = new Scene(root, 1024, 600);

        stage.setTitle("MyTurn");
        stage.setScene(scene);
        stage.show();

        //Maken van sidebar waar pagina's komen te staan
        FlowPane sidebar = new FlowPane();
        sidebar.setStyle("-fx-background-color: #292c33");
        sidebar.setPrefSize(140, scene.getHeight());
        sidebar.setMaxSize(140, scene.getHeight());
        sidebar.setOrientation(Orientation.VERTICAL);

        //Titel van de applicatie rechts boven in het scherm
        Label logo = new Label("MyTurn");
        logo.setPrefSize(sidebar.getMaxWidth(), 56);
        logo.setStyle("-fx-background-color: #000000;");
        logo.setAlignment(Pos.CENTER);

        Button Toevoegen = new Button("Product Toevoegen");
        Toevoegen.setStyle("-fx-background-color: #000000;");

        double whitespace = scene.getWidth() - sidebar.getMaxWidth();

        //Flowpane waar de toegevoegde producten in komen te staan
        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setStyle("-fx-background-color: #ffffff;");
        scrollPane.relocate(sidebar.getMaxWidth(), 50);
        scrollPane.setPrefSize(whitespace / 2, scene.getHeight() - scrollPane.getTranslateY());
//VBox waar de producten in komen te staan
        VBox content = new VBox(10);
        content.setPrefWidth(whitespace / 2);
        //Producten ophalen uit de database en laten zien
               try {
                   Class.forName("jdbc:mysql:cj.jdbc.Driver");
        Database connector = new Database("127.0.0.1", "3306", "beroepsproduct", "root", "");
        ResultSet producten = connector.query("SELECT * FROM product");

                   while (producten.next()) {
                       content.getChildren().add(new Product(producten).show());
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        scrollPane.setContent(content);
        sidebar.getChildren().addAll(logo, Toevoegen);
        root.getChildren().addAll(sidebar, scrollPane);
    }

}