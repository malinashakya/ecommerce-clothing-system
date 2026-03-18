package com.ecommerce.ecommerce_backend.mapper;

import com.ecommerce.ecommerce_backend.dto.ProductDTO;
import com.ecommerce.ecommerce_backend.entity.Product;

public class ProductMapper {

    public static ProductDTO toDTO(Product product) {
        ProductDTO dto = new ProductDTO();

        dto.setId(product.getId());
        dto.setName(product.getName());
        dto.setDescription(product.getDescription());
        dto.setPrice(product.getPrice());
        dto.setBrand(product.getBrand());
        dto.setImage(product.getImage());

        if (product.getCategory() != null) {
            dto.setCategoryId(product.getCategory().getId());
            dto.setCategoryName(product.getCategory().getName());
        }

        return dto;
    }

    public static Product toEntity(ProductDTO dto) {
        Product product = new Product();

        product.setId(dto.getId());
        product.setName(dto.getName());
        product.setDescription(dto.getDescription());
        product.setPrice(dto.getPrice());
        product.setBrand(dto.getBrand());
        product.setImage(dto.getImage());

        return product;
    }
}