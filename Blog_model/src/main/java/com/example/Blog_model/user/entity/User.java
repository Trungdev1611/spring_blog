package com.example.Blog_model.user.entity;

import com.example.Blog_model.role.entity.Role;
import jakarta.persistence.*;
import lombok.*;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
//@Table(uniqueConstraints={@UniqueConstraint(columnNames={"email"})})
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "user_id")
    private Long userId;

    @Column(unique = true, nullable = false)  //unique - distinct but still need to check exits data in database before insert data
    private String email;

    @Column(unique = true, nullable = false)  //unique - distinct but still need to check exits data in database before insert data
    private String username;

    private String password;

    @ManyToOne // n user - 1 role
    @JoinColumn(name = "roleId") // reference to roleId column
    private Role role;

}
