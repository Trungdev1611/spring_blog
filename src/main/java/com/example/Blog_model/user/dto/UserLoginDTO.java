package com.example.Blog_model.user.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter

@NoArgsConstructor
public class UserLoginDTO {
    private String username;
    private String password;
    private String token;

    public UserLoginDTO(String username, String token) {
        this.username = username;
        this.token = token;
    }


}
