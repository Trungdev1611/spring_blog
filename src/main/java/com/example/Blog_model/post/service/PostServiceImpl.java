package com.example.Blog_model.post.service;

import com.example.Blog_model.post.respository.PostRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRespository postRespository;
}
