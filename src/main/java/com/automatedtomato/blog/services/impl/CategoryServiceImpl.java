package com.automatedtomato.blog.services.impl;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.automatedtomato.blog.domain.entities.Category;
import com.automatedtomato.blog.repositories.CategoryRepository;
import com.automatedtomato.blog.services.CategoryService;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    @Override
    public List<Category> listCategories() {
        return categoryRepository.findAllWithPostCount();
    }

    @Override
    public Category createCategory(Category category) {
        // 同じ名前のカテゴリがすでにないかチェック
        if (categoryRepository.existsByNameIgnoreCase(category.getName())) {
            throw new IllegalArgumentException("Category name already exists with name: " + category.getName());
        }
        return categoryRepository.save(category);
    }

    @Override
    public void deleteCategory(UUID id) {
        Optional<Category> category = categoryRepository.findById(id);
        if (category.isPresent()) {
            if (!category.get().getPosts().isEmpty()) {
                throw new IllegalArgumentException("Category has posts associated with it");
            }
            categoryRepository.deleteById(id);
        }
    }

    @Override
    public Category getCategoryById(UUID id) {
        return categoryRepository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Category does not exist with id: " + id));
    }
}
