package com.example.Blog_model.store.dto;

import com.example.Blog_model.products.entity.Products;
import com.example.Blog_model.user.entity.User;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class StoreDTO {

    private Long id;
    @NotEmpty(message = "Please provide name store")
    private String name;
    @NotEmpty(message = "Please provide location to register")
    private String location;
    @NotEmpty(message = "Please provide owner to register")
    private String owner;
    private List<Products> products;
}
