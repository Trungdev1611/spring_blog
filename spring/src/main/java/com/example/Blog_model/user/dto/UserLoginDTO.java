package com.example.Blog_model.user.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter

@NoArgsConstructor
public class UserLoginDTO {
    @NotEmpty(message = "Please input username to login")
    private String username;

    @NotEmpty(message = "Please input password to login")
    private String password;
    private String token;

    public UserLoginDTO(String username, String token) {
        this.username = username;
        this.token = token;
    }


}
