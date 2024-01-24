package com.example.beroepsproduct.classes;

import javafx.scene.Node;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Product {

    private Statement stm;
    private Database db;
    public Product(ResultSet producten){
        this.db = new Database();

    }

    public void addProduct(){

        String s = "INSERT....";
        try {
            stm = db.getConnection().createStatement();
            stm.execute(s);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

    public void wijzigProduct(){

    }

    public void delProduct(int id){

    }

    public Node show() {
    }
}
