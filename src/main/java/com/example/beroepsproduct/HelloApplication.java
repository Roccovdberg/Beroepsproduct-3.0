package com.example.beroepsproduct;

import com.example.beroepsproduct.screens.Homescreen;
import com.example.beroepsproduct.screens.Login;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    // Scherm aanmaken

    public void start(Stage stage) throws IOException {
        GridPane loginGridPane = new GridPane(); // GridPane voor inlogscherm
        loginGridPane.setPadding(new Insets(20));
        loginGridPane.setVgap(10);
        loginGridPane.setAlignment(Pos.CENTER);

        GridPane mainGridPane = new GridPane(); // GridPane voor hoofdscherm
        mainGridPane.setPadding(new Insets(20));
        mainGridPane.setVgap(10);
        mainGridPane.setAlignment(Pos.CENTER);

        Label usernameLabel = new Label("Gebruikersnaam:");
        TextField usernameInput = new TextField();

        Label passwordLabel = new Label("Wachtwoord:");
        PasswordField passwordInput = new PasswordField();

        Button inloggen = new Button("Maak account aan");
        inloggen.setOnAction(e -> {
            Login login = new Login(stage);
            Scene loginScene = new Scene(login.getScene().getRoot(), 800, 600);
            stage.setScene(loginScene);
            stage.show();
        });
        inloggen.setCursor(Cursor.HAND);

        Button loginButton = new Button("Inloggen");
        //oginButton.setOnAction(e -> handleLogin(usernameInput.getText(), passwordInput.getText(), new Homescreen(stage)));
        loginButton.setCursor(Cursor.HAND);

        Button naarHomescreen = new Button("Homepage!");
        naarHomescreen.setOnAction(e -> {
            Homescreen homescreen = new Homescreen(stage);
        });
        naarHomescreen.setCursor(Cursor.HAND);

        loginGridPane.add(usernameLabel, 0, 0);
        loginGridPane.add(usernameInput, 1, 0);
        loginGridPane.add(passwordLabel, 0, 1);
        loginGridPane.add(passwordInput, 1, 1);
        loginGridPane.add(inloggen, 0, 2);
        loginGridPane.add(loginButton, 1, 2);
        loginGridPane.add(naarHomescreen, 0, 3);

        Scene loginScene = new Scene(loginGridPane, 800, 600); // Inlogscene

        stage.setTitle("MyTurn");
        stage.setScene(loginScene); // Stel inlogscene in als begin scene
        stage.show();
    }


}