package com.example.Blog_model.user.entity;

import com.example.Blog_model.post.entity.Post;
import com.example.Blog_model.role.entity.Role;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

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

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user", cascade = CascadeType.ALL)
    private List<Post> posts;
}
