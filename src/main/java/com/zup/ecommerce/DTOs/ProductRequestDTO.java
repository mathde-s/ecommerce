package com.zup.ecommerce.DTOs;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;

public class ProductRequestDTO {

    @NotNull(message = "o nome não pode ser nulo")
    private String name;

    @PositiveOrZero(message = "o preço deve ser maior ou igual a zero")
    private double price;

    @Positive(message = "a quantidade não pode ser meno que zero")
    private int quantity;
}
