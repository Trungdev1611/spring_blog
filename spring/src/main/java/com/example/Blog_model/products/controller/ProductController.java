package com.example.Blog_model.products.controller;


import com.example.Blog_model.products.dto.ProductDTO;
import com.example.Blog_model.products.service.ProductImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {
    @Autowired
    private ProductImpl productImpl;

    @PostMapping("/store/{idStore}/product/create")
    ResponseEntity<ProductDTO> createProduct(@RequestBody ProductDTO productDTO, @PathVariable Long idStore) {

        ProductDTO response = productImpl.createProduct(productDTO, idStore);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/store/{idStore}/products")
    ResponseEntity<List<ProductDTO>> getListProduct(@PathVariable Long idStore) {

        List<ProductDTO> response = productImpl.getListProduct(idStore);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/store/{idStore}/products/{idProduct}")
    ResponseEntity<ProductDTO> getListProduct(@PathVariable Long idProduct, @PathVariable Long idStore) {

        ProductDTO response = productImpl.getProductWithId(idProduct, idStore);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping("/store/{idStore}/products/{idProduct}")
    ResponseEntity<ProductDTO> updateProduct(@PathVariable Long idProduct, @RequestBody ProductDTO productDTO, @PathVariable Long idStore) {

        ProductDTO response = productImpl.upDateProduct(idProduct, productDTO, idStore);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/store/{idStore}/products/{idProduct}")
    ResponseEntity<ProductDTO> deleteProduct(@PathVariable Long idProduct, @PathVariable Long idStore) {
        productImpl.deleteProduct(idProduct, idStore);
        return new ResponseEntity<>(null, HttpStatus.OK);
    }
}