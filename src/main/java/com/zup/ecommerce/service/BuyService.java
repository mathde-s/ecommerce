package com.zup.ecommerce.service;

import com.zup.ecommerce.DTOs.BuyRequestDTO;
import com.zup.ecommerce.DTOs.ClientResponseDTO;
import com.zup.ecommerce.exceptions.InvalidArgumentException;
import com.zup.ecommerce.models.Buy;
import com.zup.ecommerce.models.Client;
import com.zup.ecommerce.models.Product;
import com.zup.ecommerce.repository.BuyRepository;
import com.zup.ecommerce.repository.ProductRepository;
import com.zup.ecommerce.utills.ClientMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class BuyService {

    @Autowired
    private ClientService clientService;
    @Autowired
    private BuyRepository buyRepository;
    @Autowired
    private ProductRepository productRepository;

    @Transactional
    public Buy processBuy(BuyRequestDTO buy) {

        if (buy.getProducts() == null || buy.getProducts().isEmpty()) {
            throw new InvalidArgumentException("Nenhum produto foi informado para a compra.");
        }
        ClientResponseDTO clientResponse = clientService.getClientByCpf(buy.getCpf());
        Client client = ClientMapper.requestToEntity(clientResponse);

        List<Product> availableProducts  = new ArrayList<>();
        List<String> missingProducts  = new ArrayList<>();

        for (Product requestProduct : buy.getProducts()) {
            Product product = productRepository.findByName(requestProduct.getName());
            if (product.getQuantity() <= 0) {
                missingProducts.add(requestProduct.getName());
            } else {
                product.setQuantity(product.getQuantity() - 1);
                availableProducts.add(product);
            }
        }
        if (!missingProducts.isEmpty())
            throw new InvalidArgumentException("Produto em falta: " + String.join(", ", missingProducts ));
        productRepository.saveAll(availableProducts);
        Client clientSaved = clientService.saveClient(client);
        Buy purchase = createBuy(clientSaved,availableProducts);

        return buyRepository.save(purchase);
    }
    private Buy createBuy(Client client, List<Product> products){
        Buy purchase = new Buy();
        purchase.setClient(client);
        purchase.setProducts(products);
        purchase.setBuyTime(LocalDateTime.now());
        return purchase;
    }

}
