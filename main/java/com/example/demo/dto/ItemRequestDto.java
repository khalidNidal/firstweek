package com.example.demo.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;

public class ItemRequestDto {

    @NotBlank(message = "itemName is required")
    private String itemName;

    @PositiveOrZero(message = "quantity must be >= 0")
    private int quantity;

    @Positive(message = "price must be > 0")
    private double price;

    public String getItemName() { return itemName; }
    public void setItemName(String itemName) { this.itemName = itemName; }

    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }
}
