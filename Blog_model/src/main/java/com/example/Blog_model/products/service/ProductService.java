package com.example.Blog_model.products.service;

import com.example.Blog_model.products.dto.ProductDTO;

import java.util.List;

public interface ProductService {

    ProductDTO createProduct(ProductDTO productDTO, Long idStore);


    List<ProductDTO> getListProductAllStore();

    List<ProductDTO> getListProductByStoreId(Long idStore);

    ProductDTO getProductWithId(Long idProduct, Long idStore);

    ProductDTO upDateProduct(Long idProduct, ProductDTO productDTO, Long idStore);

    void deleteProduct(Long idProduct, Long idStore);
}
