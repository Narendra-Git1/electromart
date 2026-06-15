package com.nari.electromart.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.nari.electromart.entity.Category;
import com.nari.electromart.repository.CategoryRepository;

@Service
public class CategoryServiceImpl
        implements CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(
            CategoryRepository categoryRepository) {

        this.categoryRepository = categoryRepository;
    }

    @Override
    public Category addCategory(
            Category category) {

        return categoryRepository.save(category);
    }

    @Override
    public List<Category> getAllCategories() {

        return categoryRepository.findAll();
    }

    @Override
    public Category getCategoryById(
            Long id) {

        return categoryRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException(
                                "Category Not Found"));
    }

    @Override
    public Category updateCategory(
            Long id,
            Category category) {

        Category existingCategory =
                getCategoryById(id);

        existingCategory.setName(
                category.getName());

        existingCategory.setDescription(
                category.getDescription());

        return categoryRepository.save(
                existingCategory);
    }

    @Override
    public void deleteCategory(Long id) {

        categoryRepository.deleteById(id);
    }
}