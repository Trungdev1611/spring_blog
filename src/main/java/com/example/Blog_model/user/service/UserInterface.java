package com.example.Blog_model.user.service;

import com.example.Blog_model.user.dto.UserInfoDTO;
import com.example.Blog_model.user.dto.UserLoginDTO;
import com.example.Blog_model.user.dto.UserRegisterDTO;

public interface UserInterface {
    UserRegisterDTO createUser(UserRegisterDTO userData);
    UserLoginDTO loginUser(UserLoginDTO userData);

    UserInfoDTO getInfo(UserInfoDTO userInfoDTO);
}
