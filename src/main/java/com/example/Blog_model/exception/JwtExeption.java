package com.example.Blog_model.exception;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class JwtExeption extends Exception {
    //if you extend Exception instead of RuntimeException, you need throw Exception when use it
    String message = "Don't have permission to access";

    public JwtExeption(String message) {
        this.message = message;
    }
}
