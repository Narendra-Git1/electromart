package com.nari.electromart.controller;

import java.util.List;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.nari.electromart.dto.AddToCartRequest;
import com.nari.electromart.entity.CartItem;
import com.nari.electromart.service.CartService;

@RestController
@RequestMapping("/api/cart")
public class CartController {

    private final CartService cartService;

    public CartController(
            CartService cartService) {

        this.cartService = cartService;
    }

    @PreAuthorize("hasAnyRole('USER','ADMIN')")
    @PostMapping("/add")
    public CartItem addToCart(
            @RequestBody AddToCartRequest request) {

        return cartService.addToCart(request);
    }

    @PreAuthorize("hasAnyRole('USER','ADMIN')")
    @GetMapping("/{userId}")
    public List<CartItem> getCartItems(
            @PathVariable Long userId) {

        return cartService.getCartItems(
                userId);
    }

    @PreAuthorize("hasAnyRole('USER','ADMIN')")
    @DeleteMapping("/remove/{cartItemId}")
    public String removeFromCart(
            @PathVariable Long cartItemId) {

        cartService.removeFromCart(
                cartItemId);

        return "Item Removed From Cart";
    }
}