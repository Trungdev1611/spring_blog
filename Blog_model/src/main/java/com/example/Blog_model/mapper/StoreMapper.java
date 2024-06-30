package com.example.Blog_model.mapper;

import com.example.Blog_model.products.dto.ProductDTO;
import com.example.Blog_model.products.entity.Products;
import com.example.Blog_model.store.dto.StoreDTO;
import com.example.Blog_model.store.dto.StoreDTODetail;
import com.example.Blog_model.store.entity.Store;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.stream.Collectors;

@Mapper  //@Mapper: Annotation để đánh dấu interface này là một mapper của MapStruct.
public interface StoreMapper {

    StoreMapper INSTANCE = Mappers.getMapper(StoreMapper.class);

    Store storeDtoToStore(StoreDTO storeDTO);

    StoreDTO storeToStoreDTO(Store store);

    //tránh vòng lặp vô tận của store và product mà k dùng @JSonIgnore
    @Mapping(source = "products", target = "products", qualifiedByName = "toProductDTOList")
    StoreDTODetail storeToStoreDTODetail(Store store);

    @Named("toProductDTOList") //ánh xạ từ mapping bên trên vào day
    default List<ProductDTO> toProductDTOList(List<Products> products) {
        return products.stream().map(product -> {
            return   ProductMapper.INSTANCE.productToProductDTO(product);
        }).collect(Collectors.toList());

    }

    // update Store from data in storeDTO
    void updateStoreFromDTO(StoreDTO storeDTO, @MappingTarget Store store);
}
