package com.example.Blog_model.exception;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class NotFoundEx extends RuntimeException {
    String message = "Not Found";

    public NotFoundEx(String message) {
        this.message = message;
    }
}
