package com.nari.electromart.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nari.electromart.entity.Product;

public interface ProductRepository
        extends JpaRepository<Product, Long> {

    List<Product> findByCategoryId(Long categoryId);
}