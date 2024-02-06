package com.example.beroepsproduct.classes;
import java.sql.Date;
import java.time.LocalDate;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;

public class Product {
//Data dat hoort bij een product
private String productNaam;
private Date productUitleendatum;
private Date productTeruggeefdatum;
private String productBeschrijving;
private final String productAdres;
    private Connection conn;

    //Constructor maken bij product
public Product(String productNaam, LocalDate productUitleendatum, LocalDate productTeruggeefdatum, String productBeschrijving, String productAdres) {
    this.productNaam = productNaam;
    this.productUitleendatum = Date.valueOf(productUitleendatum);
    this.productTeruggeefdatum = Date.valueOf(productTeruggeefdatum);
    this.productBeschrijving = productBeschrijving;
    this.productAdres = productAdres;
}
    public String getProductNaam() {return productNaam;}
    public void setProductNaam(String productNaam) {this.productNaam = productNaam;}
    public Date getProductUitleendatum() {return productUitleendatum;}
    public void setProductUitleendatum(Date productUitleendatum) {this.productUitleendatum = productUitleendatum;}
    public Date getProductTeruggeefdatum() {return productTeruggeefdatum;}
    public void setProductTeruggeefdatum(Date productTeruggeefdatum) {this.productTeruggeefdatum = productTeruggeefdatum;}
    public String getProductBeschrijving() {return productBeschrijving;}
    public void setProductBeschrijving(String productBeschrijving) {this.productBeschrijving = productBeschrijving;}
    public String getProductAdres() {return productAdres;}
    
}
