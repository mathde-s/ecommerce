package com.zup.ecommerce.service;

import com.zup.ecommerce.DTOs.ProductRequestDTO;
import com.zup.ecommerce.DTOs.ProductResponseDTO;
import com.zup.ecommerce.models.Product;
import com.zup.ecommerce.repository.ProductRepository;
import com.zup.ecommerce.utills.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public ProductResponseDTO createProduct (ProductRequestDTO productRequestDTO){
        Product productSaved = ProductMapper.toEntity(productRequestDTO);
        validCreate(productSaved);
        productRepository.save(productSaved);
        return ProductMapper.toResponseDTO(productSaved);
    }
    public void validCreate(Product product){
//        if (product.getName())
            throw new RuntimeException("o produto já existe!");
    }

    public List<ProductResponseDTO> getAllProducts() {
        return productRepository.findAll().stream()
                .map(ProductMapper::toResponseDTO)
                .collect(Collectors.toList());
    }
}
