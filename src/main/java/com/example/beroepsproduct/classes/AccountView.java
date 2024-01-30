package com.example.beroepsproduct.classes;

import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

public class AccountView extends HBox {

    public AccountView(String accountNaam, String accountWachtwoord) {
        // Voeg accountinformatie toe aan de GUI-elementen
        Label nameLabel = new Label("Accountnaam: " + accountNaam);
        Label passwordLabel = new Label("Wachtwoord: " + accountWachtwoord);

        // Voeg GUI-elementen toe aan de HBox
        getChildren().addAll(nameLabel, passwordLabel);

        // Optioneel: Stijl of opmaak van de HBox aanpassen
        setSpacing(10);
        setStyle("-fx-background-color: #f0f0f0; -fx-padding: 10px; -fx-border-color: #cccccc;");
    }
}