package com.example.Blog_model.exception;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class NotFoundEx extends RuntimeException {
    String message = "Don't have permission to access";

    public NotFoundEx(String message) {
        this.message = message;
    }
}
