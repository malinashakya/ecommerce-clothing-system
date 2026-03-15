package com.ecommerce.ecommerce_backend.controller;

import com.ecommerce.ecommerce_backend.entity.Category;
import com.ecommerce.ecommerce_backend.repository.CategoryRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    private CategoryRepository categoryRepository;

    public CategoryController(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @PostMapping
    public Category addCategory(@RequestBody Category category) {
        return categoryRepository.save(category);
    }

    @GetMapping("/{categoryId}")
    public Optional<Category> getById(@PathVariable Long categoryId) {
        return categoryRepository.findById(categoryId);
    }

    @GetMapping
    public List<Category> getCategories() {
        return categoryRepository.findAll();
    }
}
