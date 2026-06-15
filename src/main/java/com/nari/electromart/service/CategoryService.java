package com.nari.electromart.service;

import java.util.List;

import com.nari.electromart.entity.Category;

public interface CategoryService {

    Category addCategory(Category category);

    List<Category> getAllCategories();

    Category getCategoryById(Long id);

    Category updateCategory(Long id,
                            Category category);

    void deleteCategory(Long id);
}