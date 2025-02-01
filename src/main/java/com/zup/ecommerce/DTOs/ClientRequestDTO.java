package com.zup.ecommerce.DTOs;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.br.CPF;

public class ClientRequestDTO {

    @NotBlank(message = "o nome não pode ser nulo")
    private String name;

    @NotNull
    @CPF(message = "o CPF deve ser valido")
    private String cpf;

    @NotNull
    @Email(message = "o email deve ser válido")
    private String email;

    public ClientRequestDTO() {}

    public ClientRequestDTO(String name, String cpf, String email) {
        this.name = name;
        this.cpf = cpf;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
