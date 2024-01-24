package com.example.beroepsproduct.screens;

import com.example.beroepsproduct.screens.Homescreen;
import com.example.beroepsproduct.screens.Login;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;


public class HelloApplications {
    private Scene scene;
    public HelloApplications(Stage stage) {
        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(20, 20, 20, 20));
        gridPane.setVgap(10);

        Scene scene = new Scene(gridPane, 800, 600);
        //Button om een account aan te maken
        Button inloggen = new Button("Maak account aan");
        GridPane.setConstraints(inloggen, 1, 2); // Rij 2, Kolom 1
        inloggen.setOnAction(e -> {
            //Login screen2 = new Login(stage);
            stage.setScene(new Login(stage).getScene());
            stage.show();
//            stage.setScene(screen2.getScene());

        });

        Label usernameLabel = new Label("Gebruikersnaam:");
        GridPane.setConstraints(usernameLabel, 0, 0);

        TextField usernameInput = new TextField();
        GridPane.setConstraints(usernameInput, 1, 0);

        Label passwordLabel = new Label("Wachtwoord:");
        GridPane.setConstraints(passwordLabel, 0, 1);

        PasswordField passwordInput = new PasswordField();
        GridPane.setConstraints(passwordInput, 1, 1);

        Button loginButton = new Button("Inloggen");
        GridPane.setConstraints(loginButton, 1, 3); // Rij 3, Kolom 1
        loginButton.setOnAction(e -> handleLogin(usernameInput.getText(), passwordInput.getText()));


        Button naarHomescreen = new Button("Homepage!");
        GridPane.setConstraints(naarHomescreen, 3, 6); // Rij 2, Kolom 1
        naarHomescreen.setOnAction(e -> {
            Homescreen homescreen = new Homescreen(stage);
            stage.setScene(homescreen.getScene());  // Roep getScene() aan op de Homescreen-instantie
            stage.show();
        });hoi
        
        gridPane.getChildren().addAll(inloggen, usernameLabel, usernameInput, passwordLabel, passwordInput, loginButton, naarHomescreen);

        // Centreren van de GridPane in het midden bovenin
        gridPane.setTranslateX((scene.getWidth() - gridPane.getBoundsInParent().getWidth()) / 2);
        gridPane.setTranslateY(50);

        scene = new Scene(gridPane);
        scene.getStylesheets().add(getClass().getResource("/styles.css").toString());


    }

    public HelloApplications(Scene scene) {
        this.scene = scene;
    }

    private void handleLogin(String username, String password) {
        // Plaats hier je login validatie logica
        System.out.println("Inlogpoging met gebruikersnaam: " + username + " en wachtwoord: " + password);
    }

    public Scene getScene() {
        return scene;
    }
}