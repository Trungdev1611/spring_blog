package com.example.Blog_model.store.controller;

import com.example.Blog_model.store.dto.StoreDTO;
import com.example.Blog_model.store.dto.StoreDTODetail;
import com.example.Blog_model.store.service.StoreImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StoreController {
    @Autowired
    private StoreImpl storeImpl;
    @PostMapping("/store/create")
    ResponseEntity<StoreDTO> createUser(@RequestBody StoreDTO storeDTO) {

        StoreDTO response =  storeImpl.createStore(storeDTO);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/stores")
    ResponseEntity<List<StoreDTO>> getListStore() {

        List<StoreDTO> response =  storeImpl.getListStore();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/stores/{idStore}")
    ResponseEntity<StoreDTODetail> getListStore(@PathVariable Long idStore) {

        StoreDTODetail response =  storeImpl.getStoreWithId(idStore);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping("/stores/{idStore}")
    ResponseEntity<StoreDTO> updateStore(@PathVariable Long idStore, @RequestBody StoreDTO storeDTO) {

        StoreDTO response =  storeImpl.upDateStore(idStore, storeDTO);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/stores/{idStore}")
    ResponseEntity<StoreDTO> deleteStore(@PathVariable Long idStore) {
        storeImpl.deleteStore(idStore);
        return new ResponseEntity<>(null, HttpStatus.OK);
    }


}
