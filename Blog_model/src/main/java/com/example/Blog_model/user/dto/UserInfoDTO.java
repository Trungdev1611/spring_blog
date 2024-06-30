package com.example.Blog_model.user.dto;

import com.example.Blog_model.role.entity.Role;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Collection;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserInfoDTO {

    @NotEmpty(message = "you need to provide username")
    String nameUser;
    Collection nameRoles;
}
