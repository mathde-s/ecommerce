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
        if (product.getName() == null || product.getName().isEmpty()) {
            throw new NullArgumentException("O nome do produto não pode ser nulo ou vazio.");
        }
        if (productRepository.existsByName(product.getName()))
            throw new ExistingEntityException("o produto já existe!");
    }

    public List<ProductResponseDTO> getAllProducts() {
        return productRepository.findAll().stream()
                .map(ProductMapper::toResponseDTO)
                .collect(Collectors.toList());
    }
}
