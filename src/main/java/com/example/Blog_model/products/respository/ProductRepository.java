package com.example.Blog_model.products.respository;

import com.example.Blog_model.products.entity.Products;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Products, Long> {
}
