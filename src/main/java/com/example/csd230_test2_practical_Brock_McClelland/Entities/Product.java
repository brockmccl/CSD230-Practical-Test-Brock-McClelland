package com.example.csd230_test2_practical_Brock_McClelland.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDateTime;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //String name
    //String description
    //double price
    //LocalDateTime createdAt  (use whatever Date type you like)
    //int stockQty
    private String name;
    private String description;
    private double price;
    private LocalDateTime createdAt;
    private int stockQty;

    public Product(){
        this.name = "Default";
        this.description = "Default Item";
        this.price = 0.00;
        this.createdAt = LocalDateTime.now();
        this.stockQty = 1;
    }

    public Product(String name, String description, double price, LocalDateTime createdAt, int stockQty){
        this.name = name;
        this.description = description;
        this.price = price;
        this.createdAt = createdAt;
        this.stockQty = stockQty;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public int getStockQty() {
        return stockQty;
    }

    public void setStockQty(int stockQty) {
        this.stockQty = stockQty;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", createdAt=" + createdAt +
                ", stockQty=" + stockQty +
                '}';
    }
}
