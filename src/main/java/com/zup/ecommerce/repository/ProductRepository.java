package com.zup.ecommerce.repository;

import com.zup.ecommerce.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    boolean existsByName(String name);
    void deleteByName(String name);
    Product findByName(String name);
}
