package com.zup.ecommerce.utills;

import com.zup.ecommerce.DTOs.ClientRequestDTO;
import com.zup.ecommerce.DTOs.ClientResponseDTO;
import com.zup.ecommerce.models.Client;

public class ClientMapper {
    public static ClientResponseDTO toResponseDTO(Client client){
        return new ClientResponseDTO(
                client.getName(),
                client.getCpf(),
                client.getEmail(),
                client.getId());
    }
    public static Client toEntity(ClientRequestDTO requestDTO){
        return new Client(
                requestDTO.getName(),
                requestDTO.getCpf(),
                requestDTO.getEmail());
    }
}
