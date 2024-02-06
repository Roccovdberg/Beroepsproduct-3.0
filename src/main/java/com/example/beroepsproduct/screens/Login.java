package com.example.beroepsproduct.screens;

import com.example.beroepsproduct.classes.Database;
import com.example.beroepsproduct.classes.Inloggen;
import javafx.scene.Cursor;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.geometry.Insets;
import javafx.stage.Stage;

import java.io.IOException;

public class Login {

    private final Scene scene;

    public Login(Stage primaryStage) {
        GridPane root = new GridPane();
        root.setPadding(new Insets(20, 20, 20, 20));

        scene = new Scene(root, 800, 600);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Login Page");
        primaryStage.show();

        //Lijst om een account aan te maken
        Label usernameLabel = new Label("Gebruikersnaam:");
        GridPane.setConstraints(usernameLabel, 0, 0);

        TextField usernameInput = new TextField();
        GridPane.setConstraints(usernameInput, 1, 0);

        Label passwordLabel = new Label("Wachtwoord:");
        GridPane.setConstraints(passwordLabel, 0, 1);

        PasswordField passwordInput = new PasswordField();
        GridPane.setConstraints(passwordInput, 1, 1);

        Button loginButton = new Button("Inloggen");
        GridPane.setConstraints(loginButton, 1, 2);

        root.getChildren().addAll(usernameLabel, usernameInput, passwordLabel, passwordInput, loginButton);

        // Maak een instantie van Inloggen en Database buiten de event handlers
        Inloggen inloggen = new Inloggen();
        Database db = new Database();

        //Toevoegen van de ingvulde informatie aan de database
        loginButton.setOnAction(e -> {
            String gebruikersNaam = usernameInput.getText();
            String wachtWoord = passwordInput.getText();

            handleLogin(gebruikersNaam, wachtWoord);
            db.Maakaccount(gebruikersNaam, wachtWoord);
        });
        loginButton.setCursor(Cursor.HAND);
    }

    public void handleLogin(String username, String password) {
        // Plaats hier je login validatie logica
        System.out.println("Inlogpoging met gebruikersnaam: " + username + " en wachtwoord: " + password);
    }

    public Scene getScene() {
        return scene;
    }
}
