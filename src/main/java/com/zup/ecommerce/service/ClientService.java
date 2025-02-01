package com.zup.ecommerce.service;

import com.zup.ecommerce.DTOs.ClientRequestDTO;
import com.zup.ecommerce.DTOs.ClientResponseDTO;
import com.zup.ecommerce.exceptions.ExistingEntityException;
import com.zup.ecommerce.exceptions.NullArgumentException;
import com.zup.ecommerce.models.Client;
import com.zup.ecommerce.repository.ClientRepository;
import com.zup.ecommerce.utills.ClientMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ClientService {
    @Autowired
    private ClientRepository clientRepository;

    public ClientResponseDTO createClient(ClientRequestDTO clientRequestDTO){
        Client client = ClientMapper.toEntity(clientRequestDTO);

        if(clientRepository.existsByCpf(client.getCpf()))
            throw new ExistingEntityException("o CPF: "+client.getCpf()+" já está cadastrado a um cliente");
        if(clientRepository.existsByEmail(client.getEmail()))
            throw new ExistingEntityException("o email: "+client.getEmail()+" já esta cadastrado a um cliente");

        Client clientsSaved = clientRepository.save(client);
        return ClientMapper.toResponseDTO(clientsSaved);
    }

    public ClientResponseDTO getClientByCpf(String cpf) {
        if (cpf.isBlank())
            throw new NullArgumentException("o cpf não pode vir vazio");
        Client client = clientRepository.findByCpf(cpf);
        return ClientMapper.toResponseDTO(client);
    }

    public ClientResponseDTO updateClient(String cpf, ClientRequestDTO requestDTO){
        if (cpf.isBlank())
            throw new NullArgumentException("o cpf não pode vir vazio");
        Client clientExists = clientRepository.findByCpf(cpf);
        Client clientSaved = clientRepository.save(clientExists);
        return ClientMapper.toResponseDTO(clientSaved);
    }

    public void validCreate(ClientRequestDTO client){
        if (client == null)
            throw new NullArgumentException("Os dados do cliente não podem ser nulos.");
        if(clientRepository.existsByCpf(client.getCpf()))
            throw new ExistingEntityException("o CPF: "+client.getCpf()+" já está cadastrado a um cliente");
        if(clientRepository.existsByEmail(client.getEmail()))
            throw new ExistingEntityException("o email: "+client.getEmail()+" já esta cadastrado a um cliente");
    }
}
