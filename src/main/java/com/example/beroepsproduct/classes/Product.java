package com.example.beroepsproduct.classes;
import java.sql.Date;


public class Product {
//Data dat hoort bij een product
private String productNaam;
private Date productUitleendatum;
private Date productTeruggeefdatum;
private String productBeschrijving;
private final String productAdres;

//Constructor maken bij product
public Product(String productNaam, Date productUitleendatum, Date productTeruggeefdatum, String productBeschrijving, String productAdres) {
    this.productNaam = productNaam;
    this.productUitleendatum = productUitleendatum;
    this.productTeruggeefdatum = productTeruggeefdatum;
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
