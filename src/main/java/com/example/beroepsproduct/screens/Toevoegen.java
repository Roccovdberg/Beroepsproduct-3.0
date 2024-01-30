package com.example.beroepsproduct.screens;

import com.example.beroepsproduct.classes.Database;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.sql.Date;
import java.time.LocalDate;

public class Toevoegen {
    private final Scene scene;

    public Toevoegen(Stage primaryStage) {
        GridPane root = new GridPane();
        root.setPadding(new Insets(20, 20, 20, 20));
        root.setVgap(10);
        root.setHgap(10);

        scene = new Scene(root, 800, 600);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Product toevoegen");

        Label naamLabel = new Label("Product Naam:");
        GridPane.setConstraints(naamLabel, 0, 0);

        TextField naamInput = new TextField();
        GridPane.setConstraints(naamInput, 1, 0);

        Label uitleendatumLabel = new Label("Datum van uitlenen:");
        GridPane.setConstraints(uitleendatumLabel, 0, 1);

        DatePicker uitleendatumInput = new DatePicker();
        GridPane.setConstraints(uitleendatumInput, 1, 1);

        Label teruggeefdatumLabel = new Label("Datum van teruggave:");
        GridPane.setConstraints(teruggeefdatumLabel, 0, 2);

        DatePicker teruggeefdatumInput = new DatePicker();
        GridPane.setConstraints(teruggeefdatumInput, 1, 2);

        Label beschrijvingLabel = new Label("Productbeschrijving:");
        GridPane.setConstraints(beschrijvingLabel, 0, 3);

        TextField beschrijvingInput = new TextField();
        GridPane.setConstraints(beschrijvingInput, 1, 3);

        Label productadresLabel = new Label("Uw thuisadres:");
        GridPane.setConstraints(productadresLabel, 0, 4);

        TextField productadresInput = new TextField();
        GridPane.setConstraints(productadresInput, 1, 4);

        Button voegToe = new Button("Voeg product toe");
        GridPane.setConstraints(voegToe, 1, 5);

        root.getChildren().addAll(naamLabel, naamInput, uitleendatumLabel, uitleendatumInput, teruggeefdatumLabel, teruggeefdatumInput,
                beschrijvingLabel, beschrijvingInput, productadresLabel, productadresInput, voegToe);

        Database db = new Database();

        voegToe.setOnAction(e -> {
            try {
                String productNaam = naamInput.getText();
                LocalDate uitleenDatum = uitleendatumInput.getValue();
                LocalDate teruggeefDatum = teruggeefdatumInput.getValue();

                // Omzetting van LocalDate naar SQL Date
                Date productUitleendatum = Date.valueOf(uitleenDatum);
                Date productTeruggeefdatum = Date.valueOf(teruggeefDatum);

                String productBeschrijving = beschrijvingInput.getText();
                String productAdres = productadresInput.getText();

                // Zorg ervoor dat de productAdres een string is voordat je deze naar de database stuurt.
                db.VoegProductToe(productNaam, productUitleendatum.toLocalDate(), productTeruggeefdatum.toLocalDate(), productBeschrijving, productAdres);
            } catch (Exception ex) {
                ex.printStackTrace();
                // Mogelijk foutbeheer toevoegen om de gebruiker op de hoogte te stellen van problemen bij het toevoegen van het product.
            }
        });

        primaryStage.show();
    }

    public Scene getScene() {
        return scene;
    }
}