package com.zup.ecommerce.controller;

import com.zup.ecommerce.DTOs.BuyRequestDTO;
import com.zup.ecommerce.models.Buy;
import com.zup.ecommerce.service.BuyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/buy")
public class BuyController {

    @Autowired
    private BuyService buyService;

    @PostMapping
    public ResponseEntity<Buy> newBuy(@RequestBody BuyRequestDTO buy) {
        return ResponseEntity.ok(buyService.processBuy(buy));
    }
}
