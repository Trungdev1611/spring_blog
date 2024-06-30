package com.example.Blog_model.products.respository;

import com.example.Blog_model.products.entity.Products;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Products, Long> {
    List<Products> findByStoreId(Long idStore);
}
