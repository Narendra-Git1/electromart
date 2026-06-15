package com.nari.electromart.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.nari.electromart.dto.ProductRequest;
import com.nari.electromart.entity.Category;
import com.nari.electromart.entity.Product;
import com.nari.electromart.repository.CategoryRepository;
import com.nari.electromart.repository.ProductRepository;

@Service
public class ProductServiceImpl
        implements ProductService {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    public ProductServiceImpl(
            ProductRepository productRepository,
            CategoryRepository categoryRepository) {

        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Product addProduct(ProductRequest request) {

        Category category =
                categoryRepository.findById(
                        request.getCategoryId())
                .orElseThrow(() ->
                        new RuntimeException(
                                "Category Not Found"));

        Product product = new Product();

        product.setName(request.getName());
        product.setDescription(request.getDescription());
        product.setPrice(request.getPrice());
        product.setStockQuantity(request.getStockQuantity());
        product.setImageUrl(request.getImageUrl());
        product.setCategory(category);

        return productRepository.save(product);
    }

    @Override
    public List<Product> getAllProducts() {

        return productRepository.findAll();
    }

    @Override
    public Product getProductById(Long id) {

        return productRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException(
                                "Product Not Found"));
    }

    @Override
    public Product updateProduct(
            Long id,
            Product product) {

        Product existingProduct =
                getProductById(id);

        existingProduct.setName(
                product.getName());

        existingProduct.setDescription(
                product.getDescription());

        existingProduct.setPrice(
                product.getPrice());

        existingProduct.setStockQuantity(
                product.getStockQuantity());

        existingProduct.setImageUrl(
                product.getImageUrl());

        existingProduct.setCategory(
                product.getCategory());

        return productRepository.save(
                existingProduct);
    }

    @Override
    public void deleteProduct(Long id) {

        productRepository.deleteById(id);
    }

    @Override
    public List<Product> getProductsByCategory(
            Long categoryId) {

        return productRepository
                .findByCategoryId(categoryId);
    }
}