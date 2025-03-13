package com.zup.ecommerce.DTOs;

import com.zup.ecommerce.models.Product;

import java.util.List;

public class BuyRequestDTO {

    private String cpf;
    private List<Product> products;

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
