package com.example.beroepsproduct.screens;

import com.example.beroepsproduct.classes.Database;
import com.example.beroepsproduct.classes.Product;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.sql.*;

public class Homescreen extends BorderPane {

    public Homescreen(Stage stage) {
        // Maken van sidebar waar pagina's komen te staan
        FlowPane blokje = new FlowPane();
        blokje.setStyle("-fx-background-color: #292c33");
        blokje.setPrefSize(100, 30);
        blokje.setOrientation(Orientation.VERTICAL);

        // Titel van de applicatie rechts boven in het scherm
        Label logo = new Label("MyTurn");
        logo.setPrefSize(100, 40);
        logo.setStyle("-fx-background-color: #ffffff;");
        logo.setAlignment(Pos.CENTER);

        Button Toevoegen = new Button("Voeg toe");
        Toevoegen.setStyle("-fx-background-color: #ff0000;");
        Toevoegen.setPrefSize(100, 40);

        Toevoegen.setOnAction(e -> {
            Toevoegen toevoegen = new Toevoegen(stage);
            stage.setScene(toevoegen.getScene());
            stage.show();
        });
        blokje.getChildren().addAll(logo, Toevoegen);
        setLeft(blokje);

        //Tableview waar de producten in komen te staan
        TableView Tableview = new TableView();
        GridPane.setConstraints(Tableview, 2, 5);
        TableColumn<Product, String> col1 = new TableColumn<>("Productnaam");
        TableColumn<Product, Date> col2 = new TableColumn<>("Uitleendatum");
        TableColumn<Product, Date> col3 = new TableColumn<>("Teruggeefdatum");
        TableColumn<Product, String> col4= new TableColumn<>("Productbeschrijving");
        TableColumn<Product, String> col5 = new TableColumn<>("Productadres");

        col1.setCellValueFactory(new PropertyValueFactory<>("productNaam"));
        col2.setCellValueFactory(new PropertyValueFactory<>("productUitleendatum"));
        col3.setCellValueFactory(new PropertyValueFactory<>("productTeruggeefdatum"));
        col4.setCellValueFactory(new PropertyValueFactory<>("productBeschrijving"));
        col5.setCellValueFactory(new PropertyValueFactory<>("productAdres"));

        Tableview.getColumns().addAll(col1, col2, col3, col4, col5);
    }
}
