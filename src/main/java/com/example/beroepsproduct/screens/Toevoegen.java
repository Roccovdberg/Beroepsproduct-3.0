package com.example.beroepsproduct.screens;

import com.example.beroepsproduct.classes.Database;
import javafx.geometry.Insets;
import javafx.scene.Cursor;
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

        //Lijst om een product toe te voegen
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

        Database db = new Database();

        //Ingevulde informatie toevoegen aan de database
        voegToe.setOnAction(event -> {
            try {
                String productNaam = naamInput.getText();
                LocalDate uitleenDatum = uitleendatumInput.getValue();
                LocalDate teruggeefDatum = teruggeefdatumInput.getValue();

                // Omzetting van LocalDate naar SQL Date
                Date productUitleendatum = Date.valueOf(uitleenDatum);
                Date productTeruggeefdatum = Date.valueOf(teruggeefDatum);

                String productBeschrijving = beschrijvingInput.getText();
                String productAdres = productadresInput.getText();
                db.VoegProductToe(productNaam, productUitleendatum.toLocalDate(), productTeruggeefdatum.toLocalDate(), productBeschrijving, productAdres);
                db.createIndexProduct();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            voegToe.setCursor(Cursor.HAND);

        });
        Button naarHomescreen = new Button("Homepage!");
        GridPane.setConstraints(naarHomescreen, 1, 6);

        naarHomescreen.setOnAction(e -> {
            Homescreen homescreen = new Homescreen(primaryStage);
        });
        naarHomescreen.setCursor(Cursor.HAND);

        primaryStage.show();
        root.getChildren().addAll(naamLabel, naamInput, uitleendatumLabel, uitleendatumInput, teruggeefdatumLabel, teruggeefdatumInput,
                beschrijvingLabel, beschrijvingInput, productadresLabel, productadresInput, voegToe, naarHomescreen);
    }
    public Scene getScene() {
        return scene;
    }
}