package com.example.Blog_model.store.service;

import com.example.Blog_model.exception.NotFoundEx;
import com.example.Blog_model.mapper.StoreMapper;
import com.example.Blog_model.store.dto.StoreDTO;
import com.example.Blog_model.store.dto.StoreDTODetail;
import com.example.Blog_model.store.entity.Store;
import com.example.Blog_model.store.respository.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StoreImpl implements StoreService {
    @Autowired
    private StoreRepository storeRepository;
    private final StoreMapper storeMapper = StoreMapper.INSTANCE;

    @Override
    public StoreDTO createStore(StoreDTO storeDTO) {
        Store newStore = storeMapper.storeDtoToStore(storeDTO);
        storeRepository.save(newStore);
        return storeDTO;
    }

    @Override
    public List<StoreDTO> getListStore() {

        return storeRepository.findAll().stream()
                .map(storeMapper::storeToStoreDTO
                )
                .collect(Collectors.toList());
    }

    @Override
    public StoreDTODetail getStoreWithId(Long idStore) {
        Optional<Store> storeOptional = storeRepository.findById(idStore);
        Store store = storeOptional.orElseThrow(() -> new NotFoundEx("Not Found data correspond to get detail Store"));

        return storeMapper.storeToStoreDTODetail(store);
    }

    @Override
    public StoreDTO upDateStore(Long idStore, StoreDTO storeDTO) {
        Optional<Store> storeOptional = storeRepository.findById(idStore);
        Store store = storeOptional.orElseThrow(() -> new NotFoundEx("Not Found data correspond to update Store"));

        storeMapper.updateStoreFromDTO(storeDTO, store);

        storeRepository.save(store);
        return storeDTO;
    }

    @Override
    public void deleteStore(Long idStore) {
        Optional<Store> storeOptional = storeRepository.findById(idStore);
        Store store = storeOptional.orElseThrow(() -> new NotFoundEx("Not Found data correspond to delete Store"));
        storeRepository.deleteById(store.getId());
    }
}