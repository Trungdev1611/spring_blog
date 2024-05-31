package com.example.Blog_model.user.controller;

import com.example.Blog_model.user.dto.UserInfoDTO;
import com.example.Blog_model.user.dto.UserLoginDTO;
import com.example.Blog_model.user.dto.UserRegisterDTO;
import com.example.Blog_model.user.service.UserImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserImpl userImpl;
    @PostMapping("/auth/register")
    ResponseEntity<UserRegisterDTO> createUser(@RequestBody UserRegisterDTO userData) {

       UserRegisterDTO response =  userImpl.createUser(userData);
       return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PostMapping("/auth/login")
    ResponseEntity<UserLoginDTO> login(@RequestBody UserLoginDTO userData) {

        UserLoginDTO response =  userImpl.loginUser(userData);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("auth/user_info")
    ResponseEntity<UserInfoDTO> getUserInfo(@RequestBody UserInfoDTO userInfoDTO) {
        UserInfoDTO response = userImpl.getInfo(userInfoDTO);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

//    @GetMapping("/users/{idUser}")
//    ResponseEntity<?>



}
