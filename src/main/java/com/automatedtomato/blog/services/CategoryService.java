package com.automatedtomato.blog.services;

import java.util.List;
import java.util.UUID;

import com.automatedtomato.blog.domain.entities.Category;

public interface CategoryService {
    List<Category> listCategories();
    Category createCategory(Category category);
    void deleteCategory(UUID id);
    Category getCategoryById(UUID id);
}
