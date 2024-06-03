package com.example.Blog_model.post.entity;

import com.example.Blog_model.user.entity.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id")
    private Long idPost;
    private String namePost;

    @Column(columnDefinition = "TEXT")
    private String contentPost;

    private String imgUrl;

    @Column(columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDate createdAt;

    @ManyToOne
    @JoinColumn(name = "user_id") //name column in database
    private User user;

}
