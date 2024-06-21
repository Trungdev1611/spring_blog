package com.example.Blog_model.store.entity;

import com.example.Blog_model.employee.entity.Employee;
import com.example.Blog_model.products.entity.Products;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Store {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String name;

    private String location;
    private String owner;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "store", cascade = CascadeType.ALL)
    private List<Products> products;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "store", cascade = CascadeType.ALL)
    private List<Employee> employees;
}
