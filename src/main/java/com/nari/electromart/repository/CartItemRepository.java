package com.nari.electromart.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nari.electromart.entity.CartItem;

public interface CartItemRepository
        extends JpaRepository<CartItem, Long> {

    List<CartItem> findByUserId(Long userId);
}