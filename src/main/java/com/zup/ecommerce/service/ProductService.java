package com.zup.ecommerce.service;

import com.zup.ecommerce.DTOs.ProductRequestDTO;
import com.zup.ecommerce.DTOs.ProductResponseDTO;
import com.zup.ecommerce.exceptions.ExistingEntityException;
import com.zup.ecommerce.exceptions.InvalidArgumentException;
import com.zup.ecommerce.exceptions.ResourceNotFoundException;
import com.zup.ecommerce.models.Product;
import com.zup.ecommerce.repository.ProductRepository;
import com.zup.ecommerce.utills.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    private void validCreate(Product product){
        if (product.getPrice() <= 0) {
            throw new InvalidArgumentException("O preço deve ser maior que 0.");
        }
        if (product.getQuantity() < 0) {
            throw new InvalidArgumentException("A quantidade deve ser maior ou igual a 0.");
        }
        if (productRepository.existsByName(product.getName()))
            throw new ExistingEntityException("o produto já existe!");
    }

    public List<ProductResponseDTO> getAllProducts() {
        return productRepository.findAll().stream()
                .map(ProductMapper::toResponseDTO)
                .collect(Collectors.toList());
    }

    @Transactional
    public void deleteProduct(String name) {
        if (!productRepository.existsByName(name)) {
            throw new ResourceNotFoundException("Produto não existe.");
        }
        productRepository.deleteByName(name);
    }
}
