package com.example.beroepsproduct.screens;

import com.example.beroepsproduct.classes.Database;
import javafx.geometry.Insets;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Contractmaken {
    private final Scene scene;

    public Contractmaken(Stage primaryStage) {
        GridPane root = new GridPane();
        root.setPadding(new Insets(20, 20, 20, 20));
        root.setVgap(10);
        root.setHgap(10);

        scene = new Scene(root, 800, 600);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Contract maken");

        //Lijst met dingen om in te vullen om een contract toe te voegen
        Label productNaamLabel = new Label("Productnaam");
        GridPane.setConstraints(productNaamLabel, 0, 0);

        TextField contractproductInput = new TextField();
        GridPane.setConstraints(contractproductInput, 1, 0);

        Label contractnummerLabel = new Label("Contractnummer");
        GridPane.setConstraints(contractnummerLabel, 0, 1);

        TextField contractnummerInput = new TextField();
        GridPane.setConstraints(contractnummerInput, 1, 1);

        Label uitlenerHandtekeningLabel = new Label("Uitlenerhandtekening");
        GridPane.setConstraints(uitlenerHandtekeningLabel, 0, 2);

        TextField uitlenerHandtekeningInput = new TextField();
        GridPane.setConstraints(uitlenerHandtekeningInput, 1, 2);

        Label lenerHandtekeningLabel = new Label("Lenerhandtekening");
        GridPane.setConstraints(lenerHandtekeningLabel, 0, 3);

        TextField lenerHandtekeningInput = new TextField();
        GridPane.setConstraints(lenerHandtekeningInput, 1, 3);

        Label schadevergoedingLabel = new Label("Schadevergoeding");
        GridPane.setConstraints(schadevergoedingLabel, 0, 4);

        TextField schadevergoedingInput = new TextField();
        GridPane.setConstraints(schadevergoedingInput, 1, 4);

        Button voegToe = new Button("Voeg contract toe");
        GridPane.setConstraints(voegToe, 1, 5);

        Database db = new Database();
        //Als op Button voegToe wordt gedrukt de ingevulde velden omzetten en toevoegen aan de database
        voegToe.setOnAction(event -> {
            try {
                String contractproduct = contractproductInput.getText();
                int contractnummer = Integer.parseInt(contractnummerInput.getText());
                String uitlenerHandtekening = uitlenerHandtekeningInput.getText();
                String lenerHandtekening = lenerHandtekeningInput.getText();
                int schadevergoeding = Integer.parseInt(schadevergoedingInput.getText());

                db.VoegContractToe(contractproduct, contractnummer, uitlenerHandtekening, lenerHandtekening, schadevergoeding);
            } catch (NumberFormatException ex) {
                System.out.println("");
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });

        primaryStage.show();
        Button naarHomescreen = new Button("Homepage!");
        GridPane.setConstraints(naarHomescreen, 1, 6);

        naarHomescreen.setOnAction(e -> {
            Homescreen homescreen = new Homescreen(primaryStage);
        });
        naarHomescreen.setCursor(Cursor.HAND);
        //Alles van de lijst op het scherm laten zien
        root.getChildren().addAll(productNaamLabel, contractproductInput, contractnummerLabel, contractnummerInput,
                uitlenerHandtekeningLabel, uitlenerHandtekeningInput, lenerHandtekeningLabel, lenerHandtekeningInput,
                schadevergoedingLabel, schadevergoedingInput, voegToe, naarHomescreen);
    }

    public Contractmaken(Scene scene) {
        this.scene = scene;
    }

    public Scene getScene() {
        return scene;
    }
}
