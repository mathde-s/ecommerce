package com.zup.ecommerce.repository;

import com.zup.ecommerce.models.Buy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BuyRepository extends JpaRepository<Buy, Long> {
}
