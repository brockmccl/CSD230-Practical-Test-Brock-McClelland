package com.example.csd230_test2_practical_Brock_McClelland.Repositories;

import com.example.csd230_test2_practical_Brock_McClelland.Entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query("SELECT p FROM Product p WHERE (p.createdAt > :startDateTime AND p.createdAt < :endDateTime)")
    List<Product> findProductsBetween(LocalDateTime startDateTime, LocalDateTime endDateTime);
}
