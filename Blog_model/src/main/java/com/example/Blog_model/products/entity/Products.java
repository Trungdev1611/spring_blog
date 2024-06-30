package com.example.Blog_model.products.entity;

import com.example.Blog_model.store.entity.Store;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Products {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private double price;
    private Long quantity;
    private double discount;

//    @JsonIgnore  //avoid loop bi-direction when store has product, after product has store
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idStore", referencedColumnName = "id")
    private Store store;


}
