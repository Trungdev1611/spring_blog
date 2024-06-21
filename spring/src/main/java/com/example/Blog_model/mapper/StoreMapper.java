package com.example.Blog_model.mapper;

import com.example.Blog_model.store.dto.StoreDTO;
import com.example.Blog_model.store.dto.StoreDTODetail;
import com.example.Blog_model.store.entity.Store;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper  //@Mapper: Annotation để đánh dấu interface này là một mapper của MapStruct.
public interface StoreMapper {

    StoreMapper INSTANCE = Mappers.getMapper(StoreMapper.class);

    Store storeDtoToStore(StoreDTO storeDTO);

    StoreDTO storeToStoreDTO(Store store);
    StoreDTODetail storeToStoreDTODetail(Store store);
    // update Store from data in storeDTO
    void updateStoreFromDTO(StoreDTO storeDTO, @MappingTarget Store store);
}
