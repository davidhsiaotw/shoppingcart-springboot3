package com.example.shopping.repository;

import com.example.shopping.entity.AbstractProduct;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<AbstractProduct, String> {
}
