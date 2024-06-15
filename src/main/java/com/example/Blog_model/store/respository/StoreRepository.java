package com.example.Blog_model.store.respository;

import com.example.Blog_model.store.entity.Store;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface StoreRepository extends JpaRepository<Store, Long> {

    @Query("SELECT DISTINCT s FROM Store s LEFT JOIN FETCH s.products WHERE s.id = :id")
    Optional<Store> findByIdWithProducts(@Param("id") Long id);
}
