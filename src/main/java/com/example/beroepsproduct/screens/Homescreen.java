package com.example.beroepsproduct.screens;

import com.example.beroepsproduct.classes.Product;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

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

        // Button om product toe te voegen
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

        // Tableview waar de producten in komen te staan
        TableView<Product> tableView = new TableView<>(); // Specificeer het type van TableView

        TableColumn<Product, String> col1 = new TableColumn<>("Productnaam");
        TableColumn<Product, Date> col2 = new TableColumn<>("Uitleendatum");
        TableColumn<Product, Date> col3 = new TableColumn<>("Teruggeefdatum");
        TableColumn<Product, String> col4 = new TableColumn<>("Productbeschrijving");
        TableColumn<Product, String> col5 = new TableColumn<>("Productadres");

        col1.setCellValueFactory(new PropertyValueFactory<>("productNaam"));
        col2.setCellValueFactory(new PropertyValueFactory<>("productUitleendatum"));
        col3.setCellValueFactory(new PropertyValueFactory<>("productTeruggeefdatum"));
        col4.setCellValueFactory(new PropertyValueFactory<>("productBeschrijving"));
        col5.setCellValueFactory(new PropertyValueFactory<>("productAdres"));

        tableView.getColumns().addAll(col1, col2, col3, col4, col5);

        // Gegevens ophalen uit de database en toevoegen aan de TableView
        ObservableList<Product> productList = getProductsFromDatabase();
        tableView.setItems(productList);

        setCenter(tableView); // Voeg de TableView toe aan het midden van het Homescreen
    }

    // Methode om productgegevens uit de database op te halen
    private ObservableList<Product> getProductsFromDatabase() {
        ObservableList<Product> productList = FXCollections.observableArrayList();

        // Voorbeeld JDBC-databaseverbinding
        String url = "jdbc:mysql://localhost:3306/beroepsproduct";
        String username = "root";
        String password = "";

        try (Connection connection = DriverManager.getConnection(url, username, password);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM product;")) {

            while (resultSet.next()) {
                String productNaam = resultSet.getString("productNaam");
                Date Productuitleendatum = resultSet.getDate("productUitleendatum");
                Date Productteruggeefbatum = resultSet.getDate("productTeruggeefdatum");
                String Productbeschrijving = resultSet.getString("productBeschrijving");
                String Poductadres = resultSet.getString("productAdres");

                productList.add(new Product(productNaam, Productuitleendatum, Productteruggeefbatum, Productbeschrijving, Poductadres));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return productList;
    }
}