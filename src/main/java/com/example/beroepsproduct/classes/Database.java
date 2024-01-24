package com.example.beroepsproduct.classes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Database {

    private Connection conn;
    private String host = "localhost";
    public Database(){

        try {
            this.conn = DriverManager.getConnection("jdbc:mysql://"+ host +"/beroepsproduct", "root","");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public Connection getConnection(){
        return this.conn;
    }
    public void Maakaccount(String gebruikersNaam, String wachtWoord) {

        try {
            Statement stm = this.conn.createStatement();
//            String s = "INSERT INTO account Accountnaam, Accountwachtwoord  VALUES ('" + gebruikersNaam + "', '" + wachtWoord + "');";
            String s = "INSERT INTO account(Accountnaam, Accountwachtwoord) "+"  VALUES ('" + gebruikersNaam + "', '" + wachtWoord + "')";
            stm.execute(s);
            System.out.println("Account aangemaakt");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }



}
