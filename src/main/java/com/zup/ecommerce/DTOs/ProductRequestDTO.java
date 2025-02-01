package com.zup.ecommerce.DTOs;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;

public class ProductRequestDTO {

    @NotBlank(message = "o nome não pode ser nulo")
    private String name;

    @PositiveOrZero(message = "o preço deve ser maior ou igual a zero")
    private double price;

    @Positive(message = "a quantidade não pode ser meno que zero")
    private int quantity;


    public ProductRequestDTO() {
    }

    public ProductRequestDTO(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
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
