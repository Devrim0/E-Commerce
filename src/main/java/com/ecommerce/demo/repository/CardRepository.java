package com.ecommerce.demo.repository;

import com.ecommerce.demo.entities.Card;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CardRepository extends JpaRepository<Card, Long> {
    Optional<Card> findByCustomerId(Long customerId);
}