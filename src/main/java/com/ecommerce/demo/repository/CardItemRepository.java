package com.ecommerce.demo.repository;

import com.ecommerce.demo.entities.CardItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardItemRepository extends JpaRepository<CardItem, Long> {
}
