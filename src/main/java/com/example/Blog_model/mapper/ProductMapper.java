package com.example.Blog_model.mapper;

import com.example.Blog_model.products.dto.ProductDTO;
import com.example.Blog_model.products.entity.Products;
import com.example.Blog_model.store.dto.StoreDTO;
import com.example.Blog_model.store.entity.Store;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper  //@Mapper: Annotation để đánh dấu interface này là một mapper của MapStruct.
public interface ProductMapper {

    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    Products productDtoToProduct(ProductDTO storeDTO);

    ProductDTO productToProductDTO(Products product);

    // update Store from data in storeDTO
    void updateProductFromDTO(ProductDTO productDTO, @MappingTarget Products product);
}
