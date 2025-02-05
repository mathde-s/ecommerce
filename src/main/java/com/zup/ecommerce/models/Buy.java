package com.zup.ecommerce.models;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Buy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade = CascadeType.PERSIST)
    private Client client;

    @ManyToMany
    private List<Product> products;

    private LocalDateTime BuyTime;

    public Buy() {}

    public Buy(Long id, Client client, List<Product> products) {
        this.id = id;
        this.client = client;
        this.products = products;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public LocalDateTime getBuyTime() {
        return BuyTime;
    }

    public void setBuyTime(LocalDateTime buyTime) {
        BuyTime = buyTime;
    }
}
