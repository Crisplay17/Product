package com.spring.Product;

import jakarta.persistence.*;

@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer id;

    private String nume;
    private double pret;
    private int cantitate;
    private String descriere;

    public Product(){
    }

    public Product(String nume, double pret, int cantitate, String descriere) {
        this.nume = nume;
        this.pret = pret;
        this.cantitate = cantitate;
        this.descriere = descriere;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return nume;
    }

    public void setName(String nume) {
        this.nume = nume;
    }

    public double getPrice() {
        return pret;
    }

    public void setPrice(double pret) {
        this.pret = pret;
    }

    public int getQuantity() {
        return cantitate;
    }

    public void setQuantity(int cantitate) {
        this.cantitate = cantitate;
    }

    public String getDescription() {
        return descriere;
    }

    public void setDescription(String descriere) {
        this.descriere = descriere;
    }

}
