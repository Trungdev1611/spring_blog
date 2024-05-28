package com.example.Blog_model.user.dto;


import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class UserRegisterDTO {
    @NotEmpty(message = "Please provide email to register")
    private String email;
    @NotEmpty(message = "Please provide username to register")
    private String username;
    @NotEmpty(message = "Please provide password to register")
    private String password;
    private String roleName;
}
