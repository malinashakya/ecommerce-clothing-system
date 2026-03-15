package com.ecommerce.ecommerce_backend.repository;

import com.ecommerce.ecommerce_backend.entity.ProductSize;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductSizeRepository extends JpaRepository<ProductSize, Long> {
}
