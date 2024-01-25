package com.example.beroepsproduct.screens;
import com.example.beroepsproduct.classes.Database;
import java.time.LocalDate;
import java.util.Date;
import com.example.beroepsproduct.classes.Database;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

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
        primaryStage.show();

        Label NaamLabel = new Label("Product Naam:");
        GridPane.setConstraints(NaamLabel, 0, 0);

        TextField naamInput = new TextField();
        GridPane.setConstraints(naamInput, 1, 0);

        Label UitleendatumLabel = new Label("Datum van uitlenen:");
        GridPane.setConstraints(UitleendatumLabel, 0, 1);

        DatePicker uitleendatumInput = new DatePicker();
        uitleendatumInput.setPromptText("dd-MM-YYYY");
        GridPane.setConstraints(uitleendatumInput, 1, 1);

        Label TeruggeefdatumLabel = new Label("Datum van teruggave:");
        GridPane.setConstraints(TeruggeefdatumLabel, 0, 2);

        DatePicker teruggeefdatumInput = new DatePicker();
        teruggeefdatumInput.setPromptText("dd-MM-YYYY");
        GridPane.setConstraints(teruggeefdatumInput, 1, 2);

        Label BeschrijvingLabel = new Label("Productbeschrijving:");
        GridPane.setConstraints(BeschrijvingLabel, 0, 3);

        TextField beschrijvingInput = new TextField();
        GridPane.setConstraints(beschrijvingInput, 1, 3);

        Label ProductadresLabel = new Label("Uw thuisadres:");
        GridPane.setConstraints(ProductadresLabel, 0, 4);

        TextField ProductadresInput = new TextField();
        GridPane.setConstraints(ProductadresInput, 1, 4);

        Button voegToe = new Button("Voeg product toe");
        GridPane.setConstraints(voegToe, 1, 5);

        root.getChildren().addAll(NaamLabel, naamInput, UitleendatumLabel, uitleendatumInput, TeruggeefdatumLabel, teruggeefdatumInput,
                BeschrijvingLabel, beschrijvingInput, ProductadresLabel, ProductadresInput, voegToe);

        Database db = new Database();

        voegToe.setOnAction(e -> {
            String productNaam = naamInput.getText();
            LocalDate productUitleendatum = uitleendatumInput.getValue();
            LocalDate productTeruggeefdatum = teruggeefdatumInput.getValue();
            String productBeschrijving = beschrijvingInput.getText();
            String productAdres = ProductadresInput.getText();
            db.VoegProductToe(productNaam, productUitleendatum, productTeruggeefdatum, productBeschrijving, productAdres);
        });

        primaryStage.show();
    }

    public Scene getScene() {
        return scene;
    }
}