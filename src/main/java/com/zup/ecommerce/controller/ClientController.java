package com.zup.ecommerce.controller;

import com.zup.ecommerce.DTOs.ClientRequestDTO;
import com.zup.ecommerce.DTOs.ClientResponseDTO;
import com.zup.ecommerce.service.ClientService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import org.hibernate.validator.constraints.br.CPF;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/client")
@Validated
public class ClientController {

    @Autowired
    private ClientService clienteService;

    @PostMapping
    public ResponseEntity<ClientResponseDTO> createClient(@Valid @RequestBody ClientRequestDTO clientRequestDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(clientService.createClient(clientRequestDTO));
    }

    @GetMapping("/{cpf}")
    public ResponseEntity<ClientResponseDTO> getClientByCPF(@PathVariable @CPF(message = "CPF inválido") String cpf) {
        return ResponseEntity.ok(clienteService.getClientByCpf(cpf));
    }
}
