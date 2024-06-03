package com.example.Blog_model.post.controller;

import com.example.Blog_model.post.dto.PostDTO;
import com.example.Blog_model.post.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PostController {

    @Autowired
    private PostService postService;

    @PostMapping("/post/create")
    ResponseEntity<?>createPost(@RequestBody PostDTO postDTO) {
        return null;
    }
}
