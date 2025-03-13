package com.zup.ecommerce.repository;

import com.zup.ecommerce.models.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
    Client findByCpf(String cpd);
    boolean existsByCpf(String cpf);
    boolean existsByEmail(String email);

}
