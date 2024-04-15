package com.example.beroepsproduct.classes;

import java.sql.*;
import java.time.LocalDate;

public class Database {

    private static Connection conn;
    private String host = "adainforma.tk";

    public Database() {
        //Verbinding Database
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            this.conn = DriverManager.getConnection("jdbc:mysql://" + host + ":3306/bp2_myturn", "myturn", "800u~1Tsd");
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Connection getConnection() {
        return this.conn;
    }

    // Query voor account maken
    public void Maakaccount(String gebruikersNaam, String wachtWoord) {
        try (Statement stm = this.conn.createStatement()) {
            String s = "INSERT INTO account(Accountnaam, Accountwachtwoord) VALUES ('" + gebruikersNaam + "', '" + wachtWoord + "')";
            stm.execute(s);
            System.out.println("Account aangemaakt");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    // Query voor Product toevoegen
    public void VoegProductToe(String productNaam, LocalDate productUitleendatum, LocalDate productTeruggeefdatum, String productBeschrijving, String productAdres) {
        try (Statement stm = this.conn.createStatement()) {
            String s = "INSERT INTO product(Productnaam, Productuitleendatum, Productteruggeefdatum, Productbeschrijving, Productadres) VALUES ('" + productNaam + "', '" + productUitleendatum + "', '" + productTeruggeefdatum + "', '" + productBeschrijving + "', '" + productAdres + "')";
            stm.execute(s);
            System.out.println("Product toegevoegd");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //Query voor Index op product toevoegen
    public void maakIndexProduct() {
        try (Statement stm = this.conn.createStatement()) {
            // Check if index exists
            ResultSet rs = stm.executeQuery("SHOW INDEX FROM product WHERE Key_name = 'idx_productnaam'");
            if (!((ResultSet) rs).next()) {
                // Index does not exist, so create it
                String query = "CREATE INDEX idx_productnaam ON product(Productnaam)";
                stm.execute(query);
                System.out.println("Index 'idx_productnaam' created.");
            } else {
                System.out.println("Index 'idx_productnaam' already exists.");

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //Query voor Sorteren op Productnamen
    public static void GroupByVoegProductToe() {
        try (Statement stm = conn.createStatement()) {
            String query = "SELECT Productnaam FROM product GROUP BY Productnaam";
            stm.execute(query);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    // Query voor Product updaten
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

    //Query voor Product verwijderen
    public void verwijderProduct(String productNaam, LocalDate productUitleendatum, LocalDate productTeruggeefdatum, String productBeschrijving, String productAdres) {
        try (Statement stm = this.conn.createStatement()) {
            String s = "DELETE FROM product WHERE Productnaam = '" + productNaam + "'";
            stm.execute(s);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //Query voor Contract toevoegen
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
