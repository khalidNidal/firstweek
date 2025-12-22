package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
@Entity
public class Item {
    @Id
    @GeneratedValue
    private Long id;

    @NotBlank
    private String itemName;

    @PositiveOrZero
    private int quantity;


    @Positive
    private double price;


    public Item() {

    }

    public Item(String name, int quantity, double price) {
        this.price = price;
        this.quantity = quantity;
        itemName = name;
    }

    public Long getId() {
        return id;
    }

    public String getItemName() {
        return itemName;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setPrice(double price) {
        this.price = price;
    }


}
