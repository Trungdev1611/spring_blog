package com.example.Blog_model.store.service;

import com.example.Blog_model.store.dto.StoreDTO;

import java.util.List;

public interface StoreService {
    StoreDTO createStore(StoreDTO storeDTO);
    List<StoreDTO> getListStore();

    StoreDTO getStoreWithId(Long idStore);

    StoreDTO upDateStore(Long idStore, StoreDTO storeDTO);
    void deleteStore(Long idStore);
}
