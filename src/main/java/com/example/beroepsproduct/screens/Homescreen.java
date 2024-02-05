package com.example.beroepsproduct.screens;

import com.example.beroepsproduct.classes.Product;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.sql.*;

public class Homescreen extends BorderPane {

    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/beroepsproduct";
    private static final String DATABASE_USERNAME = "root";
    private static final String DATABASE_PASSWORD = "";

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

        // Voeg een listener toe om het gedetailleerde scherm te openen wanneer op een item wordt geklikt
        tableView.setOnMouseClicked(event -> {
            if (event.getClickCount() == 1) {
                Product selectedProduct = tableView.getSelectionModel().getSelectedItem();
                if (selectedProduct != null) {
                    showDetailScreen(selectedProduct);
                }
            }
        });

        setCenter(tableView); // Voeg de TableView toe aan het midden van het Homescreen
    }

    // Methode om productgegevens uit de database op te halen
    private ObservableList<Product> getProductsFromDatabase() {
        ObservableList<Product> productList = FXCollections.observableArrayList();

        try (Connection connection = DriverManager.getConnection(DATABASE_URL, DATABASE_USERNAME, DATABASE_PASSWORD);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM product;")) {

            while (resultSet.next()) {
                String productNaam = resultSet.getString("productNaam");
                Date productUitleendatum = resultSet.getDate("productUitleendatum");
                Date productTeruggeefdatum = resultSet.getDate("productTeruggeefdatum");
                String productBeschrijving = resultSet.getString("productBeschrijving");
                String productAdres = resultSet.getString("productAdres");

                productList.add(new Product(productNaam, productUitleendatum, productTeruggeefdatum, productBeschrijving, productAdres));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return productList;
    }

    // Methode om het gedetailleerde scherm te tonen
    private void showDetailScreen(Product product) {
        Stage detailStage = new Stage();
        detailStage.setTitle("Productdetails");

        VBox detailLayout = new VBox(10);
        detailLayout.setAlignment(Pos.CENTER);

        TextField nameTextField = new TextField(product.getProductNaam());
        DatePicker dateDatePicker = new DatePicker(product.getProductUitleendatum().toLocalDate());
        DatePicker returnDatePicker = new DatePicker(product.getProductTeruggeefdatum().toLocalDate());
        TextField descriptionTextField = new TextField(product.getProductBeschrijving());
        TextField addressTextField = new TextField(product.getProductAdres());

        Button saveButton = new Button("Opslaan");
        saveButton.setOnAction(e -> {
            try (Connection connection = DriverManager.getConnection(DATABASE_URL, DATABASE_USERNAME, DATABASE_PASSWORD)) {
                String updateQuery = "UPDATE product SET " +
                        "productNaam = ?, " +
                        "productUitleendatum = ?, " +
                        "productTeruggeefdatum = ?, " +
                        "productBeschrijving = ?, " +
                        "productAdres = ? " +
                        "WHERE productNaam = ?";

                try (PreparedStatement preparedStatement = connection.prepareStatement(updateQuery)) {
                    preparedStatement.setString(1, nameTextField.getText());
                    preparedStatement.setDate(2, Date.valueOf(dateDatePicker.getValue()));
                    preparedStatement.setDate(3, Date.valueOf(returnDatePicker.getValue()));
                    preparedStatement.setString(4, descriptionTextField.getText());
                    preparedStatement.setString(5, addressTextField.getText());
                    preparedStatement.setString(6, product.getProductNaam());

                    preparedStatement.executeUpdate();
                }

            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            // Sluit het scherm na het opslaan
            detailStage.close();
        });

        //Button om een product te verwijderen uit de database
        Button deleteButton = new Button("Verwijder product");
        deleteButton.setOnMouseClicked(event -> {
            try (Connection connection = DriverManager.getConnection(DATABASE_URL, DATABASE_USERNAME, DATABASE_PASSWORD)) {
                String deleteQuery = "DELETE FROM product WHERE productNaam =?";

                try (PreparedStatement preparedStatement = connection.prepareStatement(deleteQuery)) {
                    preparedStatement.setString(1, product.getProductNaam());

                    preparedStatement.executeUpdate();
                }

            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            // Sluit het scherm na het verwijderen
            detailStage.close();
        });

        detailLayout.getChildren().addAll(
                new Label("Naam:"),
                nameTextField,
                new Label("Uitleendatum:"),
                dateDatePicker,
                new Label("Teruggeefdatum:"),
                returnDatePicker,
                new Label("Beschrijving:"),
                descriptionTextField,
                new Label("Adres:"),
                addressTextField,
                saveButton,
                deleteButton
        );

        Scene detailScene = new Scene(detailLayout, 400, 400);
        detailStage.setScene(detailScene);
        detailStage.show();
    }
}