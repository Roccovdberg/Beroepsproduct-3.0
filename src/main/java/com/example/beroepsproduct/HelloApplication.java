package com.example.beroepsproduct;

import com.example.beroepsproduct.screens.Homescreen;
import com.example.beroepsproduct.screens.Login;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    private Button Inloggen;

    @Override
    public void start(Stage stage) throws IOException {
        // GridPane voor het opmaken van de lay-out
        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(20));
        gridPane.setVgap(10);
        gridPane.setAlignment(Pos.CENTER);

        // Scene initialiseren met de GridPane
        Scene scene = new Scene(gridPane, 800, 800);

        // Gebruikersnaam label en inputveld
        Label usernameLabel = new Label("Gebruikersnaam:");
        TextField usernameInput = new TextField();

        // Wachtwoord label en inputveld
        Label passwordLabel = new Label("Wachtwoord:");
        PasswordField passwordInput = new PasswordField();

        // Button om een account aan te maken
        Button inloggen = new Button("Maak account aan");
        inloggen.setOnAction(e -> {
            stage.setScene(new Login(stage).getScene());
            stage.show();
        });

        // Inloggen button
        Button loginButton = new Button("Inloggen");
        loginButton.setOnAction(e -> handleLogin(usernameInput.getText(), passwordInput.getText()));

        // Button om naar het homescreen te gaan
        Button naarHomescreen = new Button("Homepage!");
        naarHomescreen.setOnAction(e -> {
            Homescreen homescreen = new Homescreen(stage);
            stage.setScene(homescreen.getScene());
            stage.show();
        });

        // Elementen toevoegen aan de GridPane
        gridPane.add(usernameLabel, 0, 0);
        gridPane.add(usernameInput, 1, 0);
        gridPane.add(passwordLabel, 0, 1);
        gridPane.add(passwordInput, 1, 1);
        gridPane.add(inloggen, 0, 2);
        gridPane.add(loginButton, 1, 2);
        gridPane.add(naarHomescreen, 0, 3);

        // Titel instellen en Scene tonen
        stage.setTitle("MyTurn");
        stage.setScene(scene);
        stage.show();
    }

    private void handleLogin(String username, String password) {
        // Plaats hier je login validatie logica
        System.out.println("Inlogpoging met gebruikersnaam: " + username + " en wachtwoord: " + password);
    }
}