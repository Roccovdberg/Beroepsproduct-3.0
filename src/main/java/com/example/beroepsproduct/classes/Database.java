package com.example.beroepsproduct.classes;

import java.sql.*;
import java.sql.Date;

public class Database {

    private Connection conn;
    private String host = "localhost";

    public Database() {
        try {
            this.conn = DriverManager.getConnection("jdbc:mysql://" + host + "/beroepsproduct", "root", "");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Connection getConnection() {
        return this.conn;
    }

    // Database verbinding voor account maken
    public void Maakaccount(String gebruikersNaam, String wachtWoord) {
        try {
            Statement stm = this.conn.createStatement();
            String s = "INSERT INTO account(Accountnaam, Accountwachtwoord) VALUES ('" + gebruikersNaam + "', '" + wachtWoord + "')";
            stm.execute(s);
            System.out.println("Account aangemaakt");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    // Database verbinding voor Product toevoegen
    public void VoegProductToe(String productNaam, Date productUitleendatum, Date productTeruggeefdatum, String productBeschrijving, String productAdres) {
        try {
            Statement stm = this.conn.createStatement();
            String s = "INSERT INTO product(Productnaam, Productuitleendatum, Productteruggeefdatum, Productbeschrijving, Productadres) VALUES ('" + productNaam + "', '" + productUitleendatum + "', '" + productTeruggeefdatum + "', '" + productBeschrijving + "', '" + productAdres + "')";
            stm.execute(s);
            System.out.println("Product toegevoegd");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}