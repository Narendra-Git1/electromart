package com.nari.electromart.service;

import java.util.List;

import com.nari.electromart.dto.ProductRequest;
import com.nari.electromart.entity.Product;

public interface ProductService {

    Product addProduct(ProductRequest request);

    List<Product> getAllProducts();

    Product getProductById(Long id);

    Product updateProduct(Long id,
                          Product product);

    void deleteProduct(Long id);

    List<Product> getProductsByCategory(Long categoryId);
}