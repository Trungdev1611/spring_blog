package com.example.Blog_model.employee.entity;

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
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String position;
    private double salary;

//    @JsonIgnore  //avoid loop bi-direction when store has employee, after employee has store
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idStore", referencedColumnName = "id")
    private Store store;


}
