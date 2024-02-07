package com.example.beroepsproduct.classes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;

public class Database {

    private Connection conn;
    private String host = "localhost";

    public Database() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            this.conn = DriverManager.getConnection("jdbc:mysql://" + host + "/beroepsproduct", "root", "");
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Connection getConnection() {
        return this.conn;
    }

    // Database verbinding voor account maken
    public void Maakaccount(String gebruikersNaam, String wachtWoord) {
        try (Statement stm = this.conn.createStatement()) {
            String s = "INSERT INTO account(Accountnaam, Accountwachtwoord) VALUES ('" + gebruikersNaam + "', '" + wachtWoord + "')";
            stm.execute(s);
            System.out.println("Account aangemaakt");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    // Database verbinding voor Product toevoegen
    public void VoegProductToe(String productNaam, LocalDate productUitleendatum, LocalDate productTeruggeefdatum, String productBeschrijving, String productAdres) {
        try (Statement stm = this.conn.createStatement()) {
            String s = "INSERT INTO product(Productnaam, Productuitleendatum, Productteruggeefdatum, Productbeschrijving, Productadres) VALUES ('" + productNaam + "', '" + productUitleendatum + "', '" + productTeruggeefdatum + "', '" + productBeschrijving + "', '" + productAdres + "')";
            stm.execute(s);
            System.out.println("Product toegevoegd");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    // Database verbinding voor Product updaten
    public void updateProduct(String productNaam, LocalDate productUitleendatum, LocalDate productTeruggeefdatum, String productBeschrijving, String productAdres) {
        try (Statement stm = this.conn.createStatement()) {
            String updateQuery = "UPDATE product SET "
                    + "Productnaam = '" + productNaam + "', "
                    + "Productuitleendatum = '" + productUitleendatum + "', "
                    + "Productteruggeefdatum = '" + productTeruggeefdatum + "', "
                    + "Productbeschrijving = '" + productBeschrijving + "', "
                    + "Productadres = '" + productAdres + "'"
                    + ";";
            stm.execute(updateQuery);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    // Database verbinding voor Product verwijderen
    public void verwijderProduct(String productNaam, LocalDate productUitleendatum, LocalDate productTeruggeefdatum, String productBeschrijving, String productAdres) {
        try (Statement stm = this.conn.createStatement()) {
            String s = "DELETE FROM product WHERE Productnaam = '" + productNaam + "'";
            stm.execute(s);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    // Database verbinding voor Contract toevoegen
    public void VoegContractToe(String contractProduct, int contractnummer, String uitlenerHandtekening, String lenerHandtekening, int schadevergoeding) {
        try (Statement stm = this.conn.createStatement()) {
            String s = "INSERT INTO Contract(contractproduct, contractnummer, uitlenerHandtekening, lenerHandtekening, schadevergoeding) VALUES ('" + contractProduct + "', '" + contractnummer + "', '" + uitlenerHandtekening + "', '" + lenerHandtekening + "', '" + schadevergoeding + "')";
            stm.execute(s);
            System.out.println("Contract toegevoegd");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
