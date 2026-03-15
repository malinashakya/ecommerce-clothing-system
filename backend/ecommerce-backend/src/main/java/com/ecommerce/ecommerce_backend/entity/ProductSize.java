package com.ecommerce.ecommerce_backend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "product_sizes")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductSize {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String size;

    private Integer stock;

    @ManyToOne
    @JoinColumn(name = "product_id")
    Product product;
}
