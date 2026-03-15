package com.ecommerce.ecommerce_backend.controller;

import com.ecommerce.ecommerce_backend.entity.Product;
import com.ecommerce.ecommerce_backend.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController
{
    private final ProductService productService;

    public ProductController(ProductService productService){
        this.productService = productService;
    }

    @PostMapping("/add")
    public Product addProduct(@RequestBody Product product, @RequestParam Long categoryId)
    {
        return productService.addProduct(product,categoryId);
    }

    @GetMapping
    public List<Product> getProducts()
    {
        return productService.getAllProducts();
    }

    @GetMapping("/{id}")
    public Product getProduct(@PathVariable Long productId)
    {
        return productService.getProductById(productId);
    }
}
