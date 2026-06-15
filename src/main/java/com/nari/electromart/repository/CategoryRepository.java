package com.nari.electromart.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nari.electromart.entity.Category;

@Repository
public interface CategoryRepository
        extends JpaRepository<Category, Long> {

}