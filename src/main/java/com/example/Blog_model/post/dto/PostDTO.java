package com.example.Blog_model.post.dto;

import com.example.Blog_model.user.entity.User;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.time.LocalDate;

public class PostDTO {

    private String namePost;

    private String contentPost;

    private String imgUrl;

    private LocalDate createdAt;

}
