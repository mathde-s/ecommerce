package com.zup.ecommerce.utills;


import com.zup.ecommerce.DTOs.ProductRequestDTO;
import com.zup.ecommerce.DTOs.ProductResponseDTO;
import com.zup.ecommerce.models.Product;

public class ProductMapper {
    public static ProductResponseDTO toResponseDTO(Product product){
        return new ProductResponseDTO(product.getName(), product.getPrice(), product.getQuantity(), product.getId());
    }
    public static Product toEntity(ProductRequestDTO requestDTO){
        return new Product(requestDTO.getName(), requestDTO.getPrice(), requestDTO.getQuantity());
    }
}

