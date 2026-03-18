package com.ecommerce.ecommerce_backend.service;

import com.ecommerce.ecommerce_backend.dto.CategoryDTO;
import com.ecommerce.ecommerce_backend.entity.Category;
import com.ecommerce.ecommerce_backend.mapper.CategoryMapper;
import com.ecommerce.ecommerce_backend.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<CategoryDTO> getCategories() {
        List<Category> categories = categoryRepository.findAll();
        return categories.stream().map(CategoryMapper::toDTO).toList();
    }

    public CategoryDTO saveCategory(CategoryDTO dto) {
        Category category = CategoryMapper.toEntity(dto);
        Category saved = categoryRepository.save(category);
        return CategoryMapper.toDTO(saved);
    }

    public CategoryDTO getById(Long categoryId) {
        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new RuntimeException("Category not found !!!"));
        return CategoryMapper.toDTO(category);
    }
}
