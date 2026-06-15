package com.nari.electromart.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.nari.electromart.dto.AddToCartRequest;
import com.nari.electromart.entity.CartItem;
import com.nari.electromart.entity.Product;
import com.nari.electromart.entity.User;
import com.nari.electromart.repository.CartItemRepository;
import com.nari.electromart.repository.ProductRepository;
import com.nari.electromart.repository.UserRepository;

@Service
public class CartServiceImpl implements CartService {

    private final CartItemRepository cartItemRepository;
    private final UserRepository userRepository;
    private final ProductRepository productRepository;

    public CartServiceImpl(
            CartItemRepository cartItemRepository,
            UserRepository userRepository,
            ProductRepository productRepository) {

        this.cartItemRepository = cartItemRepository;
        this.userRepository = userRepository;
        this.productRepository = productRepository;
    }

    @Override
    public CartItem addToCart(
            AddToCartRequest request) {

        User user = userRepository.findById(
                request.getUserId())
                .orElseThrow(() ->
                        new RuntimeException(
                                "User Not Found"));

        Product product = productRepository.findById(
                request.getProductId())
                .orElseThrow(() ->
                        new RuntimeException(
                                "Product Not Found"));

        CartItem cartItem = new CartItem();

        cartItem.setUser(user);
        cartItem.setProduct(product);
        cartItem.setQuantity(
                request.getQuantity());

        return cartItemRepository.save(
                cartItem);
    }

    @Override
    public List<CartItem> getCartItems(
            Long userId) {

        return cartItemRepository
                .findByUserId(userId);
    }

    @Override
    public void removeFromCart(
            Long cartItemId) {

        cartItemRepository.deleteById(
                cartItemId);
    }
}