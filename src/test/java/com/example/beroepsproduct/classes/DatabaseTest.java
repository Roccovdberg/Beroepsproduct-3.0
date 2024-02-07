package com.example.beroepsproduct.classes;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class DatabaseTest {
    private Database db;

    @BeforeEach
    void setup() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/beroepsproduct", "root", "");
            db = new Database();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    void maakaccount() {
        String gebruikersNaam = "testgebruiker";
        String wachtWoord = "testwachtwoord";
        db.Maakaccount(gebruikersNaam, wachtWoord);
    }

    @Test
    void voegProductToe() {
        String productNaam = "TestProduct";
        LocalDate productUitleendatum = LocalDate.now();
        LocalDate productTeruggeefdatum = LocalDate.now().plusDays(7);
        String productBeschrijving = "Dit is een testproduct";
        String productAdres = "Teststraat 123";
        db.VoegProductToe(productNaam, productUitleendatum, productTeruggeefdatum, productBeschrijving, productAdres);
    }

    @Test
    void updateProduct() {
        String productNaam = "TestProduct";
        LocalDate productUitleendatum = LocalDate.now();
        LocalDate productTeruggeefdatum = LocalDate.now().plusDays(7);
        String productBeschrijving = "Dit is een bijgewerkt testproduct";
        String productAdres = "Teststraat 123";
        db.updateProduct(productNaam, productUitleendatum, productTeruggeefdatum, productBeschrijving, productAdres);
    }

    @Test
    void verwijderProduct() {
        String productNaam = "TestProduct";
        db.verwijderProduct(productNaam, null, null, null, null);
    }

    @Test
    void voegContractToe() {
        String contractProduct = "TestProduct";
        int contractnummer = 123;
        String uitlenerHandtekening = "Uitlener";
        String lenerHandtekening = "Lener";
        int schadevergoeding = 100;
        db.VoegContractToe(contractProduct, contractnummer, uitlenerHandtekening, lenerHandtekening, schadevergoeding);
    }
}