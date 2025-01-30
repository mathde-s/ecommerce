package com.zup.ecommerce.DTOs;

public class ProductResponseDTO {
    private Long id;
    private String name;
    private double price;
    private int quantity;

    public ProductResponseDTO() {}

    public ProductResponseDTO(String name, double price, int quantity, Long id) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
