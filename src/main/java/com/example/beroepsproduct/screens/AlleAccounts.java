package com.example.beroepsproduct.screens;

import com.example.beroepsproduct.classes.AccountView;
import com.example.beroepsproduct.classes.Database;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AlleAccounts extends Parent {

    public AlleAccounts(Stage stage) {
        VBox root = new VBox(10);
        Scene scene = new Scene(new ScrollPane(root), 1024, 600);

        stage.setTitle("Alle accounts in myTurn");
        stage.setScene(scene);
        stage.show();

        Button naarHomescreen = new Button("Homepage!");
        naarHomescreen.setOnAction(e -> {
            Homescreen homescreen = new Homescreen(stage);
            Scene homescreenScene = new Scene(homescreen, 800, 600);
            stage.setScene(homescreen.getScene());
            stage.show();
        });

        // VBox waar de accounts in komen te staan
        VBox content = new VBox(10);
        ScrollPane scrollPane = new ScrollPane(content);

        // Accounts ophalen uit de database en laten zien
        try {
            Database connector = new Database();
            ResultSet accounts = connector.getConnection().createStatement().executeQuery("SELECT * FROM account");

            while (accounts.next()) {
                // Voeg informatie toe aan de GUI
                String Accountnaam = accounts.getString("Accountnaam");
                String Accountwachtwoord = accounts.getString("Accountwachtwoord");

                content.getChildren().add(new AccountView(Accountnaam, Accountwachtwoord));
            }
        } catch (SQLException e) {
            // Toon foutmelding aan de gebruiker
            System.err.println("Fout bij ophalen van accounts: " + e.getMessage());
        }

        root.getChildren().add(scrollPane);
    }

    @Override
    public Node getStyleableNode() {
        return super.getStyleableNode();
    }
}
