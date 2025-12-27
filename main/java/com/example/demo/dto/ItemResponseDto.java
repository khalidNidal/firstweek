package com.example.demo.dto;

public class ItemResponseDto {

    private Long id;
    private String itemName;
    private int quantity;
    private double price;

    public ItemResponseDto() {}

    public ItemResponseDto(Long id, String itemName, int quantity, double price) {
        this.id = id;
        this.itemName = itemName;
        this.quantity = quantity;
        this.price = price;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getItemName() { return itemName; }
    public void setItemName(String itemName) { this.itemName = itemName; }

    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }
}
