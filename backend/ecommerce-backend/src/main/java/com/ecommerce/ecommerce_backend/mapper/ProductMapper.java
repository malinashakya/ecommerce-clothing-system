package com.ecommerce.ecommerce_backend.mapper;

import com.ecommerce.ecommerce_backend.dto.ProductDTO;
import com.ecommerce.ecommerce_backend.entity.Product;

public class ProductMapper {
    private ProductDTO toDTO(Product product) {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setId(product.getId());
        productDTO.setName(product.getName());
        productDTO.setDescription(productDTO.getDescription());
        productDTO.setPrice(productDTO.getPrice());
        productDTO.setBrand(product.getBrand());
        productDTO.setImage(product.getImage());

        if (product.getCategory() != null) {
            productDTO.setCategoryName(productDTO.getCategoryName());
        }
        return productDTO;
    }
}
