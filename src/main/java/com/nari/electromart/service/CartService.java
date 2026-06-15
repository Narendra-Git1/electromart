package com.nari.electromart.service;

import java.util.List;

import com.nari.electromart.dto.AddToCartRequest;
import com.nari.electromart.entity.CartItem;

public interface CartService {

    CartItem addToCart(AddToCartRequest request);

    List<CartItem> getCartItems(Long userId);

    void removeFromCart(Long cartItemId);
}